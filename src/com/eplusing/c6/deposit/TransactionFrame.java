package com.eplusing.c6.deposit;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TransactionFrame extends JFrame {
	
	public static void main(String[] args) {
		
		 //初始化一个jframe
        /*JFrame frame = new JFrame("Hello World!");

        //初始化一个文字区域
        JTextArea textarea = new JTextArea("要显示的文字");

        //初始化一个jlable
        JLabel emptyLable = new JLabel("第一个Java GUI程序的标签");

        //初始化一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        //初始化菜单
        JMenu menu1 = new JMenu("文件");
        JMenu menu2 = new JMenu("编辑");
        JMenu menu3 = new JMenu("资源");

        //初始化一个panel
        JPanel panel = new JPanel();

        //初始化一个容器
        Container container = frame.getContentPane();

        //初始化一个按钮
        JButton startAutoGen = new JButton("开始生成"); 

        //设置布局
        container.setLayout(new FlowLayout());

        //把按钮添加到pannel
        panel.add(textarea);
        panel.add(emptyLable);
        panel.add(startAutoGen);

        //把菜单添加到菜单栏
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        //设置菜单栏
        frame.setJMenuBar(menuBar);

        //设置关闭方式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //把panel添加到容器
        container.add(panel);

        //设置大小
        frame.setSize(600,500);

        //设置位置
        frame.setLocation(100, 100);

        //设置可见性
        frame.setVisible(true);*/
		
		
		
		JButton btn = new JButton("发送商品");
		JTextArea t1 = new JTextArea("商品");
		JTextArea t2 = new JTextArea("货品");
		JFrame frame = new TransactionFrame(btn, t1, t2);
		
		frame.setVisible(true);
		JPanel panel = new JPanel();
        //初始化一个容器
        Container container = frame.getContentPane();
		
        Sender send = ((TransactionFrame)frame).new Sender();
        Receiver recv = ((TransactionFrame)frame).new Receiver(send);
        
        
        
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread sendT = new Thread(send);
				Thread recvT = new Thread(recv);
				sendT.start();
				recvT.start();
				
			}
			});
		
		panel.add(btn);
		panel.add(t1);
		panel.add(t2);
		container.add(panel);
		
		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		frame.setLocation(100, 100);
		
	}
	
	public TransactionFrame(){}
	private JButton button;
	private JTextArea senderTextArea;
	private JTextArea receiverTextArea;
	public TransactionFrame(JButton button, JTextArea senderTextArea, JTextArea receiverTextArea)
			throws HeadlessException {
		super();
		this.button = button;
		this.senderTextArea = senderTextArea;
		this.receiverTextArea = receiverTextArea;
	}
	public JButton getButton() {
		return button;
	}
	public void setButton(JButton button) {
		this.button = button;
	}
	public JTextArea getSenderTextArea() {
		return senderTextArea;
	}
	public void setSenderTextArea(JTextArea senderTextArea) {
		this.senderTextArea = senderTextArea;
	}
	public JTextArea getReceiverTextArea() {
		return receiverTextArea;
	}
	public void setReceiverTextArea(JTextArea receiverTextArea) {
		this.receiverTextArea = receiverTextArea;
	}

	
	class Sender implements Runnable{
		private String[] products = {"java", "oracle", "C#", "web", "Python"};
		private volatile String product;
		
		private volatile boolean isValid;
		
		@Override
		public void run() {
			for(int i = 0; i < 5; i++){
				while(isValid){
					Thread.yield();
				}
				
				product = products[i];
				String text = senderTextArea.getText();
				senderTextArea.setText(text + "发送：" + product + "\n");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isValid = true;
			}
		}
		
		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public boolean isValid() {
			return isValid;
		}

		public void setValid(boolean isValid) {
			this.isValid = isValid;
		}

		
	}
	
	class Receiver implements Runnable{

		private Sender sender;
		public Receiver(Sender sender){
			this.sender = sender;
		}
		@Override
		public void run() {
			for(int i = 0; i < 5; i++){
				while(!sender.isValid()){
					Thread.yield();
				}
				
				String text = receiverTextArea.getText();
				receiverTextArea.setText(text + "收到：" + sender.getProduct() + "\n");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sender.setValid(false);
			}
		}
		
	}
}


