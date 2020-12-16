package geneticAlgorithm;

import geneticAlgorithm.letters.*;

import java.util.Arrays;
import java.util.Random;

/**
 * This class represents a geneticAlgorithm.Chromosome object where it holds the value of the words, the fitness score, and a flag for recalculation purposes.
 * @param <Letter> this class can only take a Letter type objects.
 */
public class Chromosome<Letter> {
    private char[] words;
    private int fitness;
    private boolean isFitnessChanged = true;

    public Chromosome(int length){
        words = new char[length];
    }

    /**
     * @return geneticAlgorithm.Chromosome object that holds randomized different geneticAlgorithm.letters.
     */
    public Chromosome<Letter> initializeChromosome(AbstractLetterFactory langType){
        for (int i = 0; i<words.length; i++){
            words[i] = langType.getLetter(getRandom(Parameters.randomLetters)).getLetter();
        }
        return this;
    }

    public static char getRandom(char[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    /**
     * @return fitness score value based on the matches.
     */
    public int recalculateFitness(){
        int chromosomeFitness = 0;
        for (int i = 0; i < words.length; i++) {
//            if (words[i] == Parameters.TARGET_RUSSIAN[i]){
            if (words[i] == Parameters.TARGET_CHROMOSOME[i]){
                chromosomeFitness++;
            }
        }
        return  chromosomeFitness;
    }

    @Override
    public String toString() {
        return Arrays.toString(words);

    }

    public char[] getWords() {
        isFitnessChanged = true;
        return words;
    }

    /**
     * @return int type fitness score value where if the chromosome has mutated or changed, it gets the updated value.
     */
    public int getFitness() {
        if (isFitnessChanged){
            fitness = recalculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }
}
