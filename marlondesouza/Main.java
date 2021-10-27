package acidentesRodovias;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
  private static ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
  private static ArrayList<Acidente> acidentes = new ArrayList<Acidente>();

  public Main() {
  }

  public static void main(String[] args) {
    String menu = "1 - Cadastrar rodovia\n" + "2 - Cadastrar acidentes\n" + "3 - Listar acidentes\n"
        + "4 - Listar rodovia com mais acidentes fatais\n" + "5 - Listar acidentes por rodovia\n" + "6 - Sair";

    int opcao = 0;

    do {
      opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

      switch (opcao) {
      case 1:
        Rodovia rodovia = new Rodovia();
        rodovia.cadastra();
        rodovias.add(rodovia);
        break;

      case 2:
        if (rodovias.size() == 0) {
          JOptionPane.showMessageDialog(null, "Você precisa cadastrar ao menos uma rodovia");
        } else {
          int qntAcidente = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos acidentes ira cadastrar?"));

          for (int i = 1; i <= qntAcidente; i++) {
            Acidente acidente = new Acidente();
            String nomeRodovia = JOptionPane.showInputDialog(null,
                "Digite o nome da rodovia onde ocorreu o acidente " + i);

            for (Rodovia r : rodovias) {
              if (r.getNome().equalsIgnoreCase(nomeRodovia)) {
                acidente.cadastra(r);
                acidentes.add(acidente);
              }
            }

          }
        }

        break;

      case 3:
        exibeAcidentesComCondutorEmbriagado();
        break;

      case 4:
        exibeRodoviaComMaisAcidentesFatais();
        break;

      case 5:
        exibeQuantidadeAcidentesPorRodovia();
        break;

      default:
        opcao = 6;
        break;
      }
      System.out.println(acidentes);
    } while (opcao != 6);
  }

  public static void exibeAcidentesComCondutorEmbriagado() {
    String acidentesComCondutorEmbriagado = "";

    for (Acidente acidente : acidentes) {
      if (acidente.isAlgumCondutorEmbriagado()) {
        acidentesComCondutorEmbriagado += acidente + "\n\n";
      }
    }
    JOptionPane.showMessageDialog(null, acidentesComCondutorEmbriagado);

  }

  public static void exibeRodoviaComMaisAcidentesFatais() {

    String rodoviaComMaisAcidentesFatais = "";
    int qntAcidentesRodoviaComMaisVitimasFatais = 0;

    for (Rodovia rodovia : rodovias) {
      int qntAcidenteComVitimasFatais = 0;

      for (Acidente acidente : acidentes) {
        if (acidente.getRodovia().getNome() == rodovia.getNome() && acidente.getVitimasFatais() > 0) {
          qntAcidenteComVitimasFatais++;
        }
      }

      if (qntAcidenteComVitimasFatais > qntAcidentesRodoviaComMaisVitimasFatais) {
        rodoviaComMaisAcidentesFatais = rodovia.getNome();

        qntAcidentesRodoviaComMaisVitimasFatais = qntAcidenteComVitimasFatais;
      }
    }
    JOptionPane.showMessageDialog(null,
        "A rodovia " + rodoviaComMaisAcidentesFatais + " teve mais acidentes com vitimas fatais, quantidade de "
            + qntAcidentesRodoviaComMaisVitimasFatais + " acidentes");
  }

  public static void exibeQuantidadeAcidentesPorRodovia() {
    ArrayList<String> nomeRodovias = new ArrayList<String>();
    ArrayList<Integer> qntAcidentesRodovias = new ArrayList<Integer>();

    for (int i = 0; i < rodovias.size(); i++) {
      String nomeRodovia = rodovias.get(i).getNome();

      for (Acidente acidente : acidentes) {
        if (nomeRodovia == acidente.getRodovia().getNome()) {
          if (nomeRodovias.contains(nomeRodovia)) {
            qntAcidentesRodovias.set(i, qntAcidentesRodovias.get(i) + 1);
          } else {
            nomeRodovias.add(nomeRodovia);
            qntAcidentesRodovias.add(i);
          }
        }
      }
    }

    String mensagem = "";

    for (int i = 0; i < nomeRodovias.size(); i++) {
      mensagem += "Rodovia " + nomeRodovias.get(i) + ": " + qntAcidentesRodovias.get(i) + "\n";
    }

    JOptionPane.showMessageDialog(null, mensagem);
  }
}
