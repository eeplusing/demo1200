package com.eplusing.c5.adapter;

public class Hotel {
	private DBSocketInterface dbSocket;
	public Hotel(){}
	public Hotel(DBSocketInterface dbSocket){
		this.dbSocket = dbSocket;
	}
	
	public void setSocket(DBSocketInterface dbSocket){
		this.dbSocket = dbSocket;
		
	}
	
	public void charge(){
		dbSocket.powerWithTwoRound();
	}
	
}
