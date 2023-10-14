import java.util.Scanner;
// Nguyen Huu Duc - 20210192
public class AddTwoMatrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nguyen Huu Duc - 20210192");
        System.out.print("Enter the number of rows of the matrix: ");
        int rows = input.nextInt();
        System.out.print("Enter the number of columns of the matrix: ");
        int cols = input.nextInt();
        int[][] firstMatrix = new int[rows][cols];
        int[][] secondMatrix = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];
        // get the first matrix's elements
        System.out.println("Enter the first matrix (row by row): ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) firstMatrix[i][j] = input.nextInt();
        }
        // get the second matrix's elements and calculate sum matrix
        System.out.println("Enter the second matrix (row by row): ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
				secondMatrix[i][j] = input.nextInt();
				sumMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
			}
        }
        input.close();
        System.out.println("The sum matrix: ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
