package fr.uvsq.cprog.collex;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RechercheLs implements Command, IValidator {

  private Dns dns;
  private boolean orderByIp;
  private String nomDomaine;
  private String cmd;

  public RechercheLs(Dns dns, String cmd) {
    validate(cmd);
    this.dns = dns;

  }

  /*
  l'implémentation de la méthode execute
   */
  @Override
  public String execute() {
    List<DnsItem> dnsItems = dns.getItems(nomDomaine);
    if (orderByIp) {
//            dnsItems.sort((dns1,dns2)->dns1.getAdresseIP().toString().compareToIgnoreCase(dns2.getAdresseIP().toString()));
      Collections.sort(dnsItems, Comparator.comparing(o -> o.getAdresseIp().toString()));
    } else {
//            dnsItems.sort((dns1,dns2)->dns1.getNomMachine().toString().compareToIgnoreCase(dns2.getNomMachine().toString()));
      Collections.sort(dnsItems, new Comparator<DnsItem>() {
        @Override
        public int compare(DnsItem o1, DnsItem o2) {
          return o1.getNomMachine().toString().compareTo(o2.getNomMachine().toString());
        }
      });
    }
    List<String> dnsItemStrings = dnsItems.stream().map(dnsItem -> dnsItem.toString()).collect(Collectors.toList());
    return String.join("\n", dnsItemStrings);
  }

  /**
   * et de retour avec les vérification, supposons que l'utilisateur passe la commande ls uvsq.fr cette requette qui commence par ls, en splitant ce string par rapport aux espaces le tableau resultant doit contenir au moins deux elments ' car il y'a le cas de -a' si la longeur du tableau est inférieur à 2 une exception est levée. on traite par la suite les cas, si il y a 2 elements est ce que l'element 1 du tableau 'tab[1]' est un nom du domaine valide rappelant qu'on a exposé une méthode static dans la classe NomMachine qui se charge de faire ça. et vice vers ça
   */
  @Override
  public void validate(String cmd) {
    String[] array = cmd.split("\\s+");
    if (array.length < 2) {
      throw new IllegalArgumentException("Une commande erroné");
    }
    if (array.length == 2) {
      if (!(NomMachine.isValidNomDomaine(array[1]))) {
        throw new IllegalArgumentException("Un nom du domaine invalide");

      } else {
        this.nomDomaine = array[1];
        orderByIp = false;
        return;

      }
    }
    /**
     * on traite le cas ls -a uvsq.fr
     */
    if (array.length == 3) {
      if (array[1].equals("-a")) {
        if (!(NomMachine.isValidNomDomaine(array[2]))) {
          throw new IllegalArgumentException("Un nom du domaine invalide");
        } else {
          this.nomDomaine = array[2];
          this.orderByIp = true;
          return;
        }

      }
    }
    if (array.length > 3) {
      throw new IllegalArgumentException("Une commande erroné");
    }

  }
}
