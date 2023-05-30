package com.project;
import java.io.*;
import java.util.*;
public class SignUpIn {
	private String name;
	private String mobile_no;
	private String mail_id;
	private String address;
	private String username;
	private String password;
	Scanner scan = new Scanner(System.in);
	int choice;
	private static final String otp = null;
	private static final String otp1 = null;
	private static final String rotp = null;
	private static final String rotp1= null;

public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_no() {
		return mobile_no;
	}
	String mob1;
	public void setMobile_no(String mobile_no) {
	this.mobile_no = mobile_no;
//		String mob1=scan.next();
//		for(int i=0; i<=1; i++)
//		{
//			if(mob1.charAt(0)==6 || mob1.charAt(0)==7 || mob1.charAt(0)==8 || mob1.charAt(0)==9)
//			{
//				setMobile_no(mobile_no);
//			}
//			else
//			{
//				System.out.println("Invalid Mobile number Please enter valid Mobile number");
//				String mob=scan.next();
//				setMobile_no(mob);
//			}
//		}
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void homepage()
{
	System.out.println("1. New to VPAC? Create an Account\n2. Existing User? Log in\n3. Admin Login");
	System.out.println("\nEnter your choice: ");  
     choice = scan.nextInt();  
     if(choice==1){
    	 New_User();
     }
     else if(choice==2) {
    	 Existing_User();
     }
     else if(choice==3) {
    	 Admin_User();
     }
     else 
     {
    	 System.out.println("Enter valid choice");
    	 homepage();
     }
}
public void show()
{
	System.out.println(".........Details.........");
	System.out.println("Name is : "+ name);
	System.out.println("Mobile Number is : "+ mobile_no);
	System.out.println("Mail Id is : "+ mail_id);
	System.out.println("Address is : "+ address);
}
     public void New_User()
     {
    	 switch (choice) {  
       case 1:  
    	    System.out.println("Enter the name");
    		String name=scan.next();
    		setName(name);
    		System.out.println("Enter the Mobile Number");
    		String mobile_no =scan.next();
    		setMobile_no(mobile_no);
    		System.out.println("VPAC sented the OTP to verify your Mobile No");
    		System.out.println(OTP());
 			System.out.println("Enter the OTP");
 			String check=scan.next();
 			System.out.println("OTP Successfully Verified");
    		System.out.println("Enter the Mail Id");
    		String mail_id=scan.next();
    		setMail_id(mail_id);
    		System.out.println("VPAC sented the OTP to verify your Mail Id");
    		System.out.println(OTP1());
 			System.out.println("Enter the OTP");
 			String check1=scan.next();
 			System.out.println("OTP Successfully Verified");
    		System.out.println("Enter the Address");
    		String address=scan.next();
    		setAddress(address);
    		System.out.println("Enter the Username");
    		String username=scan.next();
    		setUsername(username);
    		System.out.println("Enter the Password");
    		checkpas();
//    		System.out.println("(Password should be minimum 8 to maximum 16 characters)");
//    		String Password=scan.next();
//    		setPassword(Password);
//    		checkpassword();
//    		display(Password);

    	 }
    	 }
     public void checkpas() {
    	System.out.println("(Password should be minimum 8 to maximum 16 characters)");
 		String Password=scan.next();
 		setPassword(Password);
 		checkpassword();
     }
    public void login() {	
    	System.out.println("V-PAC Shop Account Successfully Created");

    	System.out.println("=========================================================");
    	show();
    	System.out.println("=========================================================");
    		System.out.println("Enter the Username");
    		String username1=scan.next();
    		System.out.println("Enter the Password");
    		String Password1=scan.next();
    		condition(username1,Password1);

    }
   		
     public void Existing_User()
     {
    	String us1="sangi123";
    	String pwd1="sangi@123";
    	String us2="mangi123";
    	String pwd2="mangi@123";
    	 switch (choice) {
     case 2:
     	System.out.println("Enter the Username");
  		String us=scan.next();
  		System.out.println("Enter the Password");
  		String pwd=scan.next();
  		if((us1.equals(us)&&(pwd1.equals(pwd))||(us2.equals(us)&&(pwd2.equals(pwd)))))
  				{
  			System.out.println("Logged in V-PAC SHOP Successfully");
  				}
  		else
  		{
  			System.out.println("Please check your username or password");
  		}
  		break;
    	 }
     }
     public void Admin_User()
     {
    	String us1="VPAC101";
     	String pwd1="Vpac@101";
     	String us2="VPAC102";
     	String pwd2="Vpac@102";
    	 switch (choice) {
    	 case 3:
    		 System.out.println("Enter the Admin id");
 	  		 String us=scan.next();
	  		 System.out.println("Enter the Password");
    	  	 String pwd=scan.next();
     		System.out.println("VPAC sented the OTP to your official Mail");
    	     System.out.println(OTP());
    	  	 System.out.println("Enter the OTP");
    	  	 String otp=scan.next();
    	  		if((us1.equals(us)&&(pwd1.equals(pwd))||(us2.equals(us)&&(pwd2.equals(pwd)))))
  				{
  			System.out.println("Admin Logged in Successfully");
  				}
  		else
  		{
  			System.out.println("Please check your username or password");
  		}
    	  		break;
    	 default:
    		 System.out.println("Invalid Choice");
  	  			break;
   	     }
    }

     public  void condition(String username,String password) {
    	 if(username.equals(getUsername())&&password.equals(getPassword()))
    	 {
    		 System.out.println("Loged in V-PAC SHOP Successfully");
    	 }
    	 else if(!password.equals(getPassword())){
    		 System.out.println("Incorrect password please enter your password again");
    		 System.out.println("Enter the Password");
     		 String Password1=scan.next();
     		check();
   	 }
   	 }
     public void check() {
    	 System.out.println("Forget Password and Update it");
    	 checkpas();
//    	 System.out.println("Enter the Password");
// 		 System.out.println("(Password should be minimum 8 to maximum 16 characters)");
// 		 String Password=scan.next();
 		 System.out.println("Re-Enter the Password");
 		 String Password1=scan.next();
 		 setPassword(Password1);
 		condition( username, password);
// 		 display(Password);
// 		login();
    	
     }
     public char[] OTP() {
 		String num="0123456789";
 		Random otp=new Random();
 		char[] rotp=new char[4];
 		for(int j=0;j<=3; j++)
 		{
 			rotp[j]=num.charAt(otp.nextInt(num.length()));
 		}
 		return rotp;
 	}
     public char[] OTP1() {
  		String alb="abcdefgh23456789!@#$%";
  		Random otp1=new Random();
  		char[] rotp1=new char[6];
  		for(int j=0;j<=5; j++)
  		{
  			rotp1[j]=alb.charAt(otp1.nextInt(alb.length()));
  		}
  		return rotp1;
  	}
//       String Password;
//    	 public  void display(String Password){ 
//    	 int n = Password.length();
//    	 boolean upper = false, lower= false,
//    	 num = false, specialkey = false;
//    	 Set<Character> set = new HashSet<Character>(Arrays.asList('!', '@', '#', '$', '%', '^', '&','*', '(', ')', '-', '+'));
//    	 for (char i : Password.toCharArray())
//    	 {
//    	 if (Character.isUpperCase(i))
//    	 upper = true;
//    	 if (Character.isLowerCase(i))
//    	 lower = true;
//    	 if (Character.isDigit(i))
//    	 num = true;
//    	 if (set.contains(i))
//    	 specialkey = true;
//    	 }
//    	 System.out.print("Strength of password:- ");
//    	 if (num && lower && upper && specialkey && (n >= 8))
//    	 System.out.print(" Strong");
//    	 else if ((lower || upper || specialkey)&& (n >= 6))
//    	 System.out.print(" Moderate");
//    	 else
//    	 System.out.println(" Weak");
//    	 System.out.println("Please enter the strong password ");
//    	 System.out.println("Enter the Password");
// 		 System.out.println("(Password should contain Uppercase,Number and Special Characters)");
// 		 String Password1 =scan.next();
// 		 
// 	   	 setPassword(Password1);
//         login(); }
    	 public void checkpassword()
    	 {
    		 Boolean flag=false;
//    		 String check=scan.next();
    		 for(int i=0; i<password.length(); i++)
    		 {
    			 if((password.charAt(i)>='A' || password.charAt(i)>='Z')&&
    					 (password.charAt(i)>='a' || password.charAt(i)>='z')&&
    					 (password.charAt(i)>='0' || password.charAt(i)>='9')&&
    					 (password.charAt(i)=='@' || password.charAt(i)>='#'
    					 || password.charAt(i)=='&'|| password.charAt(i)=='*'))
    			 {
 
    					 flag=true;
    				 }
    			 }
    		 if(flag==true)
    		 {
    			 login();
    		 }
    		 else
    		 {
    			 checkpas();
    		 }
    		
    	 }
    	 
	public static void main(String[] args) {
		System.out.println("Welcome to the Shop");
		SignUpIn S = new SignUpIn();
		S.homepage();
        
	}

}

