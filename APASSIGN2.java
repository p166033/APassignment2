package assign2.abdullah.p166033a;
 //Name abdullah
 //RollNUMBER 166033
public class EvenPrimePrintMain {
 
   // Starting counter
    int counter = 1;
  
    static int N;
  public static boolean CheckPrime(int N) {
        int remainder;
        for (int i = 2; i <= N / 2; i++) {
            remainder = N % i;
            //if remainder is 0 than number To Checkber is not prime and break loop. Else continue loop
            if (remainder == 0) {
                return false;
            }
        }
        return true;

    }
    // Function to print prime numbers
    public void printPrimeNumber()
    {
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {
  
              for (i = 1; i <= maxCheck; i++) {
                        isPrime = CheckPrime(i);
                        if (!isPrime) {
                            // If count is not then print
                    try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                
  
                        }
                    }
                
                // Print the number
                System.out.print(counter + " ");
  
                // Increment counter
                counter++;
  
                // Notify to second thread
                notify();
            }
        }
    }
  
    // Function to print even numbers
    public void printEvenNumber()
    {
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {
  
                // If count is odd then print
                while (counter % 2 == 1) {
  
                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                }
  
                // Print the number
                System.out.print(
                    counter + " ");
  
                // Increment counter
                counter++;
  
                // Notify to 2nd thread
                notify();
            }
        }
    }
 

    public static void main(String[] args)
    {
        // Given Number N
        N = 10000;
  
        // Create an object of class
        EvenPrimePrintMain mt = new EvenPrimePrintMain();
  
        // Create thread t1
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                mt.printEvenNumber();
            }
        });
  
        // Create thread t2
        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                mt.printPrimeNumber();
            }
        });
  
        // Start both threads
        t1.start();
        t2.start();
    }
}