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
import java.io.*;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.PrintWriter;

public class Tokenization {
    
    String input = null;
    Tokenization(String i)
    {
        input = i;
        
    }
    public static void main(String args[]) throws IOException {
        /*//File file = new File("C:\\Users\\Neha\\Desktop\\Input files\\input.txt");
        //FileReader fr = new FileReader(file);
        //BufferedReader br = new BufferedReader(fr);
        System.out.println("neha");
        File NewTextFile = new File("C:\\Users\\Neha\\Desktop\\Input files\\op_tokenization.txt");

        PrintWriter fw = new PrintWriter(NewTextFile);
        String s = null;

        /*while ((s = br.readLine()) != null) {
            String newString = s.replaceAll("[^a-zA-Z0-9]", " ");
            StringTokenizer st = new StringTokenizer(newString);

            while (st.hasMoreTokens()) {
                fw.println(st.nextToken());
            }
            fw.close();

        }
        */
        
        /*while (input != null) {
            String newString = input.replaceAll("[^a-zA-Z0-9]", " ");
            StringTokenizer st = new StringTokenizer(newString);

            while (st.hasMoreTokens()) {
                fw.println(st.nextToken());
            }
            fw.close();

        }
        System.out.println("Tokenization done.");*/
        Handling_abbreviations.main(args);
    }
    void Token() throws FileNotFoundException, IOException
    {
        //File file = new File("C:\\Users\\Neha\\Desktop\\Input files\\input.txt");
        //FileReader fr = new FileReader(file);
        //BufferedReader br = new BufferedReader(fr);
        
        File NewTextFile = new File("C:\\Users\\Neha\\Desktop\\Input files\\op_tokenization.txt");

        PrintWriter fw = new PrintWriter(NewTextFile);
        String s = null;

        /*while ((s = br.readLine()) != null) {
            String newString = s.replaceAll("[^a-zA-Z0-9]", " ");
            StringTokenizer st = new StringTokenizer(newString);

            while (st.hasMoreTokens()) {
                fw.println(st.nextToken());
            }
            fw.close();

        }
        */
        
        //while () {
            String newString = input.replaceAll("[^a-zA-Z0-9]", " ");
            StringTokenizer st = new StringTokenizer(newString);

            while (st.hasMoreTokens()) {
                fw.println(st.nextToken().toLowerCase());
            }
            fw.close();

        //}
        System.out.println("Tokenization done.");
        Tokenization.main(null);
    }

}
