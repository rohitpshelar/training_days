package com.extremity.emp.dao;

import java.util.List;

import com.extremity.emp.model.Attendance;
import com.extremity.emp.model.EmpPersonalDetail;
import com.extremity.emp.model.Employee;
import com.extremity.emp.model.Hr_details;
import com.extremity.emp.model.MyData;

public interface IAdminDao {

	public String addValue(MyData myData);

	public List<Hr_details> getAllHR();

	public Hr_details delete(int id);

	public List<Hr_details> edithr(int id);

	public void addhr(Hr_details hr_details);

	public List<EmpPersonalDetail> personalDetail(int id);

	public List<Employee> getAllEmployee();

	public List<Employee> editEmployee(int emp_id);

	public void addEmployee(Employee employee);

	public List<Attendance> getAttendence(int emp_id);
	
	
	public	Employee deleteemployee(int id);
	

}
