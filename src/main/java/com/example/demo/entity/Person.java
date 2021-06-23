package com.example.demo.entity;


public class Person {
   //Person(1,"vinodh","mumbai") -->Update
   //Person("Raj","Chennai") --> insert

   private int sno;
   private String name;
   private String city;
   
public Person() {}
   
public Person(int sno, String name, String city) {
	super();
	this.sno = sno;
	this.name = name;
	this.city = city;
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
   
   
   
}
