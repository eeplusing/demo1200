package com.eplusing.c5;

public class HanoiTower {

	public static void main(String[] args) {
		move(3, 'A', 'B', 'C');
	}
	
	
	public static void move(int level, char from, char inter, char to) {
		if(level == 1) {
			System.out.println("��" + level + "�����Ӵ�" + from + "�ƶ���" + to);
		}else {
			move(level - 1, from, to, inter);
			System.out.println("��" + level + "�����Ӵ�" + from + "�ƶ���" + to);
			move(level - 1, inter, from, to);
		}
	}
}
