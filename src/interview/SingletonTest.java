package interview;

public class SingletonTest {
    public static void main(String[] args)
    {
         MySingleton x =MySingleton.getMySingleton();
         MySingleton y = MySingleton.getMySingleton();
         System.out.println(x.x);
         System.out.println(y.x);
    }
}
