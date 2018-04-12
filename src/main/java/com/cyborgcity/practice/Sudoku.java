package com.cyborgcity.practice;

/**
 * Created by Ravi on 14-09-2017.
 */
public class Sudoku {

    static boolean solveSudoku(int grid[][], int row, int col){
//        if(!findUnassignedLocation(grid, grid.length, grid[0].length))
//            return solveSudoku(grid, row + 1, col);
        if (row == 9) {
            row = 0;
            if (++col == 9)
                return true;
        }
        if(grid[row][col] != 0){
            return solveSudoku(grid, row + 1, col);
        }
        for (int num = 1; num <= 9; num++){
            if(isSafe(grid, row, col, num)){
                grid[row][col] = num;
                if (solveSudoku(grid, row + 1, col))
                    return true;
                grid[row][col] = 0;
            }
        }

        return false;
    }

    static boolean findUnassignedLocation(int grid[][], int row, int col){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

    static boolean usedInRow(int grid[][], int row, int num){
        for (int i = 0; i < grid[0].length; i++){
            if(grid[row][i] == num)
                return true;
        }
        return false;
    }

    static boolean usedInCol(int grid[][], int col, int num){
        for (int i = 0; i < grid.length; i++){
            if(grid[i][col] == num)
                return true;
        }
        return false;
    }

    static boolean usedInBox(int grid[][], int boxStartRow, int boxStartCol, int num){
        for(int row = 0; row < 3; row ++){
            for(int col = 0; col < 3; col++){
                if(grid[row + boxStartRow][col + boxStartCol] == num){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int grid[][], int row, int col, int num){
        if(!usedInRow(grid, row, num) && !usedInCol(grid, col, num) && !usedInBox(grid, row - row%3, col - col%3, num))
            return true;
        return false;
    }

    static void printGrid(int grid[][]){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        if(solveSudoku(grid, 0 , 0)){
            printGrid(grid);
        }else {
            System.out.println("No solution found.");
        }
    }

}
