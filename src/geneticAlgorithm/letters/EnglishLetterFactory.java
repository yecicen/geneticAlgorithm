package geneticAlgorithm.letters;

/**
 * A factory class to create Letter objects in English alphabet
 */
public class EnglishLetterFactory extends  AbstractLetterFactory{
    public Letter getLetter(char letter){
        if(letter == 'a'){
            return  new Letter('a');
        }
        else if (letter == 'b'){
            return new Letter('b');
        }
        else if (letter == 'c'){
            return new Letter('c');
        }
        else if (letter == 'd'){
            return new Letter('d');
        }
        else if (letter == 'm'){
            return new Letter('m');
        }
        else if (letter == 'y'){
            return new Letter('y');
        }
        else if (letter == 'n'){
            return new Letter('n');
        }
        else if (letter == 'o'){
            return new Letter('o');
        }
        else if (letter == 't'){
            return new Letter('t');
        }
        else if (letter == 'h'){
            return new Letter('h');
        }
        else {
            return new Letter(' ');
        }
    }
}
