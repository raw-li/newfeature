package com.rawli.newfeature.j8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFilter {
	
	public static void main(String[] args){
		
	    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
	 
	    System.out.println("以 J 开头则为 true:");
	    filter(languages, (str)->str.startsWith("J"));
	 
	    System.out.println("以 a 结尾则为 true:");
	    filter(languages, (str)->str.endsWith("a"));
	 
	    System.out.println("存在则为 true :");
	    filter(languages, (str)->true);
	 
	    System.out.println("不存在则为true :");
	    filter(languages, (str)->false);
	 
	    System.out.println("长度大于 4则为true :");
	    filter(languages, (str)->str.length() > 4);
	}

	public static void filter(List<String> names, Predicate<String> condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}
	
}
