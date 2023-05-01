package agf6;

public class AG {
    private static int tamPopulacao = 100;
    private static double taxaCrossover = 0.65;
    private static double taxaMutacao = 0.008;

    public AG() {
    }

    public static void main(String[] args) {
        Populacao populacao = iniciaPopulacao();
        avalia(populacao);
        System.out.println("Geracao 0");
        imprimeMelhorIndividuo(populacao);
        int i = 0;

        while(true) {
            System.out.println("Geracao " + (i + 1));
            Selecao s = new Selecao(populacao);
            Populacao pais = s.getPais();
            Populacao novaGer = Crossover.fazCrossover(pais, taxaCrossover);
            Mutacao.fazMutacao(novaGer, taxaMutacao);
            avalia(novaGer);
            populacao = novaGer;
            imprimeMelhorIndividuo(novaGer);
            ++i;
        }
    }

    private static void imprimeMelhorIndividuo(Populacao p) {
        Individuo ind = p.getIndividuo(0);
        double melhor = ind.getFitness();
        double media = ind.getFitness();
        int pos = 0;
        double x = ind.getGene(0);
        double y = ind.getGene(1);

        for(int i = 1; i < tamPopulacao; ++i) {
            ind = p.getIndividuo(i);
            media += ind.getFitness();
            if (ind.getFitness() > melhor) {
                melhor = ind.getFitness();
                pos = i;
                x = ind.getGene(0);
                y = ind.getGene(1);
            }
        }

        media /= (double)tamPopulacao;
        System.out.println("Media da geracao: " + media);
        System.out.println("Melhor individuo [" + (pos + 1) + "]:");
        System.out.println("F6(" + x + ", " + y + ") = " + melhor);
        System.out.println();
    }

    private static Populacao iniciaPopulacao() {
        Populacao pop = new Populacao(tamPopulacao);

        for(int i = 0; i < tamPopulacao; ++i) {
            Individuo ind = new Individuo();

            for(int j = 0; j < ind.getGenes().length; ++j) {
                ind.setGene(j, ind.sorteia(-100.0, 100.0));
            }

            pop.setIndividuo(i, ind);
        }

        return pop;
    }

    private static void avalia(Populacao populacao) {
        for(int i = 0; i < tamPopulacao; ++i) {
            Individuo ind = populacao.getIndividuo(i);
            double x = ind.getGene(0);
            double y = ind.getGene(1);
            double fitness = 0.5 - (Math.pow(Math.sin(Math.sqrt(x * x + y * y)), 2.0) - 0.5) / Math.pow(1.0 + 0.001 * (x * x + y * y), 2.0);
            ind.setFitness(fitness);
        }

    }
}
