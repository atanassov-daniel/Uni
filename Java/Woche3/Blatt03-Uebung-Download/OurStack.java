/* Programm, welches einen einfachen Stack implementiert */
public class OurStack {
  //* Mit PUSH kann ein Element oben auf den Stapel hinzugefügt werden, mit POP hingegen wird das oberste Element entfernt
  public static void main(String[] args) {
    // Einlesen der nicht-negative Groesse
    int size;
    do {
      size = SimpleIO.getInt("Bitte geben Sie die initiale (nicht negative) Groesse ein:");
    } while (size < 0);
    // Stack mit der Groesse size initialisieren
    String[] stack = new String[size];
    int currentSize = 0;

    String operation = "";
    while (!operation.equals("STOP")) {
      operation = SimpleIO.getString("Bitte geben Sie eine Operation (PUSH, POP, CLEAR, SETSIZE, PRINT, STOP) ein:");

      switch (operation) {
        case "PUSH" -> {
          if (currentSize < stack.length) {
            stack[currentSize] = SimpleIO.getString("Geben Sie ein zu speicherndes Element ein:");
            currentSize++;
          } else {
            SimpleIO.output("Stack ist voll.");
          }
        }
        case "POP" -> {
          //* sollte ich auch stack[currentSize-1]=null; setzen oder nicht
          if (currentSize > 0) currentSize--;
        }
        case "CLEAR" -> {
          currentSize = 0;
          //* maybe do a loop and delete all elements
        }
        case "SETSIZE" -> {
          // neue Groeße einlesen
          int sizeNew;
          do {
            sizeNew = SimpleIO.getInt("Bitte geben Sie die (nicht negative) Groesse ein:");
          } while (sizeNew < 0);
          // initialisiere ein neues Stack mit der Groese sizeNew
          String[] stackNew = new String[sizeNew];
          // kopiere die ersten (d.h. zuerst eingefügten) min(currentSize; size)-Elemente vom alten Stack ins neue Stack
          //* update the size of the new stack to the new actual size
          currentSize = Math.min(currentSize, size);
          for (int i = 0; i < currentSize; i++) {
            stackNew[i] = stack[i];
          }
          // ersetze das ursprüngliche Array stack durch das neue Array stackNew
          stack = stackNew;
        }
        case "PRINT" -> {
          String result = "";

          if (currentSize == 0) result = "Stack ist leer";

          for (int i = 0; i < currentSize; i++) {
            String el = stack[i];
            if (i == 0) result += "Stack: " + el;
            else result += "," + el;
          }
          SimpleIO.output(result);
        }
        case "STOP" -> {
          //* PRINT ausfuhren und dann Programm beenden
          String result = "";

          if (currentSize == 0) result = "Stack ist leer"; 

          for (int i = 0; i < currentSize; i++) {
            String el = stack[i];
            if (i == 0) result += "Stack: " + el;
            else result += "," + el;
          }
          SimpleIO.output(result);

          return;
        }
        // Bei fehlerhaften Eingaben -> Fehlermeldung und erneute Eingabe einer Operation
        default -> {
          SimpleIO.output("Invalide Operation! Versuchen Sie es bitte erneut!");
          continue;
        }
      }
    }
  }
}