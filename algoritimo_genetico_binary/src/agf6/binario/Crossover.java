package agf6.binario;

public class Crossover {
    public Crossover() {
    }

    public static Populacao fazCrossover(Populacao pais, double taxa) {
        Populacao novaGeracao = new Populacao(pais.getTamanho());

        for(int i = 0; i < pais.getTamanho(); i += 2) {
            double num = Math.random();
            Individuo filho1 = new Individuo();
            Individuo filho2 = new Individuo();
            if (!(num < taxa)) {
                novaGeracao.setIndividuo(i, pais.getIndividuo(i));
                novaGeracao.setIndividuo(i + 1, pais.getIndividuo(i + 1));
            } else {
                int pos = (int)(0.0 + Math.random() * 43.0);

                int j;
                for(j = 0; j < pos; ++j) {
                    filho1.setGene(j, pais.getIndividuo(i).getGene(j));
                    filho2.setGene(j, pais.getIndividuo(i + 1).getGene(j));
                }

                for(j = pos; j < 44; ++j) {
                    filho1.setGene(j, pais.getIndividuo(i + 1).getGene(j));
                    filho2.setGene(j, pais.getIndividuo(i).getGene(j));
                }

                novaGeracao.setIndividuo(i, filho1);
                novaGeracao.setIndividuo(i + 1, filho2);
            }
        }

        return novaGeracao;
    }
}

