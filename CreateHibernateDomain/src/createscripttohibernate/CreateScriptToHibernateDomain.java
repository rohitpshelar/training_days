package createscripttohibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CreateTableUtils
{
	
	String primaryKey = null;
	Map<String,String> columnList = new LinkedHashMap<String, String>();

	// Set primary key value
	void setPrimaryKey(String tableString){
		int primaryKeyStart = tableString.indexOf("PRIMARY KEY");
		primaryKey = tableString.substring(tableString.indexOf("(", primaryKeyStart) + 1, tableString.indexOf(")", primaryKeyStart)).trim();
	}
	
	// Get Table name
	String getDBTableName(String tableString)
	{
		tableString = tableString.replace("CREATE TABLE", "");
		int nameStart = tableString.indexOf(" ", 0);
		int nameEnd = tableString.indexOf(" ", nameStart + 1);
		String tableName = tableString.substring(nameStart, nameEnd);
		return tableName.trim();
	}
	
	// Get class name
	String getJavaClassName(String dbTableName)
	{
		String javaClassName = "";
		String splitedTable = "";
		String[] splitedTableName = dbTableName.split("_");
		for(int i = 0 ; i < splitedTableName.length; i++)
		{
			splitedTable = splitedTableName[i];
			if((i+1) == splitedTableName.length)
			{
				Inflector inf = Inflector.getInstance();
				splitedTable = inf.singularize(splitedTable);
			}
			String firstLetter = (splitedTable.charAt(0)+ "").toUpperCase();
			
			javaClassName = javaClassName + (firstLetter + splitedTable.substring(1, splitedTable.length()));
		}
		return javaClassName;
	}
	
	List<String> getColumnSpecificationLines(String tableString)
	{
		int columnGroupStart = tableString.indexOf("(");
		int columnGroupEnd = tableString.lastIndexOf("PRIMARY KEY");
		tableString = tableString.substring(columnGroupStart + 1, columnGroupEnd).trim();
		String[] columnsArray = tableString.split(",");
		
		List<String> columnNameList = new ArrayList<String>();
		for(int i = 0; i < columnsArray.length; i++) {
			String columnName =  columnsArray[i];
			columnNameList.add(columnName.trim());
		}
		return Arrays.asList(columnsArray);
	}
	
	String getJavaDataType(String sqlDataConstraints){
		
		// NOTE : Do not change sequence of datatypes
		// TODO : Convert if to static map with Key as MYSQL datatype and Value as a Java datatype
		
		// Java number datatyapes (8)
		sqlDataConstraints = sqlDataConstraints.trim();
		if(sqlDataConstraints.contains("TINYINT")) {
			return "Byte";
		}
		
		if(sqlDataConstraints.contains("SMALLINT")) {
			return "Integer";
		}
		
		if(sqlDataConstraints.contains("MEDIUMINT")) {
			return "Integer";
		}

		if(sqlDataConstraints.contains("BIGINT")) {
			return "Long";
		}
		
		if(sqlDataConstraints.contains("INT")) {
			return "Integer";
		}
		
		if(sqlDataConstraints.contains("DECIMAL")) {
			return "Double";
		}
		
		if(sqlDataConstraints.contains("DOUBLE")) {
			return "Double";
		}
		
		if(sqlDataConstraints.contains("FLOAT")) {
			return "Float";
		}

		// Java.sql (4)
		if(sqlDataConstraints.contains("DATETIME") || sqlDataConstraints.contains("TIMESTAMP")) {
			return "java.sql.Timestamp";
		}
		
		if(sqlDataConstraints.contains("DATE")) {
			return "java.sql.Date";
		}
		
		if(sqlDataConstraints.contains("TIME")) {
			return "java.sql.Time";
		}
		
		// Java.sql (4)
		if(sqlDataConstraints.contains("VARCHAR")) {
			return "String";
		}
		
		if(sqlDataConstraints.contains("CHAR")) {
			return "String";
		}
		
		if(sqlDataConstraints.contains("MEDIUMTEXT")) {
			return "String";
		}
		
		if(sqlDataConstraints.contains("TEXT")) {
			return "String";
		}
		
		return "";
	}
	
	String getHibernateConstaints(String sqlDataConstraints){
		sqlDataConstraints = sqlDataConstraints.trim();
		String hibernateConstaints = "";
		
		// Checking length
		if(sqlDataConstraints.contains("VARCHAR")) {
			int varcharStart = sqlDataConstraints.indexOf("VARCHAR");
			String lengthValue = sqlDataConstraints.substring(sqlDataConstraints.indexOf("(", varcharStart) + 1, sqlDataConstraints.indexOf(")", varcharStart));
			hibernateConstaints = "length="+lengthValue;
			
		}
		else if(sqlDataConstraints.contains("CHAR")) {
			int charStart = sqlDataConstraints.indexOf("CHAR");
			String lengthValue = sqlDataConstraints.substring(sqlDataConstraints.indexOf("(", charStart) + 1, sqlDataConstraints.indexOf(")", charStart));
			hibernateConstaints = "length="+lengthValue;
		}
		
		// NOT NULL
		if(sqlDataConstraints.contains("NOT NULL"))
		{
			if(hibernateConstaints.length() > 0) {
				hibernateConstaints = hibernateConstaints + ", ";
			}
			hibernateConstaints = "nullable = false";
		}
		
		return hibernateConstaints;
	}
	
	String getJavaColumnName(String dbColumnName) {
		String javaColumnName = "";
		String[] splitedColumnName = dbColumnName.split("_");
		if(splitedColumnName != null && splitedColumnName.length > 0)
		{
			javaColumnName = splitedColumnName[0];
			for(int i = 1 ; i < splitedColumnName.length; i++)
			{
				String splitedColumn = splitedColumnName[i];
				String firstLetter = (splitedColumn.charAt(0)+ "").toUpperCase();
				
				javaColumnName = javaColumnName + (firstLetter + splitedColumn.substring(1, splitedColumn.length()));
			}
		}
		
		return javaColumnName;
	}
	
	String getHibernateColumn(String tableString)
	{
		/*
		 * @Column(name = "mad_met_id")
		 * private java.lang.Integer 	madMetId;
		 */
		tableString = tableString.trim();
		String dbColumnName = tableString.substring(0, tableString.indexOf(" "));
		String dbContraints = tableString.substring(tableString.indexOf(" "), tableString.length());
	
		// @Column(name = "mad_met_id")
		String hAnnotatedColumn = "\n\t@Column(name = \""+ dbColumnName+"\"";
		String hConstaints = getHibernateConstaints(dbContraints);
		if(hConstaints.length() > 0) {
			hAnnotatedColumn = hAnnotatedColumn + ", " + hConstaints;
		}
		hAnnotatedColumn = hAnnotatedColumn + ")";
		
		String hPrimaryKeyAnnotations = "";
		if(primaryKey != null && primaryKey.equals(dbColumnName.trim())) {
			hPrimaryKeyAnnotations = "\n\t@Id" + "\n\t@GeneratedValue(strategy = GenerationType.AUTO)";
		}
		
		// private java.lang.Integer 	madMetId;
		String hDataType = getJavaDataType(dbContraints);
		String JColumnName = getJavaColumnName(dbColumnName);
		
		columnList.put(JColumnName, hDataType);
		String hibernateColumn = hAnnotatedColumn + hPrimaryKeyAnnotations + "\n\tprivate " + hDataType +" "+ JColumnName + ";";
		return hibernateColumn;
	}
	
	String generateGetterSetter()
	{
		String getterSetters = "";
		for(Map.Entry<String, String> entry : columnList.entrySet()) {
			String propertyName = entry.getKey();
			String firstLetter = (propertyName.charAt(0)+ "").toUpperCase();
			String propertyCapitaliseName = (firstLetter + propertyName.substring(1, propertyName.length()));
			
			String 	getterMethod = "\tpublic "+ entry.getValue() +" get"+ propertyCapitaliseName +"() {\n";
			getterMethod = getterMethod + "\t\t return "+ propertyName + ";";
			getterMethod = getterMethod + "\n\t}\n";
					
			String 	setterMethod = "\tpublic void set"+ propertyCapitaliseName +"(" + entry.getValue() +" "+ entry.getKey() +") {\n";
			setterMethod = setterMethod + "\t\t this."+ propertyName + " = " + propertyName + ";";
			setterMethod = setterMethod + "\n\t}\n";
			
			getterSetters = getterSetters + "\n" + getterMethod +"\n"+ setterMethod;
		}
		return getterSetters;
	}
	
	String getImportCommentSection(String className)
	{
		Scanner sc = new Scanner(new InputStreamReader(System.in));
	//	System.out.println("Please enter author name : ");
		String author = "Onkar Paranjape";
		//	String author = sc.next();
		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		
		StringBuilder importCommentSection = new StringBuilder();
		
		importCommentSection.append("package com.riomed.cellmampi.domain;\n");
		importCommentSection.append("import java.io.Serializable;\n");
		importCommentSection.append("import javax.persistence.*;\n");
		
		importCommentSection.append("/**");
		importCommentSection.append("\n* The "+className+" entity bean.");
		importCommentSection.append("\n* ");
		importCommentSection.append("\n* @author "+ author +" RioMed Ltd");
		importCommentSection.append("\n* @version $1.0 $, $Date: "+ currentDate +" $");
		importCommentSection.append("\n* ");
		importCommentSection.append("\n* @spring.bean name=\""+className+"\"");
		importCommentSection.append("\n*/\n");
		
		return importCommentSection.toString();
	}
	
	
	boolean createDomainFile(String tableString, String path) throws IOException
	{
		String className = "";
		StringBuilder domainClassString = new StringBuilder("");
		// Primary key will be set
		setPrimaryKey(tableString);
		
		String dbTableName = getDBTableName(tableString);
		className = getJavaClassName(dbTableName);
	
		// import files
		domainClassString.append(getImportCommentSection(className));
		
		// Domain class
		domainClassString.append("@Entity\n@Table(name = \""+dbTableName+"\")");
		domainClassString.append("\npublic class "+ className +" implements Serializable {");
		
		// Domain properties
		List<String> columnsList = getColumnSpecificationLines(tableString);
		for(String columnString : columnsList) {
			domainClassString.append("\n"+getHibernateColumn(columnString));
		}
		
		// Domain properties getter setters
		domainClassString.append("\n"+generateGetterSetter());
		
		domainClassString.append("\n}");
		
		//System.out.println(domainClassString);
		//Write file
    	if(className.length() > 0)
    	{
    		File file = new File(path, className+".java");
            
        	file.createNewFile();
        	FileWriter writer = new FileWriter(file); 
        	//Writes the content to the file
        	writer.write(domainClassString.toString()); 
        	writer.flush();
        	writer.close();
        	return true;
    	}
    	
    	return false;
	}
}

