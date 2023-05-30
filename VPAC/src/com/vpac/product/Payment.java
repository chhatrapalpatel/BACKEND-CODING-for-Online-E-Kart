package com.vpac.product;

import java.util.Scanner;

public class Payment {
	
	public static void PaymentMethod(double amount)
	{
		System.out.println("1. Cash On Delivery"
				+ "\n2. Card Payment"
				);
		
		Scanner subc = new Scanner(System.in);
		int option = subc.nextInt();
		
		switch(option)
		{
		case 1: cashPayment(amount);
		break;
		case 2: cardPayment(amount);
		break;
		}
		
		subc.close();
	}
	
	static void cashPayment(double amount)
	{
		System.out.println("Order Reached");
		System.out.println("Your Bill");
		System.out.println("Order Placed. Successfully");
	}
	
	static void cardPayment(double amount)
	{
		Scanner subc = new Scanner(System.in);
		System.out.println("Card Name: ");
		String cardName = subc.next();
		System.out.println("Card Number: ");
		String cardNo = subc.next();
		System.out.println("Expiry Date: ");
		String expiry = subc.next();
		System.out.println("CVV: ");
		int cvv = subc.nextInt();
		
		if(!cardNo.startsWith("3456"))
		{
			System.out.println("Invalid card number");
			cardPayment(amount);
		}
		else
		{
			System.out.println("OTP Sent Your Contact Number Successfully ");
			System.out.println("Enter Your OTP Number");
			int otp = subc.nextInt();
			
			if(otp == 5873)
			{
				System.out.println("Payment Succesful of amount " + amount);

				System.out.println("Order Placed. Successfully");
			}
			else
			{
				System.out.println("Invalid OTP. Please check");
			}
		}
		
		subc.close();
	}
	
}
