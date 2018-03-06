package com.rawli.newfeature.j8.lambda;

public class AnonymousMethod {

    public static void main(String[] args) {
        Thread beforeJ8 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Java8之前");
            }
        });

        Thread j8 = new Thread(() -> System.out.println("Java8"));

        beforeJ8.start();
        j8.start();

    }

}
