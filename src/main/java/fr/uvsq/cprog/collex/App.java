package fr.uvsq.cprog.collex;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    try {
      Dns dns = new Dns();
      DnsApp dnsApp = new DnsApp(dns);
      dnsApp.run();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }


  }
}
