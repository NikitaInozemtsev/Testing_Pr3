import java.io.File;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestMain {
    @Test
    public void getFilesFromDirectory() {
        assertEquals(21, Main.getFilesFromDirectory().length);
        assertEquals(new File("src/patterns/Adapter"), Main.getFilesFromDirectory()[0]);
    }

}
