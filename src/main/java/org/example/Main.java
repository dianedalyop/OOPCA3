package org.example;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner carsreg = new Scanner(System.in);

int cars ;
            Deque<Integer> driveway = new ArrayDeque<>();
            Deque<Integer> street = new ArrayDeque<>();
        System.out.println("Pushing cars to the drive");
        for(int i = 0 ; i<= 5; i++) {
            System.out.println("Enter Car registration number");
            cars = carsreg.nextInt();
            driveway.push(cars);
        }
        System.out.println(driveway);
        System.out.println("Pushing cars to street");
        while(!driveway.isEmpty()){
            




        }


    }
}