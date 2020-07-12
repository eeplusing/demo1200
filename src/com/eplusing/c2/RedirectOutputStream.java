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
			System.out.println("年龄初始值设置为18");
			String sex = "女";
			System.out.println("性别初始值设置为女");
			String info = "这是个" + sex + "孩子，年龄大约是" + age + "岁";
			System.out.println("整合后的info信息是："+info);
			System.setOut(out);
			System.out.println("程序执行完毕");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
