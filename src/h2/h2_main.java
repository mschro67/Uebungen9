//by mschro67

package h2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class h2_main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("- Passagiere hinzufügen -\nPassagiere am Start: ");
        int a=Integer.parseInt(s.nextLine());
        Bus bus = new Bus();
        for (int x=0;x<a;x++){
            System.out.print("Name von Passagier "+(x+1)+": ");
            String name=s.nextLine();
            System.out.print("Geplante Stationen von "+name+": ");
            int planned=Integer.parseInt(s.nextLine());
            System.out.print("Ticket von "+name+": ");
            Boolean ticket=Boolean.parseBoolean(s.nextLine());
            bus.enterBus(new Passenger(name,planned,ticket));
        }

        System.out.print("\n\n- Stops fahren -\nStops: ");
        int stops=Integer.parseInt(s.nextLine());
        for (int x=0;x<stops;x++){
            System.out.println("\nPassagiere (freiwillig) ausgestiegen bei Stop "+(x+1)+": "+bus.nextStopStr());
            ArrayList<Passenger> keinTicket=bus.findPassengersWithoutTicket();
            String[] entfernt=new String[keinTicket.toArray().length];
            for (int y=0;y<entfernt.length;y++){
                entfernt[x]=keinTicket.get(x).getName();
            }
            System.out.println("Passagiere ohne Ticket: "+Arrays.toString(entfernt));
            System.out.print("Neue Passagiere bei Stop "+(x+1)+": ");
            a=Integer.parseInt(s.nextLine());
            for (int y=0;y<a;y++){
                System.out.print("Name von Passagier "+(bus.getLength()+1)+": ");
                String name=s.nextLine();
                System.out.print("Geplante Stationen von "+name+": ");
                int planned=Integer.parseInt(s.nextLine());
                System.out.print("Ticket von "+name+": ");
                Boolean ticket=Boolean.parseBoolean(s.nextLine());
                bus.enterBus(new Passenger(name,planned,ticket));
            }
            System.out.println("Passagiere: "+Arrays.toString(bus.getNames()));
        }

        s.close();
    }
}