package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import impl.*;
import user.signin.*;

public class Product {
	
	static int ItemProduct = 0;
	static ArrayList<ProductNames> AddItem = new ArrayList<ProductNames>(); 
	static Scanner subc = new Scanner(System.in);
	public static SignUp sign= null;
	public static Product product = null;

	public static ArrayList<ProductNames> ArrayList1 = new ArrayList<ProductNames>();

	static double amount = 0;
	public static void print() {
		//itemList();
		System.out.println("  Press 0(Zero) to get List Of Products :)....");
//		filter(null, null, null, null);
		int option1 = subc.nextInt();
		if(option1== 0) {
			productOption();
		}
		else if(ArrayList1.size()>=option1 && option1>0){
			AddToCart(AddItem,option1);
		}
		else {
			System.out.println(" OOPPS!!! You have entered Invalid Option :) ");
			print();
		}
//		Scanner subc = new Scanner(System.in);
				//subc.close();
		
	}
	public static void productOption()
	{
		System.out.println("***** List Of Product *****");
		System.out.println("Select the Shopping Catagory "
				+ "\n1.Mobil "
				+ "\n2.Cloths "
				+ "\n3.Chocolate"
				+ "\n4.Table"
				+ "\n5.Bed"
				+ "\n6.Sofa"
				+ "\n7.Biscuit"
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
		case 1: mobile();
			break;
		case 2: cloth();
			break;
		case 3: chocolate();
			break;
		case 4: table();
		break;
		case 5: bed();
		break;
		case 6: sofa();
		break;
		case 7: biscuit();
		break;
		default : System.out.println("Please select Valid option");
		print();
		break;
		
		}
//		System.out.println("99. Back");

	}
	
