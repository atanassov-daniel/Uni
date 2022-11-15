public class Main {
  public static void main(String[] args) {
    Pilz steinpilz1 = new Pilz();
    steinpilz1.art = Pilzart.STEINPILZ;

    Pilz steinpilz2 = new Pilz();
    steinpilz2.art = Pilzart.STEINPILZ;// TODO a.1)

    Pilz champignon = new Pilz();
    champignon.art = Pilzart.CHAMPIGNON;// TODO a.1)

    Pilz pfifferling = new Pilz();
    pfifferling.art = Pilzart.PFIFFERLING;

    Pilzsammler pettersson = new Pilzsammler();
    pettersson.name = "Pettersson";
    pettersson.korb = new Pilz[8];

    Pilzsammler findus = new Pilzsammler();
    findus.name = "Findus";
    findus.korb = new Pilz[7];

    // TODO e)
    Pilz[] uebrigePilze = findus.sammlePilze(steinpilz1, steinpilz2, champignon, pfifferling);
    pettersson.sammlePilze(uebrigePilze);
    findus.ausgabe();
    pettersson.ausgabe();
    System.out.println("---");
    while (findus.hatPlatz() || pettersson.hatPlatz()) {
      Pilz[] neueLichtung = Pilz.Pilzlichtung();
      uebrigePilze = findus.sammlePilze(neueLichtung);
      pettersson.sammlePilze(uebrigePilze);
      findus.ausgabe();
      pettersson.ausgabe();
      System.out.println("---");
    }
  }
}
