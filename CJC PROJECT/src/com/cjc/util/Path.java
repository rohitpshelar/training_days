package com.cjc.util;

import java.io.File;

public class Path {
	public static final File currentDirFile = new File("");
	public static final String helper = currentDirFile.getAbsolutePath();

	//public static final String Imagepath= helper+"/WebRoot/DBimages/";
	
	public static final String Imagepath="D:/MPI to instal/New Folder (2)/New Folder (2)/New Folder (2)/workspace_eclypse/Copy of ref(change file path to run)/WebContent/DBimages/";
	public static final String Imagepath2=helper+"/WebContent/DBimages/";
	public static final String dataBaseURL="jdbc:mysql://localhost:3306/login";
public static void main(String[] args) {
	System.out.println(Imagepath2);
	
}
}
