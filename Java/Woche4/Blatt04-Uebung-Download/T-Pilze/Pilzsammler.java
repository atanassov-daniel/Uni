public class Pilzsammler {
  String name;
  Pilz[] korb;
  int anzahl = 0;

  public Pilz[] sammlePilze(Pilz... pilze) {
    // TODO d)
    Pilz[] res;
    if (pilze.length - (korb.length - anzahl) >= 0) {
      res = new Pilz[pilze.length - (korb.length - anzahl)];
    } else {
      res = new Pilz[0];
    }
    int resIndex = 0;
    for (int i = 0; i < pilze.length; i++) {
      if (hatPlatz()) {
        korb[anzahl] = pilze[i];
        anzahl++;
        System.out.println(name + " sammelt einen " + pilze[i].art.toString());
      } else {
        res[resIndex] = pilze[i];
        resIndex++;
        System.out.println(name + " hat ekine Platz mehr fur einen " + pilze[i].art);
      }
    }
    return res;
  }

  public boolean hatPlatz() {
    return anzahl < korb.length;
  }

  public void ausgabe() {
    System.out.printf("%s (%d):%n", name, anzahl);
    for (Pilz pilz : korb) {
      if (pilz != null) {
        System.out.println(pilz.art.toString());
      } // nur die Art des Pilyes muss ausgegeben werten
    }
  }
}
