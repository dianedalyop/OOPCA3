package org.example;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Block2 {
    int quantity;
    double price;

    public Block2(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}

public class question6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Block2> blocks = new LinkedList<>();
        double totalProfit = 0;

        while (true) {
            System.out.println("Enter command (buy quantity price, sell quantity, or quit):");
            String command = scanner.next();

            if (command.equals("buy")) {
                int quantity = scanner.nextInt();
                double price = scanner.nextDouble();
                blocks.add(new Block2(quantity, price));
            } else if (command.equals("sell")) {
                int quantityToSell = scanner.nextInt();
                while (quantityToSell > 0 && !blocks.isEmpty()) {
                    Block2 block = blocks.peek();
                    if (block.quantity <= quantityToSell) {
                        quantityToSell -= block.quantity;
                        totalProfit += (block.price - block.price) * block.quantity;
                        blocks.poll();
                    } else {
                        block.quantity -= quantityToSell;
                        totalProfit += (block.price - block.price) * quantityToSell;
                        quantityToSell = 0;
                    }
                }
                System.out.println("Total profit from this sale: $" + totalProfit);
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
