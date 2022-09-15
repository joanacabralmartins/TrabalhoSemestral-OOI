package ifpr.pgua.eic.sistemaEscola.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.models.Escola;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaCadastrarAluno {

  @FXML
  private TextField tfNome;

  @FXML
  private TextField tfCpf;

  @FXML
  private TextField tfEmail;

  @FXML
  private TextField tfDtMatricula;

  @FXML
  private TextField tfTelefone;

  private Escola escola;

  public JanelaCadastrarAluno(Escola escola) {
    this.escola = escola;
  }

  @FXML
  private void cadastrar(ActionEvent evento) {
    String cpf = tfCpf.getText();
    String nome = tfNome.getText();
    String email = tfEmail.getText();
    String telefone = tfTelefone.getText();
    String matricula = tfDtMatricula.getText();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    LocalDate dataMatricula = LocalDate.parse(matricula, formatter);

    if (escola.cadastrarAluno(cpf, nome, email, telefone, dataMatricula)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Cadastro realizado!");
      alert.showAndWait();
      clear();

    } else {
      Alert alert = new Alert(AlertType.ERROR, "CPF já cadastrado!");
      alert.showAndWait();
    }

  }

  @FXML
  private void carregaMenuAlunos(ActionEvent evento) {
    App.changeScreenRegion("MENU ALUNOS", BorderPaneRegion.CENTER);
  }

  private void clear() {
    tfCpf.clear();
    tfNome.clear();
    tfEmail.clear();
    tfTelefone.clear();
    tfDtMatricula.clear();
  }

}