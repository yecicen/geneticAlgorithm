import geneticAlgorithm.GeneticAlgorithm;
import geneticAlgorithm.LanguageFactory;
import geneticAlgorithm.Parameters;
import geneticAlgorithm.Population;
import geneticAlgorithm.letters.AbstractLetterFactory;

import java.util.Arrays;

/**
 * This class in the runner of the application.
 */
public class Main {

    /**
     * @param args
     * this function is to run the application
     */
    public static void main(String[] args) {

        LanguageFactory language= new LanguageFactory();

        AbstractLetterFactory langType= language.decideLanguage("ENG");
//        AbstractLetterFactory langType= language.decideLanguage("RUS");

        Population population = new Population(Parameters.POPULATION_SIZE).initializePopulation(langType);



        GeneticAlgorithm geneticAlgorithm = GeneticAlgorithm.getInstance();

        System.out.println("-----------------------------------------");
        System.out.println("Generation # 0 " + " | Fittest chromosome fitness: " +
                population.getChromosomes()[0].getFitness());
        printPopulation(population,
                "Target Chromosome: "+ Arrays.toString(Parameters.TARGET_CHROMOSOME));

        int generationNumber  = 0;
        while (population.getChromosomes()[0].getFitness() < Parameters.TARGET_CHROMOSOME.length){
            generationNumber++;
            System.out.println("\n------------------------------------------");
            population = geneticAlgorithm.evolve(population, langType);
            population.sortChromosomesByFitness();

            System.out.println("Generation # "+generationNumber + " | Fittest chromosome fitness: " +
                    population.getChromosomes()[0].getFitness());
            printPopulation(population,
                    "Target Chromosome: "+ Arrays.toString(Parameters.TARGET_CHROMOSOME));


        }
    }

    /**
     * @param population population that we want to display
     * @param heading title of the application
     */
    public static void printPopulation(Population population, String heading){
        System.out.println(heading);
        System.out.println("----------------------------------------");
        for (int i = 0; i < population.getChromosomes().length; i++) {
            System.out.println(
                    "geneticAlgorithm.Chromosome  # "+ i + "  =>  "
                    + Arrays.toString(population.getChromosomes()[i].getWords())
                    + " | Fitness: "+ population.getChromosomes()[i].getFitness()
            );
        }
    }
}

