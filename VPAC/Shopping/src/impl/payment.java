package impl;

import java.util.Random;
import java.util.Scanner;
import Project.*;
import custome_exception.InvalidChoiceException;
import user.signin.*;

public class payment {

	private static String rotp = null;
	private static String otp = null;
	private static double amount = 0;
	private static double Bill = 0;
	private static double months = 0;
	private static  double emi = 0;
	private static int otpCall = 2;
	public static SignUp sign= null;
	public static Product product = null;
	Scanner sc=new Scanner(System.in);


	public void paymentMethod(double sum, SignUp S, Product prod) 
	{
		product = prod;
		sign = S;
		amount = sum;
		System.out.println("*****Choose Payment Method*****");
		System.out.println(" 1: Pay With Debit/Credit/ATM Cards\n 2: Net Banking \n 3: UPI Apps\n 4: Cash on Delivery");
		int choice	= sc.nextInt();	

		if(choice == 1) 
		{
			cardPayment();
		}
		else if(choice == 3)
		{
			upiPayment();
		}

		else if(choice == 2)
		{
			netPayment();
		}
		else if(choice == 5)
		{
			emiMethod();
		}
		else if(choice == 4)
		{
			System.out.println("#######Order Placed Successfully#######");
			System.out.println("*****Your Oder Will Be Reached Within 6 to 7 Working Days*****");
			try
			{
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			Invoice.generateInvoice(sum, S, prod);
			System.out.println(">>>>>>> Thank You Visit Again <<<<<<<");
			
		}

		/*else 
		{
			try {
				String msg = ".........Invalid Choice, Kindly Enter Valid Choice!......";
				throw new InvalidChoiceException(msg);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}*/
		else
		{
			System.out.println("<<<<< Invalid Choice, Kindly Enter Valid Choice!!! >>>>>");
			System.out.println("---------------------------------------------------------");
			paymentMethod(amount,sign,product);
			//			try 
			//			{
			//				String msg = ".........Invalid Choice, Kindly Enter Valid Choice!......";
			//				paymentMethod(amount,sign,product); 
			//				throw new InvalidChoiceException(msg);
			//			}
			//			catch(Exception e){
			//				System.out.println(e.getMessage());
			//			}
			//
			//			while(true)
			//			{
			//				System.out.println("****** UPI Payment Method*******");
			//				System.out.println(" 1: PhonePay\n 2: GooglePay \n 3: PAYTM");
			//				System.out.println("*****Choose your Payment Method*****");
			//				choice1	= sc.nextInt();
			//			}

		}
	}

	public void cardPayment()
	{

		System.out.println(" 1: American Express Card\n 2: MasterCard\n 3: Visa \n 9:Back");
		System.out.println("*******Select Your Card Payment Method*******");
		int choice1 = sc.nextInt();
		if(choice1 == 1)
		{
			System.out.println("***\nTo countinue press 1 \t To go Back press 9");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:american();
			//				cardDigit();
			break;
			case 9: cardPayment();
			break;
			default : System.out.println(" ==>>OOPS!!! you have entered invalid Choice... \n  ==>>Please enter the valid choice....");
			cardPayment();
			break;
			}
		}
		else if(choice1 ==2)
		{
			System.out.println("***\nTo countinue press 1 \t To go Back press 9");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:masterCard();
			//				cardDigit();
			break;
			case 9: cardPayment();
			break;
			default : System.out.println(" ==>>OOPS!!! you have entered invalid Choice... \n  ==>>Please enter the valid choice....");
			cardPayment();
			break;

			}
		}
		else if(choice1 == 3)
		{
			//			try
			//			{
			System.out.println("***\nTo countinue press 1 \t To go Back press 9***");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:visa();
			//					cardDigit();
			break;
			case 9: cardPayment();
			break;
			default : System.out.println(" ==>>OOPS!!! you have entered invalid Choice... \n  ==>>Please enter the valid choice....");
			cardPayment();
			break;
			}

