package agile.labs.unit;
import java.util.List;
import java.util.Vector;

public class Module {
	public static final int wksPerSemester= 12;
	private String name;
	private int noLectures;
	private int credits;
	private List <Topic>topics =new Vector<Topic>();

	 public Module(String name, int noLectures, int credits) {
	        this.name = name;
	        this.noLectures = noLectures;
	        this.credits = credits;
	   }
	 public int computeTopicTotal()
	 {
		 int result = 0;
		 for (Topic t :topics)
		 {
			 result +=t.getNoLectures();
			 
		 }
		return result;
	 }
	 public Topic removeTopic (String topicName)
	 {
		 Topic foundTopic = findTopic(topicName);
		 if (foundTopic != null)
		 {
			 topics.remove(foundTopic);
			
		 }
		 
		 return foundTopic; 
		 
	 }
	 public boolean addTopic (Topic t)
	 {
		 boolean result = false;
		 if ((computeTopicTotal() + t.getNoLectures())
				 <=this.noLectures * wksPerSemester){
			 topics.add(t);
			 result = true;
		 }
		 return result;
	 }
	 public Topic findTopic (String name) {
         Topic result = null ;
         for (Topic t : topics) {
                if (t.getName().equalsIgnoreCase(name)) {
                    result = t ;
                    break ;
                }
         }
         return result ;
    }
	
	   public Topic mergeTopics(String name1, String name2,String nemName) {
           Topic merged = null;
           Topic topic1 = findTopic(name1) ;
           Topic topic2 = findTopic(name2) ;
           if ( topic1 != null && topic2 != null) {
               merged = new Topic( 
                       (topic1.getNoLectures() + topic2.getNoLectures()),
                       nemName);
               removeTopic(topic1.getName());
               removeTopic(topic2.getName());
               addTopic(merged);
           }
         return merged;
       }
}

