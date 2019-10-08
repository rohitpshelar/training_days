import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.persistence.*;


/** 
 * This class will migrate Cellma Beans to Spring Domains.
 * @author Onkar Paranajpe RioMed Ltd
 */

public class StrutsToSpringDomain {
	
	/**
	 * Required cellmaDAO JAR.
	 * 
	 * How to run ?
	 * configure build path with JAR's in lib folder
	 * change path to you local directory.
	 */
	public static void main(String args[]) throws Exception
	{
		// TODO: 1. Keep sequence of bean properties as same as source file.
		// TODO: 2. Depend on 1: Keep sequence of setter getter methods as same as source file.
		
		MigrateData md = new MigrateData("G:\\Java Test\\domain");

		/*
		 * Commented code read cellmaDAO JAR file and create domain for each bean within it.
		 * 
		java.net.URL url = StrutsToSpringDomain.class.getResource("cellmaDAO.jar");
		File file = new File(url.getFile());
		JarFile jarFile = new JarFile(file);
		java.util.Enumeration<java.util.jar.JarEntry> entries = jarFile.entries();
		while (entries.hasMoreElements()) {
			JarEntry e = entries.nextElement();
			if (e.getName().startsWith("com/riomed/cellma/entity/") && e.getName().contains("Bean.class")) {
				
				String packageName = e.getName().substring(0, e.getName().lastIndexOf(".class")).replaceAll("/", ".");
				Class abc = Class.forName(packageName);
				try
				{
					md.MigrateBeanToDomain(abc);
				}
				catch(Exception e1)
				{
					System.out.println(packageName);
					System.out.println(e1);
				}
			}
		}*/
		
		Class patientBeanClass  = Class.forName("com.riomed.cellma.entity.patients.PatientsBean");
		md.MigrateBeanToDomain(patientBeanClass);
		
	}
}

/**
 * Class contains methods to migrate bean class to domain class.
 * @author Onkar.Paranjape
 */
class MigrateData
{
	String path = null;	
	List<String> skipMethod = null;
	List<String> importStatements = null;
	StringBuilder getterSetters = new StringBuilder("");
	
	/**
	 * Initialization of Skip methods and import statements
	 */
	MigrateData(String path)
	{
		// File Location
		this.path = path;
		
		// Method which need to skip
		skipMethod = new ArrayList<String>();
		skipMethod.add("getClass");
		skipMethod.add("getPrimaryKey");
		
		
		// Import statements
		importStatements = new ArrayList<String>();
		importStatements.add("import java.io.Serializable;");
		importStatements.add("import javax.persistence.*;");
		
	}
	
	/**
	 * This method is done actual migration from Bean to Domain and write domain in file.
	 * 
	 * @param beanClassFile
	 * @throws Exception
	 */
	public void MigrateBeanToDomain(Class beanClassFile) throws Exception
	{
		// Validate Class is of type Hibernate Entity If not then ignore.
		Table beanTable = (Table) beanClassFile.getAnnotation(Table.class);
		if(beanTable == null) {
			return;
		}
		
		StringBuilder domainBuilder = new StringBuilder("");
		StringBuilder joinColumnsString = new StringBuilder("\n\t");
		StringBuilder columnsString = new StringBuilder("\n\t");
		
		Method[] beanMethods = beanClassFile.getMethods();
		if(beanMethods != null && beanMethods.length > 0)
		{
			for(Method method : beanMethods)
			{
				String methodName = method.getName();
				
				// Filter get methods only. Get method are used get annotation and property name.
				if(methodName.startsWith("get") && !skipMethod.contains(methodName))
				{
	                Column columnAnnotation = method.getAnnotation(Column.class);
	                Id idAnnotation = method.getAnnotation(Id.class);
	                GeneratedValue generatedValueAnnotation = method.getAnnotation(GeneratedValue.class);
	               
	                // Implementation of join columns
	                if(columnAnnotation == null){
	                	JoinColumn joinColumnAnnotation = method.getAnnotation(JoinColumn.class);
	                	if(joinColumnAnnotation != null) {
	                		joinColumnsString.append("\n\t"+ this.getJoinColumnAnnotationString(method));
	                		joinColumnsString.append("\n\t"+ this.getColumnSpecification(method) +"\n");
	                	}
	                	continue;
	                }
	                
	                // Implementation column annotation
	                columnsString.append("\n\t"+ this.getColumnAnnotationString(columnAnnotation, idAnnotation, generatedValueAnnotation));
	                columnsString.append("\n\t"+ this.getColumnSpecification(method)+ "\n");
				}
			}
		}

		// Creating Domain
		domainBuilder.append(this.getImportStatements());
		domainBuilder.append(this.classSpecifications(beanClassFile));
		domainBuilder.append(columnsString);
		domainBuilder.append(joinColumnsString);
		domainBuilder.append(getterSetters +"\n");
		domainBuilder.append("}");
		
		// Write domain in File
		writeDomainInFile(domainBuilder, beanClassFile);

	}
	
