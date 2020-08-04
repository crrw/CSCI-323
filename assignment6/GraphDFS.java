import java.util.*;
import java.io.*;

public class GraphDFS {
    static boolean king = true;
    static List<int[]> list;
    public static void main(String[] args) {
        int[][] board = new int[15][12];
        int[] start = new int[] { 7, 1 };
        int[] end = new int[] { 14, 11 };

        board[2][4] = -1;
        board[5][3] = -1;
        board[6][8] = -1;
        board[13][2] = -1;
        board[14][1] = -1;
        board[7][11] = -1;
        board[7][1] = 1;
        board[14][11] = 1;
        int[][] dist = new int[board.length][board[0].length];
        for (int[] i : dist) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        long startTime = System.currentTimeMillis();
        dfs(board, start, dist);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
        System.out.println("Operations: " + list.size());
        System.out.println("Distance: " + dist[end[0]][end[1]]);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)[0] + "," + list.get(i)[1] + "\t");
        }

        // for(int i=0; i<list.size();i++){
        //     System.out.print("[ " + list.get(i)[0] + "," + list.get(i)[1] + " ]" + "->");
        // }
    }

    public static void dfs(int[][] board, int[] start, int[][] dist) {
        list = new ArrayList();
        if (king) {
            int[][] moves = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 } };
            for (int[] move : moves) {
                int x = start[0] + move[0];
                int y = start[1] + move[1];
                int cnt = 0;
                while (onboard(board, x, y)) {
                    x += move[0];
                    y += move[1];
                    cnt++;
                    list.add(new int[] {x,y});
                }
                if (dist[start[0]][start[1]] + cnt < dist[x - move[0]][y - move[1]]) {
                    dist[x - move[0]][y - move[1]] = dist[start[0]][start[1]] + cnt;
                    dfs(board, new int[] { x - move[0], y - move[1] }, dist);
                }
            }
        } else {
            int[][] moves = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }};
            for (int[] move : moves) {
                int x = start[0] + move[0];
                int y = start[1] + move[1];
                int cnt = 0;
                while (onboard(board, x, y)) {
                    x += move[0];
                    y += move[1];
                    cnt++;
                    list.add(new int[] {x,y});
                }
                if (dist[start[0]][start[1]] + cnt < dist[x - move[0]][y - move[1]]) {
                    dist[x - move[0]][y - move[1]] = dist[start[0]][start[1]] + cnt;
                    dfs(board, new int[] { x - move[0], y - move[1] }, dist);
                }
            }
        }
    }

    public static boolean onboard(int[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] != -1)
            return true;

        return false;
    }
}