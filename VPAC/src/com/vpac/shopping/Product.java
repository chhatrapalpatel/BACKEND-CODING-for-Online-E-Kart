package com.vpac.shopping;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.vpac.product.Product_List;


public class Product {
	
	static int ItemProduct = 0;
	static ArrayList<ProductNames> AddItem = new ArrayList<ProductNames>(); 
	static Scanner subc = new Scanner(System.in);
	

	public static ArrayList<ProductNames> ArrayList1 = new ArrayList<ProductNames>();
	static LinkedHashSet ls = new LinkedHashSet(ArrayList1);

	static double amount = 0;
	public static void print() {
		//itemList();
		System.out.println("0. List Of Product :)");
		filter(null, null, null, null);
		int option1 = subc.nextInt();
		if(option1== 0) {
			productOption();
		}
		else if(ArrayList1.size()>=option1 && option1>0){
			AddToCart(AddItem,option1);
		}
		else {
			System.out.println("Invalid Option");
			print();
		}
//		Scanner subc = new Scanner(System.in);
				//subc.close();
		
	}
	public static void productOption()
	{
		System.out.println("List Of Product");
		System.out.println("Select the Shopping Catagory "
				+ "\n1.Mobil "
				+ "\n2.Cloths "
				+ "\n3.Electronic"
				+ "\n4.Home Decore"
				+"\n99.Back");
		
		int option = subc.nextInt();
		
		switch(option)
		{
		case 99 :
			print();
//			System.out.println("0. List Of Product :)");
//		filter(null, null, null, null);
//		int option11 = subc.nextInt();
//		if(option11== 0) {
////			ProductNames.prod();
//		}
		break;
		case 1: printMobileList();
			break;
		case 2: filter(null, null, null, "Cloth");
					int option3 = subc.nextInt();
					AddToCart(AddItem,option3);
			break;
		default : System.out.println("<< ***** Invalid Option Please Select Valid Option ***** >>");
				productOption();
				break;

		}
	}
	
	public static void printMobileList()
	{
		System.out.println("0. Filter");
		filter(null, null, null, "Mobile");
		System.out.println("99. Back");
			int option2 = subc.nextInt();
			System.out.println("Filter "
					+ "\n1. brand "
					+ "\n2. color "
					+ "\n99 Back");
			
			Scanner subc = new Scanner(System.in);
			
			int option = subc.nextInt();
				
			switch(option)
			{
			case 99: productOption();
					break;
			case 1: brand(subc);
					break;		
			case 2: color(subc);
				break;
			default : System.out.println("<< ***** Invalid Option Please Select Valid Option ***** >>");
			printMobileList();
			break;
			}
	}
			
	public static void color(Scanner subc)
		{
				System.out.println("Colours: "
						+ "\n1. Black"
						+ "\n2. Gold"
						+ "\n3. Blue"
						+ "\n99 Back");
						int option2 = subc.nextInt();
						switch(option2)
						{
						case 99:printMobileList();
							break;
						case 1: filter(null, "Black", null, "Mobile");
							int option3 = subc.nextInt();
							if(option3 == 99)
								color(subc);
							else
								AddToCart(AddItem,option3);
							
							break;
						case 2: filter(null, "Gold", null, "Mobile");
							option3 = subc.nextInt();
							if(option3 == 99)
								color(subc);
							else
								AddToCart(AddItem,option3);
								
							break;	
						case 3: filter(null, "Blue", null, "Mobile");
							option3 = subc.nextInt();
							if(option3 == 99)
								color(subc);
							else
								AddToCart(AddItem,option3);
								
						break;
						default : System.out.println("<< ***** Invalid Option Please Select Valid Option ***** >>");
						color(subc);
						break;

						}
			}
			public static void brand(Scanner subc)
			{
				System.out.println("Brands "
						+ "\n1. Xiomi"
						+ "\n2. Samsung"
						+ "\n3. OPPO"
						+ "\n99 Back");
						int option1 = subc.nextInt();
						switch(option1)
						{
							case 99:printMobileList();
								break;
							case 1:xiomi(subc);
									xiomiColor(subc);
								break;
							case 2: samsung(subc);
								samsungColor(subc);
								break;
							case 3:oppo(subc);
									oppoColor(subc);
							break;
							default : System.out.println("<< ***** Invalid Option Please Select Valid Option ***** >>");
							brand(subc);
							break;
						}
			}
			
			public static void oppo(Scanner subc)
			{
				System.out.println("0. Options for Color"); 
				filter("OPPO", null, null, "Mobile");
				int option1 = subc.nextInt(); 
				if(option1 == 0)
				{
					oppoColor(subc);
			
				}
				else if(option1 == 99)
					brand(subc);
				else{
					AddToCart(AddItem,option1);
					
				}
			}
			
