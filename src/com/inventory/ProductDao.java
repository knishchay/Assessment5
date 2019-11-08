package com.inventory;

import java.util.List;
import java.util.Scanner;
import com.inventory.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProductDao {
private static EntityManagerFactory entityManagerFactory;
	
	public void addProduct() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Name of product:");
		String name=s.next();
		System.out.println("Description of product:");
		String desc=s.next();
		System.out.println("Price of product:");
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quant=s.nextInt();
		
		Product pr=new Product(name,desc,price,quant);
		
		em.getTransaction().begin();
		em.persist(pr);
		em.getTransaction().commit();
	}
	
	public void updateProduct(String name) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Product product=em.createQuery("select s from Product s where name= :name",Product.class).setParameter("name",name).getResultList().get(0);
		Scanner s=new Scanner(System.in);
		System.out.println("Name:");
		String name1=s.next();
		System.out.println("Description:");
		String description=s.next();
		System.out.println("Price:");
		int price=s.nextInt();
		System.out.println("Quantity:");
		int quantity=s.nextInt();
		product.setName(name1);
		product.setDesc(description);
		product.setPrice(price);
		product.setQuant(quantity);
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
	}
	
	public List<Product> printProduct(){
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("select s from Product s",Product.class).getResultList();
	
	}
	
	public void deleteProduct(String name)
	{
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		Product product=em.createQuery("select s from Product s where name= :name",Product.class).setParameter("name",name).getResultList().get(0);
	
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
		
	
	}
}
