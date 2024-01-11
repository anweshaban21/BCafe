package org.mis;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSql {
static Connection con;
public static Connection createC2()
{
	String url="jdbc:mysql://localhost:3306/Exam";
	String uId="root";
	String uPass="mukta@21A";
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,uId,uPass);
	}catch(Exception e) {}
	return con;
}
}
