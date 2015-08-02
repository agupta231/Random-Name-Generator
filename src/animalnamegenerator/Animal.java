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
 * @date Aug 2, 2015
 */
package animalnamegenerator;

/**
 *
 * @author ankurgupta
 */
public class Animal {
    public String prefix;
    public String suffix;
    public String animal;
    
    public Animal(String raw) {
        extractData(raw);
    }
    public void extractData(String raw) {
        
        int delimiterLocation = raw.indexOf("|");
        
        prefix = raw.substring(0, delimiterLocation - 1);
        suffix = raw.substring(delimiterLocation + 2, raw.length());
        animal = raw.substring(0, delimiterLocation -1) + raw.substring(delimiterLocation + 2, raw.length());
    }
}
