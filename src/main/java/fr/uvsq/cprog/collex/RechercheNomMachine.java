package fr.uvsq.cprog.collex;

import java.security.spec.ECPoint;

public class RechercheNomMachine implements Command{
    private Dns dns;
    private NomMachine nomMachine;
    public RechercheNomMachine(Dns dns, String strNomMachine){
        if (dns == null) {
            throw new NullPointerException("Dns null");
        }
        this.dns = dns ;
        nomMachine = new NomMachine(strNomMachine);

    }

    @Override
    public String execute() {
        try{
            DnsItem item = dns.getItem(this.nomMachine);
            if(item == null){
                return "Not found";
            }
            else{
                return item.getAdresseIP().toString();
            }
        }
        catch (Exception e){
            return "Une erreur est survenue ";
        }
    }
}
