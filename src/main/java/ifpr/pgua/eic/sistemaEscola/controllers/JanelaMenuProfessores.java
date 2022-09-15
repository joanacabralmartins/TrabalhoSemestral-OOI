package ifpr.pgua.eic.sistemaEscola.controllers;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaMenuProfessores {

  @FXML
  private void carregaTelaCadastroProfessor(ActionEvent evento) {
    App.changeScreenRegion("CADASTRO PROFESSOR", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaListarProfessores(ActionEvent evento) {
    App.changeScreenRegion("LISTAR PROFESSORES", BorderPaneRegion.CENTER);
  }

  @FXML
  private void carregaTelaPrincipal(ActionEvent evento) {
    App.changeScreenRegion("PRINCIPAL", BorderPaneRegion.CENTER);
  }

}
