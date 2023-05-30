package com.vpac.product;

import java.util.Scanner;

public class Electronic_List {
	Electronic [] electroniclist = new Electronic[8];
	
	public void printelectroniclist()
	{
		try {
		System.out.println("0. Filter");
		for(int i = 0; i<electroniclist.length; i++) {
			System.out.println( (i+1)+". "+electroniclist[i].name);
		}
		System.out.println("99. Back");
		
		Scanner subc = new Scanner(System.in);
		
		int option = subc.nextInt();
		if(option == 0)
		{
			filter();
		}
		else if(option == 99)
		{
			Product_List.product();
		}
		else
		{
			Product_List.AddToCart(electroniclist,option);
		}
		subc.close();
		}
		catch(Exception ee){
			System.out.println("Please Check "+ee);
		}
	
	}
	public void filter()
	{
		System.out.println("Filter "
				+ "\n1. Brand "
				+ "\n2. Category "
				+ "\n99.Back");
		
		Scanner subc = new Scanner(System.in);
		
		int option = subc.nextInt();
		
		switch(option)
		{
		case 99: printelectroniclist();
			break;
		case 1: brand(subc);
			break;
		case 2: elecatagory(subc);
			break;
		}
		
		subc.close();
	}
	
	public void brand(Scanner subc) {
		System.out.println("Brands of Electronic Items "
				+ "\n1. Boat "
				+ "\n2. Boalt"
				+ "\n3. Dell"
				+ "\n4. Lenavo"
				+ "\n99.Back");
				int option1 = subc.nextInt();
				switch(option1)
				{
				case 99: filter();
					break;
				case 1: filterListe("brand", "Boat", electroniclist);
						option1 = subc.nextInt();
						if(option1 == 99)
							brand(subc);
						else
							Product_List.AddToCart(electroniclist,option1);
					break;
				case 2: filterListe("brand", "Boalt", electroniclist);
					break;
				case 3: filterListe("brand", "Dell", electroniclist);
				break;
				case 4: filterListe("brand", "Lenavo", electroniclist);
				break;
				}
	}
	public void elecatagory(Scanner subc)
	{
		System.out.println("Catagory of Electronic Items"
				+ "\n1. Earphone "
				+ "\n2. Laptop"
				+ "\n3. Smart Watch"
				+ "\n99.Back");
				int option2 = subc.nextInt();
				switch(option2)
				{
				case 99: filter();
						break;
				case 1: filterListe("catagory", "Earphone", electroniclist);
						System.out.println("99.Back");
					break;
				case 2: filterListe("catagory", "Laptop", electroniclist);
					break;
				case 3: filterListe("catagory", "Smart Watch", electroniclist);
				break;
				}
		
	}
	
	public void filterListe(String type, String name,  Electronic[] e)
	{
		for(int i = 0; i<e.length; i++) {
			if(type == "brand" && name == e[i].brand)
				System.out.println( (i+1)+". "+e[i].name);
			else if(type == "colour" && name == e[i].color)
				System.out.println( (i+1)+". "+e[i].name);
			else if(type == "catagory" && name == e[i].catagory)
				System.out.println( (i+1)+". "+e[i].name);
		}
	}
	
public Electronic [] addelectronic() {
		
	Electronic earphone = new Electronic();
		earphone.brand = "Boat";
		earphone.color = "WHite";
		earphone.name = "Wireless in";
		earphone.price = 999.00;
		earphone.catagory = "Earphone";
		earphone.id=1;
		
		Electronic earphone1 = new Electronic();
		earphone1.brand = "Boat";
		earphone1.color = "Blue";
		earphone1.name = "Wired in";
		earphone1.price = 399.00;
		earphone1.catagory = "Earphone";
		earphone1.id=2;
		
		Electronic laptop1 = new Electronic();
		laptop1.brand = "Dell";
		laptop1.color = "Metal";
		laptop1.name = "Inspiron";
		laptop1.price = 49999.00;
		laptop1.catagory = "Laptop";
		laptop1.id=3;
		Electronic laptop2 = new Electronic();
		laptop2.brand = "Dell";
		laptop2.color = "Metal";
		laptop2.name = "Vastro";
		laptop2.price = 59999.00;
		laptop2.catagory = "Laptop";
		laptop2.id=4;
		
		Electronic laptop3 = new Electronic();
		laptop3.brand = "Lenavo";
		laptop3.color = "Metal";
		laptop3.name = "IdeaPad";
		laptop3.price = 54300.00;
		laptop3.catagory = "Laptop";
		laptop3.id=5;
		
		Electronic laptop4 = new Electronic();
		laptop4.brand = "Lenavo";
		laptop4.color = "Metalic black";
		laptop4.name = "Vastro";
		laptop4.price = 59990.00;
		laptop4.catagory = "Laptop";
		laptop4.id=6;
		
		Electronic watch = new Electronic();
		watch.brand = "Bolt";
		watch.color = "Blue";
		watch.name = "Smart Watch";
		watch.price = 999.00;
		watch.catagory = "Smart Watch";
		watch.id=7;
		
		Electronic watch1 = new Electronic();
		watch1.brand = "Boat";
		watch1.color = "Black";
		watch1.name = "Smart Watch";
		watch1.price = 1599.00;
		watch1.catagory = "Smart Watch";
		watch1.id=7;
		
		electroniclist[0] = earphone;
		electroniclist[1] = earphone1;
		electroniclist[2] = laptop1;
		electroniclist[3] = laptop2;
		electroniclist[4] = laptop3;
		electroniclist[5] = laptop4;
		electroniclist[6] = watch;
		electroniclist[7] = watch1;
		return electroniclist;
	}

		void AddToCart(int option)
		{	
			
			System.out.println("Item is added");
			System.out.println( electroniclist[option-1].name+" Rs:>"+electroniclist[option-1].price+
					"\nCOLOUR : "+electroniclist[option-1].color+" Brand : "+electroniclist[option-1].brand);
		}
		void continuecart(Scanner subc)
		{
			System.out.println("If You Want Continue Shopping OR Generate Final Bill :)"
								+"\n1. Continue Shopping"
								+"\n2. Payment");
			int option = subc.nextInt();
			if( option == 1) {
				Product_List.product();
			}
}
	
}
