import java.util.*;
import java.io.*;

public class StringSearch{
    static Map<Integer, String> inputTextMap;
    static Map<Integer, String> searchTextMap;
    static String inputText = "", searchText = "";
    static long time = 0;
    static int comp=0, searchIndex=1, textIndex =1;
    public static void main(String[] args)throws FileNotFoundException{
        System.out.print("===============\n");
        System.out.print("BruteForce\n");
        System.out.print("===============");
        inputTextMap = new HashMap();
        searchTextMap = new HashMap();
        textIndex = 1;
        searchIndex = 1;
        inputTextMap.put(1, "Gettysburg Address");
        inputTextMap.put(2, "Star Spangled Banner");
        inputText = inputTextMap.get(searchIndex);

        String s = readFile(textIndex);

        searchTextMap.put(1,"FREE");
        searchTextMap.put(2,"BRAVE");
        searchTextMap.put(3,"NATION");
        for(int i=1; i<=3; i++){
            searchText = searchTextMap.get(searchIndex);
            bruteForce(s, searchTextMap.get(searchIndex++));
        }
        
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
        long start = System.currentTimeMillis();
        time = start;
        for(int i=0; i<=text.length()-find.length(); i++){
            int j;
            for(j=0; j<find.length(); j++){
                comp++;
                if(text.charAt(i+j) != find.charAt(j)){
                    break;
                }
            }
            
            if(j == find.length()){
                long end = System.currentTimeMillis();
                time = end-time;
                Print p = new Print(i,comp,time,searchText,inputText);
                p.print(p);
                return;
            }
        }
    }
}