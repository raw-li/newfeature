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
	    
	    System.out.println();
	    System.out.println();
	    System.out.println("------------更简洁的方式------------");
	    
	    System.out.println("以 J 开头则为 true:");
	    betterFilter(languages, (str)->str.startsWith("J"));
	 
	    System.out.println("以 a 结尾则为 true:");
	    betterFilter(languages, (str)->str.endsWith("a"));
	 
	    System.out.println("存在则为 true :");
	    betterFilter(languages, (str)->true);
	 
	    System.out.println("不存在则为true :");
	    betterFilter(languages, (str)->false);
	 
	    System.out.println("长度大于 4则为true :");
	    betterFilter(languages, (str)->str.length() > 4);
	    
	    
	    System.out.println();
	    System.out.println();
	    System.out.println("------------更复杂的Predicate------------");
	    
	    
	    Predicate<String> startsWithJ = (str) -> str.startsWith("J");
		Predicate<String> fourLetterLong = (str) -> str.length() == 4;
		Predicate<String> completedPredicate = startsWithJ.and(fourLetterLong);
		complexFilter(languages, completedPredicate);
		
	}

	public static void filter(List<String> names, Predicate<String> condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}
	
	// 更好的办法
	public static void betterFilter(List<String> names, Predicate<String> condition) {
	    names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
	        System.out.println(name + " ");
	    });
	}
	
	// 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
	// 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
	public static void complexFilter(List<String> names, Predicate<String> condition) {
		names.stream()
		.filter(condition)
		.forEach((n) -> System.out.print("以 J 开始，并且长度大于4:" + n));
	}
	
}
