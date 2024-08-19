package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Model.Candidate;

public class canRowMapper implements RowMapper<Candidate>{

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Candidate c=new Candidate();
		c.setName(rs.getString(1));
		c.setAge(rs.getInt(2));
		c.setCity(rs.getString(3));
		c.setVotes(rs.getInt(4));
		return c;
	}

}
