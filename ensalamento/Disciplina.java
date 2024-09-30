package ensalamento;

class Disciplina {
    private String nome;
    private Curso curso;

    public Disciplina(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }
}