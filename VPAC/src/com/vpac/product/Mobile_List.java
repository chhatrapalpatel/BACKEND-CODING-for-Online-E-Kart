package com.vpac.product;

import java.util.Scanner;

public class Mobile_List {
	Mobile[] mobileList = new Mobile[9];
	double totalbill;

	public void itemp()
	{
		
	}
	
	public void printMobileList()
	{
		try {
		System.out.println("0. Filter");
		for(int i = 0; i<mobileList.length; i++) {
			System.out.println( (i+1)+". "+mobileList[i].name+" Rs:>"+mobileList[i].price);
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
			Product_List x = new Product_List();
			x.product();
		}
		else
		{
			Product_List.AddToCart(mobileList,option);
		}
		subc.close();
		}
		catch(Exception me){
			System.out.println("Please Check Array Index value"+me);
		}
	}
	
	public void filter()
	{
		System.out.println("Filter "
				+ "\n1. brand "
				+ "\n2. color "
				+ "\n99 Back");
		
		Scanner subc = new Scanner(System.in);
		
		int option = subc.nextInt();
			
		switch(option)
		{
		case 99: printMobileList();
			break;
		case 1: brand(subc);
				break;		
		case 2: color(subc);
			break;
		}
		
		subc.close();
	}
	public void color(Scanner subc)
	{
		System.out.println("Colours: "
				+ "\n1. black"
				+ "\n2. gold"
				+ "\n3. blue"
				+ "\n99 Back");
				int option2 = subc.nextInt();
				switch(option2)
				{
				case 99:filter();
					break;
				case 1: filterList("", "black", mobileList);
					int option3 = subc.nextInt();
					if(option3 == 99)
						color(subc);
					else
						Product_List.AddToCart(mobileList,option3);
					
					break;
				case 2: filterList("", "gold", mobileList);
					option3 = subc.nextInt();
					if(option3 == 99)
						color(subc);
					else
						Product_List.AddToCart(mobileList,option3);
						
					break;	
				case 3: filterList("", "blue", mobileList);
					option3 = subc.nextInt();
					if(option3 == 99)
						color(subc);
					else
						Product_List.AddToCart(mobileList,option3);
						
				break;
				}
	}
	public void brand(Scanner subc)
	{
		System.out.println("Brands "
				+ "\n1. Xiomi"
				+ "\n2. Samsung"
				+ "\n3. OPPO"
				+ "\n99 Back");
				int option1 = subc.nextInt();
				switch(option1)
				{
					case 99:filter();
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
				}
	}
	public void oppo(Scanner subc)
	{
		System.out.println("0. Options for Color"); 
		filterList("OPPO", "", mobileList);
		int option1 = subc.nextInt(); 
		if(option1 == 0)
		{
			oppoColor(subc);
	
		}
		else if(option1 == 99)
			brand(subc);
		else{
			Product_List.AddToCart(mobileList,option1);
			
		}
	}
	
	public void oppoColor(Scanner subc)
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
		case 1: filterList("OPPO", "black", mobileList);
			option1 = subc.nextInt();
			if(option1 == 99)
				oppo(subc);
			else
				Product_List.AddToCart(mobileList,option1);
				
			break;
		case 2: filterList("OPPO", "gold", mobileList);
			option1 = subc.nextInt();
			if(option1 == 99)
				oppo(subc);
			else
			Product_List.AddToCart(mobileList,option1);
			
			break;	
		case 3: filterList("OPPO", "blue", mobileList);
			option1 = subc.nextInt();
			if(option1 == 99)
				oppo(subc);
			else
			Product_List.AddToCart(mobileList,option1);
			
