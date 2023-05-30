package Project;

import java.util.Scanner;

import user.signin.SignUp;

public class ProductNames {
	
static Double amount;
	
	public int id;
	public String name;
	public String brand;
	public String colour;
	public double price;
	String catagory;
	String subcata;
	String gender;
	public ProductNames()
	{
		
	}
	public ProductNames(int id, String name, String brand, String colour, double price, String catagory,String gender) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.colour = colour;
		this.price = price;
		this.catagory = catagory;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return   id + " " + name + " " + brand + " " +colour+ " " +price+ " " +catagory+ " " + gender ;
	}
	/*
	public String toString() {
		return   name + "Rs: " + price + colour ;
	}
	*/
	public static void main(String[] args) {
		Product p = new Product();
		SignUp sign = new SignUp();
		Product.budget(sign,p);				
	}

}
