package geneticAlgorithm;

import geneticAlgorithm.letters.AbstractLetterFactory;

/**
 * This class represents the idea of Mutation on Genetic Algorithm, where some of the chromosomes randomly changes.
 * Elite chromosomes will not be subjected to the mutation.
 */
public class MutationStrategy implements StrategyInterface {
    /**
     * @param population accepts a geneticAlgorithm.Population object to mutate with newly generated population.
     * @return geneticAlgorithm.Population object where holds the mutated chromosomes.
     */
    public Population random(Population population, AbstractLetterFactory langType) {
        Population mutatePopulation = new Population(population.getChromosomes().length);

        for (int i = 0; i < Parameters.NUMB_OF_ELITE_CHROMOSOMES; i++) {
            mutatePopulation.getChromosomes()[i] = population.getChromosomes()[i];
        }

        for (int i = Parameters.NUMB_OF_ELITE_CHROMOSOMES; i < population.getChromosomes().length; i++) {
            mutatePopulation.getChromosomes()[i] = GeneticAlgorithm.getInstance().mutateChromosome(population.getChromosomes()[i], langType);
        }

        return mutatePopulation;
    }

}
