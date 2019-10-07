package com.cjc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.action.DeleteReg;
import com.cjc.action.LoginServlet;
import com.cjc.action.RegServlet;
import com.cjc.action.UpdateReg;
import com.cjc.action.UpdatedReg;

public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DeleteReg deleteReg;

	LoginServlet loginServlet;

	RegServlet regServlet;

	UpdatedReg updatedReg;

	UpdateReg updateReg;

	@Override
	public void init() throws ServletException {
		deleteReg = new DeleteReg();
		loginServlet = new LoginServlet();
		regServlet = new RegServlet();
		updatedReg = new UpdatedReg();
		updateReg = new UpdateReg();
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().equals("/log")) {
			loginServlet.LoginAction(request, response);
		}
		if (request.getServletPath().equals("/dels")) {
			deleteReg.delReg(request, response);
		}
		if (request.getServletPath().equals("/reg")) {
			regServlet.regaction(request, response);
		}
		if (request.getServletPath().equals("/edits")) {
			updateReg.updateAction(request, response);
		}
		if (request.getServletPath().equals("/editeds")) {
			updatedReg.updatedAction(request, response);
		}

	}
}
