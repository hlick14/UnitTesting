

import agile.labs.unit.Counter;
import junit.framework.TestCase;

public class TestCounter extends TestCase {
    Counter counter ;
    int limit = 10 ;

    public void setUp() throws Exception {
        counter = new Counter(limit) ;
    }

    public void tearDown() throws Exception {
        counter = null ;
    }

    public void testincrement() {
        counter.increment();
        int result = counter.increment();
        assertEquals("Normal case",2,result) ;
        for (int i = 2; i < limit ; i++) {
            counter.increment();
        }
        result = counter.increment();
        assertEquals("Boundry case",0, result) ;
    }
    public void teststep() {
        int amount =3;
        counter.step(amount);
        int result = counter.step(amount);
        assertEquals("Normal Case", 6,result);
        counter.step(amount);
        result =counter.step(amount);
        assertEquals("Rollover case",2, result);
    } 


}
