package ifpr.pgua.eic.sistemaEscola.controllers;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaMenuAlunos {

  @FXML
  private void carregaTelaCadastroAluno(ActionEvent evento) {
    App.changeScreenRegion("CADASTRO ALUNO", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaListarAlunos(ActionEvent evento) {
    App.changeScreenRegion("LISTAR ALUNOS", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaMatricularAluno(ActionEvent evento) {
    App.changeScreenRegion("MATRICULAR ALUNO", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaDesmatricularAluno(ActionEvent evento) {
    App.changeScreenRegion("DESMATRICULAR ALUNO", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaAlunosMatriculados(ActionEvent evento) {
    App.changeScreenRegion("LISTAR ALUNOS MATRICULADOS", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaPrincipal(ActionEvent evento) {
    App.changeScreenRegion("PRINCIPAL", BorderPaneRegion.CENTER);
  }

}
