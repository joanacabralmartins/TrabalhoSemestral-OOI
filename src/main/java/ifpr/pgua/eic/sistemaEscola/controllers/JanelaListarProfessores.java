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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class JanelaListarProfessores implements Initializable {

  @FXML
  private TextField tfNome;

  @FXML
  private TextArea taDetalhes;

  @FXML
  private ListView<Professor> professores;

  private Escola escola;

  public JanelaListarProfessores(Escola escola) {
    this.escola = escola;
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    professores.getItems().clear();
    professores.getItems().addAll(escola.listarProfessores());
  }

  @FXML
  private void carregaMenuProfessores(ActionEvent evento) {
    App.changeScreenRegion("MENU PROFESSORES", BorderPaneRegion.CENTER);
  }

}
