package com.hackaton.server;


public class Teacher {
	
	private String password;
	private String id;
	private String name;
	private String surname1;
	private String surname2;
	private String telephone;
	private int idAddress;
	private int idScheduleType;
	private boolean isAvailable;
	
	private static int counter=0;
	//Constructor vacío para integrar con base de datos
	public Teacher() {
		this.id="B" + counter;
		counter++;
	
	}
	
	public Teacher(String password, String id, String name, String surname1, String surname2, String telephone,
			int idAddress, int idScheduleType, boolean isAvailable) throws Exception{

		this.password = password;
		this.id = id;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.telephone = telephone;
		this.idAddress = idAddress;
		this.idScheduleType = idScheduleType;
		this.isAvailable = isAvailable;
	}
	
	public String getId() {
		return id;
	
	}




}
