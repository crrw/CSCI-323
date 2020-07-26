import java.io.*;
import java.util.*;
public class RLE{
    public static void main(String[] args)throws FileNotFoundException{
        String s = readFile();
        System.out.println(rle(s));
        // String t = readDecomp();?
        String t = rle(s);
        t = decomp(reverse(t));
        System.out.println(t);
    }

    public static String readFile()throws FileNotFoundException{
        File file = new File("C:\\Users\\Aasish\\Desktop\\323\\input\\input1.txt");
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNext()){
            sb.append(sc.nextLine());
        }

        return sb.toString();
    }
    
    public static String rle(String s){
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                cnt++;
            }
            else {
                sb.append(s.charAt(i));
                sb.append(cnt);
                cnt=1;
            }
        }
        
        if(s.charAt(s.length()-1) == s.charAt(s.length()-2)){
            sb.append(s.charAt(s.length()-1));
            sb.append(cnt);
        }
        else{
            sb.append(s.charAt(s.length()-1));
            sb.append(1);
        }
        return sb.toString();
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder(); 
        if(s.length() == 0) return ""; 

        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String decomp(String s){
        String num = "";
        StringBuilder sb = new StringBuilder(); 
        
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num += s.charAt(i);
            }
            else{
                StringBuilder t = new StringBuilder(num);
                num = t.reverse().toString();
                for(int j=0; j<Integer.parseInt(num); j++){
                    sb.append(s.charAt(i));
                }
                num = "";
            }
        }
        return sb.reverse().toString();
    }
}
