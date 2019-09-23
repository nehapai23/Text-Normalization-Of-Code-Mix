package Text_Normalization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neha
 */
public class Syllabification {
    public String Syllabify_Transliterate(String s) throws FileNotFoundException, IOException {
        Map<String, String> dictionary = new HashMap<String, String>();
        Map<String, String> dictionary1 = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Neha\\Desktop\\Input files\\barakhadi.txt")));
	BufferedReader reader1 = new BufferedReader(new FileReader(new File("C:\\Users\\Neha\\Desktop\\Input files\\maatra.txt")));
        String inputLine = null;
        while((inputLine = reader.readLine()) != null) 
	{
            String key =  inputLine.substring(0,inputLine.indexOf(","));
            String value = inputLine.substring(inputLine.indexOf(",")+1);
            //System.out.println(key+":"+value);
            dictionary.put(key,value);
        }
	reader.close();
        inputLine = null;
        while((inputLine = reader1.readLine()) != null) 
	{
            String key =  inputLine.substring(0,inputLine.indexOf(","));
            String value = inputLine.substring(inputLine.indexOf(",")+1);
            //System.out.println(key+":"+value);
            dictionary1.put(key,value);
        }
	reader1.close();
        
        //String s = "kamiyaabi..";
        System.out.println(s);
        int l = s.length();
        String syllable[] = new String[l];
        String combinations[] = new String[l];
        String label[] = new String[l];
        for(int i=0; i<l; i++)
        {
            if((s.charAt(i) == 'a') || 
                (s.charAt(i) == 'e')  ||
                (s.charAt(i) == 'i') || 
                (s.charAt(i) == 'o') ||
                (s.charAt(i) == 'u'))
            {
                syllable[i] = "V";
            } else {
                syllable[i] = "C";
            }
        }
        int j=0;
        for(int i=0; i<l-2; i++)
        {
            if(syllable[i]=="V")
            {
                if(((s.charAt(i+1)=='m' || s.charAt(i+1)=='n'))&&syllable[i+2]!="V")
                {
                    combinations[j] = Character.toString(s.charAt(i))+Character.toString(s.charAt(i+1));
                    label[j]="VC";
                    j++;
                    i+=1;
                }
                else if(syllable[i+1]=="V")
                {
                    combinations[j] = Character.toString(s.charAt(i))+Character.toString(s.charAt(i+1));
                    label[j]="V";
                    j++;   
                    i+=1;
                }
                else
                {
                    combinations[j]=Character.toString(s.charAt(i));
                    label[j]="V";
                    j++;
                }
            }
            else
            {
                if(syllable[i+1]=="C" && syllable[i+2]=="C")
                {
                    String ak = Character.toString(s.charAt(i))+Character.toString(s.charAt(i+1))+Character.toString(s.charAt(i+2));
                    //if(dictionary.containsKey(ak))
                    {
                        combinations[j]=ak;
                        label[j]="C";
                        j++;
                        i+=2;
                    }
                    /*else
                    {
                        combinations[j]=Character.toString(s.charAt(i));
                        label[j]="C";
                        j++;
                    }*/
                }
                else if(syllable[i+1]=="C")
                {
                    String ak = Character.toString(s.charAt(i))+Character.toString(s.charAt(i+1))+Character.toString(s.charAt(i+2));
                    //if(dictionary.containsKey(ak))
                    {
                        combinations[j]=ak;
                        label[j]="C";
                        j++;
                        i+=2;
                    }
                    /*else
                    {
                        combinations[j]=Character.toString(s.charAt(i));
                        label[j]="C";
                        j++;
                    }*/
                }
                else
                {
                    combinations[j]=Character.toString(s.charAt(i));
                    label[j]="C";
                    j++;
                }
            }
        }
        for(int i=0;i<j;i++)
        {
            System.out.print(" "+combinations[i]);
        }
        System.out.println("");
        for(int i=0;i<j;i++)
        {
            System.out.print(" "+label[i]);
        }
        String[] t = new String[l];
        int k=0;
        for(int i=0;i<j;i++)
        {
            if(i==j)
            {
                t[k] = combinations[i];
                break;
            }
            else if("C".equals(label[i])&&"V".equals(label[i+1])||"C".equals(label[i])&&"VC".equals(label[i+1]))
            {
                t[k] = combinations[i]+combinations[i+1];
                k++;
                i++;
            }
            else
            {
                t[k] = combinations[i];
                k++;
            }
        }
        System.out.println();
        StringBuilder inHindi=new StringBuilder(""); 
        for(int i=0; i<k; i++)
        {
            System.out.print("lol : "+t[i]);
            String d = dictionary.get(t[i]);
            System.out.println(d);
            
            if(d != null)
            inHindi.append(dictionary.get(t[i]));
            else
            {
                if(t[i].endsWith(".."))
                {
                    t[i] = t[i].substring(0, 1);
                    inHindi.append(dictionary.get(t[i]));
                }
                else if(t[i].endsWith("."))
                {
                    t[i] = t[i].substring(0, 2);
                    inHindi.append(dictionary.get(t[i]));
                }
                else
                {
                    String a = (t[i]).substring(0,2);
                    String aa = dictionary.get(a);
                    System.out.println(a);
                    System.out.println("blah"+aa);
                    String b = (t[i]).substring(2);
                    String bb = dictionary1.get(b)!=null ? dictionary1.get(b) : dictionary.get(b) ;
                    System.out.println(b);
                    System.out.println("blah"+bb);
                    inHindi.append(aa+bb);
                }
            }
            
        }
        inHindi.append("\0");
        System.out.print("\n"+inHindi);
        return(inHindi.toString());
    }
    
}
