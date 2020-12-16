package geneticAlgorithm.letters;

/**
 * Represents a Letter class where a Letter has a char value.
 */
public class Letter {
    private char letter;

    public Letter(char letter){
        this.letter = letter;
    }

    /**
     * @return letter char type
     */
    public char getLetter() {
        return letter;
    }

    /**
     * @param letter sets the given char value to class member.
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }
}
