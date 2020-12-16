package geneticAlgorithm.letters;

/**
 * A factory class to create Letter objects in English alphabet
 */
public class RussianLetterFactory extends  AbstractLetterFactory{
    public Letter getLetter(char letter){
        if(letter == 'a'){
            return  new Letter('а');
        }
        else if (letter == 'b'){
            return new Letter('б');
        }
        else if (letter == 'c'){
            return new Letter('с');
        }
        else if (letter == 'd'){
            return new Letter('д');
        }
        else if (letter == 'm'){
            return new Letter('м');
        }
        else if (letter == 'y'){
            return new Letter('ы');
        }
        else if (letter == 'n'){
            return new Letter('н');
        }
        else if (letter == 'o'){
            return new Letter('о');
        }
        else if (letter == 't'){
            return new Letter('т');
        }
        else if (letter == 'h'){
            return new Letter('х');
        }
        else {
            return new Letter(' ');
        }
    }
}
