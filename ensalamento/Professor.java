package ensalamento;

class Professor extends Pessoa {
    private Disciplina disciplina;

    public Professor(String nome, Disciplina disciplina) {
        super(nome);
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}