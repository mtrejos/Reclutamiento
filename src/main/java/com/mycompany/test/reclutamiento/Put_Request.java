/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test.reclutamiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author ErickAndresMataMata
 */
public class Put_Request {

    public void CreateProduct(String name,Integer price,String description) throws ClientProtocolException, IOException {

        String putEndpoint = "https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/products/createProduct";

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPut httpPut = new HttpPut(putEndpoint);
        httpPut.setHeader("Content-type", "application/json");

        String inputJson = "{\n" +
            "  \"name\": \""+name+"\",\n" +
            "  \"image\": \""+description+"\",\n" +
            "  \"price\": "+price+"\n" +
           
            "}";

        StringEntity stringEntity = new StringEntity(inputJson);
        httpPut.setEntity(stringEntity);
        System.out.println("Executing request " + httpPut.getRequestLine());

        HttpResponse response = httpclient.execute(httpPut);

        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

        //Throw runtime exception if status code isn't 200 
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }else{
           // System.out.println("EXITO");
             JOptionPane.showMessageDialog(null, "PRODUCTO CREADO EXITOSAMENTE");
        }

        //Create the StringBuffer object and store the response into it. 
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println("Response : \n" + result.append(line));
        }

    }
}
