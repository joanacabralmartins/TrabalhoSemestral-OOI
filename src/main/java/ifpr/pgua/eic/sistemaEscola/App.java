package ifpr.pgua.eic.sistemaEscola;

import ifpr.pgua.eic.sistemaEscola.controllers.JanelaCadastrarAluno;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaCadastrarCurso;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaCadastrarProfessor;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaDesmatricularAluno;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaListarAlunos;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaListarAlunosMatriculados;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaListarCursos;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaListarProfessores;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaMatricularAluno;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaMenuAlunos;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaMenuCursos;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaMenuProfessores;
import ifpr.pgua.eic.sistemaEscola.controllers.JanelaPrincipal;
import ifpr.pgua.eic.sistemaEscola.models.Escola;
import ifpr.pgua.eic.sistemaEscola.utils.BaseAppNavigator;
import ifpr.pgua.eic.sistemaEscola.utils.ScreenRegistryFXML;

public class App extends BaseAppNavigator {
        private Escola escola;

        @Override
        public void init() throws Exception {
                super.init();

                escola = new Escola("EscolaABCKD", "4002-2004");

                escola.carregarArquivoTexto();
        }

        @Override
        public void stop() throws Exception {
                escola.salvarArquivoTexto();
                super.stop();
        }

        @Override
        public String getHome() {
                return "PRINCIPAL";
        }

        @Override
        public String getAppTitle() {
                return "Sistema Escola";
        }

        @Override
        public void registrarTelas() {
                registraTela("PRINCIPAL",
                                new ScreenRegistryFXML(App.class, "principal.fxml", o -> new JanelaPrincipal()));
                registraTela("MENU ALUNOS",
                                new ScreenRegistryFXML(App.class, "menuAlunos.fxml", o -> new JanelaMenuAlunos()));
                registraTela("MENU PROFESSORES",
                                new ScreenRegistryFXML(App.class, "menuProfessores.fxml",
                                                o -> new JanelaMenuProfessores()));
                registraTela("MENU CURSOS",
                                new ScreenRegistryFXML(App.class, "menuCursos.fxml", o -> new JanelaMenuCursos()));
                registraTela("CADASTRO PROFESSOR",
                                new ScreenRegistryFXML(App.class, "cadastroProfessor.fxml",
                                                o -> new JanelaCadastrarProfessor(escola)));
                registraTela("CADASTRO ALUNO",
                                new ScreenRegistryFXML(App.class, "cadastroAluno.fxml",
                                                o -> new JanelaCadastrarAluno(escola)));
                registraTela("CADASTRO CURSO",
                                new ScreenRegistryFXML(App.class, "cadastroCurso.fxml",
                                                o -> new JanelaCadastrarCurso(escola)));
                registraTela("LISTAR PROFESSORES",
                                new ScreenRegistryFXML(App.class, "listarProfessores.fxml",
                                                o -> new JanelaListarProfessores(escola)));
                registraTela("LISTAR ALUNOS",
                                new ScreenRegistryFXML(App.class, "listarAlunos.fxml",
                                                o -> new JanelaListarAlunos(escola)));
                registraTela("LISTAR CURSOS",
                                new ScreenRegistryFXML(App.class, "listarCursos.fxml",
                                                o -> new JanelaListarCursos(escola)));
                registraTela("MATRICULAR ALUNO",
                                new ScreenRegistryFXML(App.class, "matriculaAluno.fxml",
                                                o -> new JanelaMatricularAluno(escola)));
                registraTela("DESMATRICULAR ALUNO",
                                new ScreenRegistryFXML(App.class, "desmatriculaAluno.fxml",
                                                o -> new JanelaDesmatricularAluno(escola)));
                registraTela("LISTAR ALUNOS MATRICULADOS",
                                new ScreenRegistryFXML(App.class, "listarAlunosMatriculados.fxml",
                                                o -> new JanelaListarAlunosMatriculados(escola)));
        }

}