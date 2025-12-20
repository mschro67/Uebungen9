//by mschro67

package h2;

import java.util.ArrayList;
import java.util.Arrays;

public class Bus{
    private ArrayList<Passenger> passengers;

    public Bus(){
        this.passengers=new ArrayList<>();
    }

    public void enterBus(Passenger p){
        passengers.add(new Passenger(p));
    }

    public void exitBus(){
        int[] leave=new int[this.getLength()+1];
        for (int x=0;x<leave.length;x++){
            leave[x]=-1;
        }
        for (int x=0;x<passengers.toArray().length;x++){
            if (this.passengers.get(x).getVisited()>=Integer.valueOf(this.passengers.get(x).getPlanned())){
                leave[x]=Integer.valueOf(x);
            }
        }

        for (int x=0;x<leave.length-1;x++){
            if (leave[x]!=-1){
                this.passengers.remove(leave[x]);
            }
        }
    }

    public String exitBusStr(){
        int[] leave=new int[this.getLength()+1];
        for (int x=0;x<leave.length;x++){
            leave[x]=-1;
        }
        for (int x=0;x<passengers.toArray().length;x++){
            if (this.passengers.get(x).getVisited()>=Integer.valueOf(this.passengers.get(x).getPlanned())){
                leave[x]=Integer.valueOf(x);
            }
        }
        ArrayList<String> left=new ArrayList<>();
        for (int x=0;x<leave.length-1;x++){
            if (leave[x]!=-1){
                left.add(this.getPassenger(x).getName());
                this.passengers.remove(leave[x]);
            }
        }

        return Arrays.toString(left.toArray());
    }

    public void nextStop(){
        for (int x=0;x<this.passengers.toArray().length;x++){
            this.passengers.get(x).changeVisited();
        }
        exitBus();
    }

    public String nextStopStr(){
        for (int x=0;x<this.passengers.toArray().length;x++){
            this.passengers.get(x).changeVisited();
        }
        return exitBusStr();
    }

    public void nextStop(Passenger[] boarding){
        nextStop();
        for (int x=0;x<boarding.length;x++){
            this.passengers.add(new Passenger(boarding[x]));
        }
    }

    public String nextStopStr(Passenger[] boarding){
        String result=nextStopStr();
        for (int x=0;x<boarding.length;x++){
            this.passengers.add(new Passenger(boarding[x]));
        }
        return result;
    }

    public ArrayList findPassengersWithoutTicket(){
        ArrayList leave=new ArrayList();
        ArrayList<Passenger> result=new ArrayList();
        for (int x=0;x<passengers.toArray().length;x++){
            if (!(this.passengers.get(x).getTicket())){
                leave.add(Integer.valueOf(x));
                result.add(new Passenger(this.passengers.get(x)));
            }
        }
        for (int x=0;x<leave.toArray().length;x++){
            this.passengers.remove(leave.get(x));
        }
        return result;
    }

    public void transferPassengers(Bus otherBus,String[] passengerNames){
        ArrayList leave=new ArrayList();
        ArrayList<Passenger> enter=new ArrayList<>();
        for (int x=0;x<passengers.toArray().length;x++){
            for (int y=0;y<passengerNames.length;y++){
                if (this.passengers.get(x).getName()==passengerNames[x]){
                    leave.add(Integer.valueOf(x));
                    enter.add(new Passenger(this.passengers.get(x)));
                }
            }
        }
        for (int x=0;x<leave.toArray().length;x++){
            this.passengers.remove(leave.get(x));
        }
        for (int x=0;x<enter.toArray().length;x++){
            otherBus.enterBus(enter.get(x));
        }
    }

    public Passenger getPassenger(int index){
        return new Passenger(this.passengers.get(index));
    }
    public int getLength(){
        return Integer.valueOf(this.passengers.toArray().length);
    }
    public String[] getNames(){
        String[] names=new String[this.passengers.toArray().length];
        for (int x=0;x<names.length;x++){
            names[x]=String.valueOf(this.passengers.get(x).getName());
        }
        return names;
    }
}