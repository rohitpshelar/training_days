package com.cjc.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.cjc.model.RegForm;

public interface IDao {

	public int AddRegDetails(RegForm s);

	public int UpdateRegDetails(RegForm s);

	public int DeleteReg(int id);

	public ResultSet GetLoginDetails(String un, String pw);

	public ResultSet GetLoginDetails(String id);

	public ArrayList<?> GetLoginDetails(int id);

	public ArrayList<?> GetLoginDetails();

}
