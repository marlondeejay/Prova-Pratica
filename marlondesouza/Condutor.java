package acidentesRodovias;

import javax.swing.JOptionPane;

public class Condutor {
  private String nome = "";
  private int idade = -1;
  private char sexo = ' ';
  private char embriagado = ' ';

  public void cadastra() {
    setNome((JOptionPane.showInputDialog(null, "Digite o nome do condutor")));
    setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade do condutor " + getNome())));
    setSexo(
        JOptionPane.showInputDialog(null, "Digite o sexo do condutor " + getNome() + " (M/F)").toUpperCase().charAt(0));
    setEmbriagado((JOptionPane.showInputDialog(null, "O condutor estava alcoolizado? (1/0)").charAt(0)));
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public char getSexo() {
    return sexo;
  }

  public void setSexo(char sexo) {
    this.sexo = sexo;
  }

  public boolean isEmbriagado() {
    if (embriagado == '1') {
      return true;
    }
    return false;
  }

  public void setEmbriagado(char embriagado) {
    this.embriagado = embriagado;
  }

  @Override
  public String toString() {
    return "{ nome = " + nome + ", embriagado = " + embriagado + ", idade = " + idade + ", sexo = " + sexo + " }";
  }
}
