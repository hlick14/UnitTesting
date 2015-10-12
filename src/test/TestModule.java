import agile.labs.unit.Module;
import agile.labs.unit.Topic;
import junit.framework.TestCase;

public class TestModule extends TestCase {
	Module module;
	Topic topic1;
	Topic topic2;
	Topic topic3;
	public void setUp() throws Exception{
		module = new Module("Module 1", 2, 5);
		 topic1 = new Topic(4,"topic 1") ;
	        topic2 = new Topic(7,"topic 2") ;
	        topic3 = new Topic(5,"topic 3") ;
	}
	public void tearDown() throws Exception {
		module = null;
		topic1 = topic2=topic3 = null;
	}
	public void testaddTopic(){
		//Normal case
		module.addTopic(topic1);
		Boolean result = module.addTopic(topic2);
		//Addition tests
		assertTrue ("Normal add topic result incorrect", result);
		Topic topic  = module.findTopic("topic 1");
		// Look up tests
		assertSame("Module state  - Valid (1st) topic no present", topic1, topic);
		topic = module.findTopic("topic 2");
		assertSame("Moudle state - valid (2nd) topic not present ",topic2,topic);
		
		// Boundary case
		//addition
		Topic topic4 = new Topic (13,"topic 4");
		result = module.addTopic(topic4);
		assertTrue("No. of lectures limit -incorrect result",result);
		//look up
		topic = module.findTopic("topic 4");
		assertSame("No. of lectures limit - incorrect topic list",topic4,topic);
		//Error Case
		result = module.addTopic(topic3);
		assertFalse("No. of lectures exceeded", result);
		topic = module.findTopic("topic 3");
		assertNull ("No. of lectures exceeded - Topic incorrectly added ", topic);
		
	}
	public void testRemoveTopic(){
		//Boundary case
		   Topic result = module.removeTopic("topic 2");
		   assertNull("Topic currently not on the list", result);
		   // Normal case 
		   addTopics();
		   result = module.removeTopic("topic 2");
		   assertSame("Normal remove - topic result incorrect",topic2,result);
		   Topic topic = module.findTopic("topic 2");
		   assertNull ("Valid topic not removerd",topic);
		   result = module.removeTopic("topic 2");
		   assertNull("Remove -non-Existing topic - result incorrect",result );
		   
		   
	   }
	public void testmergeTopics() {
		addTopics();
		Topic result = module.mergeTopics("topic 1", "topic 2", "merged1-2");
		assertEquals("Merged subjects - incorrect new name ", "merged1-2", result.getName());
		assertEquals("Merged subjects - incorrect no of lectures", 11, result.getNoLectures());
		
		
		result = module.findTopic("topic 1");
		assertNull("Remove - Topic not removed", result);
		result = module.findTopic("topic 2");
		assertNull("Remove - Topic not removed", result);
		result = module.findTopic("merged1-2");
		assertEquals("Merged subject not added correctly","merged1-2",result.getName());;
		
		//Error case
		addTopics();
		result = module.mergeTopics("topic 1", "topic 4", "merged1-2");
		assertNull("Merge subject - incorrec subject name",result);
		
		
		
	}
	   public void testfindTopic() {
	        // Boundary case
	        Topic result = module.findTopic("topic 1");
	        assertNull("Empty module returning something ",result) ;
	        // Normal cases
	        module.addTopic(topic1) ;
	        module.addTopic(topic2) ;
	        module.addTopic(topic3) ;
	        result  = module.findTopic("topic 2");
	        assertSame("Valid Topic not found ",topic2,result) ;
	        result = module.findTopic("topic 4");
	        assertNull("Invalid topic found incorrectly",result) ;
	    }
	   
	   private void addTopics() {
           module.addTopic(topic1) ;
           module.addTopic(topic2) ; 
           module.addTopic(topic3) ; 
       }
	   
	   
 	

}
