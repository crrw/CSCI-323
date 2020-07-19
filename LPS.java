import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;

public class LPS{
    static int cns=0, cn=0, cnd=0;
    public static void main(String[] args)throws FileNotFoundException{
        long compNs=0, compN=0, compD=0, start=0, end=0;
        String s = parse(readFile());
        start = System.currentTimeMillis();
        longestCommonSequence(s);
        end = System.currentTimeMillis();
        compNs = end-start;

        start = System.currentTimeMillis();
        lpsn(s);
        end = System.currentTimeMillis();
        compN = end-start;

        start = System.currentTimeMillis();
        lcs(s,rev(s));
        end = System.currentTimeMillis();
        compD = end-start;


        Print p = new Print(compNs, compN, compD, cns, cn, cnd);
        p.print(p);
        
        System.out.println("Total length of sequence: " + lpsn(s)+"\n");
        System.out.print("Longest palindrome subsequence:\t");
        System.out.println(lcs(s,rev(s)));
               
    }
    public static String readFile()throws FileNotFoundException{
        File file = new File("C:\\Users\\Aasish\\Desktop\\323\\input\\input1.txt");
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder(); 
        sc.useDelimiter("\\s");
        while(sc.hasNextLine()){
            sb.append(sc.nextLine());
        }
        return sb.toString();
    }
    public static String parse(String s){
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static int longestCommonSequence(String s){
        if(s == null || s.length() == 0) return 0; 
        s = s.replaceAll("\\s+", "");
        s = s.toLowerCase();
        int[][] dp = new int[s.length()][s.length()];

        for(int i=s.length()-1; i>=0; i--){
            dp[i][i] = 1; 
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    cns++;
                    dp[i][j] = 2+dp[i+1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static int lpsn(String s){
        s = s.replaceAll("\\s+", "");
        s = s.toLowerCase();
        int[] dp = new int[s.length()]; 
        int N = s.length(); 

        for(int i=N-1; i>=0; i--){
            int curr = 0;
            for(int j=i; j<N; j++){
                if(i == j){
                    dp[j] = 1;
                }
                else if(s.charAt(i) == s.charAt(j)){
                    cn++;
                    int t = dp[j];
                    dp[j] = curr + 2;
                    curr = t;
                }
                else{
                    cn++;
                    curr = dp[j];
                    dp[j] = Math.max(dp[j-1],dp[j]);
                }
            }
        }
        return dp[N-1];
    }

    public static String lcs(String a, String b){
        char ac[] = a.toCharArray(); 
        char bc[] = b.toCharArray();

        int[][] dp = new int[a.length()+1][b.length()+1];

        for(int i=0; i<=a.length(); i++){
            for(int j=0; j<=b.length(); j++){
                if(i == 0 || j  == 0){
                    dp[i][j] = 0;
                }
                else if(ac[i-1] == bc[j-1]){
                    cnd++;
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    cnd++;
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }            
        }

        int i = a.length(), j = i, index = dp[a.length()][b.length()];
        char[] arr = new char[index+1];

        while(i > 0 && j > 0){
            if(ac[i-1]==bc[j-1]){
                cnd++;
                arr[index-1] = ac[i-1];
                i--;
                j--;
                index--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                cnd++;
                i--;
            }
            else{
                j--;
            }
        }
        return new String(arr);
    }

    public static String rev(String a){
        StringBuilder sb = new StringBuilder(); 
        for(int i=a.length()-1; i>=0; i--){
            sb.append(a.charAt(i));
        }
        return sb.toString();
    }

    public static String convert(String s){
        StringBuilder sb = new StringBuilder(); 
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >='a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}