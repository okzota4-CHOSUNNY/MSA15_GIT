package day03;

import java.util.Scanner;

public class Ex06_Arrays {

	public static void main(String[] args) {
		// 2행 3열
		// 정방 행렬
		// [][][]
		// [][][]

		// 비정방 행렬
		// [][]
		// [][][]
		// [][][]

		int arr[][] = new int[3][];
		// [] ->
		// [] ->
		// [] ->

		arr[0] = new int[2];
		arr[1] = new int[4];
		arr[2] = new int[3];
		// [] -> [][]
		// [] -> [][][][]
		// [] -> [][][]

		// 입력
		// arr 2차원 배열에 정수를 입력받아보세요.
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println(arr[i][j] + " ");
			}
			System.out.println();
		}

		// foreach 출력
		for (int[] a : arr) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		int three[][][] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } }, { { 9, 10 }, { 11, 12 } } };

		for (int[][] two : three) {
			for (int[] one : two) {
				for (int num : one) {
					System.out.print(num + " ");
				}

				System.out.println();
			}
			System.out.println();
		}
		sc.close();
	}

}