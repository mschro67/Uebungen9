//by mschro67

package h2;

public class Passenger {
    private String name;
    private int planned,visited;
    private boolean ticket;

    public Passenger(String name, int planned, boolean ticket) {
        this.name = name;
        this.planned = planned;
        this.ticket = ticket;
        this.visited = 0;
    }

    public Passenger(Passenger p){
        this.name=String.valueOf(p.name);
        this.planned=Integer.valueOf(p.planned);
        this.ticket=Boolean.valueOf(p.ticket);
        this.visited=Integer.valueOf(p.visited);
    }

    public void changeVisited(){
        this.visited++;
    }
    public int getPlanned(){
        return Integer.valueOf(this.planned);
    }
    public int getVisited(){
        return this.visited;
    }
    public boolean getTicket(){
        return Boolean.valueOf(this.ticket);
    }
    public String getName(){
        return String.valueOf(this.name);
    }
}