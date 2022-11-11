package fr.uvsq.cprog.collex;

/**
 * Classe {@link DnsItem} responsable de la composition des {@link AdresseIP} et {@link NomMachine}.
 */
public class DnsItem {

  private AdresseIP adresseIp;
  private NomMachine nomMachine;

  public DnsItem(NomMachine nomMachine, AdresseIP adresseIp) {
    this.nomMachine = nomMachine;
    this.adresseIp = adresseIp;

  }

  public AdresseIP getAdresseIp() {
    return adresseIp;
  }

  public NomMachine getNomMachine() {
    return nomMachine;
  }

  @Override
  public String toString() {
    return this.nomMachine + " " + this.adresseIp;
  }
}
