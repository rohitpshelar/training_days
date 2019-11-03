package com.extremity.emp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.extremity.emp.dao.IAdminDao;
import com.extremity.emp.dao.IhrDao;
import com.extremity.emp.model.Attendance;
import com.extremity.emp.model.EmpLeave;
import com.extremity.emp.model.EmpPersonalDetail;
import com.extremity.emp.model.Employee;
import com.extremity.emp.model.Hr_details;
import com.extremity.emp.model.MyData;
import com.extremity.emp.service.IhrService;

public class HrServiceImpl  implements IhrService{

	@Autowired
	IhrDao iHrDao;
	public List<Employee> getAllEmployeeData() {
		
		return  iHrDao.getAllEmployeeData();
	}
	
	@Override
	public int setTeam(int Id,int eId) {
	
		return iHrDao.setTeam(Id,eId);
	}

	@Override
	public List getTeam(int tId) {
		
		return iHrDao.getTeam(tId);
	}
	public List<EmpLeave> getLeave()
	{
		return iHrDao.getLeave();
	}
	
	

	public String addValue(MyData myData) {

		System.out.println("serviceimpl");

		return iHrDao.addValue(myData);
	}

	

	@Override
	public List<EmpPersonalDetail> personalDetail(int id) {

		System.out.println("Personal Details Service impl");
		return iHrDao.personalDetail(id);
	}

	@Override
	public List<Employee> getAllEmployee() {

		System.out.println("in service===============");
		return iHrDao.getAllEmployee();
	}

	@Override
	public List<Employee> editEmployee(int emp_id) {
		// TODO Auto-generated method stub
		return iHrDao.editEmployee(emp_id);
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		iHrDao.addEmployee(employee);
	}

	@Override
	public List<Attendance>  getAttendence(int emp_id) {
		
		return iHrDao.getAttendence(emp_id);
	}

	@Override
	public Employee deleteemployee(int id) {
		
		return iHrDao.deleteemployee(id);
	}

}
