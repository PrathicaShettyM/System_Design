import java.util.Scanner;

public class SolutionA{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int k = sc.nextInt();
            int x = sc.nextInt();

            for(int j = 0; j < k; j++){
                if((x-1)%3 == 0 && ((x-1)/3)%2 != 0){ //odd
                    x = (x-1)/3;
                } else { // even 
                    x *= 2;
                }
            }

            System.out.println(x);
        }

        sc.close();
    }
}