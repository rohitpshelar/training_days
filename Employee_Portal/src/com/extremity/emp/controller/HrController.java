package com.extremity.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.extremity.emp.dao.IAdminDao;
import com.extremity.emp.model.Attendance;
import com.extremity.emp.model.EmpContact;
import com.extremity.emp.model.EmpLeave;
import com.extremity.emp.model.EmpPersonalDetail;
/*import com.extremity.emp.daoImpl.AdminDaoImpl;*/
import com.extremity.emp.model.Employee;
import com.extremity.emp.service.IAdminService;
import com.extremity.emp.service.IhrService;

@Controller
public class HrController {

	@Autowired
	IhrService service;
	static Logger log = Logger.getLogger(HrController.class);

	ModelAndView mv = null;

	@RequestMapping("hr/getEmp")
	public ModelAndView getAllEmployeeData() {

		log.info("this is my HrController");

		List<Employee> empList = service.getAllEmployeeData();
		for (Employee e : empList) {

			System.out.print("Employees name:" + e.getEmpName());
			System.out.print("Employees ID:" + e.getEmpId());
			System.out.print("Employees Team:" + e.getEmpTeam());

		}
		log.debug("this is login controller");
		return new ModelAndView("hrPages/table");

	}

	@RequestMapping(value = "hr/logout")
	public String logout() {

		return "logout";

	}

	@RequestMapping(value = "hr/hrProfile")
	public ModelAndView hrProfile() {

		System.out.print("get hr data");

		return new ModelAndView("hrPages/hrProfile");

	}

	@RequestMapping(value = "hr/teams")
	public ModelAndView manageteams() {

		ModelAndView mv = new ModelAndView();
		System.out.print("manage team here");
		List<Employee> empList = service.getAllEmployeeData();

		mv.addObject(empList);
		return new ModelAndView("hrPages/CreateTeam", "empList", empList);

	}

	@RequestMapping(value = "hr/showTeams")
	public @ResponseBody ModelAndView showTeams(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Integer id)
			throws IOException {


		request.getParameter("id");
		System.out.print("show perticular team here:" + id);
		List alTeam = service.getTeam(id);
	
		Iterator itr = alTeam.iterator();
		while (itr.hasNext()) {

			Employee e = (Employee) itr.next();
			System.out.println("Employees name::" + e.getEmpName());
			System.out.println("Employees Id::" + e.getEmpId());
			System.out.println("employee team=="+e.getTeam().getTeamName());
		}
	/*	
	mv=new ModelAndView();	
	mv.addObject("empList1",alTeam);
	mv.setViewName("hrPages/dummy");*/
		return new ModelAndView("hrPages/dummy","empList1",alTeam);	

	}

	@RequestMapping(value = "hr/insertTeam")
	public ModelAndView insertTeam(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Integer tid,
			@RequestParam Integer empId) {

		System.out.println("inside insert team id");
		System.out.println("=========================" + empId);
		System.out.println("=========================" + tid);
		int id=service.setTeam(tid, empId);
		
		return new ModelAndView("hr/CreateTeam","id",id);
	}

	@RequestMapping(value = "hr/getLeave")
	public ModelAndView getLeave(HttpServletRequest request,
			HttpServletResponse response) {

		return null;
	}

	@Autowired
	JavaMailSender jms;
	
	@RequestMapping(value = "hr/approveLeave")
	public ModelAndView approveLeave(HttpServletRequest request,HttpServletResponse response)
	{
		
		System.out.println("============Inside Approved leave=============");
		String eid=request.getParameter("id");
		
		System.out.println("==================="+eid+"=====================");
		
		SimpleMailMessage msg= new SimpleMailMessage();
		System.out.println(eid);
		msg.setTo(eid);
		//msg.setSubject(subject);
		msg.setText("Hi... "
				+ "hello sunil hear");
		
		jms.send(msg);
		return null;
		
	}
	
	@RequestMapping(value = "hr/leave")
	public ModelAndView Emails(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		System.out.println("=================inside the leave==========================");
		List<EmpLeave> leave = service.getLeave();

		ModelAndView mv1=new ModelAndView();

		mv1.addObject(leave);
		 return new ModelAndView("hrPages/leave","leave",leave);
	}
	
	@RequestMapping(value = "hr/rejectLeave")
	public ModelAndView rejectLeave(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		System.out.println("============Inside Reject leave=============");
		String eid=request.getParameter("id");
		
		System.out.println("==================="+eid+"=====================");
		
		SimpleMailMessage msg= new SimpleMailMessage();
		System.out.println(eid);
		msg.setTo(eid);
		//msg.setSubject(subject);
		msg.setText("Hi... "
				+ "hello sunil hear");
		
		jms.send(msg);
		return null;
		
	}
// Hr Controller From Admin ==================================================================
	
	
	
	@RequestMapping(value="hr/employeedetails",method=RequestMethod.GET)
	public ModelAndView getAllEmployee()
	{
		System.out.println("DDDDDDDDDDDDDDDDD");
		ModelAndView mav = new ModelAndView("hrPages/hr-employee-detail");
		List<Employee> allemployee = service.getAllEmployee();
		mav.addObject("EMPLOYEE_GET_ALL_DATA", allemployee);
		return mav;
	}

	
	@RequestMapping(value="hr/editEmployee", method=RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id")Integer emp_id)
	{
		ModelAndView mav = new ModelAndView("hrPages/editProfile");
		List<Employee> editemp=service.editEmployee(emp_id);
		mav.addObject("editEmployeedata", editemp);
		return mav;
		
	}
	
	@RequestMapping(value ="hr/deleteemployee", method = RequestMethod.GET)
	public ModelAndView deleteemployee(@RequestParam Integer id) {
		System.out.println(id);
		System.out.println("in delete method controller");

		service.deleteemployee(id);
		ModelAndView mav = new ModelAndView("redirect:../hr/employeedetails");
		return mav;
	}

	
	
	@RequestMapping(value="hr/updateEmployee", method=RequestMethod.GET)
	public String saveEmployeeInoformation(@ModelAttribute Employee employee,
			BindingResult result) {
		try {
			service.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:../hr/employeedetails";
	}
	
	
	@RequestMapping(value="hr/attendence",method=RequestMethod.GET)
	public ModelAndView getAttendence(@RequestParam("id")Integer emp_id)
	{
		System.out.println("IN ATTENDANCE RE BEAT");
		ModelAndView mav = new ModelAndView("hrPages/attendenceSheet");
		List<Attendance> attendence = service.getAttendence(emp_id);
		mav.addObject("attendence", attendence);
		return mav;
	}
	
	@RequestMapping(value="hr/checkin",method=RequestMethod.GET)
	public ModelAndView checkIn()
	{
		ModelAndView mav = new ModelAndView("hr/checkin");
		return mav;
	}
	
	@RequestMapping(value="hr/AddUser",method=RequestMethod.GET)
	public @ResponseBody String addUser( ){
		System.out.println("i am in check in controller");
		String returnText;
	
			returnText = "Sorry, an error has occur. User has not been added to list.";
		
		return returnText;
	}

	
	@RequestMapping(value="/hr/newempprofile",method=RequestMethod.GET)
	public ModelAndView getEmployeeProfile(@RequestParam("id")Integer id)
	{
		
		System.out.println("====Profile  method==");
		
		System.out.println("id=====>>>>"+id);
		
		
		ModelAndView mav = new ModelAndView("hrPages/hr_emp_profile");
		List<EmpPersonalDetail> editemp=service.personalDetail(id);
		mav.addObject("profiledata", editemp);
		return mav;
		
	}
	
	

}
