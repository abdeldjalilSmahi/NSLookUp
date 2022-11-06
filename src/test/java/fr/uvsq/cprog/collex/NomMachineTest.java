package fr.uvsq.cprog.collex;
import static org.junit.Assert.* ;
import org.junit.Test;

public class NomMachineTest {

    @Test
    public void InstantiateNotValidNomMachineTest(){
        assertThrows(IllegalArgumentException.class,()->new NomMachine("machine1.jalil.smahi."));

    }
    @Test
    public void testEqualse(){
        NomMachine nomMachine1 = new NomMachine("machine1.jalil.smahi");
        NomMachine nomMachine2 = new NomMachine("machine1.jalil.smahi");
        assertEquals(nomMachine1,nomMachine2);
    }


}
