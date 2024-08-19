package com.Dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Model.Candidate;
import com.Model.votter;

public class votterDao {
	JdbcTemplate jt;
	

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	public String insertVotter(votter v) {
		String res=null;
		int r=jt.update("insert into votterinfo values(?,?,?,?)", v.getUsername(), v.getEmail(), v.getPassword(),v.getVote());
		if(r==1) {
			res="insert";
		}else {
			res="failed";
		}
		return res;
	}


	public String checkVotter(String user, String pass) {
		
		String sql= "select * from votterinfo";

		
		List<votter> v1= (List<votter>) jt.query(sql, new voteRowMapper());
		String res=null;
		if(v1!=null) {
		for(votter v:v1) {
			if(v.getUsername().equals(user) && v.getPassword().equals(pass)) {
			if(v.getVote().equals("No")) {
				res="No";
				break;
			}else {
				res="Yes";
			}
			}
		}
	}else {
		res="failed";
	}
		return res;
	}


	public void update(String vote) {
		// TODO Auto-generated method stub
		String sql="update votterinfo set vote='Yes' where name=?";
		
		jt.update(sql,vote);
	}
}
