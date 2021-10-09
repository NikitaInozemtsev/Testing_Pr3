import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("some text");

    }

    public static File[] getFilesFromDirectory() {
        File folder = new File("src/patterns");
        return folder.listFiles();
    }
}
