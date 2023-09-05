package com.greatlearning.app;

import java.util.Scanner;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmpCredentialsImpl;

public class DriverApp {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in); //default input device(Keyboard)
		System.out.println("Please enter Employee First Name");//Virat
		String f=sc.next();
		System.out.println("Please enter Employee Last Name");//Kohli
		String l=sc.next();
		
		Employee emp1=new Employee(f,l);
//		Employee emp2=new Employee();
//		emp2.setFname("Rohit");
//		emp2.setLname("Sharma");
		
		EmpCredentialsImpl cred=new EmpCredentialsImpl();
		
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. HR");
		System.out.println("4. Legal");
		
		System.out.println("Please choose your department");
		int choice=sc.nextInt();
		String genEmail="";
		String genPassword="";
		switch(choice)
		{
		case 1:
					genEmail=cred.generateEmailId(emp1.getFname().toLowerCase(), emp1.getLname().toLowerCase(), "tech");
					break;
		case 2:
					genEmail=cred.generateEmailId(emp1.getFname().toLowerCase(), emp1.getLname().toLowerCase(), "admin");
					break;
		case 3:
					genEmail=cred.generateEmailId(emp1.getFname().toLowerCase(), emp1.getLname().toLowerCase(), "hr");
					break;
		case 4:
					genEmail=cred.generateEmailId(emp1.getFname().toLowerCase(), emp1.getLname().toLowerCase(), "legal");
					break;
		default : 	System.out.println("Please enter valid Input");
		}
		
		genPassword=cred.generatePassword();
		emp1.setEmailid(genEmail); //rohit.sharma@tech.gl.com
		emp1.setPassword(genPassword); //A12$dfe3
		
		cred.showDetails(emp1);//fname,lname,id & pw
	}

		
		
}

