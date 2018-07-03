package org.techi.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.techi.model.Employee;

public class ClientTest2 {
	
	public static void main(String[] args) {
		ApplicationContext ctx= null;
		
		try {
			//ctx= new FileSystemXmlApplicationContext("C:\\projectsss\\spring\\devZone\\repository\\springFw\\spring-core\\Lab2\\src\\applicationContext.xml"); // Complete Path
			ctx= new FileSystemXmlApplicationContext("src/applicationContext.xml"); //Relative Path
			Employee employee = ctx.getBean("employee", Employee.class);
			System.out.println(employee.getEmployeeId()+"\t"+ employee.getEmployeeName());
			
		} catch (BeansException e) {
			e.printStackTrace();
		}finally {
			if (ctx!=null) {
				((AbstractApplicationContext) ctx).close();
			}
		}
	}

}
