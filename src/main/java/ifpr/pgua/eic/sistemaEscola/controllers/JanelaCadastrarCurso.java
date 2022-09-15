package ifpr.pgua.eic.sistemaEscola.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.models.Escola;
import ifpr.pgua.eic.sistemaEscola.models.Professor;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaCadastrarCurso implements Initializable {
  private Escola escola;

  private Professor prof;

  @FXML
  private TextField tfCodigo;

  @FXML
  private TextField tfNome;

  @FXML
  private TextField tfDescricao;

  @FXML
  private TextField tfCargaHoraria;

  @FXML
  private ChoiceBox<Professor> cbProfessor;

  public JanelaCadastrarCurso(Escola escola) {
    this.escola = escola;
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    for (Professor prof : escola.listarProfessores()) {
      cbProfessor.getItems().addAll(prof);
    }
    cbProfessor.setOnAction(this::profSelecionado);
  }

  public void profSelecionado(ActionEvent event) {
    prof = cbProfessor.getValue();
  }

  @FXML
  private void cadastrar(ActionEvent evento) {
    String codigo = tfCodigo.getText();
    String nome = tfNome.getText();
    String descricao = tfDescricao.getText();
    String cargaHoraria = tfCargaHoraria.getText();
    String cpfProfessor = prof.getCpf();

    int cdg = Integer.valueOf(codigo);
    int iCargaHoraria = Integer.valueOf(cargaHoraria);

    Professor professor = escola.buscaProfessorCpf(cpfProfessor);

    if (professor == null) {
      Alert alert = new Alert(AlertType.ERROR, "Necessário um professor cadastrado na escola!");
      alert.showAndWait();
    }

    else if (escola.cadastrarCurso(cdg, nome, descricao, iCargaHoraria, professor)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Cadastro realizado!");
      alert.showAndWait();
      clear();

    } else {
      Alert alert = new Alert(AlertType.ERROR, "Curso já cadastrado!");
      alert.showAndWait();
    }

  }

  @FXML
  private void carregaTelaMenuCursos(ActionEvent evento) {
    App.changeScreenRegion("MENU CURSOS", BorderPaneRegion.CENTER);
  }

  private void clear() {
    tfCodigo.clear();
    tfNome.clear();
    tfDescricao.clear();
    tfCargaHoraria.clear();
  }

}
