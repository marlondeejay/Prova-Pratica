package acidentesRodovias;

import javax.swing.JOptionPane;

public class Veiculo {
  private int anoFabricacao = -1;
  private Condutor condutor = new Condutor();

  public void cadastra(int numeroVeiculo) {
    setAnoFabricacao(
        Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de fabricação do veiculo" + numeroVeiculo)));
    condutor.cadastra();
    setCondutor(condutor);
  }

  public boolean getCondutorEmbriagado() {
    return condutor.isEmbriagado();
  }

  public int getAnoFabricacao() {
    return anoFabricacao;
  }

  public void setAnoFabricacao(int anoFabricacao) {
    this.anoFabricacao = anoFabricacao;
  }

  public Condutor getCondutor() {
    return condutor;
  }

  public void setCondutor(Condutor condutor) {
    this.condutor = condutor;
  }

  @Override
  public String toString() {
    return "{ anoFabricacao=" + anoFabricacao + ", condutor = " + condutor + " }";
  }

}
