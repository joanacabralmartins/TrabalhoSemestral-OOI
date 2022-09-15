package ifpr.pgua.eic.sistemaEscola.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.models.Aluno;
import ifpr.pgua.eic.sistemaEscola.models.Curso;
import ifpr.pgua.eic.sistemaEscola.models.Escola;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;

public class JanelaDesmatricularAluno implements Initializable {

  @FXML
  private ChoiceBox<Aluno> cbAluno;

  @FXML
  private ChoiceBox<Curso> cbCurso;

  private Escola escola;

  private Aluno aluno;

  private Curso curso;

  public JanelaDesmatricularAluno(Escola escola) {
    this.escola = escola;
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    for (Aluno aluno : escola.listarAlunos()) {
      cbAluno.getItems().addAll(aluno);
    }

    for (Curso curso : escola.listarCursos()) {
      cbCurso.getItems().addAll(curso);
    }

    cbAluno.setOnAction(this::alunoSelecionado);
    cbCurso.setOnAction(this::cursoSelecionado);
  }

  public void alunoSelecionado(ActionEvent event) {
    aluno = cbAluno.getValue();
  }

  public void cursoSelecionado(ActionEvent event) {
    curso = cbCurso.getValue();
  }

  @FXML
  private void desmatricular(ActionEvent evento) {
    String cpf = aluno.getCpf();
    String nomeCurso = curso.getNome();

    Aluno aluno = escola.buscarAlunoCpf(cpf);
    Curso curso = escola.buscarCurso(nomeCurso);

    if (aluno == null || curso == null) {
      Alert alert = new Alert(AlertType.ERROR, "Operação não realizada!");
      alert.showAndWait();
    }

    else if (escola.desmatricular(aluno, curso)) {
      Alert alert = new Alert(AlertType.INFORMATION, "Operação realizada!");
      alert.showAndWait();

    } else {
      Alert alert = new Alert(AlertType.ERROR, "Aluno não matriculado!");
      alert.showAndWait();
    }

  }

  @FXML
  private void carregaMenuAlunos(ActionEvent evento) {
    App.changeScreenRegion("MENU ALUNOS", BorderPaneRegion.CENTER);
  }

}