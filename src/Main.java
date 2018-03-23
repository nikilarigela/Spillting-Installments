import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int remainingAmount;
        int paying, paid = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("enter amount");
        Util.totalAmount = sc.nextInt();

        System.out.println("enter totalMonths");
        Util.totalMonths = sc.nextInt();
        Util.array = new int[Util.totalMonths];

        ArrayList<Integer> payingArray = new ArrayList<Integer>();

        Util.install = Util.totalAmount / Util.totalMonths;


        try {
            for (int i = 0; i <= Util.array.length; i++) {
                Util.array[i] = Util.install;

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        Methods methodObject = new Methods();

        System.out.println("Basic Structure");
        System.out.println("----------------------");
        Util.display();
        boolean sorted = true;
        int count = 1;

//        System.out.println("Want to Adjust the Installment y/n");
//        char c = sc.next().charAt(0);
//        System.out.println(c);
//        if (c == 'y' | c == 'Y') {
//            System.out.println("Enter month to be Adjusted");
//            int m = sc.nextInt();
//            System.out.println("Enter Amount to pay at the Entered Month");
//            int amt = sc.nextInt();
//            if (m <= Util.totalMonths) {
//                if (amt > Util.install) {
//                    Util.array[m] = amt;
//                    if(m == Util.totalMonths){
//                        Util.array[1] = Util.array[1]-(amt-Util.install);
//                        Util.display();
//                    }else{
//                        Util.array[m+1] = Util.array[m+1]-(amt-Util.install);
//                        Util.display();
//                    }
//                }else{
//                    if(m == Util.totalMonths){
//                        Util.array[1] = Util.array[1]+(amt-Util.install);
//                        Util.display();
//                    }else{
//                        Util.array[m+1] = Util.array[m+1]+(amt-Util.install);
//                        Util.display();
//                    }
//                }
//            } else {
//                System.out.println("Enter Correct  Month");
//            }
//        } else {
//            System.out.println("Thank you");
//            System.out.println("Your InstallMent Structure");
//            Util.display();
//        }
        System.out.println("Want to Adjust the Installment y/n");
        char c = sc.next().charAt(0);
        System.out.println(c);
        if (c == 'y' | c == 'Y') {

            LOOP:
            for (int i = 0; i <= Util.totalMonths; i++) {
                System.out.println("Enter " + count + " Installment");
                paying = sc.nextInt();
                paid = paid + paying;
                payingArray.add(paid);
                if (Util.install != paying) {
                    sorted = false;
                    if (paying > Util.install && sorted == true) {
                        Util.array[i + 1] = Util.array[i + 1] - (paying - Util.install);

                        sorted = true;
                    } else {
                        Util.array[i + 1] = Util.array[i + 1] + (Util.install - paying);
                        sorted = true;
                    }
                }
                Util.display();
                count++;
                System.out.println("Paid Amount" + paid);
                System.out.println("UNPaid Amount" + (Util.totalAmount - paid));
                if (paid == Util.totalAmount) {
                    break LOOP;
                }
            }

            System.out.println("Paid Structure");
            System.out.println("--------------");
            for (int k = 1; k <= payingArray.size(); k++) {

                System.out.println(k + " Installment " + payingArray.get(k));
            }

        }else {
            System.out.println("Thank You");
        }

    }
}