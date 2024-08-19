package com.Model;

public class votter {
	
	String username;
	String email;
	String password;
	String vote;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	@Override
	public String toString() {
		return "votter [username=" + username + ", email=" + email + ", password=" + password + ", vote=" + vote + "]";
	}
	
	
	
}
