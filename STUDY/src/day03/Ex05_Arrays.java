package day03;


public class Ex05_Arrays {

	public static void main(String[] args) {
		// 2차원 배열 선언
		// - 1차원 : 2 (2행)
		// - 2차원 : 3 (3열)
		// [][][]
		// [][][]
		int arr[][] = new int[2][3];
		
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		// [1][2][3]
		// [4][5][6]
		
		// 2차원 배열을 반복하기 위해서, 이중 반복문을 사용한다.
		
		// arr.length		: 첫번째 차원의 배열요소의 개수 : 2
		// arr[i].length	: 두번째 차원의 배열요소의 개수 : 3
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println( arr[i][j]);
			}
			System.out.println();
		}
		// i  j    arr[i][j]
		// 0  0	 	 1
		//    1      2
		//    2      3
		//    3
		// 1  0      4
		//    1      5
		//    2      6
		//    3
	}
	
}
