import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor{

    private static class Worker implements Runnable{

        final String taskName;
        final int fileOperation;
        public Worker(String threadName, int sleepTime){
            this.taskName = threadName;
            this.fileOperation = sleepTime;
        }

        @Override
        public void run(){
            System.out.println(taskName + " has started executing, " + "and it will sleep for " + fileOperation + " milliseconds");
            try {
                Thread.sleep(fileOperation);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName + " has finished execution");
        }
    }

    public static void main(String[] args){
        ExecutorService  serverThreads = Executors.newFixedThreadPool(5);

        Queue<Worker> queueOfTasks = new LinkedList<Worker>();
        queueOfTasks.add(new Worker("Job 1", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 2", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 3", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 4", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 5", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 6", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 7", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 8", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 9", (int)(Math.random() * 1000)));
        queueOfTasks.add(new Worker("Job 10", (int)(Math.random() * 1000)));

        while(!queueOfTasks.isEmpty()){
            serverThreads.execute(queueOfTasks.poll());
        }

        serverThreads.shutdown();
    }
}
