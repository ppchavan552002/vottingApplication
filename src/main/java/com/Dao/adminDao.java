package com.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Model.Candidate;

public class adminDao {
	
	JdbcTemplate jt;
	

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public JdbcTemplate getJt() {
        return jt;
    }

	public String verifyAdmin(String username, String pass) {
		
		String res=null;
		if (username.equals("admin@gmail.com") && pass.equals("admin123")) {
			res="valid";
		}else {
			res="invalid";
		}
		
		return res;
	}

	public String enterCandidate(Candidate c) {
		
		
		String sql="insert into candidateinfo values(?,?,?,?)";
		
		int r=jt.update(sql,c.getName(),c.getAge(),c.getCity(),c.getVotes());
		System.out.println(r);
		String res=null;
		if (r==1) {
			res="inserted";
		}else {
			res="failed";
		}
		return res;
	}

	public List<Candidate> showAll() {
		
		return jt.query("select * from candidateinfo", new canRowMapper()) ;
	}

	public String voteUpdate(String vote) {
		// TODO Auto-generated method stub
		String sql="select * from candidateinfo";
		
		int r=0;
		String res="";
		
		List<Candidate> cl = jt.query(sql, new canRowMapper());
		
		for(Candidate c:cl) {
			System.out.println(c.getAge());
			if(c.getName().equals(vote)) {
				int count=c.getVotes();
				count++;
				r=jt.update("update candidateinfo set votes=? where name=?",count,vote);
				break;
			}
		}
		if(r>=1) {
			res="vote";
		}else {
			res="invote";
		}
		return res;
		
	}

	

}
