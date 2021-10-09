import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("some text");

    }

    public static File[] getFilesFromDirectory() {
        File folder = new File("src/patterns");
        return folder.listFiles();
    }

    public static String getPattern(File[] files, int index) throws IOException {
        FileReader reader = new FileReader(files[index]);

        Scanner scanner = new Scanner(reader);
        StringBuilder result = new StringBuilder();
        while (scanner.hasNextLine()) {
            result.append(scanner.nextLine() + "\n");
        }
        reader.close();
        return result.toString();
    }
}
