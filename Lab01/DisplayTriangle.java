import java.util.Scanner;
// Nguyen Huu Duc - 20210192
public class DisplayTriangle{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("DucNH210192: Enter height of triangle ... ");
        int height = input.nextInt();
        System.out.println();
        input.close();
        int w = 1;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height-i; j++) System.out.print(" ");
            for (int k = 1; k <= w; k++) System.out.print("*");
            w+=2;
            System.out.println();
        }
        System.exit(0);
    }
}
