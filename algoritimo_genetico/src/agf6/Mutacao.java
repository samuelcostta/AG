package agf6;

public class Mutacao {
    public Mutacao() {
    }

    public static void fazMutacao(Populacao p, double taxa) {
        for(int i = 0; i < p.getTamanho(); ++i) {
            Individuo ind = p.getIndividuo(i);

            for(int j = 0; j < 2; ++j) {
                double num = Math.random();
                if (num < taxa) {
                    ind.swapGene(j);
                }
            }
        }

    }
}