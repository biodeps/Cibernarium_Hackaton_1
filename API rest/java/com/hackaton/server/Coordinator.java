package com.hackaton.server;

public class Coordinator {
	private String idCoordinator;
	private String password;
	
	public Coordinator() {
	}

	public Coordinator(String idCoordinator, String password) {
		
		this.idCoordinator = idCoordinator;
		this.password = password;
	}
	
	public String getIdCoordinator() {
		return idCoordinator;
	}

	public void setIdCoordinator(String idCoordinator) {
		this.idCoordinator = idCoordinator;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void updateCoordinator(Coordinator coordinatorUpdated) {
		// TODO Auto-generated method stub
		
	}

}
