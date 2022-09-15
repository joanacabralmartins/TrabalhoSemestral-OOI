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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class JanelaListarAlunosMatriculados implements Initializable {

  @FXML
  private ListView<Curso> cursos;

  @FXML
  private ListView<Aluno> alunos;

  private Escola escola;

  public JanelaListarAlunosMatriculados(Escola escola) {
    this.escola = escola;
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    cursos.getItems().clear();
    cursos.getItems().addAll(escola.listarCursos());
  }

  @FXML
  private void carregaMenuAlunos(ActionEvent evento) {
    App.changeScreenRegion("MENU ALUNOS", BorderPaneRegion.CENTER);
  }

  @FXML
  private void exibirAlunos(MouseEvent evento) {
    Curso curso = cursos.getSelectionModel().getSelectedItem();

    if (curso != null) {
      alunos.getItems().clear();
      alunos.getItems().addAll(escola.listarAlunosMatriculados(curso));
    }
  }

}