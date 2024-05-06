package org.example;

import org.example.comunication.Comunication;
import org.example.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MyApp {

    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Comunication comunication = context.getBean("comunication",Comunication.class);
//        List<Employees> employees = comunication.getEmployees();
//        System.out.println(employees);
//        Employees employees = new Employees();
//        employees.setName("John");
//        employees.setSurname("John");
//        employees.setDepartment("IT");
//        employees.setSalary(2000);
//        comunication.addEmployee(employees);

//        System.out.println(comunication.getEmployeeById(100));
        System.out.println(comunication.deleteEmployee(14));
        context.close();
    }
}
