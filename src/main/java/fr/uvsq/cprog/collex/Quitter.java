package fr.uvsq.cprog.collex;

public class Quitter implements Command {

  private Dns dns;

  public Quitter(Dns dns) {
    this.dns = dns;
  }

  @Override
  public String execute() {
    return "exit";
  }
}
