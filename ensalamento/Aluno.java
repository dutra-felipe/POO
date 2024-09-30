package ensalamento;

class Aluno extends Pessoa {
    private Curso curso;

    public Aluno(String nome, Curso curso) {
        super(nome);
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }
}