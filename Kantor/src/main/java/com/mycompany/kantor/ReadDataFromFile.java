/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kantor;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author maciejszczypta
 */
public class ReadDataFromFile {
    public ReadDataFromFile(){
        
    }
    /*
        nazwa funkcji: readData();
        argumenty: action(sell/buy), currency ;
        typ zwracany: String, najmniejsza i najwieksza cena;
        informacje: Pobiera ceny z pliku nastepnie wybiera najmniejsza i najwieksza;
        autor: Maciej Szczypta;
    */
    public static String readData(String action, String currency){
        try {
            File myObj = new File("importantdata.csv");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> prices = new ArrayList<>();
            int i=0;
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                if(data.contains(currency) && data.contains(action)){
                    String test = data.substring(data.indexOf("CENA:")+5);
                    test = test.substring(0, data.indexOf(";"));
                    prices.add(test);
                    i++;
                }
            }
            
            if(i>0){
                Collections.sort(prices);
                String smallest = prices.get(0);
                String biggest = prices.get(prices.size() - 1);
                myReader.close();
                
                return smallest+"/"+biggest;
            }else{
                return null;
            }
            
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }     
        return null;
    }
}
