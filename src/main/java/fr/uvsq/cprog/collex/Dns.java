package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Dns {
    private List<DnsItem> dnsItems ;
    private Configuration configuration ;
    private final String configurationPath = "config.properties";
    /*
    Constructeur qui prend en charge le chargement de la base de données
     */
    public Dns(){

        try {
            this.configuration = new Configuration(configurationPath);
            this.dnsItems = this.configuration.reLoadDatabase();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    /*
    On definit deux méthodes getItem qui sera rechargé une fois en passant une adresseIp autre fois en passant nomMachine
     */
    public DnsItem getItem(AdresseIP adresseIP){
        return this.dnsItems.stream()
                .filter(dnsItem -> dnsItem.getAdresseIp().equals(adresseIP))
                .findFirst()
                .orElse(null);
    }

    public DnsItem getItem(NomMachine nomMachine){
        return this.dnsItems.stream()
                .filter(dnsItem -> dnsItem.getNomMachine().equals(nomMachine) )
                .findFirst()
                .orElse(null);
    }
    /*
    la méthode getItems , prend un String qui est un nom du domaine
    ici on utilise la méthode static pour valider que c'est un nom domaine
     */
    public List<DnsItem> getItems(String nomDomaine){
        if(!NomMachine.isValidNomDomaine(nomDomaine)){
            throw new IllegalArgumentException("un nom du domaine invalide");
        }
        return this.dnsItems.stream()
                .filter(dnsItem -> dnsItem.getNomMachine().getNomDomaine().equals(nomDomaine))
                .collect(Collectors.toList());

    }
    /*
    La méthode add item
     */
    public void addItem(NomMachine nomMachine, AdresseIP adresseIP) throws IOException {
        if(this.getItem(nomMachine)!= null){
            throw new IllegalArgumentException("ce nom qualifié existe deja ");

        }
        if(this.getItem(adresseIP)!=null){
            throw new IllegalArgumentException("cette adresse ip existe deja");
        }
        DnsItem dnsItem = new DnsItem(nomMachine, adresseIP);
        this.configuration.saveChanges(dnsItem);
        this.dnsItems = configuration.reLoadDatabase();

    }
}
