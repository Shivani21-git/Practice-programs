package interview;
import java.util.ArrayList;

public class solution {
        public static void main(String[] args)
        {
            pair();
        }
        public static void pair()
        {
            int  boys_count = 3;

            int[]  boys_skill_list = {3,6,7};

            int  girls_count = 4;

            int[]  girls_skill_list = {7,5,7,10};

            ArrayList result = new ArrayList();
            int count =0;

            int length;

            if(boys_count>girls_count)
            {
                length = boys_count;
            }
            else
            {
                length = girls_count;
            }
            for(int i=0;i<length;i++)
            {

                for(int item : boys_skill_list)
                {
                    int diff = girls_skill_list[i]-item;
                    if(diff==-1)
                    {
                        count++;

                    }
                }
            }
            //  System.out.println(result.size());
            System.out.println(count);
        }
    }

