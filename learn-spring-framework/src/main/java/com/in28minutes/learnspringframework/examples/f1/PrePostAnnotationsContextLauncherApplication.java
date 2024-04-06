package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency =someDependency;
		System.out.println("Dependencies are ready!");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getready();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("CleanUp");
	}
}

@Component
class SomeDependency{

	public void getready() {
		System.out.println("Some logic using SomeDepencency");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {
		try (var context =
				new AnnotationConfigApplicationContext
				(PrePostAnnotationsContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
		}
	}
}
