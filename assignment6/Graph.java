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
        int[] start = new int[]{7,1};
        int[] end = new int[]{14,11};
        
        board[14][11] = 1; //destination
        //blocked pathway
        board[3][5] = -1;
        board[6][4] = -1;
        board[8][12] = -1;
        board[15][2] = -1;
        board[7][9] = -1;
        board[14][3] = -1;
    }

    public void dfs(int[][] board, int[] start, int[] end, boolean[][] vis){

    }
}