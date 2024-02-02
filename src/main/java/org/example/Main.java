package org.example;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // QUESTION 1
        Scanner kb = new Scanner(System.in);


        Deque<Integer> driveway = new ArrayDeque<>();
        Deque<Integer> street = new ArrayDeque<>();

        boolean simulation = true;

        while (simulation) {
            System.out.println("Operation \n"+
                    "Postive value Add car\n"+
                    "Negative value Remove car\n" +
                    "0 to Exit");


            int carreg = kb.nextInt();
            if (carreg > 0) {
                System.out.println("Pushing cars to the driveway\n");

                    System.out.println("Enter Car registration number");

                    driveway.push(carreg);

                System.out.println(driveway);
            }
          else if (carreg < 0) {
                System.out.println("Pushing cars to street");
                int option = carreg * -1;

                while (!driveway.isEmpty()){

                    int car = driveway.pop();
                    if (car == option)
                        break;

                    street.push(car);


                }
                System.out.println("street " +street);
                System.out.println("driveway " +driveway);
                while (!street.isEmpty()){

                    driveway.push(street.pop());
                }

            }

            else{
                System.out.println("END");
                simulation = false;
            }

        }

        System.out.println(" Cars on Driveway "+driveway);
        System.out.println("Cars on Street "+street);

    }
    }
