package com.yourstore.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StoreTest {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-persistence-unit");

	@Test
	public void testStore () {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			// create test store
			Store store = new Store();
			store.setAddress("123 test street");
			store.setEmail("test@gmail.com");
			store.setMinStock(10);

			// persist the store
			em.persist(store);
			em.getTransaction().commit();

			// verify the store was saved with an ID
			assertNotNull(store.getId());

			// Retrieve the store from the database
			Store retrievedStore = em.find(Store.class, store.getId());

			// Verify the properties
			assertEquals("123 test street", retrievedStore.getAddress());
			assertEquals("test@gmail.com", retrievedStore.getEmail());
			assertEquals(10, retrievedStore.getMinStock());
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	@Test
	public void testRelationShips() {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			// create store and related entities
			Store store = new Store();
			store.setAddress("456 test Avenue");
			store.setEmail("store@example.com");
			store.setMinStock(5);

			// create storage related to the store
			Storage storage = new Storage();
			// set storage properties
			storage.setStore(store);
		} finally {
		}
	}
}
