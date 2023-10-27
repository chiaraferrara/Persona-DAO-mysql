
import dao.ConcretePersonaDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean exit = false;
        int scelta = 0;
        while (exit == false) {
            System.out.println("Benvenuto, cosa vorresti fare?");
            System.out.println("1) Aggiunti persona");
            System.out.println("2) Aggiorna la mail di una persona");
            System.out.println("3) Aggiorna il numero di telefono di una persona");
            System.out.println("4) Lista delle persone.");
            System.out.println("5) Elimina persona");
            System.out.println("6) Esci");
            System.out.println("Inserisci il numero della tua scelta");
            Scanner s = new Scanner(System.in);
            scelta = s.nextInt();

            switch (scelta) {
                case 1:
                    ConcretePersonaDAO.add();
                    break;
                case 2:
                    ConcretePersonaDAO.updateEmail();
                    break;
                case 3:
                    ConcretePersonaDAO.updateTel();
                    break;
                case 4:
                    ConcretePersonaDAO.readPersona();
                    break;
                case 5:
                    ConcretePersonaDAO.delete();
                    break;
                case 6:
                    exit= true;
                    break;

            }
        }
    }
}