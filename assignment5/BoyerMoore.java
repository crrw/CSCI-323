import java.util.*;
import java.io.*;

public class BoyerMoore {
    static Map<Integer, String> inputTextMap;
    static Map<Integer, String> searchTextMap;
    static String inputText = "", searchText = "";
    static long time = 0;
    static int comp = 0, searchIndex = 1, textIndex = 1, NO_OF_CHARS = 65534;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("===============\n");
        System.out.print("BoyerMoore\n");
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
            searchText = searchTextMap.get(searchIndex);
            char[] pattern = searchText.toCharArray();
            char[] text = s.toCharArray();
            search(text, pattern);
            searchIndex++;
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

    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static void badCharHeuristic(char[] str, int size, int badchar[]) {
        int i;
        for (i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        for (i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    static void search(char txt[], char pat[]) {
        long start = System.currentTimeMillis();
        time = start;
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];
        badCharHeuristic(pat, m, badchar);

        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pat[j] == txt[s + j])
                j--;
            if (j < 0) {
                long end = System.currentTimeMillis();
                time = end-start;
                Print p = new Print(s, comp, time, searchText, inputText);
                p.print(p);
                return;

            } else {
                s += max(1, j - badchar[txt[s + j]]);
                comp++;
            }

        }
    }
}