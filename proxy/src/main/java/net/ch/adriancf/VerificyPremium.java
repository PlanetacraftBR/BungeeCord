/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ch.adriancf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/**
 *
 * @author adriancf
 */
public class VerificyPremium
{
    
    	public static boolean Conectar (String nick)
    {
      URL host = null;
      try
      {
        host = new URL("https://minecraft.net/haspaid.jsp?user=" + nick);
       
      }
      catch (MalformedURLException e1)
      {
       
      }
      URLConnection connection = null;
      try
      {
        connection = host.openConnection();
   
        BufferedReader reader = null;
     
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
  
        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
        	String json = inputLine;
        	if (json.contains("false"))
                    return false;
        }
        reader.close();
       
      }
      catch (IOException e)
      {
       return true;
      }
      return true;
    }
}
