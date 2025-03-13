package com.yourstore.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StoreEntityTest {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-persistence-unit");
    
    @Test
    public void testStoreCreation() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // Create a test store
            Store store = new Store();
            store.setAddress("123 Test Street");
            store.setEmail("test@example.com");
            store.setMinStock(10);
            
            // Persist the store
            em.persist(store);
            em.getTransaction().commit();
            
            // Verify the store was saved with an ID
            assertNotNull(store.getId());
            
            // Retrieve the store from the database
            Store retrievedStore = em.find(Store.class, store.getId());
            
            // Verify the properties
            assertEquals("123 Test Street", retrievedStore.getAddress());
            assertEquals("test@example.com", retrievedStore.getEmail());
            assertEquals(Integer.valueOf(10), retrievedStore.getMinStock());
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }
    
    @Test
    public void testRelationships() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // Create store and related entities
            Store store = new Store();
            store.setAddress("456 Test Avenue");
            store.setEmail("store@example.com");
            store.setMinStock(5);
            
            // Create a storage related to the store
            Storage storage = new Storage();
            // Set storage properties...
            storage.setStore(store);
            
            // Add storage to store
            HashSet<Storage> storages = new HashSet<>();
            storages.add(storage);
            store.setStorages(storages);
            
            // Persist the store (cascade should persist storage too)
            em.persist(store);
            em.getTransaction().commit();
            
            // Clear persistence context
            em.clear();
            
            // Retrieve store and verify relationships
            Store retrievedStore = em.find(Store.class, store.getId());
            assertEquals(1, retrievedStore.getStorages().size());
            
            // Get the related storage
            Storage retrievedStorage = retrievedStore.getStorages().iterator().next();
            assertNotNull(retrievedStorage);
            
            // Verify the bidirectional relationship
            assertEquals(retrievedStore.getId(), retrievedStorage.getStore().getId());
            
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }
    
    @Test
    public void testValidation() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // Create a store with invalid email
            Store store = new Store();
            store.setAddress("789 Test Blvd");
            store.setEmail("invalid-email"); // Invalid email format
            store.setMinStock(-5); // Negative value, should fail @Min validation
            
            // This should throw a validation exception
            em.persist(store);
            em.flush(); // Force validation
            
            fail("Should have thrown a validation exception");
        } catch (jakarta.validation.ConstraintViolationException e) {
            // Expected exception
            assertTrue(e.getConstraintViolations().size() >= 1);
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }
}
