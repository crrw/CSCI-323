import java.util.*;
import java.io.*;
public class StringSearch{
    public static void main(String[] args){

    }
    public static readFile()throws FileNotFounndException{
        File file = new File("input1.txt");
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNext()){
            sb.append(sc.nextLine());
        }

        return sb.toString();
    }
}