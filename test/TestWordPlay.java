import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Alexander Kovalevsky on 19.11.2015.
 */
public class TestWordPlay {
    private WordPlay wp;

    @Test
    public void test_isVowel() {
        wp = new WordPlay();
        wp.isVowel('F');
        assertFalse("waiting for FALSE", wp.isVowel('F'));
        assertTrue("waiting for TRUE", wp.isVowel('a'));
    }

    @Test
    public void test_replaceVowels() {
        wp = new WordPlay();
        assertEquals("Waiting for H*ll* W*rld", "H*ll* W*rld", wp.replaceVowels("Hello World", '*'));
    }

    @Test
    public void test_emphasize() {
        wp = new WordPlay();
        assertEquals("Waiting for M+ry Bell+ +br*c*d*br+", "M+ry Bell+ +br*c*d*br+", wp.emphasize("Mary Bella Abracadabra", 'a'));
    }
}
