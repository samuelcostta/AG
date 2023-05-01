package agf6.binario;

public class AG {
    private static int numGeracoes = 20;
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

        for(int i = 0; i < numGeracoes; ++i) {
            System.out.println("Geracao " + (i + 1));
            Selecao s = new Selecao(populacao);
            Populacao pais = s.getPais();
            Populacao novaGer = Crossover.fazCrossover(pais, taxaCrossover);
            Mutacao.fazMutacao(novaGer, taxaMutacao);
            avalia(novaGer);
            populacao = novaGer;
            imprimeMelhorIndividuo(novaGer);
        }

    }

    private static void imprimeMelhorIndividuo(Populacao p) {
        Individuo ind = p.getIndividuo(0);
        double melhor = ind.getFitness();
        double media = ind.getFitness();
        int pos = 0;
        double x = doubleValue(getX(ind));
        double y = doubleValue(getY(ind));

        for(int i = 1; i < tamPopulacao; ++i) {
            ind = p.getIndividuo(i);
            media += ind.getFitness();
            if (ind.getFitness() > melhor) {
                melhor = ind.getFitness();
                pos = i;
                x = doubleValue(getX(ind));
                y = doubleValue(getY(ind));
            }
        }

        media /= (double)tamPopulacao;
        System.out.println("Media da geracao: " + media);
        System.out.println("Melhor individuo [" + (pos + 1) + "]:");
        System.out.println("F6(" + x + ", " + y + ") = " + melhor);
        System.out.println();
    }

    private static int binaryToDecimal(int[] vet) {
        int sum = 0;

        for(int i = vet.length - 1; i >= 0; --i) {
            sum = (int)((double)sum + (double)vet[i] * Math.pow(2.0, (double)(vet.length - i - 1)));
        }

        return sum;
    }

    private static int[] getX(Individuo ind) {
        int[] binx = new int[22];

        for(int j = 0; j < 22; ++j) {
            binx[j] = ind.getGene(j);
        }

        return binx;
    }

    private static int[] getY(Individuo ind) {
        int[] biny = new int[22];

        for(int j = 22; j < 44; ++j) {
            biny[j - 22] = ind.getGene(j);
        }

        return biny;
    }

    private static double doubleValue(int[] genes) {
        double dec = (double)binaryToDecimal(genes);
        dec = dec * 200.0 / (Math.pow(2.0, 22.0) - 1.0);
        dec -= 100.0;
        return dec;
    }

    private static Populacao iniciaPopulacao() {
        Populacao pop = new Populacao(tamPopulacao);

        for(int i = 0; i < tamPopulacao; ++i) {
            Individuo ind = new Individuo();

            for(int j = 0; j < 44; ++j) {
                double num = Math.random();
                if (num < 0.5) {
                    ind.setGene(j, 1);
                } else {
                    ind.setGene(j, 0);
                }
            }

            pop.setIndividuo(i, ind);
        }

        return pop;
    }

    private static void avalia(Populacao populacao) {
        for(int i = 0; i < tamPopulacao; ++i) {
            Individuo ind = populacao.getIndividuo(i);
            double x = doubleValue(getX(ind));
            double y = doubleValue(getY(ind));
            double fitness = 0.5 - (Math.pow(Math.sin(Math.sqrt(x * x + y * y)), 2.0) - 0.5) / Math.pow(1.0 + 0.001 * (x * x + y * y), 2.0);
            ind.setFitness(fitness);
        }

    }
}

