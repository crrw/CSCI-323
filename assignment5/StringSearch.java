import java.util.*;
import java.io.*;

public class StringSearch{
    static Map<Integer, String> hm;
    public static void main(String[] args)throws FileNotFoundException{
        int i = 1;
        hm = new HashMap();
        hm.put(1, "gettysburg address");
        hm.put(2, "star spangled banner");
        String s = readFile(i);
        String findF = "FREE";
        String findS = "BRAVE"; 
        String findT = "NATION";
        System.out.println("Searching in text: " + hm.get(i));
        bruteForce(s, findF);
        // bruteForce(s,findS);
        // bruteForce(s,findT);
    }
    public static String readFile(int n)throws FileNotFoundException{
        String read = "input"+Integer.toString(n)+".txt";
        File file = new File(read);
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNext()){
            sb.append(sc.nextLine());
        }
        return sb.toString().toUpperCase();
    }

    public static void bruteForce(String text, String find){
        for(int i=0; i<=text.length()-find.length(); i++){
            int j;
            for(j=0; j<find.length(); j++){
                if(text.charAt(i+j) != find.charAt(j)){
                    break;
                }
            }
            if(j == find.length()){
                System.out.println("First occurence found at: " + i);
            }
        }
    }
}