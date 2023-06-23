package Input;

import java.util.Scanner;

public class Choices {
    public double amount(){
        Scanner sc = new Scanner(System.in);

        try{
            Double a = sc.nextDouble();
            return a;
        } catch (Exception e){
            System.out.println("pls enter numbers only");
            return -1;
        }
    }
    public int input(){
        Scanner sc = new Scanner(System.in);
        try {
            int i = sc.nextInt();
            return i;
        }catch (Exception e){
            System.out.println("pls enter numbers only");
            return -1;
        }

    }
    public String currency(int i){
        try {switch (i) {
            case 1:
                return "USD";

            case 2:
                return "INR";

            case 3:
                return "GBP";

            case 4:
                return "KWD";

            case 5:
                return "SGD";

        }
        }catch (Exception e){
            System.out.println( "pls enter from the choices only");
            return null;

    }
        return null;
    }
}
