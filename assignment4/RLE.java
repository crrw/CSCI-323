import java.util.*;
public class RLE{
    public static void main(String[] args){
        String s = "wwwwaaadexxxxxxywww";
        System.out.println(rle(convert(s)));
    }
    public static String convert(String s){
        return s.replaceAll("\\s+", "");
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
}
