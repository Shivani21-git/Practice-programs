package interview;
// Write your own singleton class and explain where have you used in your project.
// In terms of practical use Singleton patterns are used in logging, caches, thread pools, configuration settings, device driver objects.
public class MySingleton {
    private static MySingleton object = null; // Lazy loading
    //  private static MySingleton object = new MySingleton(); // Early initialization

    public String x;
    private MySingleton()
    {
        x= "My name is shivani";
    }
    public static MySingleton getMySingleton()
    {
        if(object==null) {
            return object = new MySingleton(); // Lazy loading
        }
        return object;
    }

}
