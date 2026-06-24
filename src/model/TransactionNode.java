/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Do Tuan Khai
 */
public class TransactionNode {
    public Transaction data;
    
    public Transaction next;
    
    public Transaction prev;
    
    public TransactionNode(Transaction data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
