package geneticAlgorithm;

import geneticAlgorithm.letters.*;

/**
 * Represent the geneticAlgorithm.GeneticAlgorithm class where it demonstrates the basic structure of a genetic algorithm with
 *  mutation, crossover and evolution.
 */
public final class  GeneticAlgorithm {
    //Eager initilization type Singleton pattern.
    private static final GeneticAlgorithm instance = new GeneticAlgorithm();
    private GeneticAlgorithm() {}

    /**
     * This function demonstrates the Singleton pattern applied to genetic algorithm.
     * With it's use in mutation and crossover singleton pattern applied for memory optimization purposes.
     * @return returns a geneticAlgorithm.Population type.
     */
    public static GeneticAlgorithm getInstance() {
        return instance;
    }

    /**
     * @param population a population to evolve and get the best generation.
     * @return population object that has mutated and some parts have been subject to crossover.
     */
    public Population evolve(Population population, AbstractLetterFactory langType){
        return new MutationStrategy().random(
                new CrossOverStrategy().random(population, langType), langType);
    }

    /**
     * @param chromosome one of the main characteristics of GA is to mutating a chromose,
     * where with a random chance of getting mutated, some parts will be changed in the chromosome with a random letter.
     * @return mutateChromosome object with the tyoe ıf geneticAlgorithm.Chromosome.
     */
    public Chromosome mutateChromosome( Chromosome chromosome, AbstractLetterFactory langType){
        Chromosome<Letter> mutateChoromosome = new Chromosome<Letter>(Parameters.TARGET_CHROMOSOME.length);
        for (int i = 0; i < chromosome.getWords().length; i++) {
            if (Math.random() < Parameters.MUTATION_RATE){
                mutateChoromosome.getWords()[i] = langType.getLetter(Chromosome.getRandom(Parameters.randomLetters)).getLetter();
            }
            else mutateChoromosome.getWords()[i] = chromosome.getWords()[i];
        }
        return mutateChoromosome;
    }


    /**
     * This method applies core principle of Genetic Algorithm where it switches parts of the given chromosomes and return a new, combined chromosome.
     * @param chromosome1  a chromosome to get some part of it and combine.
     * @param chromosome2  a chromosome to get some part of it and combine.
     * @return geneticAlgorithm.Chromosome type object.
     */
    public Chromosome<Letter> crossOverChromosome(Chromosome chromosome1, Chromosome chromosome2){
        Chromosome<Letter> crossOverChromosome = new Chromosome<Letter>(Parameters.TARGET_CHROMOSOME.length);
        for (int i = 0; i < chromosome1.getWords().length; i++) {
            if (Math.random() < 0.5){
                crossOverChromosome.getWords()[i] = chromosome1.getWords()[i];
            }else {
                crossOverChromosome.getWords()[i] = chromosome2.getWords()[i];
            }
        }
        return crossOverChromosome;
    }

}

