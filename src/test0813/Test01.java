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
		 * jdbc���Ľӿ�����
		 * 1.DriverManager���࣬�������ݿ�����
		 * 2.Connection���ӿڣ��������ݿ�����
		 * 3.PreparedStatement���ӿڣ�����sql��䣬�����շ���ֵ
		 * 4.ResultSet���ӿڣ�����ѯ����ֵ�Ľ������ResultSet��
		 * 
		 * */
		//jdbcģ�����
		//1.����jdbc������ʹ��Java���������������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * 2.ʹ��DriverManager���е�getConnection����ȡһ������
		 * getConnection��������������
		 * 1�����ݿ������ַ�
		 * 2���û���
		 * 3������
		 */
		try {
		//2.ʹ��DriverManager���е�getConnection����ȡһ������
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=utf-8","root","ROOT");
		//3.ʹ��PreparedStatement����sql
			PreparedStatement pst = con.prepareStatement("select * from dept");
		//4.���ܲ������ݿⷵ�صĽ��
			ResultSet rs = pst.	executeQuery();
			//��rs�е�����ָ��
		    /*
		     * ResultSet�о���һ�Ų�ѯ�����ı����������һ��ָ�루�α꣩
		     * ��ָ��Ĭ��ָ���һ�е��ϲ���ʹ��next��������ָ�������ƶ�
		     * ͬʱ��next�������᷵��һ����booleanֵ����ʾ�Ƿ�����һ��
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