	/**
	 * This method will write domain in to file. File will be kept to specific path.
	 */
	public void writeDomainInFile(StringBuilder domainBuilder, Class beanClassFile) throws Exception
	{
		String beanClassName = beanClassFile.getSimpleName().replace("Bean", "");
		Inflector inf = Inflector.getInstance();
		beanClassName = inf.singularize(beanClassName);
			
		File domainFile = new File(path, beanClassName+ ".java");
		
		FileOutputStream fo = new FileOutputStream(domainFile);
		fo.write(domainBuilder.toString().getBytes());
		fo.flush();
		fo.close();
	}
	
	/**
	 * This method will specify the column, id, generateValue annotation to column
	 * @param columnAnnotation @Column class 
	 * @param idAnnotation : @Id annotation class
	 * @param generatedValueAnnotation @GeneratedValue annotation class
	 * @return
	 */
	public String getColumnAnnotationString(Column columnAnnotation, Id idAnnotation, GeneratedValue generatedValueAnnotation){
		StringBuilder columnStr = new StringBuilder("");
		
		if(idAnnotation != null) {
			columnStr.append("@Id" + "\n\t");
		}
		
		if(generatedValueAnnotation != null) {
			columnStr.append("@GeneratedValue (strategy = GeneratedValue."+ generatedValueAnnotation.strategy() +")" + "\n\t");
		}

		columnStr.append("@Column(");
		columnStr.append("name = \""+columnAnnotation.name()+"\"");
		if(columnAnnotation.length() > 0){
			columnStr.append(", length = \""+columnAnnotation.length()+"\"");
		}
		if(!columnAnnotation.nullable()){
			columnStr.append(", nullable =\""+columnAnnotation.nullable()+"\"");
		}
		columnStr.append(")");
		return columnStr.toString();
	}
	
	/**
	 * This method will create join column annotation as given below
	 * @JoinColumn, @OneToOne.
	 * @return String
	 */
	public String getJoinColumnAnnotationString(Method method){
		//  @JoinColumn(name="pat_add_id", updatable=false, insertable=false)
		
		StringBuilder joinColumnStr = new StringBuilder("");
		OneToOne otoAnnotation = method.getAnnotation(OneToOne.class);
		OneToMany otmAnnotation = method.getAnnotation(OneToMany.class);
		ManyToMany mtmAnnotation = method.getAnnotation(ManyToMany.class);
		ManyToOne mtoAnnotation = method.getAnnotation(ManyToOne.class);
		
		if(otoAnnotation != null){
			joinColumnStr.append("@OneToOne(");
			joinColumnStr.append("optional = "+otoAnnotation.optional()+", ");
			joinColumnStr.append("fetch = "+otoAnnotation.fetch());
			joinColumnStr.append(")\n\t");
			
			if(!importStatements.contains("import javax.persistence.OneToOne;"))
			{
				importStatements.add("import javax.persistence.OneToOne;");
			}
		}
		else if(otmAnnotation != null) {
			joinColumnStr.append("@OneToMany(");
			joinColumnStr.append("fetch = "+otoAnnotation.fetch());
			joinColumnStr.append(")\n\t");
			
			if(!importStatements.contains("import javax.persistence.OneToMany;"))
			{
				importStatements.add("import javax.persistence.OneToMany;");
			}
		}
		else if(mtmAnnotation != null) {
			joinColumnStr.append("@ManyToMany(");
			joinColumnStr.append("fetch = "+mtmAnnotation.fetch());
			joinColumnStr.append(")\n\t");
			
			if(!importStatements.contains("import javax.persistence.ManyToMany;"))
			{
				importStatements.add("import javax.persistence.ManyToMany;");
			}
		}
		else if(mtoAnnotation != null) {
			joinColumnStr.append("@ManyToOne(");
			joinColumnStr.append("optional = "+mtoAnnotation.optional()+", ");
			joinColumnStr.append("fetch = "+mtoAnnotation.fetch());
			joinColumnStr.append(")\n\t");
			
			if(!importStatements.contains("import javax.persistence.ManyToOne;"))
			{
				importStatements.add("import javax.persistence.ManyToOne;");
			}
		}
		JoinColumn joinColumnAnnotation = method.getAnnotation(JoinColumn.class);
    	if(joinColumnAnnotation != null){
    		joinColumnStr.append("@JoinColumn(");
    		joinColumnStr.append("name = \""+joinColumnAnnotation.name()+"\", ");
    		joinColumnStr.append("updatable = \""+joinColumnAnnotation.updatable()+"\", ");
    		joinColumnStr.append("insertable = \""+joinColumnAnnotation.insertable()+"\"");
    		joinColumnStr.append(")");
    	}
		
		return joinColumnStr.toString();
	}
	
