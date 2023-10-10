package com.tpg.repository;


import java.sql.PreparedStatement;




import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.tpg.model.Admin;
import com.tpg.model.AuthenticationRequest;



@Repository
public class Adminrepository{
	@Autowired
	private JdbcTemplate temp;
	public UserDetails loadByusername(String username) {
		
		String sql="select* from admin where username=?";
		AuthenticationRequest auth = temp.queryForObject(sql, new Object[] {username},new AuthMapper() );
		return new User(auth.getUsername(),auth.getPassword(),new ArrayList<>());
	}
	
	public Integer Register(Admin member) {
		try {
		String sql = "insert into admin(id,username,email,password) values(?,?,?,?)";
		return temp.execute(sql,new PreparedStatementCallback<Integer>() {
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setLong(1, member.getId());
				ps.setString(2, member.getUsername());
				ps.setString(3, member.getEmail());
				ps.setString(4, member.getPassword());
				int a=ps.executeUpdate();
				return a;
			}
			
			});
		}
		
		
		catch(DuplicateKeyException e) {
			e.printStackTrace();
			return -1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
