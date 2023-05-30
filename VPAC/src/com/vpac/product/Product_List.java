package com.vpac.product;

import java.util.Scanner;


public class Product_List {
	static double amount;
	public static void main(String[] args) {
		
		budget();
	}
	static int[] itemMobile = new int[20];
	static int itemIndMobile = 0;
	
	static int[] itemCloth = new int[20];
	static int itemIndCloth = 0;
	
	static int[] itemelct = new int[20];
	static int itemIndelect = 0;
	
	static Mobile[] mobileList1;
	static Cloths[] clothList1;
	static Electronic[] electroniclist1;
	
	public static  void AddToCart(Electronic[] electroniclist,int option)
	{	
		System.out.println("Item is added");
		System.out.println( electroniclist[option-1].name+" Rs:>"+electroniclist[option-1].price);
		itemCloth[itemIndCloth++] = option - 1;
		electroniclist1 = electroniclist;
		
		AllCart();
	}
	
	public static  void AddToCart(Cloths[] clothlist,int option)
	{	
		System.out.println("Item is added");
		System.out.println( clothlist[option-1].name+" Rs:>"+clothlist[option-1].price);
		itemCloth[itemIndCloth++] = option - 1;
		clothList1 = clothlist;
		
		//System.out.println( "total Item :" +itemIndCloth);
		AllCart();
	}

	public static void AddToCart(Mobile[] mobileList, int option)
	{	
		System.out.println("Item is added");
		System.out.println( mobileList[option-1].name+" Rs:>"+mobileList[option-1].price);
		itemMobile[itemIndMobile++] = option - 1;
		mobileList1 = mobileList;
		
		
		//System.out.println( "total Item :" +itemIndMobile);
		/*
		int sum = 0;
		for(int i = 0;i<itemIndMobile; i++)
		{
			System.out.println( mobileList[i].name+" Rs:>"+mobileList[i].price);
			sum+=mobileList[i].price;
		}
		
		System.out.println("Total Amount : "+sum);
		continuecart(sum);
		*/
		AllCart();
	}
	
	public static void AllCart()
	{
		double sum = 0;
		System.out.println(" "+itemIndMobile + " "+ itemIndCloth);
		for(int i = 0;i<itemIndMobile; i++)
		{
			System.out.println( mobileList1[itemMobile[i]].name+" Rs:>"+mobileList1[itemMobile[i]].price);
			sum+=mobileList1[itemMobile[i]].price;
		}
		for(int i = 0;i<itemIndCloth; i++)
		{
			System.out.println(clothList1[itemCloth[i]].name+" Rs:>"+clothList1[itemCloth[i]].price);
			sum+=clothList1[itemCloth[i]].price;
		}
		for(int i = 0;i<itemIndelect; i++)
		{
			System.out.println(electroniclist1[itemelct[i]].name+" Rs:>"+electroniclist1[itemelct[i]].price);
			sum+=electroniclist1[itemelct[i]].price;
		}
		
		System.out.println("Total Amount : "+sum);
		
			
				
			if(sum<amount || amount<0)
			{
				continuecart(sum);
			}
			else{
				System.out.println("****You Are Crossing Your Budget****"
							    +"\n*****  Be Sure U Buy IN Budegt *****");
				continuecart(sum);
			}
		
		//System.out.println("Total Amount : "+sum);
		//continuecart(sum);
		
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
		 		product();
			break;
		case 2: 
			amount = -1;
			product();
			break;
		
		}
			
	}
	static void continuecart(double sum)
	{
		System.out.println("If You Want Continue Shopping OR Generate Final Bill :)"
							+"\n1. Continue Shopping"
							+"\n2. Payment");
		Scanner subc = new Scanner(System.in);
		int option = subc.nextInt();
		if( option == 1) {
			Product_List.product();
		}
		else if(option == 2)
		{
			Payment.PaymentMethod(sum);
		}
		subc.close();
	}
	
	public static void product()
	{
		Scanner subc = new Scanner(System.in);
		System.out.println("List Of Product");
		System.out.println("Select the Shopping Catagory "
				+ "\n1.Mobil "
				+ "\n2.Cloths "
				+ "\n3.Electronic"
				+ "\n4.Home Decore");
		
		int option = subc.nextInt();
		
		switch(option)
		{
		case 1: Mobile_List mobile = new Mobile_List();
				mobile.addMobile();
				mobile.printMobileList();
				
			break;
		case 2: Cloth_List cloth = new Cloth_List();
				cloth.addcloth();
				cloth.printClothList();
		
			break;
		case 3: Electronic_List elec = new Electronic_List();
				elec.addelectronic();
				elec.printelectroniclist();

			break;
		case 4: HomeDecore_List home = new HomeDecore_List();
				home.adddecore();
				home.printhomeList();
			break;
		}
		
		subc.close();
	}

}
