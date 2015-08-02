/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalnamegenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 *
 * @author Ankur
 */
public class Main {
    public static LinkedList<String>Prefix;
    public static LinkedList<String>Suffix;
    
    public static void main(String[] args) {
        Main.extractData();
        System.out.print(Prefix);
    }
    
    public static void extractData() {
        try(BufferedReader br = new BufferedReader(new FileReader("animals.txt"))) {   
            String line = "blank";
            
            while(line != null) {
                line = br.readLine();
                int delimiterLocation  = line.indexOf("|");
 
                String prefix = line.substring(0, delimiterLocation - 1);
                String suffix = line.substring(delimiterLocation + 2, line.length());
                
                System.out.println(prefix);
                System.out.println(suffix);
                
                Main.Suffix.add("test");
            }
        }
        catch (Exception e) {
        }
    }
}
