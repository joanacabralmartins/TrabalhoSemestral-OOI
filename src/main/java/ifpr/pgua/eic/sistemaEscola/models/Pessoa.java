package ifpr.pgua.eic.sistemaEscola.models;

public class Pessoa {
  protected String cpf, nome, email, telefone;

  Pessoa(String cpf, String nome, String email, String telefone) {
    this.cpf = cpf;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
