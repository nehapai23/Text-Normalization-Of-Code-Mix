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

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;

public class Handling_wordplay
{
    public static void main(String args[]) throws IOException
    {
	try
        {
            File file = new File("C:\\Users\\Neha\\Desktop\\Input files\\op_slang.txt");
            PrintWriter writer = new PrintWriter("C:\\Users\\Neha\\Desktop\\Input files\\op_wordplay.txt", "UTF-8");
            PrintWriter writer2 = new PrintWriter("C:\\Users\\Neha\\Desktop\\Input files\\op_lang_identification.txt", "UTF-8");
            Scanner input = new Scanner(file);
            LinkedHashMap dictionary = new LinkedHashMap();
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Neha\\Desktop\\Input files\\englishDictionary.txt")));
                    String inputLine = null;
                    while((inputLine = reader.readLine()) != null) 
		    {
                    	String[] words = inputLine.split("\\s+");
                        if(inputLine.equals(""))
                        	continue;
                        for(String word: words) 
			{
                        	word = word.replace(".", "");
                            	word = word.replace(",", "");
                                if(dictionary.containsKey(word)) 
				{
                                	Integer val = (Integer)dictionary.get(word);
                                	dictionary.put(word, val + 1);
                            	}
                            	else
                                	dictionary.put(word, 1);
                      	}
                    }
		    /*Set<Entry> entries = dictionary.entrySet();
                    Iterator<Entry> iter = entries.iterator();*/
	    while(input.hasNext())
            {
                String w = input.next();
                String s1 = w.replaceAll("([a-zA-Z])(\\1{2,})", "$1");
                String s2 = w.replaceAll("([a-zA-Z])(\\1{2,})", "$1$1");
		if(s1.equals(s2))
                {
                    writer.println(s1);
                    if(dictionary.containsKey(s1))
                    {
                        writer2.println(s1+"/E");
                        
                    }
                    else
                    {
                        writer2.println(s1+"/H");
                    }
                }
                else
                {
		                     
                    if(dictionary.containsKey(s1))
                    {
                    	writer.println(s1);
                        writer2.println(s1+"/E");
                    }
                    else if (dictionary.containsKey(s2))
                    {
                        writer.println(s2);
                        writer2.println(s2+"/E");
                    
                    }else
                    {
                        writer.println(s1);
                        writer2.println(s1+"/H");

                    }
                    reader.close();
                }
                
	    }
            writer.close();
            writer2.close();
         }
         catch (IOException e)
         {
                // do something
         }
	 System.out.println("Wordplay handling done.");
         System.out.println("Language Identification done.");
         Hindi_Transliteration.main(args);
         
   }
}