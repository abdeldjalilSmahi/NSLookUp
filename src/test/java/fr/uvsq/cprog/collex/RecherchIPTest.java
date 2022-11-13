package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;

import org.junit.*;

public class RecherchIPTest {

  @Test
  public void TestNullPointerDnsConstructor() {
    Dns dns = null;
    assertThrows(NullPointerException.class, () -> new RecherchIP(dns, "192.168.1.2"));
  }

  @Test
  public void rechercherUnNomMachineByIpTest() {
    Dns dns = new Dns();
    RecherchIP recherchIP = new RecherchIP(dns,"193.151.25.12");
    assertEquals("ecampus.uvsq.fr",recherchIP.execute());
  }

}
