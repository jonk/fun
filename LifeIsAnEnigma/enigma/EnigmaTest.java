package enigma;

import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.assertEquals;

public class EnigmaTest {

    @Test
    public void testReverse() {
        char[] reversedRotor = {'A', 'B', 'C', 'D'};
        Rotor.reverseRange(reversedRotor, 0, reversedRotor.length);
        assertEquals("DCBA", new String(reversedRotor));
    }

    @Test
    public void testRotateInnerRing() {
        Rotor rotor = new Rotor("ABCD", 0, 0);
        rotor.rotateInnerRing(2);
        assertEquals("YZABCDEFGHIJKLMNOPQRSTUVWX", rotor.getInnerRing());
    }

    @Test
    public void regexTest() {
        String inp = "*";
        assertEquals(inp.matches("[" + Pattern.quote("+-*/^") + "]??"), true);
    }


}