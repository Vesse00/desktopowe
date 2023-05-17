/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kantor;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author maciejszczypta
 */
public class GetPriceFromAPI {
    public GetPriceFromAPI(){
        
    }
    /*
        nazwa funkcji: getPrice();
        argumenty: akcja(sell/buy), waluta;
        typ zwracany: float, cena(sprzedazy/zakupu)
        informacje: pobiera z API NPB;
        autor: Maciej Szczypta;
    */
    public double getPrice(String action, String currency){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://api.nbp.pl/api/exchangerates/rates/c/"+currency+"/today/"))
            .build();
        try{
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String result = response.body().toString();
            
            if(action.equals("buy")){
                String ask = result.substring(result.indexOf("\"ask\":")+6);
                String test = ask.substring(0, ask.indexOf("}"));
                
                return Double.parseDouble(test);
            }else if(action.equals("sell")){
                String bid = result.substring(result.indexOf("\"bid\":")+6);
                String test = bid.substring(0, bid.indexOf(","));
                
                return Double.parseDouble(test);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        BigDecimal data = new BigDecimal(0);
        return 0;
        
    }
}
