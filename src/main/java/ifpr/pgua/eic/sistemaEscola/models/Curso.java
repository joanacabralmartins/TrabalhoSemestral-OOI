package ifpr.pgua.eic.sistemaEscola.models;

import java.util.ArrayList;

public class Curso {
  int codigo;
  String nome;
  String descricao;
  int cargaHoraria;
  Professor professor;
  ArrayList<Aluno> alunos;

  public Curso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor) {
    this.codigo = codigo;
    this.nome = nome;
    this.descricao = descricao;
    this.cargaHoraria = cargaHoraria;
    this.professor = professor;

    alunos = new ArrayList<>();
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(int cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public ArrayList<Aluno> getAlunos() {
    return alunos;
  }

  public boolean matricula(Aluno aluno) {
    for (Aluno aluno_ : alunos) {
      if (aluno.equals(aluno_)) {
        return false;
      }
    }
    return alunos.add(aluno);
  }

  public boolean desmatricula(String cpf) {
    int cont = 0;

    for (Aluno aluno : alunos) {
      if (aluno.getCpf().equals(cpf)) {
        alunos.remove(cont);
        return true;
      }
      cont++;
    }

    return false;
  }

  public String toString() {
    return "Nome do Curso: " + nome + ", Professor: " + professor;
  }

}
