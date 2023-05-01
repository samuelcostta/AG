package agf6.binario;

public class Mutacao {
    public Mutacao() {
    }

    public static void fazMutacao(Populacao p, double taxa) {
        for(int i = 0; i < p.getTamanho(); ++i) {
            Individuo ind = p.getIndividuo(i);

            for(int j = 0; j < 44; ++j) {
                double num = Math.random();
                if (num < taxa) {
                    ind.swapGene(j);
                }
            }
        }

    }
}