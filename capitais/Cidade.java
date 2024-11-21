package capitais;

public class Cidade implements Comparable<Cidade> {
    private String nome;
    private String uf;
    private boolean capital;

    public Cidade(String uf, String nome, boolean capital) {
        this.uf = uf;
        this.nome = nome;
        this.capital = capital;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    @Override
    public int compareTo(Cidade other) {
        return this.nome.compareTo(other.nome);
    }

    @Override
    public String toString() {
        return (capital ? "[Capital] " : "") + nome + " - " + uf;
    }
}
