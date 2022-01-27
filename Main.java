import java.util.*;
import java.io.*;

/**
 * () means the character is in the word somewhere
 * [] means the character is in the word at the same place
 */

public class Main
{
    private static final int t = 6, l = 5;
    private static String ans, blank = "\n|";
    
    private static String[] tries = new String[t];
    private static ArrayList<String> words = new ArrayList<>();
    
    private static int k = 0;
    
    public static void main(String[] args) throws IOException
    {
        //gathering words and randomizing answer
        
        Scanner sc = new Scanner(new File("words.txt"));
        
        while(sc.hasNextLine())
        {
            String word = sc.nextLine();
            if(word.length() == l) words.add(word.toLowerCase());
        }
        
        ans = words.get((int) (Math.random() * words.size()));
        
        //beginning output
        
        for(int i = 0; i < l; i++)
            blank += "   |";

        for(int i = 0; i < t; i++)
            System.out.println(blank);
        
        System.out.println("\n() means the letter is in the word somewhere.\n[] means the letter is in the correct place.");
            
        //main loop    
        
        sc = new Scanner(System.in);
        
        for(int lives = 0; lives < t; lives++)
        {
            String guess = sc.nextLine().toLowerCase();
            
            if(guess.length() != l || !words.contains(guess))
            {
                printTries();
                System.out.println("\nInvalid word!");
                
                lives--;
                continue;
            }
            
            tries[lives] = format(guess);
            printTries();
            
            if(k == l)
            {
                System.out.println("\nYou win!");
                break;
            }
        }
        
        if(k != l) System.out.println("\nYou lose!");
    }
    
    private static String format(String g) //formats guess into output
    {
        String a = ans;
        StringBuilder sb = new StringBuilder("|");
        k = 0;
        
        for(int i = 0; i < l; i++)
        {
            char c = g.charAt(i);
            
            if(ans.charAt(i) == c)
            {
                sb.append("[").append(c).append("]|");
                k++;
            }
            else if(a.contains("" + c))
            {
                sb.append("(").append(c).append(")|");
                a.replace("" + i, "");
            }
            else sb.append(" ").append(c).append(" |");
        }
        
        return sb.toString();
    }
    
    private static void printTries() //outputs guesses
    {
        System.out.print("\f");
        
        for(int i = 0; i < t; i++)
            System.out.println(tries[i] == null ? blank : ("\n" + tries[i]));
    }
}
