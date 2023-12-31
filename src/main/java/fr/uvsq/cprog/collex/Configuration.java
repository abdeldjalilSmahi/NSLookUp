package fr.uvsq.cprog.collex;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * On se basant sur le principe single reponsability, nous créons une classe qui se charge de lire
 * le fichier propreties et se base aussi de la lecture et l'écriture sur la base de données.
 */

public class Configuration implements IValidator {

  /**
   * déclaration de l'attribut databasePath qui represente le chemin du fichier txt.
   */
  private String databasePath;

  /**
   * Constructeur de la classe
   *
   * @param pathConfiguration le chemin du fichier de configuration.
   * @throws IOException
   */
  public Configuration(String pathConfiguration) throws IOException {
    validate(pathConfiguration);
    FileInputStream inputStream = new FileInputStream(pathConfiguration);
    Properties properties = new Properties();
    properties.load(inputStream);
    databasePath = new File(properties.getProperty("database_path")).getAbsolutePath();

  }

  /**
   * @return le chemin de la base de données  databasePath
   */
  private String getDatabasePath() {
    return this.databasePath;
  }

  /**
   * La méthode qui lit le fichier text
   */
  public List<DnsItem> reLoadDatabase() throws IOException {
    List<DnsItem> dnsItemList = new ArrayList<>();
    List<String> list;
    Path path = Paths.get(this.getDatabasePath());

    list = Files.readAllLines(path);
    list.forEach(thing -> {
      String[] dnsItemAsString = thing.split("\\s+");
      NomMachine nomMachine = new NomMachine(dnsItemAsString[0]);
      AdresseIP adresseIP = new AdresseIP(dnsItemAsString[1]);
      DnsItem currentDnsItem = new DnsItem(nomMachine, adresseIP);
      dnsItemList.add(currentDnsItem);

    });
    return dnsItemList;
  }

  /*
   * une méthode qui gére l'écriture
   */
  public void saveChanges(DnsItem dnsItem) throws IOException {
    FileWriter fileWriter = new FileWriter(this.getDatabasePath(), true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.append(dnsItem + "\n");
    bufferedWriter.close();

  }

  /**
   * Implémentation de la méthode validate de l'interface {@link IValidator}.
   *
   * @param str
   */
  @Override
  public void validate(String str) {
    if (!isValidPath(str)) {
      throw new IllegalArgumentException("Invalide path");
    }

  }

  /**
   * Méthode qui vérifie si le chemin est valide ou pas.
   *
   * @param path
   * @return
   */
  private static boolean isValidPath(String path) {
    try {
      Paths.get(path);
    } catch (InvalidPathException | NullPointerException ex) {
      return false;
    }
    return true;
  }
}
