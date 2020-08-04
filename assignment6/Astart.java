import java.util.*;
import java.io.*;

public class Astart {
    static boolean king = true;
    static List<int[]> list;
    public static void main(String[] args) {
        int[][] board = new int[15][12];
        Pair start = new Pair(7, 1);
        Pair end = new Pair(14, 11);

        board[2][4] = -1;
        board[5][3] = -1;
        board[6][8] = -1;
        board[13][2] = -1;
        board[14][1] = -1;
        board[7][11] = -1;
        board[7][1] = 1;
        board[14][11] = 1;
        long startTime = System.currentTimeMillis();
        System.out.println("Distance: " + star(board, start, end));
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime-startTime) +"ms");
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[i].length; j++) {
        //         System.out.print(board[i][j] + "   ");
        //     }
        //     System.out.println();
        // }
        System.out.print("\t");
        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i)[0] + "," + list.get(i)[1] + "\t");
        }
    }

    public static int star(int[][] board, Pair start, Pair end){
        list = new ArrayList();
        if (king) {
            int[][] dist = new int[board.length][board[0].length];

            for (int[] arr : dist) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            dist[start.first][start.second] = 0;
            int[][] moves = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 } };

            PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
            queue.offer(start);

            while (!queue.isEmpty()) {
                Pair curr = queue.remove();
                for (int[] move : moves) {
                    int x = curr.first + move[0];
                    int y = curr.second + move[1];
                    int cnt = 0;

                    while (onboard(board, x, y)) {
                        x += move[0];
                        y += move[1];
                        cnt++;
                        list.add(new int[] {x,y});
                    }

                    if (dist[curr.first][curr.second] + cnt < dist[x - move[0]][y - move[1]]) {
                        dist[x - move[0]][y - move[1]] = dist[curr.first][curr.second]  + cnt;
                        queue.offer(new Pair (x - move[0], y - move[1]));
                    }
                }
            }
            if (dist[end.first][end.second] == Integer.MAX_VALUE) {
                return -1;
            }
            return dist[end.first][end.second];

        } else {
            int[][] dist = new int[board.length][board[0].length];

            for (int[] arr : dist) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            dist[end.first][end.second] = 0;
            int[][] moves = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

            PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
            queue.add(start);

            while (!queue.isEmpty()) {
                Pair curr = queue.remove();
                for (int[] move : moves) {
                    int x = curr.first + move[0];
                    int y = curr.second + move[1];
                    int cnt = 0;

                    while (onboard(board, x, y)) {
                        x += move[0];
                        y += move[1];
                        cnt++;
                        list.add(new int[] {x,y});
                    }

                    if (dist[curr.first][curr.second] + cnt < dist[x - move[0]][y - move[1]]) {
                        dist[x - move[0]][y - move[1]] = dist[curr.first][curr.second] + cnt;
                        queue.add(new Pair (x - move[0], y - move[1]));
                    }
                }
            }
            if (dist[end.first][end.second] == Integer.MAX_VALUE) {
                return -1;
            }
            return dist[end.first][end.second];
        }
    }

    public static boolean onboard(int[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] != -1)
            return true;

        return false;
    }
}

class Pair implements Comparable {
    static int first, second;

    public Pair(int first, int second){
        this.first = first; 
        this.second = second;
    }
    public void setFirst(int x){
        this.first = x;
    }
    public void setSecond(int y){
        this.second = y;
    }
    public int getFirst(){
        return this.first; 
    }
    public int getSecond(){
        return this.second;
    }
    @Override
    public int compareTo(Object p) {
        if(((Pair) p).getFirst() == ((Pair) p).getSecond())
            return 0;
        else{
            return ((Pair)p).getFirst() - ((Pair) p).getSecond();
        }
    }
}