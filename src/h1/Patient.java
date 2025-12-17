//by mschro67

package h1;

public class Patient{
    private String name;
    private int prio;

    public Patient(String name,int prio){
        this.name=name;
        this.prio=prio;
    }

    public Patient(Patient a){
        this.name=String.valueOf(a.name);
        this.prio=Integer.valueOf(a.prio);
    }

    public String getName(){
        return String.valueOf(this.name);
    }
    public int getPrio(){
        return Integer.valueOf(this.prio);
    }
}
