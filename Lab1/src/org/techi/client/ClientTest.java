package org.techi.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.techi.model.Message;

public class ClientTest {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("bean.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);

		Object bean = beanFactory.getBean("message");
		if (bean != null) {
			Message message = (Message) bean;
			System.out.println(message.getMessageId() + "\t" + message.getMessage());
		}
		
		System.out.println("--------getBean(String,Class)------------");
		Message message = beanFactory.getBean("message", Message.class);
		System.out.println(message.getMessageId() + "\t" + message.getMessage());
		
		System.out.println("------getAliases()--------------");
		
		String [] aliases = beanFactory.getAliases("message");
		
		for (String aName : aliases) {
			System.out.println(aName);
		}
		
		System.out.println("------getBean(Class)--------------");
		Message message1 = beanFactory.getBean(Message.class);
		System.out.println(message1.getMessageId() + "\t" + message1.getMessage());
		
		System.out.println("------getType(String)--------------");
		Class<?> clz = beanFactory.getType("message");
		System.out.println(clz.getName());
		
		System.out.println("------isSingleton(String)--------------");
		System.out.println(beanFactory.isSingleton("message"));
		
		System.out.println("------isPrototype(String)--------------");
		System.out.println(beanFactory.isPrototype("message"));
		
	}

}

/*
 
Output:

Jul 03, 2018 2:17:30 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [bean.xml]
1001	Hello World
--------getBean(String,Class)------------
1001	Hello World
------getAliases()--------------
MyMessage1
MyMessage2
------getBean(Class)--------------
1001	Hello World
------getType(String)--------------
org.techi.model.Message
------isSingleton(String)--------------
true
------isPrototype(String)--------------
false

  
 * */
