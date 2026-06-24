/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import model.Transaction;
import model.TransactionNode;

/**
 *
 * @author Do Tuan Khai
 */
public class TransactionList {
    private TransactionNode head;
    private TransactionNode tail;
    
    public void addTransaction(Transaction t){
        //điền vô đây chức năng add
    }
    
    public Transaction deleteTransaction(String id){
        //điền vô đây chức năng delete trả lại node vừa xóa
        return null;
    }
    
    public void displayHistory(){
        //điền vào đây chức năng show lịch sử giao dịch
    }
    
    public void mergeSortByAmount(){
        //điền vào đây chức năng sắp xếp theo tiền
    }
    
    public void mergeSortByDate(){
        //điền vô đây chức năng sắp xếp bằng ngày
    }
}
