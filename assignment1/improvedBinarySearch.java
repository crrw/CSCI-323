import java.util.*;
public class improvedBinarySearch{
    public static void main (String[] args){
        int[] arr = new int[1<<16]; 
        for(int i=0; i<arr.length; i++){
            arr[i] = getRandomNumber(0, (int)Math.pow(10,8));
        }

        Arrays.sort(arr);
        for(int i=0; i<10; i++){
            int key = getRandomNumber(0, (int)Math.pow(10,8));
            binarySearch(arr, 0, arr.length-1, key);
            System.out.println();
        }
    }
    
    public static void binarySearch(int[] arr, int left, int right, int key){
        int cnt = 0;

        while(right - left > 1){
            int mid = left + (right-left)/2;
            cnt++;
            if(arr[mid] <= key){
                left = mid;
            }
            
            else {
                right = mid;
            }
        }

        if(arr[left] == key){
            System.out.format("---------------------------------------------------------%n");
            System.out.format("| Left | Right  | Comparisons  | Found  | Total Elements |%n");
            System.out.format("---------------------------------------------------------%n");
            System.out.format(left + " \t " +right + "\t\t" + cnt+ "\t" + "Found At: "+ left+""+ arr.length);
        }
        else{
            System.out.format("---------------------------------------------------------%n");
            System.out.format("| Left | Right  | Comparisons  | Found | Total Elements |%n");
            System.out.format("---------------------------------------------------------%n");
            System.out.format(left + " \t " +right + "\t\t" + cnt+ "\t" + "Not Found" + "\t" + arr.length);
        }
        
    }
    public static int getRandomNumber(int min, int max){
        return (int) ((Math.random()*(max-min))+min);
    }

    public static void x(int stop){
        for(int i=2; i<= stop; i++){
            if(isPrime(i) && isPrime(2*i+1)){
                System.out.println(i);
            }
        }
    }
    public static boolean  isPrime(int x){
        for(int i=2; i<x; i++){
            if(x%i == 0)return false;
        }
        return true;
    }
}