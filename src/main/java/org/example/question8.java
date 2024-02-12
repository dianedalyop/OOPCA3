package org.example;
import java.util.Scanner;
import java.util.Stack;

public class question8 {

    public static void main(String [] args)
    {
        Scanner kb =  new Scanner(System.in);

        Stack<Integer> output =  new Stack<Integer>();
        boolean quit =  false;

        System.out.println("Enter Command");
        System.out.println( "Enter a Number or operator");
        while (!quit)
        {
            String option = kb.nextLine();



            if(option.equals("+")){
                output.push(output.pop()+output.pop());
            }
            else if(option.equals("-")){
                output.push(output.pop()-output.pop());
            }
            else if(option.equals("*")){
                output.push(output.pop()*output.pop());
            }
            else if(option.equals("/")){
                output.push(output.pop()/output.pop());
            }
            else if(option.equalsIgnoreCase("q")){
                quit = true;
            }
            else{
                output.push(Integer.parseInt(option));

            }



            System.out.println(output);
        }

    }



}
