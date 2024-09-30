package ensalamento;

import java.util.HashSet;
import java.util.Set;

class Turma {
    private Professor professor;
    private Disciplina disciplina;
    private Set<Aluno> alunos;

    public Turma(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new HashSet<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void mostrarTurma() {
        System.out.println("Turma da disciplina: " + disciplina.getNome());
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNome() + " (" + aluno.getCurso().getNome() + ")");
        }
    }
}