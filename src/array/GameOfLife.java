/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:
Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

package array;

public class GameOfLife
{
    public void gameOfLife(int[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                int count = check_neighbor(board, i, j);

                if(board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = -1;
                if(board[i][j] == 0 && (count == 2 || count == 3))
                    board[i][j] = 2;
            }
        }

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == -1)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }

    private int check_neighbor(int[][] board, int i, int j)
    {
        int count = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};

        for(int[] dir:dirs)
        {
            int nRow = i + dir[0];
            int nCol = j + dir[1];

            if(nRow < 0 || nRow >= board.length)
                continue;
            if(nCol < 0 || nCol >= board[0].length)
                continue;
            if(board[nRow][nCol] == 1 || board[nRow][nCol] == -1)
                count++;
        }
        return count;
    }
}
