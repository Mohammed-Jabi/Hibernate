package com.tap.hybernetproject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tap.module.Student;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        
        // Perform your database operations within the transaction
//        Student s =new Student(1, "Alex", 97);
//        session.save(s);
        
        //Get te data
        Student s1 = session.get(Student.class,1);
        System.out.println(s1);
        
        //Get all data 
        Query querry = session.createQuery("from Student");
        List student = querry.getResultList();
        
        display(student);
        
        //Udate
        Student s2 = session.get(Student.class, 2);
        s2.setMarks(88);
        
        session.update(s2);
        

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

	static void display(List student) {
		for(Object students : student  ) {
			System.out.println(students);
		}
	}
}
