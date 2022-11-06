package fr.uvsq.cprog.collex;

public class DnsItem {
    private AdresseIP adresseIP ;
    private NomMachine nomMachine ;

    public DnsItem(NomMachine nomMachine, AdresseIP adresseIP){
        this.nomMachine = nomMachine ;
        this.adresseIP = adresseIP ;

    }

    public AdresseIP getAdresseIP() {
        return adresseIP;
    }

    public NomMachine getNomMachine() {
        return nomMachine;
    }
    @Override
    public String toString() {
        return this.nomMachine + " " + this.adresseIP ;
    }
}
