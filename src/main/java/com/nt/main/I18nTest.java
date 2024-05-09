package com.nt.main;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;

public class I18nTest {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//read  language and country from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Language code::");
		String  lang=sc.next();
		System.out.println("enter Country code::");
		String  country=sc.next();
		//prepare Locale object having language, country code
		Locale locale=new Locale(lang, country);
		
		String msg1=ctx.getMessage("welcome.message", new Object[] {}, locale);
		String msg2=ctx.getMessage("goodbye.message", new Object[] {}, locale);
		String msg3=ctx.getMessage("newyear.wishes", new Object[] {}, locale);
		
		System.out.println(msg1+"......."+msg2+"......"+msg3);
		
		ctx.close();
	}

}
