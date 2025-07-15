package com.uglyeagle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(7L); // make sure this ID is unique in your DB
        emp.setFirstName("John");
        emp.setLastName("Doe");
        emp.setEmail("john.doe@email.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        System.out.println("Employee saved: " + emp);

        em.close();
        emf.close();
    }
}
