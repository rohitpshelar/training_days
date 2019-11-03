package com.extremity.emp.daoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.extremity.emp.dao.IhrDao;
import com.extremity.emp.model.Attendance;
import com.extremity.emp.model.EmpLeave;
import com.extremity.emp.model.EmpPersonalDetail;
import com.extremity.emp.model.Employee;
import com.extremity.emp.model.MyData;

public class HrDaoImpl  implements IhrDao{

	@Autowired
	SessionFactory sessionFactory;
	List<EmpLeave> leave = new  ArrayList<EmpLeave>();
	List <Employee> empList=new ArrayList<Employee>();
	
	//=========method written for getting All Empoyees======================//
	
	public List<Employee> getAllEmployeeData() {
		
		System.out.println("inside daoImpl========================== in getAllEmployeeData()");
	Query query= sessionFactory.openSession().createQuery("FROM Employee");
	
	empList=query.list();
	
	
		return  empList;
	}
	//=========method written for set the team for perticular Employee======================//
		@Override
		public int setTeam( int tId,int eId) {
			
		Query query = sessionFactory.openSession().createQuery( "UPDATE Employee set team_id = :tId "  + 
	            "WHERE empId = :employee_id");
		query.setParameter("tId",tId);
		query.setParameter("employee_id",eId);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
			
			return result;
		}
		
		/*for selecting perticular team*/
		@Override
		public List getTeam(int tId) {
			

			System.out.println("inside getTeam in hrDaoImpl:"+tId);
		
			Query query = sessionFactory.openSession().createQuery("from Employee e where e.team.teamId="+tId);
			
			List<Employee> al=query.list();
			
			for(Employee ee: al)
			{
				System.out.println("emp name:"+ee.getEmpName());
				System.out.println("emp id:"+ee.getEmpId());
				System.out.println("emp team:"+ee.getEmpTeam());
			}
			
			return al;
			
		}
	
	
	
	public List<EmpLeave> getLeave()
	{
			
		Query query= sessionFactory.openSession().createQuery("FROM EmpLeave");
		leave=query.list();
		
			return  leave;
		
	}

	
	@Override
	public List<EmpPersonalDetail> personalDetail(int id) {
		
		System.out.println("employee personal Dao impl");
		
		List<EmpPersonalDetail> list=null;
		try {
			Session session = sessionFactory.openSession();
			System.out.println("================="+id+"=========edit dao========");
			EmpPersonalDetail employee=(EmpPersonalDetail) session.load(EmpPersonalDetail.class, id);
			list=new ArrayList<EmpPersonalDetail>();
			list.add(employee);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}




/*--------------------------------------------Get all  employee--------------------------------------*/ 

public List<Employee> getAllEmployee()
{
	System.out.println("in ========================dao============");
	Session session = sessionFactory.openSession();
	//Transaction tx = session.beginTransaction();
	Criteria criteria=session.createCriteria(Employee.class);
	List employees=criteria.list();
	System.out.println(employees);
	return criteria.list();
}

/*--------------------------------------------Edit the employee--------------------------------------*/ 

public List<Employee> editEmployee(int emp_id) 
{
	List<Employee> list=null;
	try {
		Session session = sessionFactory.openSession();
		System.out.println("================="+emp_id+"=========edit dao========");
		Employee employee=(Employee) session.load(Employee.class, emp_id);
		list=new ArrayList<Employee>();
		list.add(employee);
		System.out.println(list);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

/*--------------------------------------------Add the employee--------------------------------------*/ 

@Override
public void addEmployee(Employee employee) {
System.out.println("in ===============da0 update========dao===e============");
	
	Session session = sessionFactory.openSession();
	session.saveOrUpdate(employee);
	session.beginTransaction().commit();
	 System.out.println("Command successfully executed....");
}


/*----------------------------------------Attendence------------------------------------------------*/

public List<Attendance> getAttendence(int emp_id)
{
	List<Attendance>   attendence=null;
	Date dww=null;
	Date dww2=null;
	try {
	SimpleDateFormat sdf = new SimpleDateFormat("2016-06-01");
	String d1= sdf.format(new Date()); 
	SimpleDateFormat sdf2 = new SimpleDateFormat("2016-06-07");
	String d2 = sdf2.format(new Date()); 
	
	String string = "11-30-2015"; 

	SimpleDateFormat  formatter = new SimpleDateFormat("MM-dd-yyyy");
	Date date1 = formatter.parse(string);
	java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
		Date d=new Date();
		Integer i=d.getMonth()+1;
		System.out.println(i);
	
		System.out.println(sdf); 
		System.out.println(sdf2); 
	
	
	System.out.println("in ================Attendence========dao============");
    Session session = sessionFactory.openSession();
    attendence=session.createQuery("from Attendance where month(date)='"+i+"' and emp_id='"+emp_id+"'").list();
	System.out.println(attendence);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return attendence;
}

@Override
public Employee deleteemployee(int id) {
	System.out.println("in ========================dao===employww============");
	Session session = sessionFactory.openSession();
	Transaction tx =	session.beginTransaction();
	System.out.println(id);
	
	System.out.println("=========Employee Id above========");
	Employee i = (Employee) session.get(Employee.class, id);
	
	session.delete(i);
	tx.commit();
	return null;
}
@Override
public String addValue(MyData myData) {
	// TODO Auto-generated method stub
	return null;
}
}
