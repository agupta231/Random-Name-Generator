/*
 * All code is made by the author and is
 * not available for use other than the author
 * and his/her team.
 * 
 * Contact the author for details if you want 
 * to use his/her code.
 * 
 * Any unauthorized use of the author's code will 
 * result in the author having full control over the 
 * usage of the code as well as power to confiscate
 * the code. If this header is found deleted, then all
 * of the penalties mentioned above will apply.   
 * 
 * @author Ankur Gupta
 * @date Aug 1, 2015
 */
package animalnamegenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author ankurgupta
 */
public class NameGenerator {
    public LinkedList<String>Prefixes;
    public LinkedList<String>Suffixes;
    
    public NameGenerator() {
        Prefixes = new LinkedList<>();
        Suffixes = new LinkedList<>();
    }
    
    public void extractData() {
        try(BufferedReader br = new BufferedReader(new FileReader("animals.txt"))) {
            String line = br.readLine();
            
            while(line != null) {
                line = br.readLine();
                
                int delimiterLocation = line.indexOf("|");
                String prefix = line.substring(0, delimiterLocation - 1);
                String suffix = line.substring(delimiterLocation + 2, line.length());
                
                Prefixes.add(prefix);
                Suffixes.add(suffix);
            }
        }
        catch(Exception e) {
            
        }
    }
   
    public String generateName() {
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        boolean endsWithVowel = false;
        
        String prefix = Prefixes.get((int)(Math.random() * Prefixes.size()));
        String suffix = "";
        
        if(vowels.contains(Character.toLowerCase(prefix.charAt(prefix.length() - 1)))) {
            endsWithVowel = true;
        }
        
        while(true) {
            suffix = Suffixes.get((int)(Math.random() * Suffixes.size()));
            
            if(endsWithVowel) {
                if(!vowels.contains(Character.toLowerCase(suffix.charAt(0)))) {
                    break;
                }
            }
            else if(!endsWithVowel) {
                if(vowels.contains(Character.toLowerCase(suffix.charAt(0)))) {
                    break;
                }
            }
        }
        
        String finalString = prefix + suffix;
        return finalString;
    }
}
