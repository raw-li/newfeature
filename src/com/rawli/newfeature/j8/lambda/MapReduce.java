package com.rawli.newfeature.j8.lambda;

import java.util.Arrays;
import java.util.List;

public class MapReduce {

	public static void main(String[] args) {
		// 不使用lambda表达式为每个订单加上12%的税
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
		    double price = cost + .12*cost;
		    System.out.println(price);
		}
		 
		System.out.println();
		System.out.println();
		
		// 使用lambda表达式
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
		
		
		System.out.println();
		System.out.println();
		
		// 为每个订单加上12%的税
		// 老方法：
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
		    double price = cost + .12*cost;
		    total = total + price;
		}
		System.out.println("Total : " + total);
		 
		// 新方法：
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
		
	}
	
}
