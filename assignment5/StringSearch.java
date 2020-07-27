import java.util.*;
import java.io.*;

public class StringSearch{
    static List<Integer> bfIndex;
    public static void main(String[] args)throws FileNotFoundException{
        String s = readFile(1);
        String findF = "free";
        String findS = "brave"; 
        String findT = "nation";
        bruteForce(s, findT);
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
        return sb.toString().toLowerCase();
    }

    public static void bruteForce(String text, String find){
        bfIndex = new ArrayList();
        for(int i=0; i<text.length()-find.length()+1; i++){
            for(int j=0; j<find.length(); j++){
                if(text.charAt(i+j) != find.charAt(j)){
                    break;
                }
                else if(j == find.length()){
                    bfIndex.add(i);
                }
            }
        }
    }
}