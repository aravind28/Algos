import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aravindheswaran on 4/9/17.
 */

/*
*  References:
*             1. http://blog.kavinyao.com/2014/11/java-thread-pool/
*             2. http://www.java67.com/2015/07/how-to-stop-thread-in-java-example.html
*             3. http://stackoverflow.com/questions/23962359/thread-pool-in-a-web-server-in-java
*/

public class ThreadPooledServer implements Runnable {

    int portNumber;                   // any port number can be given
    ServerSocket serverSocket = null; // currently no sockets are created
    volatile boolean isServerRunning = false;  // server has not started, volatile because all threads must have access to it
    ExecutorService serverThreadPool; // placeholder to create a threadpool
    Queue<Task> listOfTasks;  // the list of tasks to be completed will be placed in this queue

    public ThreadPooledServer(){
        portNumber = 8080;                   // starting server at port 8000
        isServerRunning = true;              // server has started running
        serverThreadPool = Executors.newFixedThreadPool(5); // assigning a thread pool of size 5 to the server
        listOfTasks = new LinkedList<>(); // storing a queue containing the tasks to be completed
    }

    // create a socket object and assign it to the serverSocket variable,
    // Then start working on the tasks which are in queue
    @Override
    public void run(){

        try {
            System.out.println("Assigning port to Server");
            serverSocket = new ServerSocket(portNumber);
        } catch (Exception e) {
            System.out.println("Error binding socket to port");
             e.printStackTrace();
        }
        System.out.println("Tasks start executing");
        while(isServerRunning){
            while(!listOfTasks.isEmpty()){
                serverThreadPool.execute(listOfTasks.poll()); // processes tasks using the thread pools
            }
        }
        serverThreadPool.shutdown();
    }

    // once the command to stop the server is received from the main thread, release the socket and stop the server
    public synchronized void stop(){
        isServerRunning = false;
        try {
            System.out.println("Releasing port");
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    /* parses the task name and the file operation and adds it to the queue
    *  for simplicity I have included a delay to be the file operation currently,
    *  it can be extended to do file operations or RESTful operations
    *  I was not sure of the requirement, so I restriced myself to do the delay
    */
    public void addTaskToQueue(String taskName, int fileOperation){
        listOfTasks.add(new Task(taskName, fileOperation));
    }

    public void acceptRequestsFromClient(){
        // Commented code contains implementation, where we can accept connections from clients before
        // adding the tasks to the queue
//            Socket requestFromClient = null;
//            try{
//                requestFromClient = serverSocket.accept();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
        addTaskToQueue("Job 1", (int)(Math.random() * 1000));
        addTaskToQueue("Job 2", (int)(Math.random() * 3000));
        addTaskToQueue("Job 3", (int)(Math.random() * 1000));
        addTaskToQueue("Job 4", (int)(Math.random() * 1000));
        addTaskToQueue("Job 5", (int)(Math.random() * 1000));
        addTaskToQueue("Job 6", (int)(Math.random() * 3000));
        addTaskToQueue("Job 7", (int)(Math.random() * 3000));
    }

    public static void main(String[] args){

        ThreadPooledServer server = new  ThreadPooledServer(); // create a server object
        server.acceptRequestsFromClient(); // accept requests from client and add it to queue

        new Thread(server).start(); // start a server
        try {
            // wait time for server before it shuts down
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Server Stopped");
        server.stop(); // stop the server
    }
}
