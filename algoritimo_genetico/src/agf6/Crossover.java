package agf6;

import java.util.Random;

public class Crossover {
    public Crossover() {
    }

    public static Populacao fazCrossover(Populacao pais, double taxa) {
        Populacao novaGeracao = new Populacao(pais.getTamanho());

        for(int i = 0; i < pais.getTamanho() - 1; ++i) {
            double num = Math.random();
            Individuo filho1 = new Individuo();
            Individuo filho2 = new Individuo();
            if (num < taxa) {
                double alpha = sorteia(0.0, 1.0);
                filho1.setGenes(crossoverAritimetico(pais.getIndividuo(i).getGenes(), pais.getIndividuo(i).getGenes(), alpha));
                filho2.setGenes(crossoverAritimetico(pais.getIndividuo(i + 1).getGenes(), pais.getIndividuo(i).getGenes(), 1.0 - alpha));
                novaGeracao.setIndividuo(i, filho1);
                novaGeracao.setIndividuo(i + 1, filho2);
            } else {
                novaGeracao.setIndividuo(i, pais.getIndividuo(i));
                novaGeracao.setIndividuo(i + 1, pais.getIndividuo(i + 1));
            }
        }

        return novaGeracao;
    }

    public static double[] crossoverAritimetico(double[] pai, double[] mae, double alpha) {
        int length = pai.length;
        double[] filho = new double[length];

        for(int i = 0; i < length; ++i) {
            filho[i] = alpha * pai[i] + (1.0 - alpha) * mae[i];
        }

        return filho;
    }

    public static double sorteia(double limiteInferior, double limiteSuperior) {
        Random r = new Random();
        return limiteInferior + (limiteSuperior - limiteInferior) * r.nextDouble();
    }
}
