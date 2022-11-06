package fr.uvsq.cprog.collex;

public class NomMachine implements IValidator{
    private String nomMachine;
    private String nomDomaine ;
    private String nomQualifie ;

    public NomMachine(String nomMachine){
        /*
        toujours on fait des validation avant l'instanciation
         */
        validate(nomMachine);
        this.nomMachine = nomMachine ;
        parserNomMachine();
    }

    public String getNomMachine() {
        return nomMachine;
    }


    /*
    cette methode interne nous servira d'extraire le nom machine 'avant le premier point'
    et le nom du domaine après le premier point
     */

    private void parserNomMachine(){
        String[] parser = this.getNomMachine().split("\\.",2);
        this.nomQualifie = parser[0];
        this.nomDomaine = parser[1];
    }

    /*
    On expose un méthodes qui peremet de retourner le nome du machine ' avant premier point '
    en se basant sur la méthode privé implémentée ci-dessus.
     */
    public String getMachine(){
        return this.nomMachine;
    }
    /*
    On expose aussi un méthode qui permet de retourner le nom du domaine.
     */

    public String getNomDomaine(){
        return this.nomDomaine ;

    }
    /*
    On dote notre classe d'une méthode static qui nous permettera de valider si nom du domaine est valide
     */

    public static boolean isValidNomDomaine(String nomDomaine){
        if(nomDomaine.startsWith(".")){
            return false ;
        }
        if(nomDomaine.endsWith(".")){
            return false ;
        }
        if(nomDomaine.split("\\.").length !=2){
            return false ;
        }
        return true ;

    }

    /*
        Cette méthode verifie si la saisie est un nom qualifié de machine "nom.qualifié.machine"
        static parceque va nous servir par la suite si on veut faire des validation sans instancier un objet
        comme verificiation des entrées du User
         */
    public static boolean isValidNomMachine(String nomMachine){
        if(nomMachine.startsWith(".")){
            return false;
        }
        if(nomMachine.endsWith(".")){
            return false;

        }
        if(nomMachine.split("\\.").length != 3){
            return false;
        }
        return true ;
    }
    /*
    l'implementation de notre validator ;
     */

    @Override
    public void validate(String str) {
        if(!isValidNomMachine(str)){
            throw new IllegalArgumentException(nomMachine+ " n'est pas un nomMachine qualifié valide");
        };
    }
    /*
    redefinition de la méthode toString
     */
    @Override
    public String toString() {
        return this.getNomMachine();
    }
    /*
    redefintion de la méthode equals

     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null){
            return false;
        }

        if (!(obj instanceof NomMachine)) {
            return false;
        }

        if (obj == this){
            return true;
        }
        NomMachine machine1 = (NomMachine) obj;
        String nomMachine = machine1.getNomMachine();
        return this.nomMachine.equals(nomMachine);
    }
}
