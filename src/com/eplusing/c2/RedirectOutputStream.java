package com.eplusing.c2;
import java.io.FileNotFoundException;
import java.io.PrintStream;
public class RedirectOutputStream {

	public static void main(String[] args) {
		try {
			PrintStream out = System.out;
			PrintStream ps = new PrintStream("./src/com/eplusing/c2/log.txt");
			System.setOut(ps);
			int age = 18;
			System.out.println("�����ʼֵ����Ϊ18");
			String sex = "Ů";
			System.out.println("�Ա��ʼֵ����ΪŮ");
			String info = "���Ǹ�" + sex + "���ӣ������Լ��" + age + "��";
			System.out.println("���Ϻ��info��Ϣ�ǣ�"+info);
			System.setOut(out);
			System.out.println("����ִ�����");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