			//			}
			//			catch(Exception ie)
			//			{
			//				ie.printStackTrace();
			//				cardPayment();
			//			}
		}
		else if(choice1==9)
		{
			paymentMethod(amount,sign,product);
		}
		else {
//			try 
//			{
//				String msg = "<<<<<Invalid Choice, Kindly Enter Valid Choice!!!>>>>>";
			System.out.println("<<<<<Invalid Choice, Kindly Enter Valid Choice!!!>>>>>");
				cardPayment();
//				throw new InvalidChoiceException(msg);
//			}
//			catch(Exception e){
//				System.out.println(e.getMessage());
//			}
//			while(true)
//			{
//				System.out.println(" 1: American Express Card\n 2: MasterCard\n 3: Visa");
//				System.out.println("*******Select Your Card Payment Method*******");
//				choice1 = sc.nextInt();
//			}
		}
	}
//	public void cardNoCheck()
//	{
//
//		System.out.println("=====>>Enter 16 Digit Card Number......");
//		String card=sc.next();
//		for(int i=0; i<1;i++)
//		{
////			if(card.charAt(0)=='3')
////			{
////				cardDigit(card);
////
////			}
//			 if(card.charAt(0)=='3'||card.charAt(0)=='5' || card.charAt(0)=='4')
//			{
//				cardDigit(card);
//
//			}
////			else if(card.charAt(0)=='4')
////			{
////				cardDigit(card);
////			}
//			else
//			{
//				System.out.println("==>>You have entered wrong number!! please enter the valid number.....");
//				cardPayment();
//			}
//		}
//	}
	public void visa()
	{
		System.out.println("=====>>Enter 16 Diget Card Number......");
		String card=sc.next();
		for(int i=0; i<1;i++)
		{
			if(card.charAt(0)=='4')
			{
				cardDigit(card);
			}
			else
			{
				System.out.println("==>>You have entered wrong number!! please enter the valid number.....");
				cardPayment();
			}
		}
	}

	public void masterCard()
	{
		System.out.println("=====>>Enter 16 Diget Card Number......");
		String card=sc.next();
		for(int i=0; i<1;i++)
		{
			if(card.charAt(0)=='3'||card.charAt(0)=='5')
			{
				cardDigit(card);

			}
			else
			{
				System.out.println("==>>You have entered wrong number!!! please enter the valid number.....");
				cardPayment();
			}
		}
	}

	public void american()
	{
		System.out.println("=====>>Enter 16 Diget Card Number......");
		String card=sc.next();
		for(int i=0; i<1;i++)
		{
			if(card.charAt(0)=='3')
			{
				cardDigit(card);

			}
			else
			{
				System.out.println(" ==>> You have entered wrong number!!! Please enter the valid number....");
				cardPayment();
			}
		}
	}

	public void cardDigit(String card)
	{
		if(card.length()>15 && card.length()<=17)
		{
			System.out.println("*****Card Number entered successfully*****");
			System.out.println("=====>>Enter your CVV...");
			int cv=sc.nextInt();
			if(cv>99 && cv<=999)
			{
				orderDone();
			}
			else
			{
				System.out.println("The CVV entered is inappropriate...."
						+ "\n please ReEnter..... ");
				cardDigit(card);
			}
		}
		else
		{
			System.out.println(" ==>>Oopsss!!!! You have entered Invalid length...... \n ==>>Please enter the valid length....");
		}
	}

	public void netPayment()
	{

		System.out.println("*******Net Banking*******");
		System.out.println(" 1: Airtel Payment Bank\n 2: Axis Bank\n 3: HDFC Bank\n 4: ICICI Bank\n 5: SBI Bank \n 9: Back");

		int choice2 =sc.nextInt();
		if(choice2 == 1 || choice2 == 2 || choice2 == 3 || choice2 == 4 || choice2 == 5)
		{
			reEnter();
		}
		else if(choice2==9)
		{
			paymentMethod(amount,sign,product);
		}
	
		else
		{
			System.out.println(" ==>>Oopsss!!!! You have entered Invalid choice...... \n ==>>Please enter the valid choice....");
			netPayment();
		}

	}
	public void reEnter()
	{
		System.out.println("=====>>Enter Your Name.......");
		String name=sc.next();
		System.out.println("=======>>Enter Your Password......");
		String pwd=sc.next();

		if(pwd.length() >=8 && pwd.length()<=16)
		{
			otpMethod();
		}
		else 
		{
			try {
				String msg = "==>> Oppss!!! you have entered Invalid Password.... \n ==>Kindly Enter Valid Password!!!....";

				throw new InvalidChoiceException(msg);
			}catch(Exception e){
				System.out.println(e.getMessage());
				reEnter();
			}
		}
	}
	public String OTP() {
		String num="0123456789";
		Random otp=new Random();
		String rotp = "";
		for(int j=0;j<=3; j++)
		{
			//rotp[j]=num.charAt(otp.nextInt(num.length()));
			rotp +=num.charAt(otp.nextInt(num.length()));
		}
		return rotp;
	}
	public void orderDone()
	{
		try
		{
			Thread.sleep(3000);
			System.out.println("......your CVV recieved.....");
			otpMethod();

		}
		catch (java.lang.Exception ie)
		{
			ie.printStackTrace();
			paymentMethod(amount,sign,product);
		}
	}
	public void upiPayment()
	{
		System.out.println("****** UPI Payment Method*******");
		System.out.println(" 1: PhonePay\n 2: GooglePay \n 3: PAYTM \n 9: Back");
		System.out.println("*****Choose your Payment Method*****");
		int choice1	= sc.nextInt();	
		if(choice1 == 1 || choice1 == 2 ||choice1 == 3)
		{	
			otpMethod();
		}
		else
			paymentMethod(amount,sign,product);
		
	}
	
	public void otpMethod()
	{
		int ti = 0;
		while(ti++<otpCall)
		{	
			String otp = OTP();
			System.out.println("Yout OTP is.. "+otp+"  Bill of online purchase \n "+Product.showAllCart());
			System.out.println("=====>>Enter OTP Sent To Your Mobile Number......");
			String check=sc.next();
			if(otp.equals(check))
			{
				
				try 
				{
					Thread.sleep(3000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				System.out.println("=====>>OTP Verified Successfully.....");
	
				System.out.println("#######Order Placed Successfully#######");
				System.out.println("*****Your Oder Will Be Reached Within 6 to 7 Working Days*****");

				Invoice.generateInvoice(amount, sign, product);
				try
				{
					Thread.sleep(3000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println(">>>>>>>Thank You Visit Again<<<<<<<");
				return;
			}
			else
			{
				if(ti<otpCall)
					System.out.println("Wrong Otp Please try again"
						+ "\nNew Otp Send");
				else
					System.out.println("Wrong Otp Please try again. Try Payment again");
			}
		}
		paymentMethod(amount,sign,product);
	}

	public void emiMethod()
	{
		System.out.println(" Option 1: 3 months \n Option 2: 6 months \n Option 3: 9 months \n Option 9: Back");
		System.out.println("*******Select Your EMI Options*******");
		int choice1 = sc.nextInt();
		if(choice1 == 1)
		{
			System.out.println("***\nTo countinue press 1 \t To go Back press 9");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:months3();
			
			break;
			case 9: emiMethod();
			break;
			}
		}
		if(choice1==2)
		{
			System.out.println("***\nTo countinue press 1 \t To go Back press 9");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:months6();
			
			break;
			case 9: emiMethod();
			break;
			}
		}
		if(choice1==3)
		{
			System.out.println("***\nTo countinue press 1 \t To go Back press 9");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:months9();
			
			break;
			case 9: emiMethod();
			break;
			}
		}
		else if(choice1==9)
		{
			paymentMethod(amount,sign,product);
		}
		else 
		{
			System.out.println(" ==>>Oopsss!!!! You have entered Invalid choice...... \n ==>>Please enter the valid choice....");
			emiMethod();
		}
	}
	public void months3()
	{
		double total_Bill=amount*0.15;
		//min_pay=Bill-(Bill*20);
		total_Bill=Bill+amount;
		System.out.println("..You have to pay minimum 40% of total Bill.....");
		double min_pay=total_Bill-(total_Bill*0.60);
		emi = emi/3;
		System.out.println(emi/months);
	}
	public void months6()
	{
		double total_Bill=amount*0.15;
		//min_pay=Bill-(Bill*20);
		total_Bill=Bill+amount;
		System.out.println("..You have to pay minimum 40% of total Bill.....");
		double min_pay=total_Bill-(total_Bill*0.60);
		emi = emi/3;
		System.out.println(emi/months);
	}
	public void months9()
	{
		double total_Bill=amount*0.15;
		//min_pay=Bill-(Bill*20);
		total_Bill=Bill+amount;
		System.out.println("..You have to pay minimum 40% of total Bill.....");
		double min_pay=total_Bill-(total_Bill*0.60);
		emi = emi/3;
		System.out.println(emi/months);
	}
}
