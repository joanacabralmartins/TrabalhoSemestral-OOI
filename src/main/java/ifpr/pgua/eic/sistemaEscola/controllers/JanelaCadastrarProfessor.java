package ifpr.pgua.eic.sistemaEscola.controllers;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.models.Escola;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaCadastrarProfessor {

  @FXML
  private TextField tfNome;

  @FXML
  private TextField tfCpf;

  @FXML
  private TextField tfEmail;

  @FXML
  private TextField tfSalario;

  @FXML
  private TextField tfTelefone;

  private Escola escola;

  public JanelaCadastrarProfessor(Escola escola) {
    this.escola = escola;
  }

  @FXML
  private void cadastrar(ActionEvent evento) {
    String cpf = tfCpf.getText();
    String nome = tfNome.getText();
    String email = tfEmail.getText();
    String telefone = tfTelefone.getText();
    String salario = tfSalario.getText();

    double dSalario = Double.valueOf(salario);

    if (escola.cadastrarProfessor(cpf, nome, email, telefone, dSalario)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Cadastro realizado!");
      alert.showAndWait();
      clear();

    } else {
      Alert alert = new Alert(AlertType.ERROR, "CPF já cadastrado!");
      alert.showAndWait();
    }

  }

  @FXML
  private void carregaMenuProfessores(ActionEvent evento) {
    App.changeScreenRegion("MENU PROFESSORES", BorderPaneRegion.CENTER);
  }

  private void clear() {
    tfCpf.clear();
    tfNome.clear();
    tfEmail.clear();
    tfTelefone.clear();
    tfSalario.clear();
  }

}
