import java.util.*;
import java.io.*;

public class StringSearch{
    static List<Integer> bfIndex;
    public static void main(String[] args)throws FileNotFoundException{
        bfIndex = new ArrayList();
        String s = readFile(2);
        System.out.println(s);
        String findF = "FREE";
        String findS = "BRAVE"; 
        String findT = "NATION";
        bruteForce(s, findF);
        System.out.print(bfIndex);
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
                bfIndex.add(i);
                System.out.println("Found at: " + i);
            }
        }
    }
}