package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;

import org.junit.*;

public class RechercheNomMachineTest {

  @Test
  public void executeTest(){
    Dns dns = new Dns();
    RechercheNomMachine rechercheNomMachine = new RechercheNomMachine(dns, "www.uvsq.fr");
    assertEquals("193.51.31.90", rechercheNomMachine.execute() );
  }
}
