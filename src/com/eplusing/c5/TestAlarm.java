package com.eplusing.c5;

import javax.swing.JOptionPane;

public class TestAlarm {
	public static void main(String[] agrs){
		AlarmClock alarm = new AlarmClock(120, true);
		alarm.start();
		
		JOptionPane.showMessageDialog(null, "ÊÇ·ñÍ»³ö");
		
		System.exit(0);
	}
}
