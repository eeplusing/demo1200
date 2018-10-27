package com.eplusing.c6.deposit;

import javax.swing.JTextArea;

public class Transfer implements Runnable{

	private Bank bank;
	private JTextArea text;
	public Transfer(Bank bank) {
		super();
		this.bank = bank;
	}
	
	public Transfer(){
		super();
	}

	public Transfer(Bank bank, JTextArea text) {
		super();
		this.bank = bank;
		this.text = text;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			bank.deposit(10);
		}
	}

}
