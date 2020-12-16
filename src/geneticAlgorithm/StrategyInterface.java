package geneticAlgorithm;

import geneticAlgorithm.letters.AbstractLetterFactory;

/**
 * An interface for making strategy methods controlled from one place.
 * Currently we only support randomized selection, mutation or crossover but we are hoping to add balanced approaches.
 */
public interface StrategyInterface {
    public Population random(Population population, AbstractLetterFactory langType);
}

