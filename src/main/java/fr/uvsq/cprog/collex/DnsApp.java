package fr.uvsq.cprog.collex;

import java.util.Scanner;

/**
 * Class DnsAPp résonsable des intéractions avec le client.
 */
public class DnsApp {

  private Dns dns;
  private String cmd;
  private DnsTUI dnsTUI;
  private boolean quit = false;

  public DnsApp(Dns dns) {
    this.dns = dns;
  }

  /**
   * La méthode résponsable avec les interactions utilisateurs.
   * Réccupère leurs entrées.
   * Selon l'entrée elle décide quel Command doit Invoquer "Principe du Command Design pattern".
   * {@link DnsTUI} joue le role de "the invoquer".
   */
  public void run() {
    System.out.println("Bonjour, Je suis NS-Lookup\n"
        + "Pour \"exit\" tappez quitter");
    while (!quit) {

      System.out.println("-----------------------------");
      try {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        this.cmd = sc.nextLine();
        dnsTUI = new DnsTUI(dns, cmd);
        Command command = dnsTUI.nextCommand(cmd);
        String result = dnsTUI.afficher(command);
        if (result == "exit") {
          quit = true;
        }
        System.out.println("> " + result);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

    }
  }

}
