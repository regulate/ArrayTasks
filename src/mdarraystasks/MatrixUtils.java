package mdarraystasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatrixUtils {

	//work only with first zero found
	public static int[][] makeIntersectionIfZeroFound(int[][] array){
		int[][] result = new int[array.length][];
		//copy array
		for(int i = 0; i < array.length; i++){
		    result[i] = array[i].clone();
		}
		
		int zeroRowIdx = 0;
		boolean found = false;
		// down [iterate over array of arrays]
		for (int i = 0; i < result.length; i++) {
			// right [iterate over nested arrays]
			for (int j = 0; j < result[i].length; j++) {
				if(result[i][j]==0){
					zeroRowIdx = i;
					found = true;
					for (int k = 0; k < result.length; k++) {
						result[k][j] = 0;
					}
				}
			}
			if(found==true)
				break;
		}
		//fill row with zeroes
		result[zeroRowIdx] = new int[result[zeroRowIdx].length];
		return result;
	}
	
	public static int[][] makeIntersectionsIfZeroesFound(int[][] array){
		int[][] result = new int[array.length][];
		//copy array
		for(int i = 0; i < array.length; i++){
		    result[i] = array[i].clone();
		}
		
		// for saving points of zeroes
		Map<Integer, Integer> zeroPoints = new HashMap<>();
		
		// down [iterate over array of arrays]
		for (int i = 0; i < result.length; i++) {
			// right [iterate over nested arrays]
			for (int j = 0; j < result[i].length; j++) {
				if(result[i][j]==0){
					zeroPoints.put(i, j);
				}
			}
		}
		
		//for all found zero columns
		for(Integer column :zeroPoints.values()){
			//iterate over all arrays and replace values in zero column with zero
			for(int i =0;i<result.length;i++){
				result[i][column] = 0;
			}
		}
		
		//for all found zero rows
		for(Integer row :zeroPoints.keySet()){
			//fill with zeroes
			result[row] = new int[result[row].length];
		}
		return result;
	}
	
	public static void printMatrix(int[][] matrix){
		for(int[] row : matrix){
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[][] input = new int[9][];
		input[0] = new int[]{1,1,1,1,1,1,1,1,1};
		input[1] = new int[]{1,1,1,1,0,1,1,1,1};
		input[2] = new int[]{1,1,1,1,1,1,1,1,1};
		input[3] = new int[]{1,1,0,1,1,1,1,1,1};
		input[4] = new int[]{1,1,1,1,1,1,1,1,1};
		input[5] = new int[]{1,1,1,1,1,1,1,1,1};
		input[6] = new int[]{1,1,1,1,1,1,1,1,1};
		input[7] = new int[]{1,1,1,1,1,1,1,1,1};
		input[8] = new int[]{1,1,1,1,1,1,1,0,1};
		
		int [][] singleIntersection = makeIntersectionIfZeroFound(input);
		int [][] multInstersections = makeIntersectionsIfZeroesFound(input);
		
		System.out.println("Original matrix:");
		printMatrix(input);
		System.out.println("Single intersection matrix:");
		printMatrix(singleIntersection);
		System.out.println("Multiply intersection matrix:");
		printMatrix(multInstersections);
		
	}
	
}
