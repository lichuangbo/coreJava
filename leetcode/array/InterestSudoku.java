/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月2日
 */
package cn.edu.tit.leetcode;


/**
 * 有效的数独
 * @author 李创博
 * @version: 1.0
 */
public class InterestSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean [][]rows = new boolean[9][10];
		boolean [][]cols = new boolean[9][10];
		boolean [][]boxes = new boolean[9][10];
		
		for (int i = 0; i < 9; i++) {//这是行
			for (int j = 0; j < 9; j++) {//这是列
				if (board[i][j] != '.') {
					int temp = board[i][j] - '0';
					int k = i / 3 * 3 + j / 3;
					if (rows[i][temp] == true) {
						return false;
					}else {
						rows[i][temp] = true;
					}
					if (cols[j][temp] == true) {
						return false;
					}else {
						cols[j][temp] = true;
					}
					if (boxes[k][temp] == true) {
						return false;
					}else {
						boxes[k][temp] = true;
					}
				}
			}
		}
        return true;
    }
	
	public boolean isValidSudoku1(char[][] board) {
		/**
		 * 标记法：
		 * 	一维下表表示行、列、块号0-8，二维下标表示数字1-9，二维数组值表示出现次数
		 * 	（i/3*3+j/3表示块号 ？）
		 * 测试用时：6ms
		 */
		int [][]rows = new int[9][10];
		int [][]cols = new int[9][10];
		int [][]boxes = new int[9][10];
		for (int i = 0; i < board.length; i++) {//行
			for (int j = 0; j < board[i].length; j++) {//列
				if (board[i][j] != '.') {
					//将char类型转化为int类型
					int temp = board[i][j] - '0';
					int k = i / 3 * 3 + j / 3;
					if (rows[i][temp] == 1 || cols[j][temp] == 1 || boxes[k][temp] == 1) {
						return false;
					}
					rows[i][temp] = cols[j][temp] = boxes[k][temp] = 1;
				}
			}
		}	
		return true;
	}
	public static void main(String[] args) {
		char [][]board = {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}	
		};
		InterestSudoku is = new InterestSudoku();
		System.out.println(is.isValidSudoku(board));
	}
}
