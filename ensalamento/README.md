# Ensalamento - Alocação de Alunos em Turmas

Este repositório contém um exemplo de um sistema de **ensalamento** implementado em Java. O programa realiza a alocação de alunos em turmas, associando-os a disciplinas de acordo com seus cursos. O código utiliza os conceitos de orientação a objetos para representar os elementos principais de uma instituição de ensino, como **alunos**, **professores**, **disciplinas**, **cursos**, e **turmas**.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes principais:

- **Pessoa**: Representa uma pessoa genérica, contendo o atributo nome.
- **Aluno**: Subclasse de `Pessoa`, associada a um curso específico.
- **Professor**: Subclasse de `Pessoa`, associada a uma disciplina.
- **Curso**: Representa um curso oferecido pela instituição.
- **Disciplina**: Representa uma disciplina que faz parte de um curso.
- **Turma**: Representa a turma que reúne um professor, uma disciplina, e os alunos matriculados.
- **Ensalamento**: Classe principal que realiza o processo de alocação dos alunos às turmas.
- **Main**: Classe que executa o processo de ensalamento.

## Dados Utilizados

Aqui estão os dados que são utilizados no sistema para exemplificar o ensalamento:

### Alunos

- Alfredo - TI
- Amélia - TI
- Ana - ADM
- Bruno - TI
- Bentinho - ADM
- Capitú - TI
- Debra - TI
- Ian - ADM
- Iracema - TI
- Joelmir - ADM
- Julieta - TI
- Luana - ADM
- Luciana - TI
- Majô - ADM
- Maria - ADM
- Norberto - TI
- Paulo - ADM
- Romeu - ADM
- Wendel - TI
- Zoey - TI

### Professores

- Mia - POO
- Saulo - Estrutura de Dados
- Paula - BI

### Cursos

- TI
- ADM

### Disciplinas

- POO (TI)
- Estrutura de Dados (TI)
- BI (ADM)

## Link para o Vídeo Explicativo 

Você pode assistir ao vídeo explicativo sobre o código neste [link do vídeo](https://drive.google.com/file/d/16rGA600DG7yAiqRt2V4i9YRXTHuQTDJW/view?usp=sharing).