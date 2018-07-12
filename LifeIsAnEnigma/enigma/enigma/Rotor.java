package enigma;

class Rotor extends Mapper {

    private int rotorPos;
    private int ringPos;

    public Rotor(String outerRing, int rotorPos, int ringPos) {
        super(outerRing);
        this.rotorPos = rotorPos;
        this.ringPos = ringPos;
    }

    /** This is the internal mapping from input ring to output ring. */
    public char encodeOutput(char letter) {
        int outIndex = getInnerRing().indexOf(letter);
        return getOuterRing().charAt(outIndex);
    }

    public char encodeReverseOutput(char letter) {
        int outIndex = getOuterRing().indexOf(letter);
        return getInnerRing().charAt(outIndex);
    }

    /** This will select the mapped value based on the POSITION being fed into it,
     *  not the letter.
     */
    public char encodeInput(int pos) {
        return getInnerRing().charAt(pos);
    }

    public char encodeReverseInput(int pos) {
        return getOuterRing().charAt(pos);
    }

    /** Helper method to decide if we should rotate inner or outer ring.
     *
     * @param k number of times to rotate a ring.
     * @param isOuter checks whether we are rotating the outer or inner ring.
     */
    public void rotateRing(int k, boolean isOuter) {
        if (isOuter) {
            setOuterRing(rotateRing(k, getOuterRing()));
        } else {
            setInnerRing(rotateRing(k, getInnerRing()));
        }
    }

    /** Rotates a string using some fancy schmancy reversing strategy.
     *  @param k The numbers of times to rotate this. */
    private String rotateRing(int k, String ring) {
        k = k % 26;
        char[] ringArr = ring.toCharArray();
        reverseRange(ringArr, 0, ringArr.length);
        reverseRange(ringArr, 0, k);
        reverseRange(ringArr, k, ringArr.length);
        return new String(ringArr);
    }

    public void rotateRotor(int k) {
        setInnerRing(rotateRing(k, getInnerRing()));
        setOuterRing(rotateRing(k, getOuterRing()));
    }

    public static void reverseRange(char[] arr, int start, int end) {
        end--;
        while (start < end) {
            char tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;
            start++;
            end--;
        }
    }

    @Override
    public String toString() {
        return "Rotor{" +
                "rotorPos=" + rotorPos +
                ", ringPos=" + ringPos +
                "} " + super.toString();
    }
}