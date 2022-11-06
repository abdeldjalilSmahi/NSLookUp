package fr.uvsq.cprog.collex;
import org.apache.commons.validator.routines.InetAddressValidator;


public class AdresseIP implements IValidator{
    private String adresseIP;

    public AdresseIP(String adresseIP) {
        validate(adresseIP);
        this.adresseIP = adresseIP ;

    }

    public String getAdresseIP() {
        return adresseIP;
    }

    /*
    On importe une méthode de l'api commons-validator qui permet de valider les adresses ip
     */
    public static boolean isValidIpAddress(String ipAddress){
        return InetAddressValidator.getInstance().isValidInet4Address(ipAddress);
    }

    /*
    validez si l'utilsateur essaie d'instancier une valide addresse ip
     */

    @Override
    public void validate(String adrIp) {
        if(!(isValidIpAddress(adrIp))){
            throw new IllegalArgumentException(adresseIP + " n'est pas une adresse ip valide" );
        }
    }

    /*
    On redefinit la méthode equals pour simplifier les comparaisons entre adresses ip après .
     */

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(!(obj instanceof AdresseIP)){
            return false;
        }
        if(obj == this){
            return true ;
        }
        AdresseIP adresseIP1 = (AdresseIP) obj;
        String strAdresseIP1 = adresseIP1.getAdresseIP();
        return this.adresseIP.equals(strAdresseIP1);
    }
    /*
    redefinir la methode toString
     */
    @Override
    public String toString(){
        return this.getAdresseIP();
    }
}
