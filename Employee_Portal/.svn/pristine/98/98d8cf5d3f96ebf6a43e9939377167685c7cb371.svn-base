package com.extremity.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.extremity.emp.dao.IAdminDao;
import com.extremity.emp.model.Hr_details;
import com.extremity.emp.service.IAdminService;

@Controller
public class AdminHRDetailsController {
	@Autowired
	IAdminService iAdminService;
	IAdminDao iAdminDao;

	@RequestMapping(value = "/admin/hrdetails", method = RequestMethod.GET)
	public ModelAndView getAllHR() {
		ModelAndView mav = new ModelAndView("adminPages/adminHRDetail");
		List<Hr_details> hr = iAdminService.getAllHR();
		mav.addObject("EMPLOYEE_GET_ALL_DATA", hr);
		System.out.println(hr + "hr");
		return mav;
	}

	@RequestMapping(value = "/admin/deleteContact", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam Integer id) {
		System.out.println(id);
		System.out.println("in delete method controller");

		iAdminService.delete(id);
		ModelAndView mav = new ModelAndView("redirect:../admin/hrdetails");
		return mav;
	}

	@RequestMapping(value = "admin/edithr", method = RequestMethod.GET)
	public ModelAndView edithr(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("/adminPages/editProfile_hr");
		List<Hr_details> editemp = iAdminService.edithr(id);
		mav.addObject("editEmployeedata", editemp);
		return mav;

	}

	@RequestMapping(value = "admin/updatehr", method = RequestMethod.GET)
	public String saveEmployeeInoformation(
			@ModelAttribute Hr_details hr_details, BindingResult result) {
		try {
			System.out.println("method");
			iAdminService.addhr(hr_details);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:../admin/hrdetails";
	}

}
