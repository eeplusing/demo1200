package com.eplusing.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class TestReferenceDemo {
	public static void main(String[] args) throws Exception {

		// 强引用，GC时，即使OOM也不回收，只要引用对象被占用也不回收
		// refrence();

		// 执行GC时，在堆内存不够用时，引用对象被回收
		// softReference();

		// 只要发生GC，若引用对象就被回收
		//weakReference();
		
		//引用队列
		//referenceQuene();
		
		//幽灵引用
		phantomReference();

	}

	private static void phantomReference() throws Exception {
		String str = new String("eplusing.com");
		ReferenceQueue<String> quene = new ReferenceQueue<String>();
		PhantomReference<String> pr = new PhantomReference<String>(str, quene);
		System.out.println(pr);
		str = null;
		Thread.sleep(200);
		System.gc();
		System.out.println(pr.isEnqueued());
		System.out.println(pr.get());
		
		//引用队列保存一个已经要被回收的对象信息
		System.out.println(quene.poll());		
	}

	public static void referenceQuene() throws Exception {
		String str = new String("eplusing.com");
		ReferenceQueue<String> quene = new ReferenceQueue<String>();
		WeakReference<String> weak = new WeakReference<String>(str, quene);
		System.out.println(weak);
		str = null;
		
		System.out.println(weak.isEnqueued());
		Thread.sleep(200);
		
		System.gc();
		
		System.out.println(weak.isEnqueued());
		
		//引用队列保存一个已经要被回收的对象信息
		System.out.println(quene.poll());
	}

	public static void weakReference() {
		String str = new String("eplusing.com");
		// 创建软引用对象
		WeakReference<String> refStr = new WeakReference<String>(str);

		str = null;

		System.out.println(refStr.get());
		System.gc();
		System.out.println(refStr.get());

		/* Map中的key value必须是匿名对象或key都没有被引用才能被回收 */
		Map<Integer, String> whm = new WeakHashMap<Integer, String>();
		Integer i1 = new Integer(1);
		whm.put(i1, new String("A"));
		whm.put(new Integer(2), new String("B"));
		// 断开i1的引用
		i1 = null;
		System.out.println("GC前map:" + whm);
		System.gc();
		System.out.println("GC后map:" + whm);

	}

	/**
	 * 使用软引用处理缓存问题
	 */
	public static void softReference() {
		String str = new String("eplusing.com");
		// 创建软引用对象
		SoftReference<String> refStr = new SoftReference<String>(str);

		str = null;

		System.gc();

		System.out.println(refStr.get());

	}

	public static void refrence() {
		while (true) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName());
				String str = "eplusing.com";

				for (int i = 0; i < 1000; i++) {
					str = str + i;
					str.intern();
				}

				/** 强引用 */
				Object oa = new Object();
				// ob与oa具有同样的引用
				Object ob = oa;
				// oa断开了对原始的引用,ob仍指向原oa指向的内存
				oa = null;

				System.gc();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
			;
		}
	}
}
