package com.cut.cardona;

import com.cut.cardona.util.JPAutil;
import jakarta.persistence.EntityManager;

public class CreatePersistence {
    public static void main(String[] args) {


        EntityManager entityManager = JPAutil.getEntityManager();
        entityManager.close();


    }
}
