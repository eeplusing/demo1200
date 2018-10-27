package com.eplusing.c6.deposit;

public class DepositTest {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Transfer tran = new Transfer(bank);
		Thread t1 = new Thread(tran);
		Thread t2 = new Thread(tran);
		t1.start();
		t2.start();
	}

}
