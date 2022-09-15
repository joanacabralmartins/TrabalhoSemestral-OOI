package ifpr.pgua.eic.sistemaEscola.controllers;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaPrincipal {

  @FXML
  private void carregaTelaMenuAlunos(ActionEvent evento) {
    App.changeScreenRegion("MENU ALUNOS", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaMenuProfessores(ActionEvent evento) {
    App.changeScreenRegion("MENU PROFESSORES", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaMenuCursos(ActionEvent evento) {
    App.changeScreenRegion("MENU CURSOS", BorderPaneRegion.CENTER);
  }

}