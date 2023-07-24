package com.tap.hybernetproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        Student s =new Student(1, "Alex", 97);
        session.save(s);
        

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
