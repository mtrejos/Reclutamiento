/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test.reclutamiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author ErickAndresMataMata
 */
public class Post_Request {

    public void UpdateProduct(String name, Integer price, String description) throws ClientProtocolException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/products/updateProduct");

        String json = "{\n" +
            "  \"name\": \""+name+"\",\n" +
            "  \"image\": \""+description+"\",\n" +
            "  \"id\": \"9198ead1-ee77-4106-9649-09588c45b23b\",\n" +
            "  \"price\": "+price+"\n" +
           
            "}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }else{
           // System.out.println("EXITO");
           JOptionPane.showMessageDialog(null, "PRODUCTO ACTUALIZADO EXITOSAMENTE");
        }
       // assertThat(response.getStatusLine().getStatusCode().equalTo(200));
        client.close();
    }
}
