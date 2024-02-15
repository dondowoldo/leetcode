package arrayshashing;

// https://leetcode.com/problems/valid-sudoku/

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
  public static void main(String[] args) {
    char[][] board =
        new char[][] {
          {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

    char[][] board2 = new char[][] {
            {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
            {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
            {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
            {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
    };
    System.out.println(isValidSudoku(board2));
  }

  private static boolean isValidSudoku(char[][] board) {
    for (int y = 0; y < board.length; y++) {
      Set<Character> row = new HashSet<>();
      for (int x = 0; x < board[y].length; x++) {
        if (!validateRow(board[y][x], row)) {
          return false;
        }
      }
    }
    if (!validateCols(board)) {
      return false;
    }

    return validateBoxes(board);
  }

  private static boolean validateBoxes(char[][] board) {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {

        Set<Character> box = new HashSet<>();
        for(int k = i * 3; k < (i * 3) + 3; k++) {
          for(int l = j * 3; l < (j * 3) + 3; l++) {
            char current = board[k][l];
            if (isDot(current)) {
              continue;
            }
            if (!box.add(current)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  private static boolean validateCols(char[][] board) {
    for (int x = 0; x < board.length; x++) {
      Set<Character> col = new HashSet<>();
      for (int y = 0; y < board.length; y++) {
        char current = board[y][x];
        if (isDot(current)) {
          continue;
        }
        if (!col.add(current)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean validateRow(char current, Set<Character> row) {
    if (isDot(current)) {
      return true;
    }
    return row.add(current);
  }

  private static boolean isDot(char c) {
    return c == '.';
  }
}
