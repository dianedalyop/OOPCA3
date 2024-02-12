package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Block {
    int quantity;
    double price;

    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}

public class question7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Queue<Block>> stockMap = new HashMap<>();

        while (true) {
            System.out.println("Enter command (buy symbol quantity price, sell symbol quantity, or quit):");
            String command = scanner.next();

            if (command.equals("buy")) {
                System.out.println( "Enter the quantity you wish to buy");
                int quantity = scanner.nextInt();
                System.out.println("Enter buying price");
                double price = scanner.nextDouble();
                buyStock(stockMap, command, quantity, price);
            } else if (command.equals("sell")) {
                System.out.println("Enter the quantity you want to sell");
                int quantityToSell = scanner.nextInt();
                sellStock(stockMap, command, quantityToSell);
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static void buyStock(Map<String, Queue<Block>> stockMap, String symbol, int quantity, double price) {
        Queue<Block> blocks = stockMap.getOrDefault(symbol, new LinkedList<>());
        blocks.add(new Block(quantity, price));
        stockMap.put(symbol, blocks);
    }

    private static void sellStock(Map<String, Queue<Block>> stockMap, String symbol, int quantityToSell) {
        Queue<Block> blocks = stockMap.get(symbol);
        if (blocks == null || blocks.isEmpty()) {
            System.out.println("No shares available for selling.");
            return;
        }

        double totalProfit = 0;
        while (quantityToSell > 0 && !blocks.isEmpty()) {
            Block block = blocks.peek();
            if (block.quantity <= quantityToSell) {
                // Sell the entire block
                quantityToSell -= block.quantity;
                totalProfit += (block.price - block.price) * block.quantity;
                blocks.poll();
            } else {
                // Sell part of the block
                block.quantity -= quantityToSell;
                totalProfit += (block.price - block.price) * quantityToSell;
                quantityToSell = 0;
            }
        }
        System.out.println("Total profit from selling " + symbol + " shares: $" + totalProfit);
    }
}

