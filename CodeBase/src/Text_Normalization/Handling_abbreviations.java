/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Text_Normalization;

/**
 *
 * @author Neha
 */
import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
public class Handling_abbreviations
{
	public static void main(String args[]) throws IOException
    	{
		try
        	{
            	File file = new File("C:\\Users\\Neha\\Desktop\\Input files\\op_tokenization.txt");
            	Scanner input = new Scanner(file);
		PrintWriter writer = new PrintWriter("C:\\Users\\Neha\\Desktop\\Input files\\op_abbreviation.txt", "UTF-8");
            	Map<String, String> dictionary = new HashMap<String, String>();
		BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Neha\\Desktop\\Input files\\abbreviations_dictionary.txt")));
		String inputLine = null;
                while((inputLine = reader.readLine()) != null) 
		{
                    	String key =  inputLine.substring(0,inputLine.indexOf(" "));
			String value = inputLine.substring(inputLine.indexOf(" ")+1);
			//System.out.println(key+":"+value);
			dictionary.put(key,value);
                }
		reader.close();
		while(input.hasNext())
            	{
			String w = input.next();
                        String s1 = w.replaceAll("([a-zA-Z])(\\1{2,})", "$1");
                        //System.out.println(s1);
			if(dictionary.containsKey(w))
				writer.println(dictionary.get(w));
                        else if(dictionary.containsKey(s1))
				writer.println(dictionary.get(s1));
                        else
				writer.println(w);
		}
		writer.close();
		}
        	catch (IOException e)
        	{
                	// do something
        	}
                	
                System.out.println("Abbreviations handled.");
		Handling_slang.main(args);
	}
}