package com.eplusing.demo1200.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeManager {

	private static PrototypeManager pm;
	private Map prototypes = null;

	private PrototypeManager() {
		prototypes = new HashMap();
	}

	public static PrototypeManager getManager() {
		if (null == pm) {
			pm = new PrototypeManager();
		}

		return pm;
	}

	public void register(String name, Object prototype) {
		prototypes.put(name, prototype);
	}

	public void unregister(String name) {
		prototypes.remove(name);
	}

	public Prototype getPrototype(String name) {
		if (prototypes.containsKey(name)) {
			// ���嵥�ж�Ӧԭ�͵ĸ���Ʒ���ظ��ͻ�
			//return (Prototype) ((Prototype)prototypes.get(name)).clone();
			return null;
		} else {
			Prototype object = null;
			try {
				object = (Prototype) Class.forName(name).newInstance();
				register(name, object);
			} catch (Exception e) {
				System.err.println("Class " + name + "û�ж���!");
			}
			return object;
		}
	}

}
