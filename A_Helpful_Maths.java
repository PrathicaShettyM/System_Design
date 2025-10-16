import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A_Helpful_Maths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        List<Integer> list = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(c == '+') continue;
            else list.add(c-'0');
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
            sb.append('+');
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());
    }
}