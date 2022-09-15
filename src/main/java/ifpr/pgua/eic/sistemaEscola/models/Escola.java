package ifpr.pgua.eic.sistemaEscola.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Escola {
  String nome, telefone;

  ArrayList<Professor> professores;
  ArrayList<Aluno> alunos;
  ArrayList<Curso> cursos;

  public Escola(String nome, String telefone) {
    this.nome = nome;
    this.telefone = telefone;

    professores = new ArrayList<>();
    alunos = new ArrayList<>();
    cursos = new ArrayList<>();
  }

  public boolean cadastrarAluno(String cpf, String nome, String email, String telefone, LocalDate dataMatricula) {
    if (buscarAlunoCpf(cpf) == null) {
      Aluno aluno = new Aluno(cpf, nome, email, telefone, dataMatricula);
      return alunos.add(aluno);
    }
    return false;
  }

  public boolean cadastrarProfessor(String cpf, String nome, String email, String telefone, double salario) {
    if (buscaProfessorCpf(cpf) == null) {
      Professor professor = new Professor(cpf, nome, email, telefone, salario);
      return professores.add(professor);
    }
    return false;
  }

  public boolean cadastrarCurso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor) {
    if (buscarCurso(nome) == null) {
      Curso curso = new Curso(codigo, nome, descricao, cargaHoraria, professor);
      return cursos.add(curso);
    }
    return false;
  }

  public boolean matricularAluno(Aluno aluno, Curso curso) {
    if (aluno != null && curso != null) {
      return curso.matricula(aluno);
    }

    return false;
  }

  public boolean desmatricular(Aluno aluno, Curso curso) {
    ArrayList<Aluno> alunosAux = new ArrayList<Aluno>();
    alunosAux = curso.getAlunos();

    int i = 0;

    for (Aluno aluno_ : alunosAux) {
      if (aluno.equals(alunosAux.get(i))) {
        curso.desmatricula(aluno.getCpf());
        return true;
      }
      i++;
    }

    return false;
  }

  public ArrayList<Aluno> listarAlunos() {
    return alunos;
  }

  public ArrayList<Professor> listarProfessores() {
    return professores;
  }

  public ArrayList<Curso> listarCursos() {
    return cursos;
  }

  public ArrayList<Aluno> listarAlunosMatriculados(Curso curso) {
    return curso.getAlunos();
  }

  public Aluno buscarAlunoCpf(String cpf) {
    for (Aluno aluno : alunos) {
      if (aluno.getCpf().equals(cpf)) {
        return aluno;
      }
    }
    return null;
  }

  public Professor buscaProfessorCpf(String cpf) {
    for (Professor professor : professores) {
      if (professor.getCpf().equals(cpf)) {
        return professor;
      }
    }
    return null;
  }

  public Curso buscarCurso(String nome) {
    for (Curso curso : cursos) {
      if (curso.getNome().equals(nome)) {
        return curso;
      }
    }
    return null;
  }

  public void salvarArquivoTexto() {
    try (FileWriter fwriter = new FileWriter("professores.txt");
        BufferedWriter bwriter = new BufferedWriter(fwriter)) {
      for (Professor professor : professores) {
        bwriter.write(professor.getCpf() + ";" + professor.getNome() + ";" + professor.getEmail() + ";"
            + professor.getTelefone() + ";" + professor.getSalario());
        bwriter.newLine();
      }
    } catch (IOException e) {
      System.out.println("Erro ao salvar professores");
    }

    try (FileWriter fwriter = new FileWriter("alunos.txt");
        BufferedWriter bwriter = new BufferedWriter(fwriter)) {
      for (Aluno aluno : alunos) {
        bwriter.write(aluno.getCpf() + ";" + aluno.getNome() + ";" + aluno.getEmail() + ";" + aluno.getTelefone() + ";"
            + aluno.getDataMatricula());
        bwriter.newLine();
      }
    } catch (IOException e) {
      System.out.println("Erro ao salvar alunos");
    }

    try (FileWriter fwriter = new FileWriter("cursos.txt");
        BufferedWriter bwriter = new BufferedWriter(fwriter)) {
      for (Curso curso : cursos) {
        bwriter.write(curso.getCodigo() + ";" + curso.getNome() + ";" + curso.getDescricao() + ";"
            + curso.getCargaHoraria() + ";" + curso.getProfessor().getCpf() + ";");
        for (Aluno aluno : curso.getAlunos()) {
          bwriter.write(aluno.getCpf() + ",");
        }
        bwriter.newLine();
      }
    } catch (IOException e) {
      System.out.println("Erro ao salvar cursos");
    }

  }

  public void carregarArquivoTexto() {
    try (FileReader fin = new FileReader("professores.txt");
        BufferedReader bin = new BufferedReader(fin)) {

      String linha = bin.readLine();
      while (linha != null) {
        String[] tokens = linha.split(";");
        String cpf = tokens[0];
        String nome = tokens[1];
        String email = tokens[2];
        String telefone = tokens[3];
        double salario = Double.valueOf(tokens[4]);
        Professor professor = new Professor(cpf, nome, email, telefone, salario);

        if (buscaProfessorCpf(cpf) == null) {
          this.professores.add(professor);
        }

        linha = bin.readLine();
      }
    } catch (IOException e) {
      System.out.println("Erro ao carregar itens");
    }

    try (FileReader fin = new FileReader("alunos.txt");
        BufferedReader bin = new BufferedReader(fin)) {

      String linha = bin.readLine();
      while (linha != null) {
        String[] tokens = linha.split(";");
        String cpf = tokens[0];
        String nome = tokens[1];
        String email = tokens[2];
        String telefone = tokens[3];
        LocalDate dataMatricula = LocalDate.parse(tokens[4]);

        Aluno aluno = new Aluno(cpf, nome, email, telefone, dataMatricula);

        if (buscarAlunoCpf(cpf) == null) {
          this.alunos.add(aluno);
        }

        linha = bin.readLine();
      }
    } catch (IOException e) {
      System.out.println("Erro ao carregar itens");
    }

    try (FileReader fin = new FileReader("cursos.txt");
        BufferedReader bin = new BufferedReader(fin)) {

      String linha = bin.readLine();
      while (linha != null) {
        String[] tokens = linha.split(";");
        int codigo = Integer.valueOf(tokens[0]);
        String nome = tokens[1];
        String descricao = tokens[2];
        int cargaHoraria = Integer.valueOf(tokens[3]);
        String cpf = tokens[4];
        Professor professor = buscaProfessorCpf(cpf);

        Curso curso = new Curso(codigo, nome, descricao, cargaHoraria, professor);

        if (buscarCurso(nome) == null) {
          this.cursos.add(curso);
        }

        if (tokens.length > 5) {
          String[] cpfAlunos = tokens[5].split(",");
          for (String cpfAluno : cpfAlunos) {
            Aluno aluno = buscarAlunoCpf(cpfAluno);
            curso.matricula(aluno);
          }
        }

        linha = bin.readLine();
      }
    } catch (IOException e) {
      System.out.println("Erro ao carregar itens");
    }
  }
}