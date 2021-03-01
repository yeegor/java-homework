// Create multiple threads.

class MyThread implements Runnable {
    Thread thrd;
  
    // Construct a new thread.
    MyThread(String name) {
      thrd = new Thread(this, name);
    }

    protected static int activeThreadCount = 0;
    protected static void increaseActiveThreadCount() {
        MyThread.activeThreadCount++;
    }

    protected static void decreaseActiveThreadCount() {
        MyThread.activeThreadCount--;
    }

    public static int getActiveThreadCount() {
        return MyThread.activeThreadCount;
    }
  
    // A factory method that creates and starts a thread.
    public static MyThread createAndStart(String name) {
      MyThread myThrd = new MyThread(name);
      
      myThrd.thrd.start(); // start the thread
      return myThrd;
    }

    protected static void printActiveThreadCount() {
        System.out.println("======= Current active thread count: " + MyThread.getActiveThreadCount());
    }
  
    // Entry point of thread.
    public void run() {
      MyThread.increaseActiveThreadCount();
      MyThread.printActiveThreadCount();

      System.out.println(thrd.getName() + " starting.");
      try {
        for(int count=0; count < 10; count++) {
          Thread.sleep(400);
          System.out.println("In " + thrd.getName() + ", count is " + count);
        }
      }
      catch(InterruptedException exc) {
        System.out.println(thrd.getName() + " interrupted.");
      }
      System.out.println(thrd.getName() + " terminating.");
      MyThread.decreaseActiveThreadCount();
      MyThread.printActiveThreadCount();
    }
  }
  
  class MoreThreads {
    public static void main(String args[]) {
      System.out.println("Main thread starting.");
  
      MyThread mt1 = MyThread.createAndStart("Child #1");
      MyThread mt2 = MyThread.createAndStart("Child #2");
      MyThread mt3 = MyThread.createAndStart("Child #3");
  
      for(int i=0; i < 50; i++) {
        System.out.print(".");
        try {
          Thread.sleep(100);
        }
        catch(InterruptedException exc) {
          System.out.println("Main thread interrupted.");
        }
      } 
  
      System.out.println("Main thread ending.");
    }
  }