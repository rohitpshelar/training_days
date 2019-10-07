package com.DaoIMPL;

import java.sql.ResultSet;
import com.dao.Dao;
import com.util.DatabaseConnection;

public class DaoIMPL implements Dao {

	public  ResultSet getCity(int i) {
		String sql="SELECT   DISTINCT `city`.`cid`,`city`.`cname`FROM    `ajax`.`state`    INNER JOIN `ajax`.`country`         ON (`state`.`coid` = `country`.`coid`)    INNER JOIN `ajax`.`city`         ON (`city`.`sid` = "+i+");";
		ResultSet rs=DatabaseConnection.executeQuery(sql);
		return rs;
	}

	public ResultSet getCountry() {
		System.out.println("inside getCountry");
		String sql="SELECT coid,`coname`FROM `ajax`.`country`";
		ResultSet rs=DatabaseConnection.executeQuery(sql);
		return rs;
	}

	public ResultSet getState(int i) {
		String sql="SELECT DISTINCT   sid,`state`.`sname` FROM  `ajax`.`state`   INNER JOIN `ajax`.`country` WHERE (`country`.`coid` = "+i+")   AND (`state`.`coid` = "+i+")";

		ResultSet rs=DatabaseConnection.executeQuery(sql);
		return rs;
	}

	
}
