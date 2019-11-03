package com.extremity.emp.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller


public class LoginController {
	

	@RequestMapping(value = "/login/loginPass", method = RequestMethod.GET)
	public String loginPass(Model map, HttpSession session,
			HttpServletRequest req) {

		System.out
				.println("===============================================================");
		@SuppressWarnings("unused")
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Collection<? extends GrantedAuthority> roleNames = SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		String roleName = "";
		for (GrantedAuthority role : roleNames) {
			roleName = role.getAuthority();
			break;
		}

		String retstr = "";

		if ("ROLE_ADMIN".equalsIgnoreCase(roleName)) {
			retstr = "redirect:../admin/AdminHome";
		} else if ("ROLE_EMPLOYEE".equalsIgnoreCase(roleName)) {
			retstr = "redirect:../employee/employeeHome";
		} else if ("ROLE_HR".equalsIgnoreCase(roleName)) {
			retstr = "redirect:../hr/hrHome";
		} else {
			retstr = "redirect:../403";
		}

		return retstr;
	}
	
	@RequestMapping(value="admin/AdminHome",method=RequestMethod.GET)
	public ModelAndView adminPage()
	{
		System.out.println("in admin login controller");
		ModelAndView model = new ModelAndView();
		model.addObject("title","Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("adminPages/adminFront");//page is not designed
		System.out.println("out admin login controller");
		return model;
	}
	
	
	@RequestMapping(value = "hr/hrHome", method = RequestMethod.GET)
	public ModelAndView customerPage(HttpServletRequest request) {
		
		System.out.println("in hr page");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HttpSession session = request.getSession();
	
		session.setAttribute("sessionId", auth.getName());
		System.out.println("in hr login controller");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication for Customer");
		model.addObject("message", "This page is for ROLE_Customer only!");
		model.setViewName("hrPages/hrFront");//page is not designed
		System.out.println("out customer login controller");
		return model;
	}


	@RequestMapping(value = "/employee/employeeHome", method = RequestMethod.GET)
	public ModelAndView employeePage(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", auth.getName());
		System.out.println("in employee login controller");
		ModelAndView model = new ModelAndView();
		model.addObject("title","Spring Security Login Form - Database Authentication for employee");
		model.addObject("message", "This page is for ROLE_employee only!");
		model.setViewName("employeePages/employeeHome");//page is not designed
		System.out.println("out employee login controller");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		System.out.println("in login /login controller");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			System.out.println("in login login page");
			model.addObject("error", "Invalid username or password!");
			model.setViewName("login");
		}
		if (logout != null) {
			System.out.println("in login logout page");
			//model.addObject("msg", "You've been logged out successfully!");
			model.setViewName("login");
		}
		
		return model;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
        System.out.println("access denied");
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}
	
	/* @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public String logout(ModelMap model) {
	        return "logout";
	    }
*/
}
