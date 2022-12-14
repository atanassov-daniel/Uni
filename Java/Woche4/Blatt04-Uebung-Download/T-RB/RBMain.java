
public class RBMain {
  public static void main (String [] arguments) {
    /* Wand: #
     * Eingang: 0
     * Ausgang: @
     * Energie: -
     */
    String [] map = {"#######",
                     "#0   -#",
                     "##### #",
                     "#####@#",
                     "#######"};
    String [] program = {"for 0 2", "for 1 3", "move", "endfor 1",
                                    "turnRight", "turnRight",
                         "endfor 0"};

    String [] program2 = {"for 0 2", "for 1 3", "move", "endfor 1",
                                     "pickUp", "turnRight",
                          "endfor 0"};
    
    // Beginn TODO
    RB myRB = null;

    int checkResult = -1;
    // Ende TODO
    if( checkResult >= 0) {
      System.out.println("Programm hochgeladen.");
      Room myRoom = new Room();
      myRoom.setMap(map);
      myRoom.runRB(myRB);
    } else if (checkResult == -1 ) {
      System.out.println("Syntaxfehler");
    } else {
      System.out.println("Zu viele Kommandos");
    }
  }
}
