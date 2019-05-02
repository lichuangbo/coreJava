/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月2日
 */
package cn.edu.tit.leetcode;

/**
 *  旋转图像
 * @author 李创博
 * @version: 1.0
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
        /**
         * 1,	2,	3
         * 4,	5,	6
         * 7,	8,	9
         * 
         * 3,	2,	1
         * 6,	5,	4
         * 9,	8,	7
         * 
         * 7,	4,	1
         * 8,	5,	2
         * 9,	6,	3
         * 测试耗时：1ms
         */
		int length = matrix.length; 
		for (int i = 0; i < length; i++) {
			reverse(matrix[i]);
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[length- 1 - j][length - 1 - i];
				matrix[length- 1 - j][length -1 - i] = temp;
			}
		}
    }
	
	private void reverse(int []nums) {
		/**
		 * 1	2	3	4
		 * 4	3	2	1
		 */
		for (int i = 0; i < nums.length / 2; i++) {
			int temp = nums[nums.length - 1 - i];
			nums[nums.length - i - 1] = nums[i];
			nums[i] = temp;
		}
	}
	
	public void rotate1(int[][] matrix) {
		/**
		 * 一圈一圈转:
		 * 	[i][j]下一转[n-1-j][i]
		 */
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - 1 - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 -j][i];
                matrix[n - 1 -j][i] = matrix[n - 1 -i][n - 1 -j];
                matrix[n - 1 -i][n - 1 -j] = matrix[j][n - 1 -i];
                matrix[j][n - 1 -i] = temp;
            }
        }
    }
	
	public static void main(String[] args) {
		int [][]matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		RotateImage ri = new RotateImage();
		ri.rotate1(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
