//by mschro67

package h1;

import java.util.Scanner;

public class h1_main{
    public static void main(String[] args){

        Scanner s=new Scanner(System.in);

        Patient a=new Patient("A",0),
                b=new Patient("B",-1),
                c=new Patient("C",1);

        PrioListe prios=new PrioListe();

        prios.addPatient(a);
        prios.addPatient(b);
        prios.addPatient(c);

        System.out.println("- Patienten hinzufügen -");
        System.out.print("Patienten: ");
        int patienten=Integer.parseInt(s.nextLine());
        System.out.println();
        for (int x=0;x<patienten;x++) {
            System.out.print("Name von Patient "+(x+1)+": ");
            String name=s.nextLine();
            System.out.print("Prio von Patient "+(x+1)+": ");
            int prio=Integer.parseInt(s.nextLine());
            System.out.println();
            prios.addPatient(name,prio);
        }

        System.out.println("- Position finden -");
        /*System.out.print("Name: ");
        String NAME=s.nextLine();
        System.out.print("Prio: ");
        int PRIO=Integer.parseInt(s.nextLine());
        System.out.print(NAME+", "+PRIO+": ");*/
        System.out.println("Index von c: "+prios.getPosition(c));

        s.close();

        System.out.println();
        System.out.println("- Patienten -");
        while (prios.getLänge()>0){
            Patient patient=prios.getNextPatient();
            System.out.println(patient.getName()+", "+patient.getPrio());
        }
    }
}
