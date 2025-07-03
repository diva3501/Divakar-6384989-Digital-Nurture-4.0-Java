package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Alice");
        emp.setDepartment("HR");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(emp);
        tx.commit();
        session.close();

        System.out.println("Employee saved using Hibernate.");
    }
}
