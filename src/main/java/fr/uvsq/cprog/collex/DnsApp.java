package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsApp {

  private Dns dns;
  private String cmd;
  private DnsTUI dnsTUI;
  private boolean quit = false;

  public DnsApp(Dns dns) {
    this.dns = dns;

  }

  public void run() {
    System.out.println("\n"
        + "     _______..___  ___.      ___       __    __   __     .__   __.      _______.        __        ______     ______    __  ___  __    __  .______   \n"
        + "    /       ||   \\/   |     /   \\     |  |  |  | |  |    |  \\ |  |     /       |       |  |      /  __  \\   /  __  \\  |  |/  / |  |  |  | |   _  \\  \n"
        + "   |   (----`|  \\  /  |    /  ^  \\    |  |__|  | |  |    |   \\|  |    |   (----` ______|  |     |  |  |  | |  |  |  | |  '  /  |  |  |  | |  |_)  | \n"
        + "    \\   \\    |  |\\/|  |   /  /_\\  \\   |   __   | |  |    |  . `  |     \\   \\    |______|  |     |  |  |  | |  |  |  | |    <   |  |  |  | |   ___/  \n"
        + ".----)   |   |  |  |  |  /  _____  \\  |  |  |  | |  |    |  |\\   | .----)   |          |  `----.|  `--'  | |  `--'  | |  .  \\  |  `--'  | |  |      \n"
        + "|_______/    |__|  |__| /__/     \\__\\ |__|  |__| |__|    |__| \\__| |_______/           |_______| \\______/   \\______/  |__|\\__\\  \\______/  | _|      \n"
        + "                                                                                                                                                    \n");
    while (!quit) {
      System.out.println("-----------------------------");
      try {
        Scanner sc = new Scanner(System.in);
        this.cmd = sc.nextLine();
        dnsTUI = new DnsTUI(dns, cmd);
        Command command = dnsTUI.nextCommand(cmd);
        String result = dnsTUI.afficher(command);
        if (result == "exit") {
          System.out.println(result);
          quit = true;
        }
        System.out.println(result);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }


    }

  }

}
