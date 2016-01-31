package enigma;

class Rotor extends Mapper {

    private int rotorPos;
    private int ringPos;

    public Rotor(String outerRing, int rotorPos, int ringPos) {
        super(outerRing);
        this.rotorPos = rotorPos;
        this.ringPos = ringPos;
    }

    /** This will select the mapped value based on the POSITION being fed into it,
     *  not the letter.
     */
    public char encodeInput(char letter) {
        //TODO FINISH THIS
        return 't';
    }

    /** Rotates the inner using some fancy schmancy reversing strategy.
     *  @param k The numbers of times to rotate this. */
    public void rotateInnerRing(int k) {
        char[] ringArr = getInnerRing().toCharArray();
        reverseRange(ringArr, 0, ringArr.length);
        reverseRange(ringArr, 0, k);
        reverseRange(ringArr, k, ringArr.length);
        setInnerRing(new String(ringArr));
    }


    public static void reverseRange(char[] arr, int start, int end) {
        end = end - 1;
        while (start < end) {
            char tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;
            start++;
            end--;
        }
    }
}