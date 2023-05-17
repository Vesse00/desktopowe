/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sortowacz;

import com.mycompany.kantor.GetPriceFromAPI;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author maciejszczypta
 */
public class Sortowacz {

    public static void main(String[] args) {
        GetPriceFromAPI api = new GetPriceFromAPI();
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        double prices[] = new double[10];
        prices[0] = api.getPrice("buy", "USD");
        prices[1] = api.getPrice("sell", "USD");
        prices[2] = api.getPrice("buy", "EUR");
        prices[3] = api.getPrice("sell", "EUR");
        prices[4] = api.getPrice("buy", "GBP");
        prices[5] = api.getPrice("sell", "GBP");
        prices[6] = api.getPrice("buy", "CHF");
        prices[7] = api.getPrice("sell", "CHF");
        prices[8] = api.getPrice("buy", "JPY");
        prices[9] = api.getPrice("sell", "JPY");
        System.out.println(Arrays.toString(prices));
        JOptionPane.showMessageDialog(frame, Arrays.toString(prices));
        
        double prices2[] = new double[10];
        prices2[0]=prices[2]; //3
        prices2[1]=prices[3]; //4
        prices2[2]=prices[4]; //5
        prices2[3]=prices[5]; //6
        prices2[4]=prices[6]; //7
        prices2[5]=prices[7]; //8
        prices2[6]=prices[8]; //9
        prices2[7]=prices[9]; //10
        prices2[8]=prices[0]; //1
        prices2[9]=prices[1]; //2
        System.out.println(Arrays.toString(prices2));
        JOptionPane.showMessageDialog(frame, Arrays.toString(prices2));
        
        prices[0] = prices[7]; //8
        prices[1] = prices[8]; //9
        prices[2] = prices[9]; //10
        prices[3] = prices2[8]; //1
        prices[4] = prices2[9]; //2
        prices[5] = prices2[0]; //3
        prices[6] = prices2[1]; //4
        prices[7] = prices2[2]; //5
        prices[8] = prices2[3]; //6
        prices[9] = prices2[4]; //7
        System.out.println(Arrays.toString(prices));
        JOptionPane.showMessageDialog(frame, Arrays.toString(prices));
               
               
        
    }
}
