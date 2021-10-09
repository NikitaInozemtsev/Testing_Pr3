import java.io.File;
import java.io.IOException;

import org.junit.Test;

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

}
