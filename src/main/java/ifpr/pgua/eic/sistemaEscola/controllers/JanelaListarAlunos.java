package ifpr.pgua.eic.sistemaEscola.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.sistemaEscola.App;
import ifpr.pgua.eic.sistemaEscola.models.Aluno;
import ifpr.pgua.eic.sistemaEscola.models.Escola;
import ifpr.pgua.eic.sistemaEscola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class JanelaListarAlunos implements Initializable {

  @FXML
  private TextField tfNome;

  @FXML
  private TextArea taDetalhes;

  @FXML
  private ListView<Aluno> alunos;

  private Escola escola;

  public JanelaListarAlunos(Escola escola) {
    this.escola = escola;
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    alunos.getItems().clear();
    alunos.getItems().addAll(escola.listarAlunos());
  }

  @FXML
  private void carregaMenuAlunos(ActionEvent evento) {
    App.changeScreenRegion("MENU ALUNOS", BorderPaneRegion.CENTER);
  }

}