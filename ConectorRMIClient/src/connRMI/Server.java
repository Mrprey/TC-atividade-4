package connRMI;

public class Server {
    final String uri;
    final String name;
    Boolean status = true;
    int processes = 0;

    public Server(String uri, String name) {
        this.uri = uri;
        this.name = name;
    }

    public void setProcesses() {
        this.processes += 1;
    }
}
