package user.signin;

import java.io.*;
import java.util.*;
import Project.*;
import impl.Invoice;

public class SignUp {
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
	public static SignUp S = null;
	public static int otpCall = 2;
	int count=0;
	
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

	public void homepage(SignUp sign)
	{
			count = 0;
			S = sign;
		System.out.println("1. New to VPAC? Create an Account\n2. Existing User? Log in\n3. Admin Login");
		System.out.println("\n====>> Enter your choice to enter in V-PAC Shopping...... ");  
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
	    	 System.out.println(" OOPS!!! you have entered invalid Choice... \n  Please enter the valid choice....");
	    	 homepage(sign);
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

public void createFile()
{
	try {
		String fileName = "C:\\Users\\Dell\\Desktop\\VPAC\\Shopping\\IDPasswordDataBase\\" +S.username;
		FileWriter f1 = new FileWriter(fileName);
		System.out.println("User Created :");
		f1.write(S.username+"\n");
		f1.write(S.password+"\n");
		f1.write(S.name+"\n");
		f1.write(S.mobile_no+"\n");
		f1.write(S.mail_id+"\n");
		f1.write(S.address+"\n");
		f1.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

     public void New_User()
     {
    	 switch (choice) {  
       case 1:  
    	    System.out.println(" ===>>Please Enter your name...");
    		String name=scan.next();
    		setName(name);
    		checkmob();
    		}
     }
     
     
     public void checkmob()
     {
    	 System.out.println("===>>Enter your Mobile Number...");
 		String mobile_no =scan.next();
    	 for(int i=0; i<1; i++)
    	 {
    		 if(mobile_no.charAt(0)>='6' && mobile_no.charAt(0)<='9' && mobile_no.length()==10) {
    			
    			 setMobile_no(mobile_no);
    	    		System.out.println(">>>>> V-PAC sent OTP to verify your Mobile Number...<<<<<");
    	    		//System.out.println(OTP());
    	    		//System.out.println("Enter the OTP");
    	 			//String check=scan.next();
    	 			otpMethod();
    	 			System.out.println("***OTP Verified Successfully***");
    	    		System.out.println("==>>Enter your E-Mail Id...");
    	    		String mail_id=scan.next();
    	    		setMail_id(mail_id);
    	    		System.out.println(">>>>> V-PAC sent the OTP to verify your E-Mail Id...<<<<<");
    	    		//System.out.println(OTP1());
    	    		
    	 			//System.out.println("Enter the OTP");
    	 			//String check1=scan.next();
    	 			otpMethod();
//    	 			System.out.println("***OTP Verified Successfully***");
    	    		System.out.println("==>>Enter your Address...");
    	    		String address=scan.next();
    	    		setAddress(address);    		
    	    		System.out.println("==>>Enter the Username...");    		    		
    	    		String username=scan.next();
    	    		
    	    		setUsername(username);
    	    		
    	    		String fileName = "C:\\Users\\Dell\\Desktop\\VPAC\\Shopping\\IDPasswordDataBase\\" +S.username;
    	    		
    	    		File myfile = new File(fileName);
    	    		
    	    		if(myfile.exists())
    	    		{
    	    			System.out.println("OOPS!! User Already Exist!"
    	    					+ "\n Please use different user id"
    	    					+ "\n Enter Details again...");
    	    			New_User();
    	    		}
    	    		System.out.println("====>>>Enter your Password.....");
    	    		checkpas();
//    	    		System.out.println("(Password should be minimum 8 to maximum 16 characters)");
//    	    		String Password=scan.next();
//    	    		setPassword(Password);
//    	    		checkpassword();
//    	    		display(Password);

    	    	 }
    		 else
    		 {
    			 System.out.println(" ==>> Invalid moblie number!!! \n ==>> please check the number you have entered....");
    			checkmob(); 
    		 }
    	 }
     }
     public void checkpas() {
    	System.out.println("=====>>>Password should be contains Uppercase, Numeric, Special Character(@,*,#,&)<-----");
 		String Password=scan.next();
 		setPassword(Password);
 		checkpassword();
     }
    public void login() {

		createFile();
    	System.out.println("*****V-PAC Shop Account Successfully Created*****");

    	System.out.println("=========================================================");
    	show();
    	System.out.println("=========================================================");
//    		System.out.println("Enter the Username");
//    		String username1=scan.next();
//    		System.out.println("Enter the Password");
//    		String Password1=scan.next();
//    		condition(username1,Password1);
    	Existing_User();

    }
    public void Existing_User()
    {
    	
    	System.out.println("=====>>>Enter the Username.....");
  		String us=scan.next();
  		setUsername(us);
  		System.out.println("=====>>>Enter your Password.....");
  		String pwd=scan.next();
  		
    	File fr = new File("C:\\Users\\Dell\\Desktop\\VPAC\\Shopping\\IDPasswordDataBase\\" +us);
		
		try {
			if(fr.exists())
			{
				Scanner scan = new Scanner(fr);
				scan.hasNext();
				String us1 = scan.next();
				scan.hasNext();
				String pwd1 = scan.next();
				int ti=1;
				
				while(count++<=ti)
				{
					if(us.equals(us1)) 
					{
						if(us.equals(us1) && pwd.equals(pwd1))
						{
							System.out.println("*****WELCOME TO V-PAC PRODUCT LIST***** \n Hope you will enjoy it");
							Product p = new Product();
							p.budget(S,p);
						}
						else
						{
							System.out.println(" OOPS!!! you have entered Wrong Password... \n ==>> Please enter valid Password....");
							Existing_User();
						}
					}	
					else {
					System.out.println(">>>> Entered User Id or Password is incorrect <<<< \n ==>>Please Enter valid Credentials....");
					homepage(S);
					}
					break;
				}
				if(count>ti) 
				{
					homepage(S);
				} 
//			}
//			else {
//				System.out.println("Wrong User Not Exist");
//				homepage(S);
				
			}
			else
			{
				System.out.println(">>>>  Wrong User Not Exist  <<<< \\n ==>>Please Enter valid Credentials....");
				homepage(S);
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
//     public void Existing_User1()
//     {
//    	String us1="sangi123";
//    	String pwd1="sangi@123";
//    	String us2="mangi123";
//    	String pwd2="mangi@123";
//    	 switch (choice) {
//     case 2:
//     	System.out.println("Enter the Username");
//  		String us=scan.next();
//  		System.out.println("Enter the Password");
//  		String pwd=scan.next();
//  		if((us1.equals(us)&&(pwd1.equals(pwd))||(us2.equals(us)&&(pwd2.equals(pwd)))))
//  				{
//  			System.out.println("Logged in V-PAC SHOP Successfully");
//  				}
//  		else
//  		{
//  			System.out.println("Please check your username or password");
//  		}
//  		break;
//    	 }
//     }
     public void Admin_User()
     {
    	String us1="VPAC101";
     	String pwd1="Vpac@101";
     	String us2="VPAC102";
     	String pwd2="Vpac@102";
    	 switch (choice) {
    	 case 3:
    		 System.out.println("=====>>>Enter the Admin id....");
 	  		 String us=scan.next();
	  		 System.out.println("=====>>>Enter Password....");
    	  	 String pwd=scan.next();
    	  		if((us1.equals(us)&&(pwd1.equals(pwd))||(us2.equals(us)&&(pwd2.equals(pwd)))))
  				{
  			System.out.println("<<<<<<< Admin Logged in Successfully >>>>>>");

				Product.itemList1();
  			while(true)
  			{
  				System.out.println("***** The List Of Products....*****");
  				Product.filter(null, null, null, null);
  			System.out.println("Press : 1 to add new Products ..... "
  					+"\n Else!!! Press any number to Logout....");
  			int option=scan.nextInt();
  			//public ProductNames(int id, String name, String brand, String colour, double price, String catagory,String gender) {
  			
  			if(option ==1)
  			{
  				System.out.println("Name: ");
  				String name = scan.next();
  				System.out.println("Brand: ");
  				String brand = scan.next();
  				System.out.println("Colour: ");
  				String color = scan.next();
  				System.out.println("Price: ");
  				Double price = scan.nextDouble();
  				System.out.println("Catagoery: ");
  				String catagoery = scan.next();
  				System.out.println("Gender: ");
  				String gender = scan.next();
  				Product.addProductAdmin(name,brand,color,price,catagoery,gender);
  				
  			}
  			else homepage(S);
  				break;
  			}
  			
  		}
  		else
  		{
  			System.out.println("===>> Please check your Username or Password");
  		}
    	  		break;
    	 default:
    		 System.out.println("OOPS!!! you have entered invalid Choice... \n ===>> Please enter the valid choice.....");
  	  			break;
   	     }
    }
     public  void condition(String username,String password) {
    	 if(username.equals(getUsername())&&password.equals(getPassword()))
    	 {
    		 System.out.println(">>>> Loged in V-PAC SHOP Successfully <<<<< \n YES!!! You Can Start to fill your Basket....");
    		 //ProductNames.main(null);
    		 Product p = new Product();
    		 p.budget(S,p);
    	 }
    	 else if(!password.equals(getPassword())){
    		 System.out.println(" Entered password is Incorrect  please Re-enter your valid password...");
    		 System.out.println("=====>>>Enter your Password....");
     		 String Password1=scan.next();
     		check();
   	 }
   	 }
     public void check() {
    	 System.out.println(">>>>>>Forget Password and Update it...");
    	 checkpas();
//    	 System.out.println("Enter the Password");
// 		 System.out.println("(Password should be minimum 8 to maximum 16 characters)");
// 		 String Password=scan.next();
 		 System.out.println("<<<<Please Re-Enter the Password...");
 		 String Password1=scan.next();
 		 setPassword(Password1);
 		condition( username, password);
// 		 display(Password);
// 		login();
    	
     }
/*
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
*/

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
 	public void otpMethod()
 	{
 		int ti = 0;
 		while(ti++<otpCall)
 		{	
 			String otp = OTP();
 			System.out.println(otp);
 			System.out.println("=====>>Enter OTP  Sent......");
 			String check=scan.next();
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
 				return;
 			}
 			else
 			{
 				if(ti<otpCall)
 					System.out.println("<<<<You have entered incorrect OTP Please try again..."
 						+ "\nNew OTP Sent Successfully");
 				else
 				{
 					New_User();
 					System.out.println("OTP entered is incorrect..Please Re-enter...");
 				}
 			}
 		}
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
//    	 
//	public static void main(String[] args) {
//		System.out.println("Welcome to the Shop");
//		S = new SignUp();
//		S.homepage(sign);
//        
//	}

}


