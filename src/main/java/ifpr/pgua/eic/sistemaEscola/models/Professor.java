package ifpr.pgua.eic.sistemaEscola.models;

public class Professor extends Pessoa {
  protected double salario;

  public Professor(String cpf, String nome, String email, String telefone, double salario) {
    super(cpf, nome, email, telefone);
    this.salario = salario;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String toString() {
    return "Nome: " + nome + ", CPF: " + cpf;
  }

  public String nome() {
    return nome;
  }

}
