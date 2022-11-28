import java.util.*;

public class Spielverwaltung {
  
  public static Spieler[] generiereClub(int spieleranzahl) {
    Spieler [] club = new Spieler[spieleranzahl];
    for (int i = 0; i < spieleranzahl; ++i) {
      club[i] = new Spieler();
      club[i].name = "Spieler " + i;
    }
    return club;
  }
  
  public static void gibKarten(Spieler[] club, Karte[] stapel) {
    Collections.shuffle(Arrays.asList(stapel));
    for (int i = 0; i < club.length; ++i) {
      //System.out.println("Gib die ersten beiden Karten an Spieler " + i);
      club[i].kartenhand = new Karte[4];
      club[i].kartenhand[0] = stapel[2*i];
      club[i].kartenhand[1] = stapel[2*i + 1];
      club[i].kartenanzahl += 2;
    }
    for (int i = 0; i < club.length; ++i) {
      //System.out.println("Gib die naechsten beiden Karten an Spieler " + i);
      club[i].kartenhand[2] = stapel[2*club.length + 2*i];
      club[i].kartenhand[3] = stapel[2*club.length + 2*i + 1];
      club[i].kartenanzahl += 2;
    }
  }
  
}