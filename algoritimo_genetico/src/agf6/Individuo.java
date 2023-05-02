package agf6;
import java.util.Random;

public class Individuo {
    private double[] genes;
    private double fitness;
    private double valorMinimo;
    private double valorMaximo;

    public Individuo() {
        this.genes = new double[2];
        this.fitness = 0.0;
        this.valorMaximo = 5.12;
        this.valorMinimo = -5.12;
    }

    public Individuo(double[] genes) {
        this.genes = genes;
        this.fitness = 0.0;
        this.valorMinimo = -5.12;
        this.valorMaximo = 5.12;
    }

    public Individuo(double limiteInferior, double limiteSuperior) {
        this.genes = new double[2];
        this.fitness = 0.0;
        this.valorMaximo = limiteSuperior;
        this.valorMinimo = limiteInferior;
    }

    public double[] getGenes() {
        return this.genes;
    }

    public double getGene(int pos) {
        return this.genes[pos];
    }

    public double getValorMinimo() {
        return this.valorMinimo;
    }

    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public double getValorMaximo(double valorMaximo) {
        return valorMaximo;
    }

    public void setValorMaximo(double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public double getFitness() {
        return this.fitness;
    }

    public void setGene(int pos, double val) {
        this.genes[pos] = val;
    }

    public void setGenes(double[] genes) {
        this.genes = genes;
    }

    public void setFitness(double val) {
        this.fitness = val;
    }

    public void setIndividuo(double[] genes) {
        this.genes = genes;
    }

    public void swapGene(int pos) {
        this.genes[pos] = this.sorteia(this.valorMinimo, this.valorMaximo);
    }

    public double sorteia(double limiteInferior, double limiteSuperior) {
        Random r = new Random();
        return limiteInferior + (limiteSuperior - limiteInferior) * r.nextDouble();
    }
}

