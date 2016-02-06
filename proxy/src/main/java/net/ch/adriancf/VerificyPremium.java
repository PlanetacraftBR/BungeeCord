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
        host = new URL("http://api.planetacraft.com.br/API/addconta.php?nick=" + nick);
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
        String UUID = ConectarWeb("http://api.planetacraft.com.br/API/uuid.php?nick=" + nick);
        String inputLine;
        while ((inputLine = reader.readLine()) != null)
        {
        	String json = inputLine;
        	if (UUID.contains("PIRATA"))
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
    
    
     public static String ConectarWeb(String url)
    {
      URL host = null;
      String link = "";
      try
      {
        host = new URL(url);
       
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
            link = json;
            return link;
        }
        reader.close();
       
      }
      catch (IOException e)
      {
       return link;
      }
      return link;
    }
}
