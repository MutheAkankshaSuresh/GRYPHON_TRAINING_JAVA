
import java.util.ArrayList;
import java.util.List;

class Channel {
    private List<CustomerSubscribe> subs = new ArrayList<>();

    void subscribe(CustomerSubscribe sub) {
        subs.add(sub);
    }

    void upload(String title) {
        System.out.println("\nNew video uploaded: " + title);
        notifySubscribers(title);
    }

    private void notifySubscribers(String title) {
        for (CustomerSubscribe sub : subs) {
            sub.update(title);
        }
    }
    void unsubscribe(CustomerSubscribe sub) {
        subs.remove(sub);
    }
}

class CustomerSubscribe {
    private String name;
    private Channel channel;

    CustomerSubscribe(String name) {
        this.name = name;
    }

    void subscribeChannel(Channel ch) {
        this.channel = ch;
        ch.subscribe(this);
    }

    void update(String videoTitle) {
        System.out.println(name + " notified about: " + videoTitle);
    }
}

public class youtube {
    public static void main(String[] args) {

        Channel worldAffairs = new Channel();

        CustomerSubscribe cs1 = new CustomerSubscribe("Akanksha");
        CustomerSubscribe cs2 = new CustomerSubscribe("Priyanka");
        CustomerSubscribe cs3 = new CustomerSubscribe("Sans");
        CustomerSubscribe cs4 = new CustomerSubscribe("Sakshi");
        CustomerSubscribe cs5 = new CustomerSubscribe("Dora");

        cs1.subscribeChannel(worldAffairs);
        cs2.subscribeChannel(worldAffairs);
        cs3.subscribeChannel(worldAffairs);
        cs4.subscribeChannel(worldAffairs);
        cs5.subscribeChannel(worldAffairs);
        
        worldAffairs.unsubscribe(cs5);
        
        

        worldAffairs.upload("India–Pakistan Relations Explained");
    }
}