package agf6;

public class Selecao {
    private double[] adaptabilidade;
    private Populacao pais;
    private Populacao atual;

    public Selecao(Populacao p) {
        this.adaptabilidade = new double[p.getTamanho()];
        this.pais = new Populacao(p.getTamanho());
        this.atual = p;
        this.setAdaptabilidade(p);
        this.selecionaPais();
    }

    private void selecionaPais() {
        for(int i = 0; i < this.adaptabilidade.length; ++i) {
            int num = (int)(0.0 + Math.random() * this.adaptabilidade[this.adaptabilidade.length - 1]);

            for(int pos = 0; pos < this.adaptabilidade.length; ++pos) {
                if (this.adaptabilidade[pos] >= (double)num) {
                    this.pais.setIndividuo(i, this.atual.getIndividuo(pos));
                    break;
                }
            }
        }

    }

    private void setAdaptabilidade(Populacao p) {
        Individuo individuo = p.getIndividuo(0);
        this.adaptabilidade[0] = individuo.getFitness();

        for(int i = 1; i < this.adaptabilidade.length; ++i) {
            individuo = p.getIndividuo(i);
            this.adaptabilidade[i] = individuo.getFitness() + this.adaptabilidade[i - 1];
        }

    }

    public Populacao getPais() {
        return this.pais;
    }
}
