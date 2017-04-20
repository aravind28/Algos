import java.util.*;
import java.util.concurrent.*;

public class MultiThreadedServer {
    Queue<Task> listOfTasks;
    ExecutorService serverThreads;
    static boolean finishedServingRequests = false;

    public MultiThreadedServer(){
        listOfTasks = new LinkedList<Task>();
        serverThreads = Executors.newFixedThreadPool(2);
    }

    private void addTaskToQueue(String taskName, int fileOperation){
        listOfTasks.add(new Task(taskName, fileOperation));
    }

    private void serveRequests(){
        while(!listOfTasks.isEmpty()){
            serverThreads.execute(listOfTasks.poll());
        }
        serverThreads.shutdown();
        while(true){
            if(serverThreads.isShutdown()) finishedServingRequests = true;
            else continue;
        }
    }

    public static void main(String[] args){

        MultiThreadedServer server = new MultiThreadedServer();
        server.addTaskToQueue("Job 1", (int)(Math.random() * 1000));
        server.addTaskToQueue("Job 2", (int)(Math.random() * 1000));
        server.addTaskToQueue("Job 3", (int)(Math.random() * 1000));
        server.addTaskToQueue("Job 4", (int)(Math.random() * 1000));
        server.addTaskToQueue("Job 5", (int)(Math.random() * 1000));
        server.addTaskToQueue("Job 6", (int)(Math.random() * 1000));
        server.addTaskToQueue("Job 7", (int)(Math.random() * 1000));
        server.serveRequests();

        while(true) {
            if(finishedServingRequests) {
                System.out.println("123");
                break;
            }
            else{
                continue;
            }
        }
        System.out.println("123");
    }
}
