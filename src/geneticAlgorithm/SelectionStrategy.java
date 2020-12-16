package geneticAlgorithm;

import geneticAlgorithm.letters.AbstractLetterFactory;

/**
     * This class is to select the possible candidates for our genetic algorithm. each of the population member will be sorted based on their fitness scores.
     */
    public class SelectionStrategy implements StrategyInterface {
        /**
         * @param population takes a geneticAlgorithm.Population object and randomly selects some of the given population to newly generated population.
         * @return geneticAlgorithm.Population object where holds sorted chromosomes
         */
        public Population random(Population population, AbstractLetterFactory langType) {
            Population tournamentPopulation = new Population(Parameters.TOURNMENT_SELECTION_SIZE);

            for (int i = 0; i < Parameters.TOURNMENT_SELECTION_SIZE; i++) {
                tournamentPopulation.getChromosomes()[i] = population
                        .getChromosomes()[(int) (Math.random() * population.getChromosomes().length)];
            }

            tournamentPopulation.sortChromosomesByFitness();

            return tournamentPopulation;
        }
    }
