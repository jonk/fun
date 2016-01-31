package enigma;

class Mapper {
    
    private String outerRing;
    private String innerRing;

    public Mapper(String outerRing) {
        this.outerRing = outerRing;
        this.innerRing = MappingConstants.INNER_RING;
    }

    public char encodeOutput(char letter) {
        int outerIndex = innerRing.indexOf(letter);
        return outerRing.charAt(outerIndex);
    }

    public String getOuterRing() {
        return this.outerRing;
    }

    public String getInnerRing() {
        return this.innerRing;
    }

    public void setInnerRing(String innerRing) {
        this.innerRing = innerRing;
    }

    public void setOuterRing(String outerRing) {
        this.outerRing = outerRing;
    }

    @Override
    public String toString() {
        String sb = "";
        sb = sb.concat("Outer Ring: " + getOuterRing() + "\n");
        sb = sb.concat("Inner Ring: " + getInnerRing());
        return sb;
    }
}