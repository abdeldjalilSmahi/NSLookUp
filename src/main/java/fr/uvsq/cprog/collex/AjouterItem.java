package fr.uvsq.cprog.collex;

import java.io.IOException;

public class AjouterItem implements Command, IValidator {

  private AdresseIP adresseIP;
  private NomMachine nomMachine;
  private Dns dns;

  public AjouterItem(Dns dns, String cmd) {
    validate(cmd);
    this.dns = dns;
  }

  @Override
  public String execute() {
    try {
      this.dns.addItem(this.nomMachine, this.adresseIP);
      return "ajouté avec succès";
    } catch (IOException e) {
      return e.getMessage();
    }
  }

  @Override
  public void validate(String cmd) {
    String[] array = cmd.split("\\s+");
    if (array.length < 3) {
      throw new IllegalArgumentException("commande add erronée");
    }
    if (array.length == 3) {
      if (!(AdresseIP.isValidIpAddress(array[1]))) {
        throw new IllegalArgumentException("une adresse ip invalide");

      }
      if (!(NomMachine.isValidNomMachine(array[2]))) {
        throw new IllegalArgumentException("un nom machine qualifié invalide");
      }
      this.adresseIP = new AdresseIP(array[1]);
      this.nomMachine = new NomMachine(array[2]);


    }

  }
}
