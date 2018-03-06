package com.rawli.newfeature.j8.lambda;

import java.util.Arrays;
import java.util.List;

public class IterateCollection {
	
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "X", "Y", "Z");
        list.forEach(n -> System.out.println(n));
        System.out.println();
        System.out.println("直接使用方法：");
        list.forEach(System.out::println);
    }
    
}
