package agf6;

public class Populacao {
    private Individuo[] populacao;
    private int tamanho;

    public Populacao() {
        this.populacao = new Individuo[100];
        this.tamanho = 100;
    }

    public Populacao(int tamanho) {
        this.populacao = new Individuo[tamanho];
        this.tamanho = tamanho;
    }

    public Populacao(Individuo[] populacao) {
        this.populacao = populacao;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public Individuo getIndividuo(int pos) {
        return this.populacao[pos];
    }

    public void setIndividuo(int pos, Individuo i) {
        this.populacao[pos] = i;
    }
}