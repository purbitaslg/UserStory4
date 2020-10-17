package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pp.model.Project;

public class ProjectDAO {
	
	Connection con;
	Statement stmt;

	public ProjectDAO() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	
	
	public boolean InsertData(Project p) {
		
		try {
			con=DbConnector.getConnection();
			//Project p1=new Project(,title,desc,domain);
			
			
			  String query=("insert into project values(?,?,?,?)");
			  PreparedStatement ps = con.prepareStatement(query);
			  
			  ps.setInt(1,p.getId()); 
			  ps.setString(2,p.getTitle()); 
			  ps.setString(3,p.getDescription());
			  ps.setString(4,p.getDomain()); 
			  ps.executeUpdate();
			  return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 return false;
		}
		finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public List<Project> showAll() throws SQLException, ClassNotFoundException{
		try {
		con=DbConnector.getConnection();
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from project");
		List<Project> list = new ArrayList<Project>();
		while(rs.next()) {
		
		Project p = new Project();
		p.setId(rs.getInt(1));
		p.setTitle(rs.getString(2));
		p.setDescription(rs.getString(3));
		p.setDomain(rs.getString(4));
		list.add(p);
		
		}return list;
		//return null;
		
		}finally {
			
			con.close();
		}
	}
	
	
	

}
