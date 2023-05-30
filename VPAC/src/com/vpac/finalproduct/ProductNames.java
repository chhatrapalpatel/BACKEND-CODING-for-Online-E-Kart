package com.vpac.finalproduct;

import java.util.Scanner;



public class ProductNames {
	
	static Double amount;
	
	public int id;
	public String name;
	public String brand;
	public String colour;
	public double price;
	String catagory;
	String subcata;
	String gender;
	public ProductNames(int id, String name, String brand, String colour, double price, String catagory,String gender) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.colour = colour;
		this.price = price;
		this.catagory = catagory;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return   name + "Rs: " + price + colour ;
	}
	public static void main(String[] args) {
//		Product pl = new Product();
//		//pl.print();
//		pl.itemList();
//		System.out.println("0. Filter");
//		pl.filter(null, null, null, null);
//		System.out.println("99. Back");
//		Scanner subc = new Scanner(System.in);
//		int option = subc.nextInt();
//		if(option== 0) {
//			
//		}
		budget();
				
	}
	public static void budget()
	{
		Scanner subc = new Scanner(System.in);
		System.out.println("Do You Like To Set Your OWN BUDGET"
							+"\n.1 Set the Budegt"
							+"\n.2 Continue to Shopping No Budget Limit");
		int option = subc.nextInt();
		switch(option){
		case 1: System.out.println("Enter the Amount");
		 		 amount = subc.nextDouble();
		 		item();
			break;
		case 2: item();
			break;
		
		}
			
	}
	public static void prod()
	{
		Product p = new Product();
		p.print();
//		Scanner subc = new Scanner(System.in);
//		System.out.println("List Of Product");
//		System.out.println("Select the Shopping Catagory "
//				+ "\n1.Mobil "
//				+ "\n2.Cloths "
//				+ "\n3.Electronic"
//				+ "\n4.Home Decore");
//		
//		int option = subc.nextInt();
//		
//		switch(option)
//		{
//		case 1: Product p = new Product();
//				p.print();
//			break;
//		case 2: Cloth_List cloth = new Cloth_List();
//				cloth.addcloth();
//				cloth.printClothList();
//		
//			break;
//		case 3: Electronic_List elec = new Electronic_List();
//				elec.addelectronic();
//				elec.printelectroniclist();
//
//			break;
//		case 4: HomeDecore_List home = new HomeDecore_List();
//				home.adddecore();
//				home.printhomeList();
//			break;
//		}
//		
//		subc.close();
	}
	public static void item() {
		Product pl = new Product();
		//pl.print();
		pl.itemList();
		System.out.println("0. List Of Product :)");
		pl.filter(null, null, null, null);
		Scanner subc = new Scanner(System.in);
		int option = subc.nextInt();
		if(option== 0) {
			prod();
		}
	}

}