		break;
		}
	}
	
	public void samsung(Scanner subc)
	{
		System.out.println("0. Options for Colour");
		filterList("Samsung", "", mobileList);
		int option5 = subc.nextInt();
		if(option5 == 0)
		{	
			samsungColor(subc);
			
		}
		else if(option5 == 99)
			brand(subc);
		else
		{
			Product_List.AddToCart(mobileList,option5);
			
		}
	}
	
	public void samsungColor(Scanner subc)
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
		case 1: filterList("Samsung", "black", mobileList);
		option5 = subc.nextInt();
			if(option5 == 99)
				samsungColor(subc);
			else
				Product_List.AddToCart(mobileList,option5);
				
			break;
		case 2: filterList("Samsung", "gold", mobileList);
			option5 = subc.nextInt();
			if(option5 == 99)
				samsungColor(subc);
			else
				Product_List.AddToCart(mobileList,option5);
				
				break;	
		case 3: filterList("Samsung", "blue", mobileList);
				option5 = subc.nextInt();
				if(option5 == 99)
					samsungColor(subc);
				else
					Product_List.AddToCart(mobileList,option5);
					
				break;
				}
	}
	
	public void xiomi(Scanner subc)
	{
		System.out.println("0. Options for Color"); 
		filterList("Xiomi", "", mobileList);
		int option3 = subc.nextInt(); 
		if(option3 == 0)
		{
			xiomiColor(subc);
		}
		else if(option3 == 99)
			brand(subc);
		else
		{
			Product_List.AddToCart(mobileList,option3);
			
		}
	}
	
	public void xiomiColor(Scanner subc)
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
		case 1: filterList("Xiomi", "black", mobileList);
				option3 = subc.nextInt();
				if(option3 == 99)
					xiomi(subc);
				else
					Product_List.AddToCart(mobileList,option3);
					
			break;
		case 2: filterList("Xiomi", "gold", mobileList);
			option3 = subc.nextInt();
			if(option3 == 99)
				xiomi(subc);
			else
				Product_List.AddToCart(mobileList,option3);
				
			break;	
		case 3: filterList("Xiomi", "blue", mobileList);
			System.out.println("axc");
			option3 = subc.nextInt();
			if(option3 == 99)
				xiomiColor(subc);
			else
				Product_List.AddToCart(mobileList,option3);
				
		break;
		}
	}
	
	public void filterList(String brand, String color, Mobile[] m)
	{
		for(int i = 0; i<m.length; i++) {
			/*
			if(type == "brand" && brand == m[i].brand)
				System.out.println( (i+1)+". "+m[i].name + " Rs:>"+m[i].price);
			else if(type == "colour" && color == m[i].colour)
				System.out.println( (i+1)+". "+m[i].name+ " Rs:>"+m[i].price);
			*/
			if( (color == m[i].colour || color == "") 
					&& (brand == m[i].brand || brand == "") )
				System.out.println( (i+1)+". "+m[i].name+ " Rs:>"+m[i].price);
		}
		System.out.println( "99. Back");
	}
	
	public Mobile[] addMobile()
	{
		Mobile redmi11 = new Mobile();
		redmi11.brand = "Xiomi";
		redmi11.name = "Redmi11";
		redmi11.colour = "black";
		redmi11.price = 11999;
		redmi11.id = 1;

		
		Mobile redmi12 = new Mobile();
		redmi12.brand = "Xiomi";
		redmi12.name = "Redmi Note 12";
		redmi12.colour = "blue";
		redmi12.price = 17999.00;
		redmi12.id = 2;


		Mobile redmi13 = new Mobile();
		redmi13.brand = "Xiomi";
		redmi13.name = "Redmi11";
		redmi13.colour = "gold";
		redmi13.price = 11999.00;
		redmi13.id = 3;
		
		Mobile samsung1 = new Mobile();
		samsung1.brand = "Samsung";
		samsung1.name = "M21";
		samsung1.colour = "black";
		samsung1.price = 10990.00;
		samsung1.id = 4;
		
		Mobile samsung2 = new Mobile();
		samsung2.brand = "Samsung";
		samsung2.name = "M21";
		samsung2.colour = "blue";
		samsung2.price = 10990.00;
		samsung2.id = 5;
		
		Mobile samsung3 = new Mobile();
		samsung3.brand = "Samsung";
		samsung3.name = "M13";
		samsung3.colour = "blue";
		samsung3.price = 10999.00;
		samsung3.id = 6;
		
		Mobile oppo1 = new Mobile();
		oppo1.brand = "OPPO";
		oppo1.name = "A17k";
		oppo1.colour = "blue";
		oppo1.price = 9499.00;
		oppo1.id = 7;
		
		Mobile oppo2 = new Mobile();
		oppo2.brand = "OPPO";
		oppo2.name = "A17k";
		oppo2.colour = "gold";
		oppo2.price = 9499.00;
		oppo2.id = 8;
		
		Mobile oppo3 = new Mobile();
		oppo3.brand = "OPPO";
		oppo3.name = "A31";
		oppo3.colour = "gold";
		oppo3.price = 12490.00;
		oppo3.id = 9;

		mobileList[0] = redmi11;
		mobileList[1] = redmi12;
		mobileList[2] = redmi13;

		mobileList[3] = samsung1;
		mobileList[4] = samsung2;
		mobileList[5] = samsung3;
		
		mobileList[6] = oppo1;
		mobileList[7] = oppo3;
		mobileList[8] = oppo3;
		return mobileList;
	}
	/*
	void Product_List.AddToCart(mobileList,int option)
	{	
		
		System.out.println("Item is added");
		System.out.println( mobileList[option-1].name+" Rs:>"+mobileList[option-1].price);
		System.out.println( "itemInd :" +itemInd);
		for(int i = 0;i<itemInd; i++)
		{
			System.out.println( mobileList[option-1].name+" Rs:>"+mobileList[option-1].price);
		}
		
	}
	*/

	
	
}
