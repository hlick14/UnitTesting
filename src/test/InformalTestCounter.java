import agile.labs.unit.Counter;

public class InformalTestCounter {
	public static void main(String[] args) {
	    int limit = 10 ;
	    Counter counter = new Counter(limit) ;
	    counter.increment();
	    int result = counter.increment();
	    if (result != 2) {
	        System.out.println("Simple case failed");
	    }
	    for (int i = 2; i < limit ; i++) {
	        counter.increment();
	    }
	    result = counter.increment();
	    if (result != 0) {
	        System.out.println("Boundry case failed");
	    }
	    int amount = 3;
        counter.step(amount);
        result = counter.step(amount);
        if (result != 6) {
            System.out.println("Step - Simple case failed");
        }
        counter.step(amount);
        result = counter.step(amount);
        if (result != 2) {
            System.out.println("Step - Boundry case failed");
        }
	    
	}
}
