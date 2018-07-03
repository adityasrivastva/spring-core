package org.techi.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.techi.model.Employee;

public class ClientTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Employee employee = ctx.getBean("employee", Employee.class);
		System.out.println(employee.getEmployeeId()+"\t"+ employee.getEmployeeName());
		
		((AbstractApplicationContext) ctx).close();
		
		
	}

}
