package fr.uvsq.cprog.collex;

public class RecherchIP implements Command {

  private Dns dns;
  private AdresseIP adresseIP;

  public RecherchIP(Dns dns, String cmd) {
    if (dns == null) {
      throw new NullPointerException("pas du dns");
    }
    this.dns = dns;
    this.adresseIP = new AdresseIP(cmd);

  }

  @Override
  public String execute() {
    try {
      DnsItem dnsItem = dns.getItem(this.adresseIP);
      if (dnsItem == null) {
        return "non trouvé";
      } else {
        return dnsItem.getNomMachine().toString();
      }

    } catch (Exception e) {
      return "Une erreur est survenue";
    }
  }


}
