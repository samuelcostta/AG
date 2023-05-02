package agf6.binario;

public class Individuo {
    private int[] genes;
    private double fitness;

    public Individuo() {
        this.genes = new int[44];
        this.fitness = 0.0;
    }

    public Individuo(int[] genes) {
        this.genes = genes;
        this.fitness = 0.0;
    }

    public int[] getGenes() {
        return this.genes;
    }

    public int getGene(int pos) {
        return this.genes[pos];
    }

    public double getFitness() {
        return this.fitness;
    }

    public void setGene(int pos, int val) {
        this.genes[pos] = val;
    }

    public void setFitness(double val) {
        this.fitness = val;
    }

    public void setIndividuo(int[] genes) {
        this.genes = genes;
    }

    public void swapGene(int pos) {
        this.genes[pos] = 1 - this.genes[pos];
    }
}
