package fr.uvsq.cprog.collex;

public class DnsTUI {
    private Command command ;
    private Dns dns;
    private String cmd;
    public DnsTUI(Dns dns, String cmd){
        this.cmd = cmd;
        this.dns  = dns ;

    }
    public Command nextCommand(String cmd){
        if(AdresseIP.isValidIpAddress(cmd)){
            this.command = new RecherchIP(dns, cmd);
        }
        if(NomMachine.isValidNomMachine(cmd)){
            this.command = new RechercheNomMachine(dns, cmd);
        }

        if(cmd.startsWith("add")){
            this.command = new AjouterItem(dns, cmd);
        }
        if(cmd.startsWith("ls")){
            this.command = new RechercheLs(dns, cmd);
        }
        if(cmd.equals("exit")){
            this.command = new Quitter(dns);
        }
        if(!AdresseIP.isValidIpAddress(cmd) && !NomMachine.isValidNomMachine(cmd) && !cmd.startsWith("add") && !cmd.startsWith("ls")&& !cmd.equals("exit")){
            this.command = new CmdErrone(cmd);
        }
        return this.command ;

    }
    public String afficher(Command command){
        return command.execute();
    }

}
