package BusinessLogic;
import GUI.SimulationFrame;
import Model.Server;
import Model.Task;
import Model.WriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers; //lista de cozi
    private int maxNoServers=0;
    private int maxTasksPerServer=0;
    private ArrayList<Thread> threads; //lista dethread-uri
    private SimulationFrame frame;
    private WriteFile writeFile;

    public Scheduler(int maxNoServers, int maxTasksPerServer, SimulationFrame frame) throws IOException {
        this.servers= new ArrayList<Server>(); //lista de cozi
        this.threads= new ArrayList<Thread>();//lista de thread-uri
        this.frame=frame;

        //se creaza penttru fiecrae coada un Thread
        for(int i=0;i<maxNoServers;i++){
            Server s= new Server(frame,writeFile);
            servers.add(s);
            Thread th= new Thread(s,"Q"+ (i+1));
            threads.add(th);
            th.start();
        }
    }

    public void dispatchTask(Task t){
            int minQueue=10000;
            int poz=0;
            for(int i=0;i<servers.size();i++){
                if(minQueue>servers.get(i).getTasks().size()){
                    poz=i;
                    minQueue=servers.get(i).getTasks().size();
                }
            }
            servers.get(poz).addTask(t);
            servers.get(poz).getWaitingPeriod().getAndSet(t.getServiceTime());
    }
    public List<Server>getServers(){
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public ArrayList<Thread> getThreads() {
        return threads;
    }

}
