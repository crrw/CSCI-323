import java.util.*; 
import java.io.*;

public class Graph{
    static int[][] board;
    boolean mode;
    static int moves = 0;
    public static void main(String[] args){
        int N, M; 
        N = 15;
        M = 12;
        board = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j] = 0;
            }
        }
        board[7][1] = 1;
        
    }

    public void dfs(int[][] board, int[] start, int[] end, boolean[][] vis){

    }
}