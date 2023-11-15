// Nguyen Huu Duc - 20210192
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "sample.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        StringBuffer outputStringBuilder = new StringBuffer();
        for (byte b : inputBytes) {
            outputStringBuilder.append(Character.toString((char) b));
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
