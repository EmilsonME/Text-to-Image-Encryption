/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileencryption;

import java.nio.charset.Charset;
import java.util.*;
//import javafx.scene.paint.Color;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author Emilson
 */
public class PixelRepresentation {
    public TreeMap<String, Color> map;
    public TreeMap<String, String> map2;
    
    public PixelRepresentation(){
        map = new TreeMap<>();
        map2 = new TreeMap<>();
        ArrayList<String> temp;
        try{
           FileReader file = new FileReader("hex.txt");
           BufferedReader bf = new BufferedReader(file);
           String line;
           temp = new ArrayList<String>();
           while((line = bf.readLine()) != null) {
               if(temp.contains(line.trim()) != true){
                   temp.add(line.trim());
               }else{
                   System.out.println(line);
               }
           }
           
            for (int i = 0; i <255; i++){
                char c = (char)i;
                System.out.println(c);
                map2.put(temp.get(i), Character.toString(c));
                map.put(Character.toString(c), Color.decode(temp.get(i)));

            }
        }catch(Exception e){
           
       }
    }
    
    public Color getPixelColor(String character){
        Color pixelColor = map.get(character);
        //System.out.println(character + "ASD");
        if(pixelColor == null){
            System.out.println("Not detected: " + character);
            return new Color(255,255,255);
        }
        
        return pixelColor;
    }
    public String getCharacter(String hex){
        String letter = map2.get(hex);
        if(letter == null){
           // System.out.println("Color not Found " + hex);
            return " ";
        }
        return letter;
    }
}
