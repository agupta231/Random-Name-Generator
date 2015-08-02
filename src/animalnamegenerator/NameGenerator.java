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
    public LinkedList<Animal>animals;
    
    public NameGenerator() {
        animals = new LinkedList<>();
    }
    
    public void extractData() {
        try(BufferedReader br = new BufferedReader(new FileReader("animals.txt"))) {
            String line = br.readLine();
            
            while(line != null) {
                line = br.readLine();
                
                animals.add(new Animal(line));
            }
        }
        catch(Exception e) {
            
        }
    }
   
    public String generateName() {
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        boolean endsWithVowel = false;
        
        int prefixRandom = (int) (Math.random() * animals.size());
        String prefix = animals.get(prefixRandom).prefix;
        String prefixAnimal = animals.get(prefixRandom).animal;
        
        String suffix = "";
        String suffixAnimal = "";
        
        if(vowels.contains(Character.toLowerCase(prefix.charAt(prefix.length() - 1)))) {
            endsWithVowel = true;
        }
        
        while(true) {
            int suffixRandom = (int) (Math.random() * animals.size());
            suffix = animals.get(suffixRandom).suffix;            
            
            if(endsWithVowel) {
                if(!vowels.contains(Character.toLowerCase(suffix.charAt(0)))) {
                    suffixAnimal = animals.get(suffixRandom).animal;
                    break;
                }
            }
            else if(!endsWithVowel) {
                if(vowels.contains(Character.toLowerCase(suffix.charAt(0)))) {
                    suffixAnimal = animals.get(suffixRandom).animal;
                    break;
                }
            }
        }
        
        StringBuilder finalString = new StringBuilder();
        finalString.append(prefixAnimal);
        finalString.append(" + ");
        finalString.append(suffixAnimal);
        finalString.append(" = ");
        finalString.append(prefix);
        finalString.append(suffix);
        
        return finalString.toString();
    }
}
