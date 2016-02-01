package enigma;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotorTest {

    @Test
    public void testReverse() {
        char[] reversedRotor = {'A', 'B', 'C', 'D'};
        Rotor.reverseRange(reversedRotor, 0, reversedRotor.length);
        assertEquals("DCBA", new String(reversedRotor));
    }

    @Test
    public void testRotateInnerRing() {
        Rotor rotor = new Rotor("ABCD", 0, 0);
        rotor.setInnerRing(rotor.rotateRing(2, rotor.getInnerRing()));
        assertEquals("YZABCDEFGHIJKLMNOPQRSTUVWX", rotor.getInnerRing());
    }

    /** Test based on using ROTOR_1_OUTER as an outer ring */
    @Test
    public void testEncodeOutput() {
        Rotor rotor = new Rotor(MappingConstants.ROTOR_1_OUTER, 0, 0);
        assertEquals(rotor.encodeOutput('A'), 'E');

        // After rotating the inner ring, it is expected that the output will change
        rotor.setInnerRing(rotor.rotateRing(5, rotor.getInnerRing()));
        assertEquals(rotor.encodeOutput('A'), 'G');
    }


}