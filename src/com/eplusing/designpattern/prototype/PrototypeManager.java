package com.eplusing.designpattern.prototype;

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
			// 将清单中对应原型的复制品返回给客户
			//return (Prototype) ((Prototype)prototypes.get(name)).clone();
			return null;
		} else {
			Prototype object = null;
			try {
				object = (Prototype) Class.forName(name).newInstance();
				register(name, object);
			} catch (Exception e) {
				System.err.println("Class " + name + "没有定义!");
			}
			return object;
		}
	}

}
