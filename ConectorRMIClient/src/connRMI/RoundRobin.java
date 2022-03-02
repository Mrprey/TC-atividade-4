package connRMI;

import java.util.ArrayList;
import java.util.List;

public class RoundRobin {
    private final Server server1 = new Server("rmi://localhost:1099/Server1", "Servidor 1");
    private final Server server2 = new Server("rmi://localhost:2000/Server2", "Servidor 2");
    private final List<Server> serverList = new ArrayList<>();

    public String newRequest() {
        if(serverList.isEmpty()) {
            serverList.add(server1);
            serverList.add(server1);
            serverList.add(server2);
            serverList.add(server2);
        }
        return pop(serverList).uri;
    }

    private Server pop(List<Server> list){
        Server item = list.get(0);
        list.remove(0);
        System.out.println(item.name+" escolhido");
        return item;
    }
}

