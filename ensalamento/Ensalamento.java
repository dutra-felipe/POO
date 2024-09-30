package ensalamento;

import java.util.*;

public class Ensalamento {
    private Map<Curso, List<Disciplina>> cursosDisciplinas = new HashMap<>();
    private Map<Disciplina, Turma> disciplinasTurmas = new HashMap<>();
    
    private Curso ti;
    private Curso adm;

    public Ensalamento() {
        ti = new Curso("TI");
        adm = new Curso("ADM");

        Disciplina poo = new Disciplina("POO", ti);
        Disciplina estruturaDados = new Disciplina("Estrutura de Dados", ti);
        Disciplina bi = new Disciplina("BI", adm);

        cursosDisciplinas.put(ti, Arrays.asList(poo, estruturaDados));
        cursosDisciplinas.put(adm, Arrays.asList(bi));

        Professor mia = new Professor("Mia", poo);
        Professor saulo = new Professor("Saulo", estruturaDados);
        Professor paula = new Professor("Paula", bi);

        disciplinasTurmas.put(poo, new Turma(mia, poo));
        disciplinasTurmas.put(estruturaDados, new Turma(saulo, estruturaDados));
        disciplinasTurmas.put(bi, new Turma(paula, bi));
    }

    public void alocarAlunos() {
        List<Aluno> alunos = Arrays.asList(
            new Aluno("Alfredo", ti),
            new Aluno("Amélia", ti),
            new Aluno("Ana", adm),
            new Aluno("Bruno", ti),
            new Aluno("Bentinho", adm),
            new Aluno("Capitú", ti),
            new Aluno("Debra", ti),
            new Aluno("Ian", adm),
            new Aluno("Iracema", ti),
            new Aluno("Joelmir", adm),
            new Aluno("Julieta", ti),
            new Aluno("Luana", adm),
            new Aluno("Luciana", ti),
            new Aluno("Majô", adm),
            new Aluno("Maria", adm),
            new Aluno("Norberto", ti),
            new Aluno("Paulo", adm),
            new Aluno("Romeu", adm),
            new Aluno("Wendel", ti),
            new Aluno("Zoey", ti)
        );

        for (Aluno aluno : alunos) {
            List<Disciplina> disciplinas = cursosDisciplinas.get(aluno.getCurso());
            for (Disciplina disciplina : disciplinas) {
                Turma turma = disciplinasTurmas.get(disciplina);
                turma.adicionarAluno(aluno);
            }
        }
    }

    public void mostrarEnsalamento() {
        for (Turma turma : disciplinasTurmas.values()) {
            turma.mostrarTurma();
            System.out.println();
        }
    }
}
