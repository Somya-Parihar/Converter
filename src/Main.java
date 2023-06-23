import Input.Choices;
import Screen.Output;
import convert.ApiCall;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Choices value = new Choices();
        Output out = new Output();
        System.out.print("The Amount to be Converted:");
        double amount = value.amount();
        while (amount == -1){
            System.out.println("\n");
            System.out.print("The Amount to be Converted:");
            amount = value.amount();
        }
        //printing the currency choices to convert from
        System.out.println("Convert from:");
        out.convertChoices();
        //taking the choice as input and get the currency stored in from variable
        int choice1 = value.input();
        String from = value.currency(choice1);
        while (from == null){
            System.out.println("\n");
            System.out.println("Only enter from the choices given");
            System.out.println("Convert from:");
            out.convertChoices();
            choice1 = value.input();
            from = value.currency(choice1);
        }
        //printing the currency choices to convert to
        System.out.println("Convert to:");
        out.convertChoices();
        int choice2 = value.input();
        String to = value.currency(choice2);
        while (to == null){
            System.out.println("\n");
            System.out.println("Only enter from the choices given");
            System.out.println("Convert to:");
            out.convertChoices();
            choice1 = value.input();
            to = value.currency(choice1);
        }
        ApiCall convert = new ApiCall();
        double exchange = convert.Convert(from,to);
        System.out.println("On converting " + amount +" "+from+" we get " +String.format("%.2f",amount*exchange) + " " + to);

    }
}