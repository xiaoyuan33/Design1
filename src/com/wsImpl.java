package com;
import java.sql.*;
import javax.jws.WebService;  
@WebService(endpointInterface = "com.wsInterface", serviceName = "wsInterface")
public class wsImpl implements wsInterface { 
  public String login(String name, String password) {  
    String result = "登录CXF 服务端成功!";   
     if (!"cxf".equalsIgnoreCase(name) || !"cxf".equalsIgnoreCase(password)) {
         result = "用户名或密码不正确，请重新登录!";   
  } 
   return result; 
    }  
  public String viewInfo(String name) {
	  try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	     System.out.println("Success loading Mysql Driver!");
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/jpa","root","root");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

	      System.out.println("Success connect Mysql server!");
	      Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from s_scenic_spot WHERE spotId='1'");
	        return rs.getString("spotIntro");
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	      return "";
	    }
	  
  }
  public static void main(String args[]) {
	    try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	     System.out.println("Success loading Mysql Driver!");
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/jpa?useUnicode=true&amp;characterEncoding=utf-8","root","root");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

	      System.out.println("Success connect Mysql server!");
	      Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from s_scenic_spot WHERE spotId='1'");
	                                                              //user 为你表的名称
	while (rs.next()) {
	        System.out.println(rs.getString("Intro"));
	      }
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
	  }
 @Override
  public void roomReseve() {
	 try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/jpa","root","root");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
	      Statement stmt = connect.createStatement();
	      stmt.execute("UPDATE `jpa`.`h_room` SET `status` = '预订' WHERE `roomid` = '4';");
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
  }
@Override
public void ticketReseve() {
	 try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/jpa","root","root");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
	      Statement stmt = connect.createStatement();
	      stmt.execute("UPDATE `jpa`.`s_ticket` SET `ticketNum` = '99' WHERE `ticketId` = '1'; ");
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
}
@Override
public void viewReseve() {
	
	 try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/jpa","root","root");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
	      Statement stmt = connect.createStatement();
	      stmt.execute("UPDATE `jpa`.`b_train` SET `ticketNum1` = '107' WHERE `id` = '1';");
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
}
	}