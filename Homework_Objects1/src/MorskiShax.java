import java.util.Scanner;

public class MorskiShax {

	static boolean isFull(char[][] matrix) {
		boolean full = true;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == '\0') {
					full = false;
					break;
				}
			}
			if (full = false) {
				break;
			}
		}
		return full;
	}

	static boolean checkSecDiag(char[][] matrix) {
		boolean secDiagSame = false;
		int count = 0;
		for (int row = 0; row < matrix.length - 1; row++) {
			for (int col = matrix[row].length - 1; col > 0; col--) {
				if (matrix[row][col] == matrix[row + 1][col - 1] && matrix[row][col] != '\0') {
					count++;
				} else {
					count = 0;
				}
			}
			if (count == 2) {
				secDiagSame = true;
				return secDiagSame;
			}
		}
		return secDiagSame;
	}

	static boolean checkMainDiag(char[][] matrix) {
		boolean mainDiagSame = false;
		int count = 0;
		for (int row = 0; row < matrix.length - 1; row++) {
			for (int col = 0; col < matrix[row].length - 1; col++) {
				if (matrix[row][col] == matrix[row + 1][col + 1] && matrix[row][col] != '\0') {
					count++;
				} else {
					count = 0;
				}
			}
			if (count == 2) {
				mainDiagSame = true;
				return mainDiagSame;
			}
		}
		return mainDiagSame;
	}

	static boolean checkRow(char[][] matrix) {
		boolean rowSame = false;
		int count = 0;

		for (int col = 0; col < matrix.length; col++) {
			for (int row = 0; row < matrix.length - 1; row++) {
				if (matrix[row][col] == matrix[row + 1][col] && matrix[row][col] != '\0') {
					count++;
				} else {
					count = 0;
				}
			}
			if (count == 2) {
				rowSame = true;
				return rowSame;
			}
		}
		return rowSame;
	}

	static boolean checkCol(char[][] matrix) {
		boolean colSame = false;
		int count = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length - 1; col++) {
				if (matrix[row][col] == matrix[row][col + 1] && matrix[row][col] != '\0') {
					count++;
				} else {
					count = 0;
				}
			}
			if (count == 2) {
				colSame = true;
				return colSame;
			}
		}
		return colSame;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[][] matrix = new char[3][3];
		int row = 0;
		int col = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		while (isFull(matrix) == false) {
			System.out.println("Player 1,(X) enter coordinates: ");
			row = scan.nextInt();
			col = scan.nextInt();
			while (matrix[row][col] == 'X' || matrix[row][col] == 'O') {
				System.out.println("Player 1,(X) enter coordinates: ");
				row = scan.nextInt();
				col = scan.nextInt();
			}
			matrix[row][col] = 'X';
			if (checkCol(matrix) == true || checkRow(matrix) == true || checkMainDiag(matrix) == true || checkSecDiag(matrix) == true) {
				System.out.println("player 1 wins");
				return;
			}
			System.out.println("Player 2,(O) enter coordinates: ");
			row = scan.nextInt();
			col = scan.nextInt();
			while (matrix[row][col] == 'X' || matrix[row][col] == 'O') {
				System.out.println("Player 2,(X) enter coordinates: ");
				row = scan.nextInt();
				col = scan.nextInt();
			}
			matrix[row][col] = 'O';
			if (checkCol(matrix) == true || checkRow(matrix) == true || checkMainDiag(matrix) == true || checkSecDiag(matrix) == true) {
				System.out.println("player 2 wins");
				return;
			}
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		System.out.println("It's a tie");

	}

}
