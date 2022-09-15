package ifpr.pgua.eic.sistemaEscola.controllers;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaMenuCursos {

  @FXML
  private void carregaTelaCadastrarCurso(ActionEvent evento) {
    App.changeScreenRegion("CADASTRO CURSO", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaListarCursos(ActionEvent evento) {
    App.changeScreenRegion("LISTAR CURSOS", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaPrincipal(ActionEvent evento) {
    App.changeScreenRegion("PRINCIPAL", BorderPaneRegion.CENTER);
  }

}
