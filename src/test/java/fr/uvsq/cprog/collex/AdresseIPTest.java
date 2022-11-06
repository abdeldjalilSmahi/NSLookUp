package fr.uvsq.cprog.collex;
import static org.junit.Assert.* ;
import  org.junit.*;
public class AdresseIPTest {

    @Test
    public void instantiateThrowErrorIPTest(){
        assertThrows(IllegalArgumentException.class, ()->new AdresseIP("290.290.290.290"));
    }

    @Test
    public void equalsAdresseIpTest(){
        AdresseIP adresseIP1 = new AdresseIP("192.168.1.2");
        AdresseIP adresseIP2 = new AdresseIP("192.168.1.2");
        assertTrue(adresseIP1.equals(adresseIP2));
    }

}
