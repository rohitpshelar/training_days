package com.extremity.emp.dao;

import java.util.List;

import com.extremity.emp.model.Attendance;
import com.extremity.emp.model.EmpLeave;
import com.extremity.emp.model.EmpPersonalDetail;
import com.extremity.emp.model.Employee;
import com.extremity.emp.model.MyData;

public interface IhrDao {

	List<Employee> getAllEmployeeData();

	public int setTeam(int id,int eId);

	 public List getTeam(int tId);
	
	public List<EmpLeave> getLeave();
	public List<EmpPersonalDetail> personalDetail(int id);

	public List<Employee> getAllEmployee();

	public List<Employee> editEmployee(int emp_id);

	public void addEmployee(Employee employee);

	public List<Attendance> getAttendence(int emp_id);
	
	
	public	Employee deleteemployee(int id);

	String addValue(MyData myData);
	
}
