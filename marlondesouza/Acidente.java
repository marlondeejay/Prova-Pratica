package acidentesRodovias;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Acidente {
  private Rodovia rodovia = new Rodovia();
  private int vitimasFatais = -1;
  private ArrayList<Veiculo> veiculosEnvolvidos = new ArrayList<Veiculo>();

  public void cadastra(Rodovia rodovia) {
    setRodovia(rodovia);
    setVitimasFatais(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de vitimas fatais")));

    int qntVeiculos = Integer
        .parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de veículos que se envolveram no acidentes"));

    for (int i = 1; i <= qntVeiculos; i++) {
      Veiculo veiculo = new Veiculo();
      veiculo.cadastra(i);
      veiculosEnvolvidos.add(veiculo);
    }

  }

  public boolean isAlgumCondutorEmbriagado() {
    for (Veiculo veiculo : veiculosEnvolvidos) {
      if (veiculo.getCondutorEmbriagado()) {
        return true;
      }
    }

    return false;
  }

  public Rodovia getRodovia() {
    return rodovia;
  }

  public void setRodovia(Rodovia rodovia) {
    this.rodovia = rodovia;
  }

  public int getVitimasFatais() {
    return vitimasFatais;
  }

  public void setVitimasFatais(int vitimasFatais) {
    this.vitimasFatais = vitimasFatais;
  }

  public ArrayList<Veiculo> getVeiculosEnvolvidos() {
    return veiculosEnvolvidos;
  }

  public void setVeiculosEnvolvidos(ArrayList<Veiculo> veiculosEnvolvidos) {
    this.veiculosEnvolvidos = veiculosEnvolvidos;
  }

  @Override
  public String toString() {
    return "[rodovia = " + rodovia.getNome() + ", vitimasFatais = " + vitimasFatais + ", veiculosEnvolvidos = [\n "
        + veiculosEnvolvidos + "\n]";
  }
}
