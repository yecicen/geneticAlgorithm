package geneticAlgorithm.letters;

/**
 * An abstract factory pattern applied to generating words in different alphabets.
 * Currently only implemented on English Alphabet but more can be added, such as Russian or Arabic.
 */
public abstract class AbstractLetterFactory {
    Letter letter;

    public abstract Letter getLetter(char letter);
}
