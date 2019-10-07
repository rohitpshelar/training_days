package com.extremityIndia.dao;

import java.util.List;

import com.extremityIndia.hibernate.Systemlogin;

public interface LoginDao {
	
	
	public List<Systemlogin> loginCheck(Systemlogin systemlogin);

}
