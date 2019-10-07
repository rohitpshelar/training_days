package com.dao;

import java.sql.ResultSet;

public interface Dao {
	ResultSet getCountry();
	ResultSet getState(int i);
	ResultSet getCity(int i);
	

}
