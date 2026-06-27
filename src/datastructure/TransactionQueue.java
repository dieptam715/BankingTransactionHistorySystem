/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import java.util.Queue;
import model.Transaction;
import java.util.LinkedList;

/**
 *
 * @author Do Tuan Khai
 */
public class TransactionQueue {
    private Queue<Transaction> queue;
    
    public TransactionQueue(){

        queue = new LinkedList<>();

    }

    
    public void enqueue(Transaction t){
           queue.offer(t);
    }

    public Transaction dequeue(){
       if(queue.isEmpty()){

            return null;
        }
        return queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
