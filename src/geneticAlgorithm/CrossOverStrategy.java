package geneticAlgorithm;

import geneticAlgorithm.letters.AbstractLetterFactory;
import geneticAlgorithm.letters.Letter;

/**
 * This class represents the crossover strategy where two population changes chromosomes between them to improve success rate.
 */
public class CrossOverStrategy implements StrategyInterface {
    /**
     * @param population accepts a population object to randomly exchange chromosomes between the population.
     * @return geneticAlgorithm.Population object where some members of the population that has changed chromosomes.
     */
    public Population random(Population population, AbstractLetterFactory langType) {
        Population crossOverPopulation = new Population(population.getChromosomes().length);

        for (int i = 0; i < Parameters.NUMB_OF_ELITE_CHROMOSOMES; i++) {
            crossOverPopulation.getChromosomes()[i] = population.getChromosomes()[i];
        }

        for (int i = Parameters.NUMB_OF_ELITE_CHROMOSOMES; i < population.getChromosomes().length; i++) {
            Chromosome<Letter> chromosome1 = new SelectionStrategy().random(population, langType).getChromosomes()[0];
            Chromosome<Letter> chromosome2 = new SelectionStrategy().random(population, langType).getChromosomes()[0];
            crossOverPopulation.getChromosomes()[i] = GeneticAlgorithm.getInstance().crossOverChromosome(chromosome1, chromosome2);
        }

        return crossOverPopulation;
    }

}
