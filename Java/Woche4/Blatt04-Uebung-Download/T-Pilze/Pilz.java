public class Pilz {
  Pilzart art;

  public static Pilz[] Pilzlichtung() {
    Pilzart[] pilzarten = Pilzart.values();
    Pilz[] res = new Pilz[pilzarten.length];
    for (int i = 0; i < pilzarten.length; i++) {
      Pilz pilz = new Pilz();
      pilz.art = pilzarten[i];
      res[i] = pilz;
    }
    // TODO c)
    return res;
  }

}
