package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Model.votter;

public class voteRowMapper implements RowMapper<votter>{

	@Override
	public votter mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		votter v=new votter();
		v.setUsername(rs.getString(1));
		v.setEmail(rs.getString(2));
		v.setPassword(rs.getString(3));
		v.setVote(rs.getString(4));
		return v;
	}

}