	/**
	 * This method will create bean property
	 * @return String
	 */
	public String getColumnSpecification(Method method){
		// private java.lang.Integer 	patId;
		
		StringBuilder columnSpecStr = new StringBuilder("");
		
		columnSpecStr.append("private ");
		String methodReturnType = method.getReturnType().toString().replaceFirst("class ", "");
		
		// Check return type and add in import statements if needed
		if(methodReturnType.lastIndexOf('.') != -1 && !methodReturnType.contains("java.lang"))
		{	
			String importStatement = "import "+ methodReturnType +";";
			if(!importStatements.contains(importStatement))
			{
				importStatements.add(importStatement);
			}
		}
		
		// Return class name without package (e.g return Integer from java.lang.Integer)
		methodReturnType = methodReturnType.substring(methodReturnType.lastIndexOf('.') + 1, methodReturnType.length());
		
		columnSpecStr.append(methodReturnType + " ");
		
		String propertyName = method.getName().replaceFirst("get", "");
		propertyName = propertyName.replaceFirst(propertyName.substring(0, 1), propertyName.substring(0, 1).toLowerCase());
		
		columnSpecStr.append(propertyName + ";");
		
		this.generateGetterSetter(getterSetters, propertyName, methodReturnType);
		
		return columnSpecStr.toString();
	}
	
	/**
	 * This method will generate getter setters methods.
	 * @param propertyName : name of bean property like patId, patFirstname
	 * @param methodReturnType : Return type like Integer, String
	 */
	public void generateGetterSetter(StringBuilder getterSetters, String propertyName, String methodReturnType)
	{
		String propertyCapitaliseName = propertyName.replaceFirst(propertyName.substring(0, 1), propertyName.substring(0, 1).toUpperCase());
		String 	getterMethod = "\n\tpublic "+ methodReturnType +" get"+ propertyCapitaliseName +"() {\n";
		getterMethod = getterMethod + "\t\t return "+ propertyName + ";";
		getterMethod = getterMethod + "\n\t}\n";
		
		String 	setterMethod = "\tpublic void set"+ propertyCapitaliseName +"(" + methodReturnType +" "+ propertyName +") {\n";
		setterMethod = setterMethod + "\t\t this."+ propertyName + " = " + propertyName + ";";
		setterMethod = setterMethod + "\n\t}\n";
		
		getterSetters.append(getterMethod);
		getterSetters.append(setterMethod);
	}
	
	/**
	 * This method will include comment, class definition
	 * @param beanClassFile : Class file of bean like PatientsBean.class
	 * @return String
	 */
	public String classSpecifications(Class beanClassFile)
	{
		StringBuilder classSpec = new StringBuilder("");
		
		String beanClassName = beanClassFile.getSimpleName().replace("Bean", "");

		Inflector inf = Inflector.getInstance();
		beanClassName = inf.singularize(beanClassName);
		
		Date currentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		classSpec.append("/**" + "\n");
		classSpec.append("* The "+ beanClassName +" entity bean." + "\n");
		classSpec.append("* " + "\n");
		classSpec.append("* @author Onkar Paranajpe RioMed Ltd" + "\n");
		classSpec.append("* @version $1.0 $, $Date: "+ simpleDateFormat.format(currentDate) +" $" + "\n");
		classSpec.append("* " + "\n");
		classSpec.append("* " + "\n");
		classSpec.append("* @spring.bean name=\""+ beanClassName +"\"" + "\n");
		classSpec.append("*/" + "\n");
		
		// Annotation of table
		Table beanTable = (Table) beanClassFile.getAnnotation(Table.class);
		
		classSpec.append("\n");
		classSpec.append("@Entity" + "\n");		 
		classSpec.append("@Table(name = \""+ beanTable.name() +"\")" + "\n");	
		
		classSpec.append("public class "+ beanClassName +" implements Serializable {");
		
		return classSpec.toString();
	}
	
	/**
	 * This method will include import statements to file.
	 * @return String
	 */
	public String getImportStatements()
	{
		StringBuilder importStatementString = new StringBuilder("");
		if(importStatements != null)
		{
			for(String statements: importStatements)
			{
				importStatementString.append(statements + "\n");
			}
		}
		return importStatementString.toString();
	}
}