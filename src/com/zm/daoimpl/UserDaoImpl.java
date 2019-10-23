package com.zm.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zm.dao.UserDao;
import com.zm.entity.User;
/**
 * ʵ�ֽӿڵ���
 * @author ...
 *
 */
public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    //JDBCʵ�ֲ鿴������̨����
	public List<User> get() {
		List<User> list = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student", "root", "root");
			String sql = "select * from student ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//user.setUid��ʾͨ����������uid���Ե�ֵ
			    //rs.getInt(1)�����ȡ���ݿ���е�1��
				User user = new User();
				user.setStuId(rs.getInt(1));
				user.setStuName(rs.getString(2));
				user.setStuPassword(rs.getString(3));
				user.setStuClass(rs.getString(4));
				list.add(user);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
    //ʵ����Ӻ�̨����
	public boolean add(User user) {
		boolean isflag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student", "root", "root");
			String sql = "insert into student value(?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			//pstmt.set������ʾ���sql����д��ڵ��ʺ�����
			pstmt.setInt(1, user.getStuId());
			pstmt.setString(2, user.getStuName());
			pstmt.setString(3, user.getStuPassword());
			pstmt.setString(4, user.getStuClass());
			
			int n = pstmt.executeUpdate();
			//��Ϊֻ��1�����ݽ�����ӣ�����n����Ϊ1
			//if������1�����Բ���ֵ����false������ʧ��
			if (n != 1 && user.getStuName()==null) {
				isflag = false;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isflag;
	}
    //ʵ���޸ĺ�̨����
	public boolean update(User user) {
		
		boolean isflag = true;
		try {
			
			user.setStuId(user.getStuId());
			user.setStuName(user.getStuName());
			user.setStuPassword(user.getStuPassword());
			user.setStuClass(user.getStuClass());
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student", "root", "root");
			String sql = "update student set stuname=?,stupassword=?,stuclass=? where stuid=?";
			pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, user.getStuName());
		    pstmt.setString(2, user.getStuPassword());
		    pstmt.setString(3, user.getStuClass());
		    pstmt.setInt(4, user.getStuId());
		    int n = pstmt.executeUpdate();
		    if(n != 1){
		    	isflag = false;
		    }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isflag;
	}
    //ʵ��ɾ����̨����
	public boolean del(int stuId) {
		boolean isflag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student", "root", "root");
			String sql = "delete from student where stuid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuId);
			int n = pstmt.executeUpdate();
			if(n!=1){
				isflag = false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(stuId);
		System.out.println(isflag);
		return isflag;
	}
    //�޸��л�ȡid�ĺ�̨����
	public User getid(int stuId) {
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student", "root", "root");
			String sql = "select * from student where stuid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuId);
            rs = pstmt.executeQuery();			
			while(rs.next()){
				user.setStuId(rs.getInt(1));
				user.setStuName(rs.getString(2));
				user.setStuPassword(rs.getString(3));
				user.setStuClass(rs.getString(4));
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User Login(String stuName, String stuPassword) {
		User user = null;// ����
		// JDBC
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student", "root", "root");
			String sql = "select * from student where stuname = ? and stupassword = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuName);
			pstmt.setString(2, stuPassword);
		
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setStuId(rs.getInt(1));
				user.setStuName(rs.getString(2));
				user.setStuPassword(rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}

	public boolean regUser(User user) {
	
			boolean isflag = true;
			//jdbc
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/student","root","root");
				String sql = "insert into student(stuid,stuname,stupassword) values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, user.getStuId());
				pstmt.setString(2, user.getStuName());
				pstmt.setString(3, user.getStuPassword());
				int n = pstmt.executeUpdate();
				if(n != 1 ){
					isflag = false;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			return isflag;
	
	}
	
		
}
