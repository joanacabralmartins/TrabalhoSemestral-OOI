package ifpr.pgua.eic.sistemaEscola.models;

import java.time.LocalDate;

public class Aluno extends Pessoa {
  protected LocalDate dataMatricula;

  public Aluno(String cpf, String nome, String email, String telefone, LocalDate dataMatricula) {
    super(cpf, nome, email, telefone);
    this.dataMatricula = dataMatricula;
  }

  public String toString() {
    return "Nome: " + nome + ", CPF: " + cpf + ", Data de Matrícula: " + dataMatricula;
  }

  public LocalDate getDataMatricula() {
    return dataMatricula;
  }

  public void setDataMatricula(LocalDate dataMatricula) {
    this.dataMatricula = dataMatricula;
  }
}
