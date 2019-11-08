package com.inventory;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue
	
	private int id ;
	private String name ;
	private String desc;
	private int price;
	private int quant;
	
	public Product() {
		super();
	}
	public Product(String name,String desc,int price,int quant) {
		super();
		
		this.name=name;
		this.desc=desc;
		this.price=price;
		this.quant=quant;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", quant=" + quant
				+ "]";
	}
	
	
}
