import java.util.*;

public class QSRP{
    static int qsrpcnt = 0; 
    static int qsmmcnt = 0;
    public static void main(String[] args){
        Integer[] arr = new Integer[10_000];
        // Print p = new Print();
        long startTime = -1, endTime = -1;
        List<Integer> lst = new ArrayList(); 
        for(int j=0; j<10_000; j++){    
            lst.add(j+1);
        }
        for(int i=0; i<arr.length; i++){
            arr[i] = (i+1);
        }
        int key = arr[arr.length/2];

        System.out.printf("%10s %5s %15s %15s %15s %15s %15s %15s", "Trial# |", "Size |", "Median(QSRP) |", "Median(QSMM) |", "Clock Time(QSRP)ms |", "Clock Time(QSMM)ms |", "Comparisons(QSRP) |", "Comparisons(QSMM)\n");
        for(int i=0; i<10; i++){
            long startmm = System.currentTimeMillis();
            medianOfMedians(lst, lst.size() / 2);
            long endmm = System.currentTimeMillis();
            List<Integer> list = Arrays.asList(arr);
            Collections.shuffle(list);
            Collections.shuffle(lst);
            list.toArray(arr);
            startTime = System.currentTimeMillis();
            smallest(arr,0,arr.length-1, key);
            endTime = System.currentTimeMillis();
            Print p = new Print((i+1), arr.length, key, 5001, (endTime-startTime), (endmm-startmm), qsrpcnt, qsmmcnt);
            Print.print(p);
            qsrpcnt = 0;
            qsmmcnt = 0;
        }
    }

    public static int smallest(Integer[] arr, int low, int high, int key) {
        int pr = partition(arr, low, high);

        if (pr == key) {
            return arr[pr];
        }

        else if (pr < key) {
            return smallest(arr, pr + 1, high, key);
        } else {
            return smallest(arr, low, pr - 1, key);
        }
    }

    public static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int idx = low;

        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                qsrpcnt++;
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx++] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[idx];
        arr[idx] = temp;

        return idx;
    }

    public static int medianOfMedians(List<Integer> arr, int in) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> med = new ArrayList();

        for (int i = 0; i < arr.size(); i += 5) {
            if (i + 5 >= arr.size() - 1) {
                list.add(arr.subList(i, arr.size()));
            } else
                list.add(arr.subList(i, i + 5));
        }

        for (int i = 0; i < list.size(); i++) {// List<List<Integer>> sort
            for (int j = 1; j < list.get(i).size(); j++) {
                int key = list.get(i).get(j);
                int k = j - 1;
                qsmmcnt++;
                while (k >= 0 && list.get(i).get(k) > key) {
                    list.get(i).set(k + 1, list.get(i).get(k));
                    k--;
                }
                list.get(i).set(k + 1, key);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i).size() / 2;
            med.add(list.get(i).get(m));
        }

        int pivot = -1;

        if (med.size() <= 5) {// median sort
            for (int i = 0; i < med.size(); i++) {
                int key = med.get(i);
                int k = i - 1;
                while (k >= 0 && med.get(k) > key) {
                    med.set(k + 1, med.get(k));
                    k--;
                }
                med.set(k + 1, key);
            }
            pivot = med.get(med.size() / 2);
        } else {
            pivot = medianOfMedians(med, med.size() / 2);
        }
        List<Integer> low = new ArrayList();
        List<Integer> high = new ArrayList();

        for (int i = 0; i < arr.size(); i++) {
            qsmmcnt++;
            if (arr.get(i) < pivot) {
                low.add(arr.get(i));
            } else if (arr.get(i) > pivot) {
                high.add(arr.get(i));
            }
        }
        if (in < low.size()) {
            return medianOfMedians(low, in);
        } else if (in > low.size()) {
            return medianOfMedians(high, in - 1 - low.size());
        }
        low.clear();
        high.clear();
        med.clear();
        list.clear();
        arr.clear();
        return pivot;
    }
}

