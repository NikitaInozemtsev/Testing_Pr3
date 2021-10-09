import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TestMain {
    @Test
    public void getFilesFromDirectory() {
        assertEquals(21, Main.getFilesFromDirectory().length);
        assertEquals(new File("src/patterns/Adapter"), Main.getFilesFromDirectory()[0]);
    }

    @Test
    public void getPatternTest() throws IOException {
        File[] files = {new File("src/patterns/Adapter")};
        assertEquals(485, Main.getPattern(files, 0).length());
        assertEquals("class PBank {\n", Main.getPattern(files, 0).substring(0, 14));

    }

    @Test
    public void takeUserInput() throws IOException {
        String[] args = {};
        InputStream in = new ByteArrayInputStream("sdfgjkhgew\n1\n2\n3\n4\nn".getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));



        try {
            Main.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(outContent.toString(), containsString("Неправильный ввод попробуйте еще раз!"));
        assertThat(outContent.toString(), containsString("Да, это правильный ответ!"));
        assertThat(outContent.toString(), containsString("Спасибо за игру!"));
    }

}