	public static void filter(String Brand, String colour, String gender, String catagory ) {
		for(int i = 0; i<ArrayList1.size();i++) {
			if((ArrayList1.get(i).colour.equals( colour) || colour == null) 
					&& (ArrayList1.get(i).brand.equals( Brand) || Brand == null) 
					&& (ArrayList1.get(i).gender.equals( gender) || gender == null)
					&& (ArrayList1.get(i).catagory.equals( catagory) || catagory == null)) {
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
		double sum = showAllCart();
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
	
	public static double showAllCart()
	{
		double sum = 0;
		System.out.println("All Added Item Are : ");
		for(int i = 0;i<AddItem.size(); i++)
		{
			System.out.println( i + " " + AddItem.get(i));
			sum += AddItem.get(i).price;
		}
		System.out.println("Total Amount: " + sum);
		return sum;
		
	}
	
	static void continuecart(double sum)
	{
				System.out.println("!!!! If You Want Continue Shopping OR Generate Final Bill !!!! :)"
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
					//Payment.PaymentMethod(sum);
					payment pay = new payment();
					pay.paymentMethod(sum, sign, product);
				}
				else if(option ==3)
				{
					for(int i = 0;i<AddItem.size(); i++)
					{	
						System.out.println( i + " " + AddItem.get(i));
					}
					System.out.println("=====>>>Select Item which you want to Delete it....");
					int option1 = subc.nextInt();
					AddItem.remove(option1);
					AllCart();
				}
				subc.close();
		
	}
	public static void itemList1()
	{
		File fr = new File("C:\\Users\\Dell\\Desktop\\VPAC\\Shopping\\IDPasswordDataBase\\Product.txt");
		
		try {
			if(fr.exists())
			{
				Scanner scan = new Scanner(fr);
				
				while(scan.hasNext())
				{
					ProductNames item = new  ProductNames();
					//System.out.println(scan.next()+"\n");
					item.id = scan.nextInt();
					item.name = scan.next();
					item.brand = scan.next();
					item.colour = scan.next();
					item.price = scan.nextDouble();
					item.catagory = scan.next();
					item.gender = scan.next();
					
					ArrayList1.add(item);
				}
				scan.close();
			}
			else {
				System.out.println("OOPS!!! Some Unexpected error to create invoice ");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addProductAdmin(String name, String brand, String colour, double price, String catagory,String gender)
	{
		try {
			String fileName = "C:\\Users\\Dell\\Desktop\\VPAC\\Shopping\\IDPasswordDataBase\\Product.txt";
			File fr = new File(fileName);
			Scanner scan = new Scanner(fr);
			String readFile = "";
			int ind = 0;
			while(scan.hasNext()) {
				String s1 = scan.next();
				readFile += s1+"\n";
				ind ++;
				//System.out.println(s1);
			}
			String readFile1 = readFile.substring(0, readFile.length()-1);
			
			int pri = (int)price;
			FileWriter f1 = new FileWriter(fileName);
			f1.write(readFile1+"\n");
			f1.write((ind/7+1)+"\n");
			f1.write(name+"\n");
			f1.write(brand+"\n");
			f1.write(colour+"\n");
			f1.write(pri+"\n");
			f1.write(catagory+"\n");
			f1.write(gender+"\n");
			ProductNames item1 = new ProductNames((ind/7+1),name,brand,colour,pri,catagory,gender);
			ArrayList1.add(item1);
			f1.close();
			System.out.println("Successfully wrote a file");
		}
		catch(IOException ie){
			System.out.println(" an error occured!");
			ie.printStackTrace();
		}
	}
	
	
	public static void budget(SignUp S, Product prod)
	{
		product = prod;
		sign = S;
		Scanner subc = new Scanner(System.in);
		System.out.println("<<<Do You Like To Set Your OWN BUDGET?????"
							+"\n.1 ****Please Set your Budegt****"
							+"\n.2 ==>>Continue to  Shop UNLIMITEDLY...");
		int option = subc.nextInt();
		switch(option){
		case 1: System.out.println("<<Please Enter Your Budget....");
		 		 amount = subc.nextDouble();
		 		 if(amount<0)
		 		 {
		 			 System.out.println("<<<Please enter your Budget greater than zero");
		 			 budget(S,product);
		 			 return;
		 		 }
			break;
		case 2: 
			amount = -1;
			break;
		
		}
		//itemList();
		itemList1();
 		print();
			
	}
	public static double discount() 
	{
		double dis;
		double tdic=0;
		if(amount > 10000) {
			dis = amount*.05;
			tdic = amount-dis;
			
		}
		return tdic;
	}
	
	public static void mobile()
	{
		System.out.println("<<To Use Filter Category For Mobile Press '0'>>");
		filter(null, null, null, "Mobile");
		int option2 = subc.nextInt();	
		if(option2==0) 
		{
			filtermobile();
		}
		else {	
			AddToCart(AddItem,option2);
		}
	}
	
	public static void filtermobile()
	{
		System.out.println("<<Filter Category For Mobile>> "
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
		default : System.out.println("Please Select valid option");
			productOption();
			break;
		}
		
		subc.close();
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
				case 99:mobile();
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
				default : System.out.println("Please Select valid option");
				mobile();
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
					case 99:filtermobile();
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
					default : System.out.println("Please Select valid option");
					filtermobile();
					break;
				}
	}
	public static void oppo(Scanner subc)
	{
		System.out.println("0. Options for Color"); 
		filtermobile();
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
		case 1: filter(null, "Black", null, "Mobile");
			System.out.println("press 99 to back");
			option1 = subc.nextInt();
			if(option1 == 99)
				oppo(subc);
			else
				AddToCart(AddItem,option1);
				
			break;
		case 2: filter(null, "Gold", null, "Mobile");
			System.out.println("press 99 to back");
			option1 = subc.nextInt();
			if(option1 == 99)
				oppo(subc);
			else
				AddToCart(AddItem,option1);
			
			break;	
		case 3: filter(null, "Blue", null, "Mobile");
			System.out.println("press 99 to back");
			option1 = subc.nextInt();
			if(option1 == 99)
				oppo(subc);
			else
				AddToCart(AddItem,option1);;
			
		break;
		default : System.out.println("Please Select valid option");
		oppo(subc);
		break;
		}
	}
	
	public static void samsung(Scanner subc)
	{
		System.out.println("0. Options for Colour");
		filter("Samsung",null, null, "Mobile");
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
		case 1: filter("Samsung","Black", null, "Mobile");
		System.out.println("press 99 to back");
		option5 = subc.nextInt();
			if(option5 == 99)
				samsungColor(subc);
			else
				AddToCart(AddItem,option5);
				
			break;
		case 2: filter("Samsung","Gold", null, "Mobile");
			System.out.println("press 99 to back");
			option5 = subc.nextInt();
			if(option5 == 99)
				samsungColor(subc);
			else
				AddToCart(AddItem,option5);
				
				break;	
		case 3: filter("Samsung","Blue", null, "Mobile");
				System.out.println("press 99 to back");
				option5 = subc.nextInt();
				if(option5 == 99)
					samsungColor(subc);
				else
					AddToCart(AddItem,option5);
					
				break;
		default : System.out.println("Please Select valid option");
		samsung(subc);
		break;
				}
	}
	
	public static void xiomi(Scanner subc)
	{
		System.out.println("0. Options for Color"); 
		filter("Xiomi",null, null, "Mobile");
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
		case 1: filter("Xiomi","Black", null, "Mobile");
				System.out.println("press 99 to back");
				option3 = subc.nextInt();
				if(option3 == 99)
					xiomi(subc);
				else
					AddToCart(AddItem,option3);
					
			break;
		case 2: filter("Xiomi","Gold", null, "Mobile");
				System.out.println("press 99 to back");
			option3 = subc.nextInt();
			if(option3 == 99)
				xiomi(subc);
			else
				AddToCart(AddItem,option3);
				
			break;	
		case 3: filter("Xiomi","Blue", null, "Mobile");
			System.out.println("press 99 to back");
			option3 = subc.nextInt();
			if(option3 == 99)
				xiomiColor(subc);
			else
				AddToCart(AddItem,option3);
				
		break;
		default : System.out.println("Please Select valid option");
		xiomi(subc);
		break;
		}
	}
	public static void cloth() {
		System.out.println("<<To Use Filter Category For Gender Bases of Cloth Press '0'>>");
		filter(null, null, null, "Cloth");
		System.out.println("====>>Please enter ur choice from the list.....");
		int option2 = subc.nextInt();	
		if(option2==0) 
		{
			filterCloth();
		}
		else {	
			AddToCart(AddItem,option2);
		}
	}
	public static void filterCloth()
	{
		System.out.println(" forFilter "
				+ "\n1. Male "
				+ "\n2. Female "
				+ "\n99.Back");
		
		Scanner subc = new Scanner(System.in);
		
		int option = subc.nextInt();
		
		switch(option)
		{
		case 99: cloth();
			break;
		case 1:  male(subc);
			break;
		case 2: female(subc);
			break;
		default : System.out.println("Please Select valid option");
				cloth();
			break;
		}
		
		subc.close();
	}
	
	public static void male(Scanner subc) {
		System.out.println("Brands of Male "
				+ "\n1. Puma "
				+ "\n2. MAX"
				+ "\n99 back");
				int option1 = subc.nextInt();
				switch(option1)
				{
				case 99: filterCloth();
					break;
				case 1: malepuma(subc);
					break;
				case 2: malemax(subc);
						break;
				default : System.out.println("Please Select valid option");
						filterCloth();
						break;		
				}
	}
	public static void malepuma(Scanner subc)
	{
		System.out.println("Male Puma "
				+"\n1. Blue"
				+"\n2. Black"
				+ "\n3. Red"
				+ "\n4. White"
				+"\n99.Back"); 
//		filter("Puma", null, "Male", "Cloth");
		int option3 = subc.nextInt();
			
			switch(option3) 
			{
			case 99: male(subc);
				break;
			case 1:
				filter("Puma", "Blue", "Male", "Cloth");
				int option4 = subc.nextInt();
				AddToCart(AddItem,option4);
			break;
			case 2:
				filter("Puma", "Black", "Male", "Cloth");
				int option5 = subc.nextInt();
				AddToCart(AddItem,option5);
				break;
			case 3:
				filter("Puma", "Red", "Male", "Cloth");
				int option6 = subc.nextInt();
				AddToCart(AddItem,option6);
			break;
			case 4:
				filter("Puma", "White", "Male", "Cloth");
				int option7 = subc.nextInt();
				AddToCart(AddItem,option7);
			break;
			default : System.out.println("Please Select valid option");
				male(subc);
			break;
			}
	}
	public static void malemax(Scanner subc)
	{
		System.out.println("Male Max "
				+"\n1. Blue"
				+"\n2. Black"
				+ "\n3. Red"
				+ "\n4. White"
				+"\n99.Back");  
//			filterListc("gender", "MAX", clothlist);
				int option4 = subc.nextInt();
				switch(option4) 
				{
				case 99: male(subc);
				break;
			case 1:
				filter("Max", "Blue", "Male", "Cloth");
				int option5 = subc.nextInt();
				AddToCart(AddItem,option5);
			break;
			case 2:
				filter("Max", "Black", "Male", "Cloth");
				int option6 = subc.nextInt();
				AddToCart(AddItem,option6);
				break;
			case 3:
				filter("Max", "Red", "Male", "Cloth");
				int option7 = subc.nextInt();
				AddToCart(AddItem,option7);
			break;
			case 4:
				filter("Max", "White", "Male", "Cloth");
				int option8 = subc.nextInt();
				AddToCart(AddItem,option8);
			break;
				}
	}
//-----------------------------------------------------------female	
	public static void female(Scanner subc) {
		System.out.println("Brands of Male "
				+ "\n1. Puma "
				+ "\n2. MAX"
				+ "\n99 back");
				int option1 = subc.nextInt();
				switch(option1)
				{
				case 99: filterCloth();
					break;
				case 1: femalepuma(subc);
					break;
				case 2: femalemax(subc);
						break;			
				}
	}
	public static void femalepuma(Scanner subc)
	{
		System.out.println("FeMale Puma "
				+"\n1. Blue"
				+"\n2. Black"
				+ "\n3. Red"
				+ "\n4. White"
				+"\n99.Back"); 
//		filter("Puma", null, "Male", "Cloth");
		int option3 = subc.nextInt();
			
			switch(option3) 
			{
			case 99:female(subc);
				break;
			case 1:
				System.out.println("<<Press '0' for Back......");
				filter("Puma", "Blue", "Female", "Cloth");
				int option4 = subc.nextInt();
				if(option4==0) {
					femalemax(subc);
				}
				else {
					AddToCart(AddItem,option4); }
			break;
			case 2:
				System.out.println("<<Press '0' for Back......");
				filter("Puma", "Black", "Female", "Cloth");
				int option5 = subc.nextInt();
				if(option5==0) {
					femalemax(subc);
				}
				else {
					AddToCart(AddItem,option5); }
			case 3:
				System.out.println("<<Press '0' for Back......");
				filter("Puma", "Red", "Female", "Cloth");
				int option6 = subc.nextInt();
				if(option6==0) {
					femalemax(subc);
				}
				else {
					AddToCart(AddItem,option6); }
			break;
			case 4:
				System.out.println("<<Press '0' for Back......");
				filter("Puma", "White", "Female", "Cloth");
				int option7 = subc.nextInt();
				if(option7==0) {
					femalemax(subc);
				}
				else {
					AddToCart(AddItem,option7); }
			break;
			}
	}
	public static void femalemax(Scanner subc)
	{
		System.out.println("FeMale Max "
				+"\n1. Blue"
				+"\n2. Black"
				+ "\n3. Red"
				+ "\n4. White"
				+"\n99.Back");  
//			filterListc("gender", "MAX", clothlist);
				int option4 = subc.nextInt();
				switch(option4) 
				{
				case 99: female(subc);
				break;
			case 1:
				System.out.println("<<Press '0' for Back......");
				filter("Max", "Blue", "Female", "Cloth");
				int option5 = subc.nextInt();
				if(option5==0) {
					femalemax(subc);
				}
				else {
					AddToCart(AddItem,option5); }
			break;
			case 2:
				System.out.println("<<Press '0' for Back......");
				filter("Max", "Black", "Female", "Cloth");
				int option6 = subc.nextInt();
				if(option6==0) {
					femalemax(subc);
				}
				else
					AddToCart(AddItem,option6);
				break;
			case 3:
				System.out.println("<<Press '0' for Back......");
				filter("Max", "Red", "Female", "Cloth");
				int option7 = subc.nextInt();
				if(option7==0) {
					femalemax(subc);
				}
				else {
						AddToCart(AddItem,option7); }
			break;
			case 4:
				System.out.println("<<Press '0' for Back......");
				filter("Max", "White", "Female", "Cloth");
				int option8 = subc.nextInt();
				if(option8==0) {
					femalemax(subc);
				}
				else {
						AddToCart(AddItem,option8); }
			break;
				}
	}
	public static void chocolate() {
		System.out.println("<<To Go Back Press '0'>>");
		filter(null, null, null, "Chocolate");
		int option2 = subc.nextInt();	
		if(option2==0) 
		{
			productOption();
		}
		else {	
			AddToCart(AddItem,option2);
		}
	}
	
	public static void table() {
		System.out.println("<<To Go Back Press '0'>>");
		filter(null, null, null, "Table");
		int option2 = subc.nextInt();	
		if(option2==0) 
		{
			productOption();
		}
		else {	
			AddToCart(AddItem,option2);
		}
	}
	public static void bed() {
		System.out.println("<<To Go Back Press '0'>>");
		filter(null, null, null, "Bed");
		int option2 = subc.nextInt();	
		if(option2==0) 
		{
			productOption();
		}
		else {	
			AddToCart(AddItem,option2);
		}
	}
	public static void sofa() {
		System.out.println("<<To Go Back Press '0'>>");
		filter(null, null, null, "Sofa");
		int option2 = subc.nextInt();	
		if(option2==0) 
		{
			productOption();
		}
		else {	
			AddToCart(AddItem,option2);
		}
	}
	
	public static void biscuit() {
		System.out.println("<<To Go Back Press '0'>>");
		filter(null, null, null, "Biscuit");
		int option2 = subc.nextInt();	
		if(option2==0) 
		{
			productOption();
		}
		else {	
			AddToCart(AddItem,option2);
		}
	}
	

}
