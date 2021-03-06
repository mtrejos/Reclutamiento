/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test.reclutamiento;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import static org.apache.http.client.methods.HttpPut.METHOD_NAME;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
/**
 *
 * @author Mariam Trejos
 */
public class Delete_Request extends HttpEntityEnclosingRequestBase {
     public void DeleteProduct(String ID) throws ClientProtocolException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        Delete_Request httpDelete = new Delete_Request("https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/products/deleteProduct");
        
        String json = "{\n" +
           
            "  \"id\": \""+ID+"\"\n" +
            
            "}";
        StringEntity entity = new StringEntity(json);
        httpDelete.setHeader("Content-type", "application/json");
        httpDelete.setEntity(entity);
        CloseableHttpResponse response = client.execute(httpDelete);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }else{
            //System.out.println("EXITO");
            JOptionPane.showMessageDialog(null, "PRODUCTO BORRADO EXITOSAMENTE");
        }
       // assertThat(response.getStatusLine().getStatusCode().equalTo(200));
        client.close();
    }

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }

    public Delete_Request(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    public Delete_Request(final URI uri) {
        super();
        setURI(uri);
    }

    public Delete_Request() {
        super();
    }
}
