package com.eplusing.c6;

import java.util.ArrayList;
import java.util.List;

public class ThreadList {
	private static ThreadGroup getRootThreadGroups(){
		ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
		while(true){
			if(rootGroup.getParent() != null){
				rootGroup = rootGroup.getParent();
			}else{
				break;
			}
		}
		
		return rootGroup;
	}
	
	public static List<String> getThreads(ThreadGroup group){
		List<String> threadList = new ArrayList<String>();
		Thread[] threads = new Thread[group.activeCount()];
		
		int count = group.enumerate(threads, false);
		
		for(int i = 0; i < count; i++){
			threadList.add(group.getName() + "Ïß³Ì×é£º" + threads[i].getName());
		}
		
		return threadList;
		
	}
	
	public static List<String> getThreadGroups(ThreadGroup group){
		List<String> threadList = getThreads(group);
		
		ThreadGroup[] groups = new ThreadGroup[group.activeCount()];
		int count = group.enumerate(groups, false);
		for(int i = 0; i < count; i++){
			threadList.addAll(getThreads(groups[i]));
		}
		
		return threadList;
		
	}
	
	public static void main(String[] args){
		for(String str : getThreadGroups(getRootThreadGroups())){
			System.out.println(str);
		}
	}
	
	
	
	
	
	
	
}
