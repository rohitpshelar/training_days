package com.extremity.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.extremity.emp.model.Attendance;
import com.extremity.emp.model.EmpPersonalDetail;
import com.extremity.emp.model.Employee;
import com.extremity.emp.service.IAdminService;


@Controller
public class AdminEmployeeController {
	@Autowired
	IAdminService Iadminservice;
	
	@RequestMapping(value="admin/employeedetails",method=RequestMethod.GET)
	public ModelAndView getAllEmployee()
	{
		System.out.println("Details method");
		ModelAndView mav = new ModelAndView("adminPages/admin-employee-detail");
		List<Employee> allemployee = Iadminservice.getAllEmployee();
		mav.addObject("EMPLOYEE_GET_ALL_DATA", allemployee);
		return mav;
	}

	
	@RequestMapping(value="admin/editEmployee", method=RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id")Integer emp_id)
	{
		ModelAndView mav = new ModelAndView("employeePages/editProfile");
		List<Employee> editemp=Iadminservice.editEmployee(emp_id);
		mav.addObject("editEmployeedata", editemp);
		return mav;
		
	}
	
	@RequestMapping(value ="/admin/deleteemployee", method = RequestMethod.GET)
	public ModelAndView deleteemployee(@RequestParam Integer id) {
		System.out.println(id);
		System.out.println("in delete method controller");

		Iadminservice.deleteemployee(id);
		ModelAndView mav = new ModelAndView("redirect:../admin/employeedetails");
		return mav;
	}

	
	
	@RequestMapping(value="admin/updateEmployee", method=RequestMethod.GET)
	public String saveEmployeeInoformation(@ModelAttribute Employee employee,
			BindingResult result) {
		try {
			Iadminservice.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:../admin/employeedetails";
	}
	
	
	@RequestMapping(value="admin/attendence",method=RequestMethod.GET)
	public ModelAndView getAttendence(@RequestParam("id")Integer emp_id)
	{
		System.out.println("IN ATTENDANCE RE BEAT");
		ModelAndView mav = new ModelAndView("adminPages/attendenceSheet");
		List<Attendance> attendence = Iadminservice.getAttendence(emp_id);
		mav.addObject("attendence", attendence);
		return mav;
	}
	
	@RequestMapping(value="admin/checkin",method=RequestMethod.GET)
	public ModelAndView checkIn()
	{
		ModelAndView mav = new ModelAndView("adminPages/checkin");
		return mav;
	}
	
	@RequestMapping(value="admin/AddUser",method=RequestMethod.GET)
	public @ResponseBody String addUser( ){
		System.out.println("i am in check in controller");
		String returnText;
	
			returnText = "Sorry, an error has occur. User has not been added to list.";
		
		return returnText;
	}

	
	@RequestMapping(value="/admin/newempprofile",method=RequestMethod.GET)
	public ModelAndView getEmployeeProfile(@RequestParam("id")Integer id)
	{
		
		System.out.println("====Profile  method==");
		
		System.out.println("id=====>>>>"+id);
		Iadminservice.personalDetail(id);
		
		ModelAndView mav = new ModelAndView("adminPages/admin_emp_profile");
		List<EmpPersonalDetail> editemp=Iadminservice.personalDetail(id);
		mav.addObject("profiledata", editemp);
		return mav;
		
	}
}
