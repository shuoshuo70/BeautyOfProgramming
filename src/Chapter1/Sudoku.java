package Chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by shuoshu on 2018/1/2.
 */
public class Sudoku {
    public static void main(String[] args) {
        Sudoku solution = new Sudoku();
        solution.generateSudoku();
    }

    public void generateSudoku() {
        char[][] sudoku = new char[9][9];
        for (char[] ch : sudoku) {
            Arrays.fill(ch, '.');
        }
        sudoku[0][0] = (char) ('0' + new Random().nextInt(9));
        solve(sudoku);
        show(sudoku);
    }

    private boolean solve(char[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(sudoku, i, j, c)) {
                            sudoku[i][j] = c;
                            if (solve(sudoku)) {
                                return true;
                            }
                            sudoku[i][j] = '.';
                        }

                    }
                    return false;
                }
            }
        }
        
        return true;
    }

    private boolean isValid(char[][] sudoku, int x, int y, char c) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == c) {
                return false;
            }
            if (sudoku[x][i] == c) {
                return false;
            }
        }

        for (int i = x / 3 * 3; i <= x / 3 * 3 + 2; i++) {
            for (int j = y / 3 * 3; j <= y / 3 * 3 + 2; j++) {
                if (sudoku[i][j] == c) {
                    return false;
                }
            }
        }

        return true;
    }

    private void show(char[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
