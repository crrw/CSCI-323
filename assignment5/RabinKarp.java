import java.util.*;
import java.io.*;

public class RabinKarp {
    static Map<Integer, String> inputTextMap;
    static Map<Integer, String> searchTextMap;
    static String inputText = "", searchText = "";
    static long time = 0;
    static int comparisons = 0, searchIndex = 1, textIndex = 1;
    public final static int uniq = 256;

    public static void main(String[] args) throws FileNotFoundException{
        System.out.print("===============\n");
        System.out.print("RabinKarp\n");
        System.out.print("===============");
        inputTextMap = new HashMap();
        searchTextMap = new HashMap();
        textIndex = 1;
        searchIndex = 1;
        inputTextMap.put(1, "Gettysburg Address");
        inputTextMap.put(2, "Star Spangled Banner");
        inputText = inputTextMap.get(textIndex);
        String s = readFile(textIndex);
        searchTextMap.put(1, "FREE");
        searchTextMap.put(2, "BRAVE");
        searchTextMap.put(3, "NATION");
        for (int i = 1; i <= 3; i++) {
            searchText = searchTextMap.get(searchIndex++);
            rabinKarp(s, searchText, 97);
        }

    }

    public static String readFile(int n) throws FileNotFoundException {
        String read = "input" + Integer.toString(n) + ".txt";
        File file = new File(read);
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        return sb.toString().toUpperCase();
    }

    public static void rabinKarp(String text, String pattern, int prime) {
        int M = pattern.length();
        int N = text.length();
        int i, j;
        int ptrn = 0, txt = 0, hash = 1;

        for (i = 0; i < M - 1; i++) {
            hash = (hash * uniq) % prime;
        }

        for (i = 0; i < M; i++) {
            ptrn = (uniq * ptrn + pattern.charAt(i)) % prime;
            txt = (uniq * txt + text.charAt(i)) % prime;
        }

        for (i = 0; i < N - M; i++) {
            comparisons++;
            if (ptrn == txt) {
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) == pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == M) {
                    Print out = new Print(i*10, comparisons, time, searchText, inputText);
                    out.print(out);
                    return;
                }
            }
            if (i < N - M) {
                txt = (uniq * (txt - text.charAt(i) * hash) + text.charAt(i + M)) % prime;
                if (txt < 0) {
                    txt = txt + prime;
                }
            }
        }
    }
}