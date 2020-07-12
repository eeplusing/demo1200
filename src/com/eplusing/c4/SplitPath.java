package com.eplusing.c4;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;

public class SplitPath {

	public static void main(String[] args) {
		do_button_actionPerformed(new ActionEvent(args, 0, null));
	}
	
	protected static void do_button_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		int option = chooser.showOpenDialog(chooser);
		if(option == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			System.out.println(path);
			
			int splitIndex = path.lastIndexOf("\\");
			int typeIndex = path.lastIndexOf(".");
			if(typeIndex < 0) {
				typeIndex = path.length();
			}
			
			String filePath = path.substring(0, splitIndex);
			String fileName = path.substring(splitIndex + 1, typeIndex);
			String extName = path.substring(typeIndex);
			System.out.println("文件路径：" + filePath + "\r");
			System.out.println("文件名称：" + fileName + "\r");
			System.out.println("文件类型：" + extName);
			
			
		}
	}

}
