package com.inventory;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int option = 0;

		
		ProductDao prod =new ProductDao();
		do{
			System.out.println("//Stock entry//");
			System.out.println("MENU");
			System.out.println("1.Add new product details");
			System.out.println("2.Update product details ");
			System.out.println("3.Delete product details");
			System.out.println("4.Print Product details ");
			
			System.out.print("\nOption > ");
			option = s.nextInt();
			switch (option) 
			{
			case 1:
				 prod.addProduct(); 
				

				break;
			case 2:
				System.out.println("Name of the product to update:");
            	String x=s.next();
            	prod.updateProduct(x);

				break;
			case 3:
				System.out.println("Name of the product to delete:");
            	String y=s.next();
            	prod.deleteProduct(y);
				break;
			case 4:
				  List<Product> gh=prod.printProduct();
                  for(Product i:gh)
                  {
                  	System.out.println(i);
                  }	
				break;
			
			default:
				option=5;
				break;
			}

		} while (option != 5);

	}



	}


