import java.io.*;
import java.util.HashMap;
import java.util.*;

public class EnglishToHindiTranslator {

    public static Map<String, String> phoneticMap = new HashMap<String, String>();
    public static Map<String, String> maatraMap = new HashMap<String, String>();

    static {
        phoneticMap.put("ma","\u092E");
        phoneticMap.put("ta","\u0924");
        phoneticMap.put("t","\u0924\u094D");
        phoneticMap.put("raa","\u0930");
        maatraMap.put("a","\u093E");
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String engWord = "maatraa";
        engWord = engWord.replaceAll("ma",phoneticMap.get("ma") );
        engWord = engWord.replaceAll("t",phoneticMap.get("t") );
        engWord = engWord.replaceAll("raa",phoneticMap.get("ra") );
        engWord = engWord.replaceAll("a",maatraMap.get("a") );

        System.out.println(new String(engWord.getBytes("UTF-8")));
    }
}