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
		
		 //��ʼ��һ��jframe
        /*JFrame frame = new JFrame("Hello World!");

        //��ʼ��һ����������
        JTextArea textarea = new JTextArea("Ҫ��ʾ������");

        //��ʼ��һ��jlable
        JLabel emptyLable = new JLabel("��һ��Java GUI����ı�ǩ");

        //��ʼ��һ���˵���
        JMenuBar menuBar = new JMenuBar();

        //��ʼ���˵�
        JMenu menu1 = new JMenu("�ļ�");
        JMenu menu2 = new JMenu("�༭");
        JMenu menu3 = new JMenu("��Դ");

        //��ʼ��һ��panel
        JPanel panel = new JPanel();

        //��ʼ��һ������
        Container container = frame.getContentPane();

        //��ʼ��һ����ť
        JButton startAutoGen = new JButton("��ʼ����"); 

        //���ò���
        container.setLayout(new FlowLayout());

        //�Ѱ�ť��ӵ�pannel
        panel.add(textarea);
        panel.add(emptyLable);
        panel.add(startAutoGen);

        //�Ѳ˵���ӵ��˵���
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        //���ò˵���
        frame.setJMenuBar(menuBar);

        //���ùرշ�ʽ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //��panel��ӵ�����
        container.add(panel);

        //���ô�С
        frame.setSize(600,500);

        //����λ��
        frame.setLocation(100, 100);

        //���ÿɼ���
        frame.setVisible(true);*/
		
		
		
		JButton btn = new JButton("������Ʒ");
		JTextArea t1 = new JTextArea("��Ʒ");
		JTextArea t2 = new JTextArea("��Ʒ");
		JFrame frame = new TransactionFrame(btn, t1, t2);
		
		frame.setVisible(true);
		JPanel panel = new JPanel();
        //��ʼ��һ������
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
				senderTextArea.setText(text + "���ͣ�" + product + "\n");
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
				receiverTextArea.setText(text + "�յ���" + sender.getProduct() + "\n");
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


