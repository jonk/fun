package enigma;

class MappingConstants {
    
    /* Each of the below rotors and mappings are relative to the standard alphabet */
    public static final String INNER_RING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* Our rotors to use! Typically select three. */
    public static final String ROTOR_1_OUTER = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    public static final String ROTOR_2_OUTER = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
    public static final String ROTOR_3_OUTER = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
    public static final String ROTOR_4_OUTER = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
    public static final String ROTOR_5_OUTER = "VZBRGITYUPSDNHLXAWMJQOFECK";

    /** Reflectors and plugboards. These essentially do the same thing,
     *  but are considered different because they perform different
     *  operations on a phyiscal machine. */ 
    public static final String REFLECTOR_A = "EJMZALYXVBWFCRQUONTSPIKHGD";
    public static final String REFLECTOR_B = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
    public static final String PLUGBOARD_A = "ATLCORFVNDPYJZGUHMKIXESWBQ";
    public static final String PLUGBOARD_B = "YRCGNZKTHWLAXVEIPOUBDFSJMQ";

    /** Letters on rotors that tell the next rotor to take a step */ 
    public static final char ROTOR_1_STEP = 'Q';
    public static final char ROTOR_2_STEP = 'E';
    public static final char ROTOR_3_STEP = 'V';
    public static final char ROTOR_4_STEP = 'J';
    public static final char ROTOR_5_STEP = 'Z';
}