package fr.uvsq.cprog.collex;

public class CmdErrone implements Command {

  /*
  En cas ou user passe une commande inconnue exemple "blalblalaa"
  on doit lui retourner un message d'erreur
  d'ou la nécissité de créer cette classe
   */
  private String cmd;

  public CmdErrone(String cmd) {
    this.cmd = cmd;
  }

  @Override
  public String execute() {
    return "Ouppsss! une commande non interprétable";
  }
}
