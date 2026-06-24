/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Do Tuan Khai
 */
public class Transaction {
    private String transactionId;
    private double amount;
    private String type;
    private LocalDate date;

    public Transaction(String transactionId, double amount, String type, LocalDate date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public void display(){
        System.out.println("ID: " + transactionId +
                            "| Amount: " + amount + 
                            "| Type: " + type + 
                            "| Date: " + date);
    }
    
    @Override
    public String toString(){
        return transactionId + "," + amount + "," + type + "," + date;
    }
}
