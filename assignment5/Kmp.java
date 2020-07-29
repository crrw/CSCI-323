import java.util.*; 
import java.io.*;

public class Kmp {
    static Map<Integer, String> inputTextMap;
    static Map<Integer, String> searchTextMap;
    static String inputText = "", searchText = "";
    static long time = 0;
    static int comp=0, searchIndex=1, textIndex =1;
    public static void main(String[] args)throws FileNotFoundException{
        System.out.println("KMP");
        inputTextMap = new HashMap();
        searchTextMap = new HashMap();
        textIndex = 1;
        searchIndex = 1;
        inputTextMap.put(1, "Gettysburg Address");
        inputTextMap.put(2, "Star Spangled Banner");
        inputText = inputTextMap.get(1);

        String s = readFile(textIndex);

        searchTextMap.put(1,"FREE");
        searchTextMap.put(2,"BRAVE");
        searchTextMap.put(3,"NATION");
        for(int i=1; i<=3; i++){
            searchText = searchTextMap.get(searchIndex);
            kmp(s, searchTextMap.get(searchIndex++));
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

    public static void kmp(String search, String pattern){
        long start = System.currentTimeMillis();
        time = start;
        int[] lpsarr = new int[pattern.length()];
        int j = 0;

        lps(pattern, pattern.length(), lpsarr);
        int i = 0; 
        while(i < search.length()){
            comp++;
            if(pattern.charAt(j) == search.charAt(i)){
                i++;
                j++;
            }
            if(j == pattern.length()){
                long end = System.currentTimeMillis();
                time = end-start;
                Print p = new Print(i,comp,time,searchText,inputText);
                p.print(p);
                return;
            }
            else if(i < search.length() && pattern.charAt(j) != search.charAt(i)){
                if(j != 0){
                    comp++;
                    j = lpsarr[j-1];
                }else{
                    i++;
                }
            }
        }

    }

    public static void lps(String s, int length, int[] lpsarr){
        int len = 0; 
        int i=1; 
        lpsarr[0] = 0;

        while(i < length){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lpsarr[i++] = len;
            }else{
                if(len != 0){
                    len = lpsarr[len-1];
                }else{
                    lpsarr[i++] = len;
                }
            }
        }
    }
}