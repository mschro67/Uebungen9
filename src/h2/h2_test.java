package h2;

public class h2_test{
    public static void main(String[] args){
        Bus bus=new Bus();
        bus.enterBus(new Passenger("Gustaf",1,true));
        bus.nextStop();
        bus.exitBus();
        bus.nextStop();
        bus.exitBus();
        System.out.println(bus.getLength());
    }
}