public class CreateScriptToHibernateDomain {

	public static void main(String args[]) throws Exception {
		String path = "G:\\Java Test\\domain";		
		
		File sourceFile = new File(path, "createScript.sql");
		
		if(!sourceFile.exists())
		{
			System.out.print("Not found");
			return; 
		}
	
		byte[] sourceFileArray = new byte[(int)sourceFile.length()];
    	FileInputStream is = new FileInputStream(sourceFile);
    	is.read(sourceFileArray);
    	is.close();
    	String sourceFileData = new String(sourceFileArray);
    
    
    	int count = 0;
    	int tableStart = 0;
    	int tablePrimaryKeyStart = 0;
    	int tableEnd = 0;
    	
    	while(count == 0){
    		
    		CreateTableUtils ctu = new CreateTableUtils();
    		try{
    			tableStart = sourceFileData.indexOf("CREATE TABLE", tableEnd);
    			if(tableStart == -1)
    			{
    				count = 1;
    				continue;
    			}
        		tablePrimaryKeyStart = sourceFileData.indexOf("PRIMARY KEY", tableStart);
        		tableEnd = sourceFileData.indexOf(");", tablePrimaryKeyStart) + 2;
        		String tableString = sourceFileData.substring(tableStart, tableEnd);
        		
        		ctu.createDomainFile(tableString, path);
            	
        		count = 0;
    		}
    		catch(Exception e)
    		{
    			count = 1;
    		}
    	}
	}
}
