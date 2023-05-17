/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kantor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author maciejszczypta
 */
public class SaveDataToFile {
    public SaveDataToFile(){
        
    }
    /*
        nazwa funkcji: saveData();
        argumenty: action(sell/buy), currency, amount(kupionej/sprzedanej), getted(ile otrzymano), price(cena);
        informacje: Zapisuje dane do pliku importantdata.csv
        autor: Maciej Szczypta;
    */
    public static void saveData(String action, String currency, BigDecimal amount,  BigDecimal getted, BigDecimal price){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date();  
            
            File f = new File("importantdata.csv");  
            FileWriter myWriter = new FileWriter(f, true);   
            myWriter.write("\nAKCJA:"+action+";WALUTA:"+currency+";ILOSC:"+amount+";TYLE DOSTANIESZ:"+getted+";CENA:"+price+";DATA:"+formatter.format(date));
            myWriter.close();
            
            System.out.println("Zapisano.");
        }catch(IOException e) {
            System.out.println("Err.");
            e.printStackTrace();
        }
    }
}
