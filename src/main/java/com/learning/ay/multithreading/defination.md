[Readme learning page](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#styling-text)

**Thread.sleep()** method internally keeps checking for Interrupt status flag.
```
public static void sleep(long millis) throws InterruptedException{
    while (/* still waiting for millis to become zero */){
        if (Thread.interrupted()){ //Return if thread is Interrupted via parent or main thread
            throw new InterruptedException();
        }
    }
}
```
**Note** : Thread.interrupted() not only returns the flag but also sets it to false. Thus, once InterruptedException is
    thrown, the flag is reset. The parent thread no longer knows anything about the interruption request sent by the owner.
Improved code:
```
try {
  Thread.sleep(100);
} catch (InterruptedException ex) {
  Thread.currentThread().interrupt(); // When we call .interrupt(), an Interrupt status flag is set to true.
  throw new RuntimeException(ex);
}
```
Asked in one of interview

    main(){
        Thread.currentThread().wait(); //Exception : java.lang.IllegalMonitorStateException
    }

Def : Thrown to indicate that a thread has attempted to wait on an object's monitor or to notify other threads waiting
    on an object's monitor without owning the specified monitor.

Thread can .start() only once else throws java.lang.illegalThreadStateException on second time
***
### Executor Framework [Executor](https://medium.com/@gaurav.sahu1591/java-multi-threading-executor-framework-219260c5c4b2)
Executor : You do not have to create, manage, schedule, and terminate your thread.
Thread pool is a pool of worker threads, which is ready to perform any task given to them,
    mostly in the form of implementation of Runnable or Callable interface.

Executor framework also provides a static utility class called Executors (similar to Collections) which provides
    several static factory method to create various type of Thread Pool implementation in Java e.g. fixed size thread pool,
    cached thread pool and scheduled thread pool

1. newSingleThreadExecutor() : Creates an Executor that uses a single worker thread.
    `ExecutorService executor = Executors.newSingleThreadExecutor();`
2. static ExecutorService newFixedThreadPool(int numThreads) : Creates a thread pool that reuses a fixed number of threads.
   `ExecutorService fixedPool = Executors.newFixedThreadPool(2);`
3. static ExecutorService newCachedThreadPool() : Creates a thread pool that creates new threads as needed,
   but will reuse previously constructed threads when they are available.
   `ExecutorService executorService = Executors.newCachedThreadPool();`
4. static ScheduledExecutorService newScheduledThreadPool(int numThreads) : Extends ExecutorService and provides methods for scheduling tasks with fixed-rate or fixed-delay execution.
   `ScheduledExecutorService scheduledExecService = Executors.newScheduledThreadPool(1);` 

ExecutorService shutdown
An ExecutorService can be shut down, which will cause it to reject new tasks.

1. shutdown() : method will allow previously submitted tasks to execute before terminating.
2. shutdownNow(): Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
    Ex : List<Runnable> pendingTasks = executor.shutdownNow();
3. awaitTermination(long timeout, TimeUnit unit): Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
   Ex: boolean terminated = executor.awaitTermination(10, TimeUnit.SECONDS);
        if (terminated) {syso("All tasks have completed execution");} 
        else {syso("Timeout occurred before all tasks completed");}

Callable : This Interface is similar to Runnable but can return a result and throw checked exceptions. The Callable interface is parameterized by the type of result it produces. 

    public interface Callable<V>{ V call() throws Exception;}

Future: represents the result of an asynchronous computation and provides methods for checking if the computation is complete and retrieving the result.

    cancel(boolean mayInterruptIfRunning): Attempts to cancel the execution of the task. The mayInterruptIfRunning parameter specifies whether the thread executing the task should be interrupted.
    isCancelled(): Returns true if the task was canceled before it was completed normally.
    isDone(): Returns true if the task is completed, either normally or by being canceled.
    get(): Waits if necessary for the computation to complete, and then retrieves its result.
    get(long timeout, TimeUnit unit): Waits if necessary for at most the given time for the computation to complete, and then retrieves its result, if available.

Limitations:

    Resource thrashing : If the thread pool size is not tuned properly threads consume numerous resources, including memory and other system resources. While the scheduling overhead of switching between threads is small, with many threads context switching can become a significant drag on your program’s performance.
    
    Thread leakage : A significant risk in all kinds of thread pools is thread leakage, which occurs when a thread is removed from the pool to perform a task, but is not returned to the pool when the task completes.
    One way this happens is when the task throws a RuntimeException or an Error. If the pool class does not catch these, then the thread will simply exit and the size of the thread pool will be permanently reduced by one.
    When this happens enough times, the thread pool will eventually be empty, and the system will stall because no threads are available to process tasks.
