import java.util.Arrays;
import java.util.Scanner;
// Nguyen Huu Duc - 20210192
public class SortArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nguyen Huu Duc - 20210192");
        System.out.print("Enter array size: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        double sum = 0;
        for (int i = 0; i < size; i++){ // get each int number
			arr[i] = input.nextInt();
			sum += arr[i]; // calculate sum
		}
		double avg = sum / size; // calculate average
        input.close();
        System.out.print("The original array is: "); // before sort
        System.out.print(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.print("\nThe sorted array is: ");
        System.out.print(Arrays.toString(arr));  // sorted array
        System.out.println("\nSum of the array elements is: " + sum);
        System.out.printf("Average value of the array elements is: %2f\n", avg);
        System.exit(0);
    }
}
