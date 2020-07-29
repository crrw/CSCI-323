import java.util.*;
import java.io.*;

public class BoyerMoore {
    static Map<Integer, String> inputTextMap;
    static Map<Integer, String> searchTextMap;
    static String inputText = "", searchText = "";
    static long time = 0;
    static int comp=0, searchIndex=1, textIndex =1, totalChar = 256;
    public static void main(String[] args)throws FileNotFoundException{
        inputTextMap = new HashMap();
        searchTextMap = new HashMap();
        textIndex = 1;
        searchIndex = 1;
        inputTextMap.put(1, "Gettysburg Address");
        inputTextMap.put(2, "Star Spangled Banner");
        inputText = inputTextMap.get(textIndex);
        String s = readFile(textIndex);
        searchTextMap.put(1,"FREE");
        searchTextMap.put(2,"BRAVE");
        searchTextMap.put(3,"NATION");
        for(int i=1; i<=3; i++){
            searchText = searchTextMap.get(searchIndex);
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
}