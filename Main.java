import java.util.*;
import java.io.*;

public class Main
{
    private static String[] tries = new String[6];
    private static ArrayList<String> words = new ArrayList<>();
    private static String ans;
    
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("words.txt"));
        
        while(sc.hasNextLine())
        {
            String word = sc.nextLine();
            if(word.length() == 5) words.add(word.toLowerCase());
        }
        
        sc = new Scanner(System.in);
        ans = words.get((int) (Math.random() * words.size()));
        System.out.println("\n|   |   |   |   |   |\n\n|   |   |   |   |   |\n\n|   |   |   |   |   |\n\n|   |   |   |   |   |\n\n|   |   |   |   |   |\n\n|   |   |   |   |   |");
        
        for(int lives = 6; lives > 0; lives--)
        {
            String guess = sc.nextLine();
            
            if(guess.length() != 5 || !words.contains(guess))
            {
                lives++;
                continue;
            }
            
            printGrid(guess);
        }
    }
    
    private static void printGrid(String guess)
    {
        
        System.out.println("\n|   |   |   |   |   |\n\n|   |   |   |   |   |\n\n|   |   |   |   |   |\n\n|   |   |   |   |   |\n\n|   |   |   |   |   |\n\n|   |   |   |   |   |");
    }
}
