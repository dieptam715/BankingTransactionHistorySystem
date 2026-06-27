/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import model.Transaction;
import java.util.Stack;

/**
 *
 * @author Do Tuan Khai
 */
public class TransactionStack {
     private Stack<Transaction> stack;


    public TransactionStack(){

        stack = new Stack<>();

    }


    public void push(Transaction t){
        stack.push(t);
    }

    public Transaction pop(){
       if(stack.isEmpty()){
            return null;
       } 
       return stack.pop();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
