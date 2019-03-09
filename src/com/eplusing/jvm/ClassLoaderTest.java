package com.eplusing.jvm;
/**
 * Java类的生命周期：
 * 	1.加载，类加载机制
 * 	2.链接
 * 		2.1验证，按java语言和jvm语义要求检查二进制class文件
 * 		2.2准备，准备要执行的准备的类，为变量分配内存并设置静态变量的初始化
 * 		2.3解析,可选的，检查指定的类是否引用了其他的类或接口，是否找到和加载其他的类和接口
 * 	3.初始化
 * 	4.使用
 * 	5.卸载
 * 
 * 
 * 类加载器将字节码加载到运行时环境
 * 
 * 1.启动（BootStrap）类加载器，将JAVA_HOME/lib下面的类库（如rt.jar）加载到内存中。BootstrapClassLoader(文件系统，本地方法调用)
 * 2.标准扩展类加载器，将JAVA_HOME/lib/ext或由系统变量${java.ext.dir}指定位置中的类库加载到内存中
 * 3.应用程序类（AppClassLoader）类加载器，将系统类路径（CLASSPATH）指定的类路径加载到内容中，该类值ClassLoader.getSystemClassLoader()的返回值，因此一般称为系统加载器
 * 4.自定义类加载器，如容器tomcat中的StandardClassLoader、WebAppClassLoader
 * 
 * 类的加载顺序是自顶向下
 * 检查类是否加载的顺序是自底向上
 * 
 双亲委派/双亲委任：类只能加载一次，只能父类加载、子类不能加载
 
 
D:\ProForEclipse\demo1200\bin>java -verbose com.eplusing.jvm.ClassLoaderTest
#BootstrapClassLoader加载的类
#1.打开rt.jar由启动类加载器完成
[Opened C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
#首先加载Object
[Loaded java.lang.Object from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
[Loaded java.io.Serializable from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
[Loaded java.lang.Comparable from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
[Loaded java.lang.CharSequence from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
[Loaded java.lang.String from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
...

[Loaded sun.misc.Launcher from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
[Loaded sun.misc.Launcher$AppClassLoader from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
[Loaded sun.misc.Launcher$ExtClassLoader from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
...

[Loaded java.lang.Void from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
类加载器演示
sun.misc.Launcher$AppClassLoader@73d16e93
[Loaded java.lang.Shutdown from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
[Loaded java.lang.Shutdown$Lock from C:\Program Files\Java\jdk1.8.0_144\jre\lib\rt.jar]
 * 
 * */

/**
 * 查看执行顺序
 * D:\ProForEclipse\demo1200\bin>javap -c  com.eplusing.jvm.ClassLoaderTest
 * 
 * */


import sun.misc.Launcher; 

public class ClassLoaderTest {
	//Launcher
	
	public static void main(String[] args) {
		System.out.println("类加载器演示");
		ClassLoader c = ClassLoaderTest.class.getClassLoader();
		while(c!=null){
			System.out.println("当前类加载器:" + c + "的父类加载器是" + c.getParent());
			c = c.getParent(); 
		}
		System.out.println(c);
	}
}