			public static void oppoColor(Scanner subc)
			{
				System.out.println("Colours: "
						+ "\n1. Black"
						+ "\n2. Gold"
						+ "\n3. Blue"
						+ "\n99.Back");
				int option1 = subc.nextInt();
				
				switch(option1)
				{
				case 99:oppo(subc);
					break;
				case 1: filter("OPPO", "Black", null, "Mobile");
					option1 = subc.nextInt();
					if(option1 == 99)
						oppo(subc);
					else
						AddToCart(AddItem,option1);
						
					break;
				case 2: filter("OPPO", "Gold", null, "Mobile");
					option1 = subc.nextInt();
					if(option1 == 99)
						oppo(subc);
					else
						AddToCart(AddItem,option1);
					
					break;	
				case 3: filter("OPPO", "Blue", null, "Mobile");
					option1 = subc.nextInt();
					if(option1 == 99)
						oppo(subc);
					else
						AddToCart(AddItem,option1);
					
				break;
				default : System.out.println("<< ***** Invalid Option Please Select Valid Option ***** >>");
				oppoColor(subc);
				break;
				}
			}
			
			public static void samsung(Scanner subc)
			{
				System.out.println("0. Options for Colour");
				filter("Samsung", null, null, "Mobile");
				int option5 = subc.nextInt();
				if(option5 == 0)
				{	
					samsungColor(subc);
					
				}
				else if(option5 == 99)
					brand(subc);
				else
				{
					AddToCart(AddItem,option5);
					
				}
			}
			
			public static void samsungColor(Scanner subc)
			{
				System.out.println("Colours: "
						+ "\n1. Black"
						+ "\n2. Gold"
						+ "\n3. Blue"
						+ "\n99. Back");
				int option5 = subc.nextInt();
				
				switch(option5)
				{
				case 99: samsung(subc);
				break;
				case 1: filter("Samsung", "Black", null, "Mobile");
				option5 = subc.nextInt();
					if(option5 == 99)
						samsungColor(subc);
					else
						AddToCart(AddItem,option5);
						
					break;
				case 2: filter("Samsung", "Gold", null, "Mobile");
					option5 = subc.nextInt();
					if(option5 == 99)
						samsungColor(subc);
					else
						AddToCart(AddItem,option5);
						
						break;	
				case 3: filter("Samsung", "blue",null, "Mobile");
						option5 = subc.nextInt();
						if(option5 == 99)
							samsungColor(subc);
						else
							AddToCart(AddItem,option5);
							
						break;
				default : System.out.println("<< ***** Invalid Option Please Select Valid Option ***** >>");
				samsungColor(subc);
				break;
				}
			}
			
			public static void xiomi(Scanner subc)
			{
				System.out.println("0. Options for Color"); 
				filter("Xiomi", null, null, "Mobile");
				int option3 = subc.nextInt(); 
				if(option3 == 0)
				{
					xiomiColor(subc);
				}
				else if(option3 == 99)
					brand(subc);
				else
				{
					AddToCart(AddItem,option3);
					
				}
			}
			
			public static void xiomiColor(Scanner subc)
			{
				System.out.println("Colours: "
						+ "\n1. Black"
						+ "\n2. Gold"
						+ "\n3. Blue"
						+ "\n99.Back");

				int option3 = subc.nextInt();
				
				switch(option3)
				{
				case 99: xiomi(subc);
					break;
				case 1: filter("Xiomi", "Black", null, "Mobile");
						option3 = subc.nextInt();
						if(option3 == 99)
							xiomi(subc);
						else
							AddToCart(AddItem,option3);
							
					break;
				case 2: filter("Xiomi", "Gold", null, "Mobile");
					option3 = subc.nextInt();
					if(option3 == 99)
						xiomi(subc);
					else
						AddToCart(AddItem,option3);
						
					break;	
				case 3: filter("Xiomi", "Blue", null, "Mobile");
					System.out.println("axc");
					option3 = subc.nextInt();
					if(option3 == 99)
						xiomiColor(subc);
					else
						AddToCart(AddItem,option3);
						
					break;
				default : System.out.println("<< ***** Invalid Option Please Select Valid Option ***** >>");
				xiomiColor(subc);
				break;
			}
	}
			
	public static void filter(String Brand, String colour, String gender, String catagory ) {
		for(int i = 0; i<ArrayList1.size();i++) {
			if((colour == ArrayList1.get(i).colour || colour == null) 
					&& (Brand == ArrayList1.get(i).brand || Brand == null) 
					&& (gender == ArrayList1.get(i).gender || gender == null)
					&& (catagory == ArrayList1.get(i).catagory || catagory == null)) {
				System.out.println( (i+1)+". "+ArrayList1.get(i)+ " Rs:>" +ArrayList1.get(i).price);
			}
			
		}
//		System.out.println( "99. Back");
	}
	
