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

    /** This will select the mapped value based on the POSITION being fed into it,
     *  not the letter.
     */
    public char encodeInput(char letter) {
        //TODO: Implement this
        return 'A';
    }

    //TODO: change this to set the rings for you!! it feels dumb to have to call a setter outside of this
    /** Rotates the inner using some fancy schmancy reversing strategy.
     *  @param k The numbers of times to rotate this. */
    public String rotateRing(int k, String ring) {
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