import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestoreCavallo {
    static String primo="";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tmpS;
        int tmp;
        ArrayList<Cavallo> listaCavallo = new ArrayList<Cavallo>();
        for (int i = 1; i <= 4; i++) {
            System.out.println("Inserisci il nome del cavallo " + i);
            tmpS =  input.nextLine();
            System.out.println("Inserisci la lentezza del cavallo " + i);
            tmp = input.nextInt();
            String v = input.nextLine(); //prende il \n
            Cavallo c=new Cavallo(tmpS, tmp);
            listaCavallo.add(c);
        }
        int n = (int) (Math.random() /0.2);
        Cavallo x = listaCavallo.get(n);
        x.interrupt();
        listaCavallo.remove(n);
        
        for(Cavallo c: listaCavallo){
            c.start();
        }
        
        System.out.println("Cavallo azzoppato: "+ x.getNomeCavallo());

        for(Cavallo c: listaCavallo){
            try {
                c.join();
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
        }
        System.out.println("Il primo cavallo: " + primo); 
        //filechooser
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Salva il vincitore");

        int result = chooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                pw.println("Il primo cavallo è: " + primo);
                System.out.println("Risultato salvato correttamente in: " + file.getName());
            } catch (IOException e) {
                System.out.println("Errore durante il salvataggio!");
            }
        }
    }
    public static String getPrimo() {
        return primo;
    }
    public static void setPrimo(String primo) {
        GestoreCavallo.primo = primo;
    }
}
