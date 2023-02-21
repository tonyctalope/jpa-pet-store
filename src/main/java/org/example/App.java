package org.example;

import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstorePU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Create some addresses
            Address address1 = new Address();
            address1.setNumber("123");
            address1.setStreet("Main Street");
            address1.setZipcode("12345");
            address1.setCity("Anytown");

            Address address2 = new Address();
            address2.setNumber("456");
            address2.setStreet("Maple Street");
            address2.setZipcode("67890");
            address2.setCity("Anytown");

            em.persist(address1);
            em.persist(address2);

            // Create some petstores
            Petstore petstore1 = new Petstore();
            petstore1.setName("Petstore 1");
            petstore1.setManagerName("Manager 1");
            petstore1.setAddress(address1);

            Petstore petstore2 = new Petstore();
            petstore2.setName("Petstore 2");
            petstore2.setManagerName("Manager 2");
            petstore2.setAddress(address2);

            em.persist(petstore1);
            em.persist(petstore2);

            // Create some products
            Product product1 = new Product();
            product1.setCode("prod1");
            product1.setLabel("Product 1");
            product1.setPrice(10.0);
            product1.setType(Product.ProdType.FOOD);

            Product product2 = new Product();
            product2.setCode("prod2");
            product2.setLabel("Product 2");
            product2.setPrice(20.0);
            product2.setType(Product.ProdType.ACCESSORY);

            Product product3 = new Product();
            product3.setCode("prod3");
            product3.setLabel("Product 3");
            product3.setPrice(30.0);
            product3.setType(Product.ProdType.CLEANING);

            em.persist(product1);
            em.persist(product2);
            em.persist(product3);

            // Create some animals
            Cat cat1 = new Cat();
            cat1.setBirthDate(new Date());
            cat1.setColor("White");
            cat1.setChipId("chip1");
            cat1.setPetstore(petstore1);

            Fish fish1 = new Fish();
            fish1.setBirthDate(new Date());
            fish1.setColor("Orange");
            fish1.setLivingEnv(Fish.LivingEnv.SEA_WATER);
            fish1.setPetstore(petstore2);

            em.persist(cat1);
            em.persist(fish1);

            em.getTransaction().commit();
            System.out.println("Records inserted successfully!");

            // Query all animals from a given petstore
            TypedQuery<Animal> query = em.createQuery(
                    "SELECT a FROM Animal a WHERE a.petstore = :petstore", Animal.class);
            query.setParameter("petstore", petstore1);
            List<Animal> animals = query.getResultList();
            System.out.println("Animals in Petstore 1:");
            for (Animal animal : animals) {
                System.out.println(animal.toString());
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error inserting records: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
