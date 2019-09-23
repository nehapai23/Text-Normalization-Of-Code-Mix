/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Text_Normalization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Neha
 */
public class Hindi_Transliteration {
    public static void main(String args[]) throws IOException
    	{
		try
        	{
            	File file = new File("C:\\Users\\Neha\\Desktop\\Input files\\op_lang_identification.txt");
            	Scanner input = new Scanner(file);
		PrintWriter writer = new PrintWriter("C:\\Users\\Neha\\Desktop\\Input files\\op_transliteration.txt", "UTF-8");
            	Map<String, String> dictionary = new HashMap<String, String>();
		BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Neha\\Desktop\\Input files\\englishToHindi_dictionary.txt")));
		String inputLine = null;
                Syllabification sy = new Syllabification();
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
                        if(w.endsWith("H"))
                        {
                            w = w.substring(0, w.indexOf('/'));
                            if(dictionary.containsKey(w))
                                    writer.println(dictionary.get(w)+"/H");
                            else if(w.matches("^-?\\d+$"))
                            writer.println(w+"/E");
                            else
                            {
                                    writer.println(sy.Syllabify_Transliterate(w+"..")+"/H");
                                
                            }
                        }
                        else
                            writer.println(w);
		}
		writer.close();
		}
        	catch (IOException e)
        	{
                	// do something
        	}
		System.out.println("Transliteration done");
		
	}
    
}
