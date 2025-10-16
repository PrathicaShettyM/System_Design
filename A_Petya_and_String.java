import java.util.Scanner;

public class A_Petya_and_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().toLowerCase();
        String s2 = sc.nextLine().toLowerCase();

        if(s1.compareTo(s2) == 0) 
            System.out.println(0);
        else if(s1.compareTo(s2) < 0)
            System.out.println(-1);
        else 
            System.out.println(1);
    }
}