	public static void AddToCart(ArrayList AddItem1,int option)
	{	
		System.out.println("Item is added");
		System.out.println( ArrayList1.get(option-1).name +" Rs:>"+ArrayList1.get(option-1).price);
		AddItem.add(ArrayList1.get(option-1));
//		AddItem.add() = option - 1;
//		ArrayList1 = AddItem1;
		
		//System.out.println( "total Item :" +itemIndCloth);
		AllCart();
	}
	public static void AllCart()
	{
		double sum = 0;
		System.out.println("All Added Item Are : ");
		for(int i = 0;i<AddItem.size(); i++)
		{
			System.out.println( i + " " + AddItem.get(i));
			sum += AddItem.get(i).price;
		}
		System.out.println("Total Amount: " + sum);

		if(sum<amount || amount<0)
		{
			continuecart(sum);
		}
		else{
			System.out.println("****You Are Crossing Your Budget****"
						    +"\n*****  Be Sure U Buy IN Budegt *****");
			continuecart(sum);
		}
		
		
		
	}
	
	static void continuecart(double sum)
	{
		System.out.println("If You Want Continue Shopping OR Generate Final Bill :)"
							+"\n1. Continue Shopping"
							+"\n2. Payment"
							+"\n3. Delete Item from Cart");
		Scanner subc = new Scanner(System.in);
		int option = subc.nextInt();
		if( option == 1) {
			print();
		}
		else if(option == 2)
		{
			Payment.PaymentMethod(sum);
		}
		else if(option ==3)
		{
			for(int i = 0;i<AddItem.size(); i++)
			{	
				System.out.println( i + " " + AddItem.get(i));
			}
			System.out.println("Select Item which you want to delete");
			int option1 = subc.nextInt();
			AddItem.remove(option1);
			AllCart();
		}
		subc.close();
	}
	
	public static void itemList(){
		ProductNames item1 = new  ProductNames(1,"Redmi-11","Xiomi","Blue",11999.00,"Mobile",null);
		ProductNames item2 = new  ProductNames(2,"Redmi-11","Xiomi","Black",11999.00,"Mobile",null);
		ProductNames item3 = new  ProductNames(3,"Redmi Note-12","Xiomi","Blue",17999.00,"Mobile",null);
		ProductNames item4 = new  ProductNames(4,"M-21","Samsung","Blue",10990.00,"Mobile",null);
		ProductNames item5 = new  ProductNames(5,"M-21","Samsung","Gold",10990.00,"Mobile",null);
		ProductNames item6 = new  ProductNames(6,"Galaxy M-13","Samsung","Gold",9699.00,"Mobile",null);
		ProductNames item7 = new  ProductNames(7,"Galaxy M-13","Samsung","Black",9699.00,"Mobile",null);
		ProductNames item8 = new  ProductNames(8,"A-31","OPPO","Gold",12490.00,"Mobile",null);
		ProductNames item9 = new  ProductNames(9,"A17K","OPPO","Blue",9499.00,"Mobile",null);
		ProductNames item10 = new  ProductNames(10,"Collar TShirt","Puma","Blue",999.00,"Cloth","Male");
		ProductNames item11 = new  ProductNames(11,"Collar TShirt","Max","Blue",599.00,"Cloth","Male");
		ProductNames item12 = new  ProductNames(12,"Collar TShirt","Puma","Red",989.00,"Cloth","Male");
		ProductNames item13 = new  ProductNames(13,"Collar TShirt","Max","Red",499.00,"Cloth","Male");
		ProductNames item14 = new  ProductNames(14,"TShirt","Puma","Blue",809.00,"Cloth","Male");
		ProductNames item15 = new  ProductNames(15,"TShirt","Max","Blue",509.00,"Cloth","Male");
		ProductNames item16 = new  ProductNames(16,"TShirt","Puma","White",809.00,"Cloth","Male");
		ProductNames item17 = new  ProductNames(17,"TShirt","Max","White",409.00,"Cloth","Male");
		ProductNames item18 = new  ProductNames(18,"Jeans","Puma","Blue",1599.00,"Cloth","Male");
		ProductNames item19 = new  ProductNames(19,"Jeans","Puma","Black",1599.00,"Cloth","Male");
		ProductNames item20 = new  ProductNames(20,"Kurti","Puma ","Blue",1599.00,"Cloth","Female");
		
		ArrayList1.add(item1);
		ArrayList1.add(item2);
		ArrayList1.add(item3);
		ArrayList1.add(item4);
		ArrayList1.add(item5);
		ArrayList1.add(item6);
		ArrayList1.add(item7);
		ArrayList1.add(item8);
		ArrayList1.add(item9);
		ArrayList1.add(item10);
		ArrayList1.add(item11);
		ArrayList1.add(item12);
		ArrayList1.add(item13);
		ArrayList1.add(item14);
		ArrayList1.add(item15);
		ArrayList1.add(item16);
		ArrayList1.add(item17);
		ArrayList1.add(item18);
		ArrayList1.add(item19);
		ArrayList1.add(item20);
		
		
		
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
		 		 if(amount<0)
		 		 {
		 			 System.out.println("Please enter amount greator than zero");
		 			 budget();
		 			 return;
		 		 }
			break;
		case 2: 
			amount = -1;
			break;
		
		}
		itemList();
 		print();
			
	}

}
