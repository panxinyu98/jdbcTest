package test0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * jdbc核心接口与类
		 * 1.DriverManager：类，管理数据库驱动
		 * 2.Connection：接口，创建数据库连接
		 * 3.PreparedStatement：接口，发送sql语句，并接收返回值
		 * 4.ResultSet：接口，将查询返回值的结果放入ResultSet中
		 * 
		 * */
		//jdbc模板代码
		//1.加载jdbc驱动（使用Java反射加载驱动程序）
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * 2.使用DriverManager类中的getConnection来获取一个链接
		 * getConnection方法三个参数：
		 * 1）数据库连接字符
		 * 2）用户名
		 * 3）密码
		 */
		try {
		//2.使用DriverManager类中的getConnection来获取一个链接
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","ROOT");
		//3.使用PreparedStatement发送sql
			PreparedStatement pst = con.prepareStatement("select * from dept");
		//4.接受操作数据库返回的结果
			ResultSet rs = pst.	executeQuery();
			//将rs中的数据指出
		    /*
		     * ResultSet中就是一张查询出来的表，这个表中有一个指针（游标）
		     * 此指针默认指向第一行的上部，使用next方法控制指针向下移动
		     * 同时，next方法还会返回一个人boolean值，表示是否有下一行
		     * */
			while(rs.next())
			{
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + "\t" + dname +"\t" + loc);
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
