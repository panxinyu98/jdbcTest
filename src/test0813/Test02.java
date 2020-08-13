package test0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test02 {
	
	public void doSelect(int deptno) {
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","ROOT");
			PreparedStatement pst = con.prepareStatement("select * from dept where deptno=?");
			pst.setInt(1, deptno);
			rs = pst.executeQuery();

			if(rs.next()) {
				System.out.println(rs.getInt("deptno") + "\t" + rs.getString("dname") + "\t" + rs.getString("loc"));
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	
	public void doInsert(int deptno,String dname,String loc) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","ROOT");
			PreparedStatement pst = con.prepareStatement("insert into dept values(?,?,?)");
			pst.setInt(1, deptno);
			pst.setString(2, dname);
			pst.setString(3, loc);
			int result = pst.executeUpdate();

			if(result>0) {
				System.out.println("ok");
			}else {
				System.out.println("error");
			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doUpdate(int deptno,String dname,String loc) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","ROOT");
			PreparedStatement pst = con.prepareStatement("update dept set dname=?,loc=? where deptno=?");
			pst.setString(1, dname);
			pst.setString(2, loc);
			pst.setInt(3, deptno);
			int result = pst.executeUpdate();

			if(result>0) {
				System.out.println("ok");
			}else {
				System.out.println("error");
			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doDelete(int deptno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","ROOT");
			PreparedStatement pst = con.prepareStatement("delete from dept where deptno=?");
			pst.setInt(1, deptno);
			int result = pst.executeUpdate();

			if(result>0) {
				System.out.println("ok");
			}else {
				System.out.println("error");
			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		//new Test02().doSelect(20);
		//new Test02().doInsert(50, "技术部", "沈阳市");
		//new Test02().doUpdate(50, "技术1部", "铁路市");
		new Test02().doDelete(50);
	}

}
