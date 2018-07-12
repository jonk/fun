package enigma;

/**
 * The main class managing rotors, encoding, and decoding messages.
 */
public class EnigmaMachine {

    private Mapper reflector;
    private Rotor r1;
    private Rotor r2;
    private Rotor r3;
    private Mapper plugBoard;

    public EnigmaMachine(Mapper reflector, Rotor r1, Rotor r2, Rotor r3, Mapper plugBoard) {
        this.reflector = reflector;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.plugBoard = plugBoard;
    }

    public char encode(char letter) {
        return null;
    }

    private char forward(char letter) {
        return null;
    }

    private char reverse(char letter) {
        return null;
    }

    private char reflect(char letter) {
        return null;
    }
}
