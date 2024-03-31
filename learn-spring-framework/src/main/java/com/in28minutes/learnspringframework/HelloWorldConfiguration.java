package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor,equals,hashcode 
//and toString are automatically are auto created
//Released in JDK 16.

record Person (String name, int age,Address address) {};
record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Thomas";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Thomas",20, new Address("Macpherson","Singapore"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(),age(),address());
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		return new Person(name,age,address3); 
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address3) {
		return new Person(name,age,address3); 
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address3) {
		return new Person(name,age,address3); 
	}
	
	@Bean (name ="address2")
	@Primary
	public Address address() {
		return new Address("Serangoon","Singapore");
	}
	
	@Bean (name ="address3")
	@Qualifier("address3Qualifier")
	public Address address3() {
		return new Address("Menglembu","Ipoh");
	}
}
