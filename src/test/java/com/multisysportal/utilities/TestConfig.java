package com.multisysportal.utilities;
public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "eliza.deguzman@xurpas.com";
	public static String password = "XTQDBFRB:";
	public static String[] to ={"eliza.deguzman@xurpas.com","medeguzman09@yahoo.com"};
	public static String subject = "CTX Billing Portal Project Report";
	
	public static String messageBody ="Here are the log reports";
	public static String attachmentPath="/Users/micadeguzman/Documents/bg.jpeg";
	public static String attachmentName="05.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	
	
	
	
	
	
}
