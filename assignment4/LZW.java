import java.util.*;
import java.io.*;

public class LZW {
    public static void main(String[] args)throws FileNotFoundException{
        // String s = readFile();
        String s = "abcdefghijklmnopqrstuvwxyz";
        List<Integer> comp = new ArrayList();
        comp = compress(s);
        System.out.println(comp);
        String t = decomp(comp);
        System.out.println(t);
    }

    public static String readFile()throws FileNotFoundException{
        File file = new File("input1.txt");
        Scanner sc = new Scanner(file); 
        StringBuilder sb = new StringBuilder(); 

        while(sc.hasNext()){
            sb.append(sc.nextLine());
        }
        String s = sb.toString();
        s = s.replaceAll("\\p{C}", "");
        return s;
    }

    public static List<Integer> compress(String s){
        int size = 256;
        Map<String, Integer> hm = new HashMap<>();

        for(int i=0; i<256; i++){
            hm.put(""+(char)i,i);
        }
        String sb = "";
        List<Integer> list = new ArrayList<>();
        for(char c: s.toCharArray()){
            String sba = sb+c;
            if(hm.containsKey(sba)){
                sb = sba;
            }
            else{
                list.add(hm.get(sb));
                hm.put(sba, size++);
                sb = ""+c;
            }
        }
        if(!sb.equals("")){
            list.add(hm.get(sb));
        }
        return list;
    }

    public static String decomp(List<Integer> list){
        int size = 256;
        Map<Integer, String> hm = new HashMap<>();
        for(int i=0; i<257; i++){
            hm.put(i, ""+(char)i);
        }

        String s = ""+(char)(int)list.remove(0);
        String res = s;

        for(int i : list){
            String curr; 
            if(hm.containsKey(i)){
                curr = hm.get(i);
            }
            else if(i == size){
                curr = s + s.charAt(0);
            }
            else throw new IllegalArgumentException("error");

            res+=curr;
            
            hm.put(size++, s+curr.charAt(0));
            s = curr;
        }
        return res.toString();
    }
}
