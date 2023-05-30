 package com.vpac.product;

import java.util.Scanner;

public class Cloth_List {
	
	Cloths [] clothlist = new Cloths[4];
	
	public void printClothList()
	{
		try {
		System.out.println("0. Filter");
		for(int i = 0; i<clothlist.length; i++) {
			System.out.println( (i+1)+". "+clothlist[i].name);
		  }
		 System.out.println("99. Back");
		}
		catch(Exception ce){
			System.out.println("Please Check Array Index value"+ce);
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
			Product_List.AddToCart(clothlist,option);
		}
		subc.close();
	}
	public void filter()
	{
		System.out.println("Filter "
				+ "\n1. Male "
				+ "\n2. Female "
				+ "\n99.Back");
		
		Scanner subc = new Scanner(System.in);
		
		int option = subc.nextInt();
		
		switch(option)
		{
		case 99: printClothList();
			break;
		case 1:  male(subc);
			break;
		case 2: System.out.println("Brands of Female "
				+ "\n1. Puma "
				+ "\n2. MAX");
				int option2 = subc.nextInt();
				switch(option2)
				{
				case 1: filterListc("gender", "Puma", clothlist);
				break;
				case 2: filterListc("gender", "MAX", clothlist);
					
				break;
				}
			break;
		}
		
		subc.close();
	}
	
	public void male(Scanner subc) {
		System.out.println("Brands of Male "
				+ "\n1. Puma "
				+ "\n2. MAX"
				+ "\n99 back");
				int option1 = subc.nextInt();
				switch(option1)
				{
				case 99: filter();
					break;
				case 1: malepuma(subc);
					break;
				case 2: malemax(subc);
						break;			
				}
	}
	public void malepuma(Scanner subc)
	{
		System.out.println("Male Puma "
				+"\n1. Collar Tshirt"
				+"\n2. Without Collar Tshirt"
				+"\n99.Back"); 
			filterListc("gender", "Puma", clothlist);
			int option3 = subc.nextInt();
			
			switch(option3) 
			{
			case 99: male(subc);
				break;
			case 1:
			filterListc("gender", "Puma", clothlist);
			Product_List.AddToCart(clothlist,option3);
			break;
			case 2:
				filterListc("gender", "Puma", clothlist);
				Product_List.AddToCart(clothlist,option3);
				break;
			}
	}
	public void malemax(Scanner subc)
	{
		System.out.println("Male Puma "
				+"\n1. Collar Tshirt"
				+"\n2. Without Collar Tshirt"
				+"\n99.Back");  
			filterListc("gender", "MAX", clothlist);
				int option4 = subc.nextInt();
				switch(option4) 
				{
				case 99: male(subc);
					break;
				case 1:
				filterListc("gender", "MAX", clothlist);
				Product_List.AddToCart(clothlist,option4);
				
				break;
				case 2:
					filterListc("gender", "MAX", clothlist);
					Product_List.AddToCart(clothlist,option4);
					break;
				}
	}
	
	public void filterListc(String type, String name, Cloths[] c)
	{
		for(int i = 0; i<c.length; i++) {
			if(type == "brand" && name == c[i].brand)
				System.out.println( (i+1)+". "+c[i].name);
			else if(type == "colour" && name == c[i].Colour)
				System.out.println( (i+1)+". "+c[i].name);
		}
	}
	
	public Cloths[] addcloth() {
		
		Cloths tshirt = new Cloths();
		tshirt.brand = "Puma";
		tshirt.Colour = "RED";
		tshirt.name = "Collar Tshirt";
		tshirt.price = 500.00;
		tshirt.id=1;
		tshirt.gender = "Male";
		
		Cloths tshirt1 = new Cloths();
		tshirt1.brand = "MAX";
		tshirt1.Colour = "Blue";
		tshirt1.name = "Without Collar Tshirt";
		tshirt1.price = 300.00;
		tshirt1.id=2;
		tshirt1.gender= "Male";
		
		Cloths Kurti = new Cloths();
		Kurti.brand = "MAX";
		Kurti.Colour = "Blue";
		Kurti.name = "Kurti";
		Kurti.price = 600.00;
		Kurti.id=3;
		Kurti.gender= "Female";
		
		Cloths Kurti1 = new Cloths();
		Kurti1.brand = "MAX";
		Kurti1.Colour = "Blue";
		Kurti1.name = "Designer Kurti";
		Kurti1.price = 1000.00;
		Kurti1.id=4;
		Kurti1.gender= "Female";
		
		clothlist[0] = tshirt;
		clothlist[1] = tshirt1;
		
		clothlist[2] = Kurti;
		clothlist[3] = Kurti1;
		
		return clothlist;
	}

}
