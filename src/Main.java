import java.util.*;
public class Main {
    /*punto d'inizio dell applicazione
    * thread padre*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cavallo fulmine = new Cavallo("Fulmine");
        Cavallo lampo = new Cavallo("Lampo");
        Cavallo rose = new Cavallo("Rose");
        Cavallo margherita = new Cavallo("Margherita");
        Cavallo rambo = new Cavallo("Rambo");
        System.out.println("Di quanto lo vuoi fare andare lento 'fulmine'?");
        fulmine.setLentezza(scanner.nextInt());
        System.out.println("Di quanto lo vuoi fare andare lento 'lampo'?");
        lampo.setLentezza(scanner.nextInt());
        System.out.println("Di quanto lo vuoi fare andare lento 'rose'?");
        rose.setLentezza(scanner.nextInt());
        System.out.println("Di quanto lo vuoi fare andare lento 'margherita'?");
        margherita.setLentezza(scanner.nextInt());
        System.out.println("Di quanto lo vuoi fare andare lento 'rambo'?");
        rambo.setLentezza(scanner.nextInt());

        rose.setPriority(Thread.MAX_PRIORITY);
        fulmine.setPriority(Thread.MIN_PRIORITY);

        fulmine.start();
        lampo.start();
        rose.start();
        margherita.start();
        rambo.start();
    }
}