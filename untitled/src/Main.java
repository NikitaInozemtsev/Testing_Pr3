import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File[] listOfFiles = getFilesFromDirectory();

        Scanner scanner;
        boolean stop = false;
        while(!stop) {
            int randomPattern = (int) (Math.random() * listOfFiles.length);

            System.out.println(getPattern(listOfFiles, randomPattern));

            List<String> arr = new ArrayList<>();
            while (arr.size() != 3) {
                int random = (int) (Math.random() * listOfFiles.length);
                if (random != randomPattern && !arr.contains(listOfFiles[random].getName())) {
                    arr.add(listOfFiles[random].getName());
                }
            }

            arr.add(listOfFiles[randomPattern].getName());

            Collections.shuffle(arr);
            scanner = new Scanner(System.in);
            String answer;
            while(true) {
                System.out.println("Что за паттерн на экране? Выберите число!");
                for (int i = 0; i < arr.size(); i++) {
                    System.out.print((i + 1) + " - " + arr.get(i) + " ");
                }
                System.out.println();
                answer = scanner.nextLine();
                try {
                    int ans = Integer.parseInt(answer);
                    if (ans >= 1 && ans <= 4) {
                        if (arr.get(ans-1).equals(listOfFiles[randomPattern].getName())) {
                            System.out.println("Да, это правильный ответ!");
                            break;
                        }
                        else {
                            System.out.println("Неправильный ответ попробуйте еще раз!");
                        }
                    }
                    else {
                        System.out.println("Нет такого ответа попробуйте еще раз!");
                    }
                }catch (NumberFormatException exception) {
                    System.out.println("Неправильный ввод попробуйте еще раз!");
                }
            }

            System.out.println("Хотите продолжить? [Y/n]");
            do {
                answer = scanner.nextLine();
                answer = answer.toLowerCase(Locale.ROOT);
            } while(!answer.equals("y") && !answer.equals("n"));

            if (answer.equals("y")) {
                System.out.println("Чтож давайте продолжим!");
            }
            else {
                System.out.println("Спасибо за игру!");
                stop = true;
            }

        }
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
