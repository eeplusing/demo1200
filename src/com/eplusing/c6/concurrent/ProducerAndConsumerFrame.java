package com.eplusing.c6.concurrent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProducerAndConsumerFrame extends JFrame{
	private static JTextArea producerTextArea;
	private static JTextArea consumerTextArea;
	private static JTextArea storageTextArea;
	private static int size = 10;
	private static LinkedBlockingQueue<Integer> quene = new LinkedBlockingQueue<Integer>();
	public static void main(String[] args){

		
		JButton btn = new JButton("启动新线程");
		producerTextArea = new JTextArea("生产者:\n");
		consumerTextArea = new JTextArea("消费者：\n");
		storageTextArea = new JTextArea("仓库：\n");
		ProducerAndConsumerFrame frame = new ProducerAndConsumerFrame();
		
		frame.setVisible(true);
		JPanel panel = new JPanel();
        //初始化一个容器
        Container container = frame.getContentPane();
        panel.add(btn);
		panel.add(producerTextArea);
		panel.add(storageTextArea);
		panel.add(consumerTextArea);
		container.add(panel);
		
		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		frame.setLocation(100, 100);
        
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Thread producer = new Thread(new Producer());
				Thread consumer = new Thread(new Consumer());
				producer.start();
				consumer.start();
			}
		});
		
		
		
	}
	
	
	private static class Producer implements Runnable{
		@Override
		public void run() {
			for(int i =0; i < size; i++){
				int b = new Random().nextInt(255);
				String text = producerTextArea.getText();
				producerTextArea.setText(text + "生产商品：" + b + "\n");
				try {
					quene.put(b);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				String storage = storageTextArea.getText();
				storageTextArea.setText(storage + "仓库中还有：" + quene.size() + "个商品\n");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	private static class Consumer implements Runnable{
		@Override
		public void run() {
			for(int i =0; i < size; i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String text = consumerTextArea.getText();
				try {
					consumerTextArea.setText(text + "消费商品：" + quene.take() + "\n");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
}
