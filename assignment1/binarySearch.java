import java.util.*;
public class binarySearch{
    public static void main(String[] args) {
        int[] arr = new int[1<<16];

        for(int i=0; i<1<<16; i++){
           arr[i] = getRandomNumber(0, (int)Math.pow(10,8));
        }
        Arrays.sort(arr);

        for(int i=0; i<10; i++){
            int key = getRandomNumber(0, (int)Math.pow(10,8));
            binSearch(arr, key);
            System.out.println();
        }
    }
    
    public static void binSearch(int[] list, int compare){
        int left = 0, right = list.length-1, cnt = 0;

        while(left <= right){
            int mid = (left+right)/2;
            cnt++;
            if(list[mid] == compare){ //if found
                System.out.format("---------------------------------------------------------------------%n");
                System.out.format("| Left | Right  | Expected | Comparisons  | Found  | Total Elements |%n");
                System.out.format("---------------------------------------------------------------------%n");
                System.out.format(left + " \t " +right+ "\t\t17"+ "\t" + cnt+ "\t" + " Found\t" + list.length);
                return;
            }
            cnt++;
            if(list[mid] < compare){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }//if loops exits, we didn't find the element
                System.out.format("---------------------------------------------------------------------%n");
                System.out.format("| Left | Right  | Expected | Comparisons  | Found  | Total Elements |%n");
                System.out.format("---------------------------------------------------------------------%n");
                System.out.format(left + " \t " +right+ "\t\t17"+ "\t" + cnt+ "\t" + "Not Found\t" + list.length);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
