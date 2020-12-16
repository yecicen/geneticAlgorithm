package geneticAlgorithm;

import geneticAlgorithm.letters.AbstractLetterFactory;
import geneticAlgorithm.letters.Letter;

import java.util.Arrays;

/**
 * A class represents a geneticAlgorithm.Population, where a population consists of a collection of chromosomes.
 */
public class Population {
    private Chromosome<Letter>[] chromosomes;

    public Population(int length){
        chromosomes = new Chromosome[length];
    }

    /**
     * @return geneticAlgorithm.Population object, where it consists of random chromosome objects.
     */
    public Population initializePopulation(AbstractLetterFactory langType){
        for (int i = 0; i < chromosomes.length; i++){
            chromosomes[i] = new Chromosome(Parameters.TARGET_CHROMOSOME.length)
                    .initializeChromosome(langType);
        }
        sortChromosomesByFitness();
        return this;
    }

    /**
     * sorts the chromosomes of the population over their best match scores
     */
    public void sortChromosomesByFitness(){
        Arrays.sort(chromosomes, (chromosome1, chromosome2) -> {
            int flag = 0;
            if (chromosome1.getFitness() > chromosome2.getFitness()){
                flag = -1;
            }
            else if (chromosome1.getFitness() < chromosome2.getFitness()){
                flag = 1;
            }
            return flag;
        });
    }

    /**
     * @return geneticAlgorithm.Chromosome array.
     */
    public Chromosome[] getChromosomes() {
        return chromosomes;
    }
}
