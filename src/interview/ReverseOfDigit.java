package interview;

// Program to find the reverse of a given digit
public class ReverseOfDigit {
    public static void main(String[] args)
    {
        int givendigit = 6754;
        StringBuilder sb = new StringBuilder();
        while (givendigit>0) {
            int mod = givendigit % 10;
            System.out.println(mod);
            //Quotient
            givendigit = givendigit / 10;
            sb.append(mod);
        }
        int reversenumber = Integer.parseInt(sb.toString());
        System.out.println(reversenumber);
        System.out.println(reversenumber+1);

    }
}
