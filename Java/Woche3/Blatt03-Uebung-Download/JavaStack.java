import java.util.Stack;

/* Programm, welches einen einfachen Stack implementiert */
/* In dieser Teilaufgabe soll nun Ihre Lösung aus der vorherigen Teilaufgabe vereinfacht werden, indem Sie die bereits existierende Datenstruktur Stack verwenden und Stacks nicht selber mithilfe von Arrays implementieren. Insbesondere müssen Sie die Größe nicht mehr verändern oder speichern. Dies geschieht bereits intern in der Implementation der Java-Stacks.*/
public class JavaStack {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>();

    String operation = "";
    while (!operation.equals("STOP")) {
      operation = SimpleIO.getString("Bitte geben Sie eine Operation (PUSH, POP, CLEAR, PRINT, STOP) ein:");

      switch (operation) {
        case "PUSH" -> {
          String newElement = SimpleIO.getString("Geben Sie ein zu speicherndes Element ein:");
          stack.push(newElement);
        }
        case "POP" -> {
          if (stack.size() > 0) stack.pop();
        }
        case "CLEAR" -> stack.clear();
        case "PRINT" -> {
          String result = "Stack: " + stack.toString();

          if (stack.size() == 0) result = "Stack ist leer";

          SimpleIO.output(result);
        }
        case "STOP" -> {
          String result = "Stack: " + stack.toString();

          if (stack.size() == 0) result = "Stack ist leer";

          SimpleIO.output(result);
          return;
        }
//Falsche Eingaben->Fehlermeldung, erneut Operation eingeben
        default -> {
          SimpleIO.output("Invalide Operation! Versuchen Sie es bitte erneut!");
          continue;
        }
      }
    }
  }
}