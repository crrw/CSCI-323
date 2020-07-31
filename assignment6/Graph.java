import java.util.*;
import java.io.*;

public class Graph {
    static boolean king = true;

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
        System.out.println(bfs(board, start, end));

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static int bfs(int[][] board, int[] start, int[] end) {
        if (king) {
            int[][] dist = new int[board.length][board[0].length];

            for (int[] arr : dist) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            dist[start[0]][start[1]] = 0;
            int[][] moves = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 } };

            Queue<int[]> queue = new LinkedList();
            queue.add(start);

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                for (int[] move : moves) {
                    int x = curr[0] + move[0];
                    int y = curr[1] + move[1];
                    int cnt = 0;

                    while (onboard(board, x, y)) {
                        x += move[0];
                        y += move[1];
                        cnt++;
                    }

                    if (dist[curr[0]][curr[1]] + cnt < dist[x - move[0]][y - move[1]]) {
                        dist[x - move[0]][y - move[1]] = dist[curr[0]][curr[1]] + cnt;
                        queue.add(new int[] { x - move[0], y - move[1] });
                    }
                }
            }
            if (dist[end[0]][end[1]] == Integer.MAX_VALUE) {
                return -1;
            }
            return dist[end[0]][end[1]];

        } else {
            int[][] dist = new int[board.length][board[0].length];

            for (int[] arr : dist) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            dist[start[0]][start[1]] = 0;
            int[][] moves = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

            Queue<int[]> queue = new LinkedList();
            queue.add(start);

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                for (int[] move : moves) {
                    int x = curr[0] + move[0];
                    int y = curr[1] + move[1];
                    int cnt = 0;

                    while (onboard(board, x, y)) {
                        x += move[0];
                        y += move[1];
                        cnt++;
                    }

                    if (dist[curr[0]][curr[1]] + cnt < dist[x - move[0]][y - move[1]]) {
                        dist[x - move[0]][y - move[1]] = dist[curr[0]][curr[1]] + cnt;
                        queue.add(new int[] { x - move[0], y - move[1] });
                    }
                }
            }
            if (dist[end[0]][end[1]] == Integer.MAX_VALUE) {
                return -1;
            }
            return dist[end[0]][end[1]];
        }
    }

    public static boolean onboard(int[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] != -1)
            return true;

        return false;
    }
}