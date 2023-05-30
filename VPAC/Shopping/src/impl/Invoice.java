package impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Project.*;
import user.signin.*;

public class Invoice {
	public static void generateInvoice(double sum, SignUp S, Product prod)
	{
		//S.show();
		UserDataPrint(S);
		prod.showAllCart();
		return;
				
	}
	
	public static void UserDataPrint(SignUp S)
	{
		File fr = new File("C:\\Users\\Dell\\Desktop\\VPAC\\Shopping\\IDPasswordDataBase\\" +S.getUsername());
		
		try {
			if(fr.exists())
			{
				Scanner scan = new Scanner(fr);
				scan.next();
				scan.next();
				
				while(scan.hasNext())
				{
					System.out.println(scan.next()+"\n");
				}
				scan.close();
			}
			else {
				System.out.println("#### Some Unexpected error to create invoice ####");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
