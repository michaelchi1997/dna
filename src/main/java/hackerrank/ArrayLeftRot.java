package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Basically, this solution uses a pattern discovered.
The first element if the rotated array is always a[d], therefore we can set the first element there, and then worry about the next.
The rotated array is then followed by whatever is from a[d + 1] to the end
Then it is followed by whatever is from a[0] to a[d - 1]
So we basically construct the rotated array by looping through 2 parts of the original array
 */

public class ArrayLeftRot {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int [] rotatedArray = new int[a.length];
        rotatedArray[0] = a[d];
        int index = 1;
        for (int i = d + 1; i < a.length; i++) {
            rotatedArray[index] = a[i];
            index++;
        }

        for (int i = 0; i < d; i++) {
            rotatedArray[index] = a[i];
            index++;
        }

        return rotatedArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
