package com.eplusing.c5.adapter;

public class AdapterSocket implements DBSocketInterface{

	private GBSocketInterface gbSocket;
	
	public AdapterSocket(GBSocketInterface gbSocket){
		this.gbSocket = gbSocket;
	}
	
	@Override
	public void powerWithTwoRound() {
		gbSocket.powerWithThreeFlat();
		
	}

}
