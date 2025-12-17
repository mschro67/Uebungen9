//by mschro67

package h1;

import java.util.ArrayList;

public class PrioListe{
    private ArrayList<Patient> myList=new ArrayList<Patient>();
    private int länge=0;

    public void addPatient(Patient p){
        ArrayList<Patient> copy=new ArrayList<Patient>();
        if (this.myList.toArray().length==0){
            copy.add(new Patient(p));
        }else{
            byte added=0;
            for (int x=0;x<länge;x++){
                if (p.getPrio()<myList.get(x).getPrio()&&added==0){
                    copy.add(new Patient(p));
                    added++;
                }
                copy.add(new Patient(this.myList.get(x)));
            }
            //System.out.println(added);
            if (added==0){
                copy.add(new Patient(p));
            }
        }
        this.myList=copy;
        länge++;
    }

    public void addPatient(String name,int prio){
        addPatient(new Patient(name,prio));
    }

    public Patient getNextPatient(){
        Patient result=new Patient(this.myList.get(0));
        ArrayList<Patient> copy=new ArrayList<Patient>();
        for (int x=1;x<länge;x++){
            copy.add(new Patient(this.myList.get(x)));
        }
        this.myList=copy;
        länge--;
        return result;
    }

    public int getPosition(String name,int prio){
        for (int x=0;x<länge;x++){
            if (String.valueOf(this.myList.get(x).getName())==String.valueOf(name)
                    &&Integer.valueOf(this.myList.get(x).getPrio())==Integer.valueOf(prio)){
                //System.out.println("GEFUNDEN");
                return x;
            }
        }
        return -1;
    }

    public int getPosition(Patient p){
        return getPosition(p.getName(),p.getPrio());
    }

    public int getLänge(){
        return Integer.valueOf(länge);
    }
}
