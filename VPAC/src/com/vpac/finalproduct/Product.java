package com.vpac.finalproduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.vpac.product.Cloths;
import com.vpac.product.Electronic;

public class Product
{

	int ItemProduct = 0;
	ArrayList AddItem = new ArrayList(); 
	

	public static ArrayList<ProductNames> ArrayList1 = new ArrayList<ProductNames>();

	
	public static void print() {
		
		Scanner subc = new Scanner(System.in);
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
			System.out.println("0. List Of Product :)");
		filter(null, null, null, null);
		int option1 = subc.nextInt();
		if(option1== 0) {
			ProductNames.prod();
		}
		break;
		case 1: filter(null, null, null, "Mobile");
			break;
		case 2: filter(null, null, null, "Cloth");
			break;
//		case 3: Electronic_Lis. Back");t elec = new Electronic_List();
//				elec.addelectronic();
//				elec.printelectroniclist();
//
//			break;
//		case 4: HomeDecore_List home = new HomeDecore_List();
//				home.adddecore();
//				home.printhomeList();
//			break;
		}
		System.out.println("99. Back");
		subc.close();
		
//		filter(null,null,null,"Mobile");
//		for(int i = 0; i<ArrayList1.size(); i++) {
//			System.out.println( (i+1)+". "+ArrayList1.get(i).name+" Rs:>"+ArrayList1.get(i).price);
//		}
//		System.out.println("99
//		Scanner subc = new Scanner(System.in);
//		
//		int option = subc.nextInt();
		
//		Iterator<ProductNames> itr = ArrayList1.iterator();
//		while(itr.hasNext())
//		{
//			System.out.println(itr.next());
//		}
		//itemList();
		/*LinkedHashSet<ArrayList> ListProduct = new LinkedHashSet<ArrayList>(ArrayList1);
		ListProduct.add(ArrayList1);
		for(Object obj : ListProduct) {
			System.out.println(obj);
		}
		*/
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
	
	public void AddToCart(ProductNames Item,int option)
	{	
		System.out.println("Item is added");
		System.out.println( ArrayList1.get(option-1).name +" Rs:>"+ArrayList1.get(option-1).price);
		AddItem.add(ArrayList1.get(option-1));
		
		
		//System.out.println( "total Item :" +itemIndCloth);
		AllCart();
	}
	public void AllCart()
	{
		double sum = 0;
		itemList();
		System.out.println(" "+AddItem + " "+ ItemProduct);
		for(int i = 0;i<ArrayList1.size(); i++)
		{
			System.out.println( ArrayList1.get(i).name+" Rs:>"+ArrayList1.get(i).price);
			sum+=ArrayList1.get(i).price;
		}
		
		
//		System.out.println("Total Amount : "+sum);
//		
//			if(sum<amount)
//			{
//				continuecart(sum);
//			}
//			else{
//				System.out.println("****You Are Crossing Your Budget****"
//							    +"\n*****  Be Sure U Buy IN Budegt *****");
//				continuecart(sum);
//			}
		
		//System.out.println("Total Amount : "+sum);
		//continuecart(sum);
		
	}
	
	public void itemList(){
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
}


