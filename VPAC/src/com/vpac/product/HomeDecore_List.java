package com.vpac.product;

import java.util.Scanner;

public class HomeDecore_List {
	HomeDecore[] homedecorelist = new HomeDecore[3];
	
	public void printhomeList()
	{
		try {
		System.out.println("0. Filter");
		for(int i = 0; i<homedecorelist.length; i++) {
			System.out.println( (i+1)+". "+homedecorelist[i].name);
		}
		}
		catch(Exception he){
			System.out.println("Please Check Array Index value"+he);
		}
		
		Scanner subc = new Scanner(System.in);
		
		int option = subc.nextInt();
		if(option == 0)
		{
			filter();
		}
		else if(option == 99)
		{
			Product_List x = new Product_List();
			x.product();
		}
		else
		{
			AddToCart(option);
			continuecart(subc);
		}
		subc.close();
	}
	
	public void filter()
	{
		System.out.println("Filter "
				+ "\n1. brand "
				+ "\n2. color ");
		
		Scanner subc = new Scanner(System.in);
		
		int option = subc.nextInt();
		
		switch(option)
		{
		case 1: System.out.println("Brands "
				+ "\n1. Sandle Wood"
				+ "\n2. OAK Wood");
				int option1 = subc.nextInt();
				switch(option1)
				{
				case 1: filterList("brand", "Sandle Wood", homedecorelist);
					break;
				case 2: filterList("brand", "OAK Wood", homedecorelist);
					break;			
				}
			break;
		case 2: System.out.println("Colours: "
				+ "\n1. Mett Black"
				+ "\n2. Brown"
				+ "\n3. blue");
				int option2 = subc.nextInt();
				switch(option2)
				{
				case 1: filterList("colour", "Mett Black", homedecorelist);
					break;
				case 2: filterList("colour", "Brown", homedecorelist);
					break;	
				case 3: filterList("colour", "blue", homedecorelist);
				break;
				}
			break;
		}
		
		subc.close();
	}
	
	public void filterList(String type, String name, HomeDecore[] h)
	{
		for(int i = 0; i<h.length; i++) {
			if(type == "brand" && name == h[i].brand)
				System.out.println( (i+1)+". "+h[i].name);
			else if(type == "color" && name == h[i].color)
				System.out.println( (i+1)+". "+h
						[i].name);
		}
	}
	
	public HomeDecore [] adddecore()
	{
		HomeDecore DiningTable = new HomeDecore();
		DiningTable.name = "Dining Table";
		DiningTable.brand = "OAK Wood";
		DiningTable.color = "Mett Black";
		DiningTable.id = 1;
		
		HomeDecore DiningTable1 = new HomeDecore();
		DiningTable1.name = "Dining Table";
		DiningTable1.brand = "OAK Wood";
		DiningTable1.color = "Brown";
		DiningTable1.id = 2;
		HomeDecore DiningTable2 = new HomeDecore();
		DiningTable2.name = "Dining Table";
		DiningTable2.brand = "Sandle Wood";
		DiningTable2.color = "Brown";
		DiningTable2.id = 3;
		
		homedecorelist [0] = DiningTable;
		homedecorelist [1] = DiningTable1;
		homedecorelist [2] = DiningTable2;
		
		return homedecorelist;
	}
	void AddToCart(int option)
	{	
		
		System.out.println("Item is added");
		System.out.println( homedecorelist[option-1].name+" Rs:>"+homedecorelist[option-1].price+
				"\nCOLOUR : "+homedecorelist[option-1].color+" Brand : "+homedecorelist[option-1].brand);
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
