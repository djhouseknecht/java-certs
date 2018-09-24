import java.lang.StringBuilder;

public class Strings { 

    public static void main(String[] args) { 
        // System.out.println("animals".replace("ls", "qt"));
        // System.out.println("animals".replace("lst", "qt"));

        /**
         * page 118: StringBuilder .equals() compares object reference. Just like == on two String classes. 
         */
        StringBuilder sb1 = new StringBuilder("hi");
        StringBuilder sb2 = new StringBuilder("hi");
        StringBuilder sb3 = sb1;

        System.out.println(sb1.equals(sb2));
        System.out.println(sb2.equals(sb3));
        System.out.println(sb3.equals(sb1));
    }
    
}