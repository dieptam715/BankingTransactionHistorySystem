/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Transaction;


/**
 *
 * @author Do Tuan Khai
 */
public class FileHandler {
    private String fileName = "transactions.dat";



    public void saveToFile(ArrayList<Transaction> list){


        try{

            ObjectOutputStream out =
                    new ObjectOutputStream(
                    new FileOutputStream(fileName));


            out.writeObject(list);


            out.close();


        }catch(Exception e){

            e.printStackTrace();

        }


    }





    public ArrayList<Transaction> loadFromFile(){


        ArrayList<Transaction> list =
                new ArrayList<>();



        try{

            ObjectInputStream in =
                    new ObjectInputStream(
                    new FileInputStream(fileName));



            list =
            (ArrayList<Transaction>) in.readObject();



            in.close();



        }catch(Exception e){

            e.printStackTrace();

        }



        return list;


    }
}
