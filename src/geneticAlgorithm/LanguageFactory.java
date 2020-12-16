package geneticAlgorithm;

import geneticAlgorithm.letters.*;

public class LanguageFactory {
    /*
        Factory method pattern to decide which object creation to be done of ENG or RUSSian.
    */
    public AbstractLetterFactory decideLanguage(String lang){
        if(lang=="ENG"){
            Parameters.TARGET_CHROMOSOME = new char[]{'m', 'a', 'y', 'n', 'o', 'o', 't', 'h'};
            return new EnglishLetterFactory();

        }
        else if(lang=="RUS"){
            Parameters.TARGET_CHROMOSOME = new char[]{'м','а', 'ы', 'н', 'о', 'о', 'т', 'х'};
            return new RussianLetterFactory();
        }

        return new EnglishLetterFactory();

    }
}
