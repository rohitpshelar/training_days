package com.extremity.emp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.extremity.emp.dao.IAdminDao;
import com.extremity.emp.model.Attendance;
import com.extremity.emp.model.EmpPersonalDetail;
import com.extremity.emp.model.Employee;
import com.extremity.emp.model.Hr_details;
import com.extremity.emp.model.MyData;
import com.extremity.emp.service.IAdminService;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao iAdminDao;

	public String addValue(MyData myData) {

		System.out.println("serviceimpl");

		return iAdminDao.addValue(myData);
	}

	@Override
	public List<Hr_details> getAllHR() {
		System.out.println("in service for hr===============");
		return iAdminDao.getAllHR();
	}

	public Hr_details delete(int id) {

		return iAdminDao.delete(id);
	}

	@Override
	public List<Hr_details> edithr(int id) {

		return iAdminDao.edithr(id);
	}

	@Override
	public void addhr(Hr_details hr_details) {

		iAdminDao.addhr(hr_details);

	}

	@Override
	public List<EmpPersonalDetail> personalDetail(int id) {

		System.out.println("Personal Details Service impl");
		return iAdminDao.personalDetail(id);
	}

	@Override
	public List<Employee> getAllEmployee() {

		System.out.println("in service===============");
		return iAdminDao.getAllEmployee();
	}

	@Override
	public List<Employee> editEmployee(int emp_id) {
		// TODO Auto-generated method stub
		return iAdminDao.editEmployee(emp_id);
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		iAdminDao.addEmployee(employee);
	}

	@Override
	public List<Attendance>  getAttendence(int emp_id) {
		
		return iAdminDao.getAttendence(emp_id);
	}

	@Override
	public Employee deleteemployee(int id) {
		
		return iAdminDao.deleteemployee(id);
	}

}
