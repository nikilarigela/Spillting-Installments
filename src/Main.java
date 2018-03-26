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
        int unPiad = Util.totalAmount;
        System.out.println("Want to Adjust the Installment y/n");
        char c = sc.next().charAt(0);
        System.out.println(c);
        int kachra = 0;
        if (c == 'y' | c == 'Y') {

            LOOP:
            try {


                for (int i = 0; i < Util.totalMonths; i++) {
                    System.out.println("Enter " + count + " Installment");
                    paying = Util.totalAmount + 1;
                    int nextInstall = Util.array[i];
                    while (paying > unPiad) {
                        paying = sc.nextInt();
                        System.out.println("YOu are Paying too much amount");
                    }
                    paid = paid + paying;
                    payingArray.add(paying);
                    System.out.println("nextInstall" + i + " =" + Util.array[i]);
                    if (nextInstall != paying) {

                        System.out.println("nextInstall" + i + " =" + Util.array[i]);
                        check(paying, i, nextInstall, kachra);

                    } else {
                        nextInstall = Util.array[i + 1];
                    }

                    count++;
                    System.out.println("Paid Amount" + paid);
                    unPiad = Util.totalAmount - paid;
                    System.out.println("UNPaid Amount" + (Util.totalAmount - paid));
                    if (paid == Util.totalAmount) {
                        break LOOP;
                    }
                    Util.display();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            if (paid != Util.totalAmount) {
                unPiad = Util.totalAmount - paid;
                System.out.println("You have due of"+unPiad);

            } else {
                System.out.println("Paid Structure");
                System.out.println("--------------");
                for (int k = 1; k <= payingArray.size(); k++) {

                    System.out.println(k + " Installment " + payingArray.get(k - 1));
                }
            }

        } else {
            System.out.println("Thank You");
        }

    }

    private static void check(int paying, int i, int nextInstall, int kachra) {
        if (paying > nextInstall) {

            Util.array[i] = paying;

            int extra = paying - nextInstall;
            if (extra > nextInstall) {
                extra = extra / 2;
                System.out.println("extra" + extra);
                Util.array[i + 1] = Util.array[i + 1] - extra;
                System.out.println("arry " + i + " =" + Util.array[i + 1] + "-" + (Util.install - extra) + ".");
                Util.array[i + 2] = Util.array[i + 2] - extra;
                System.out.println("arry " + i + " =" + Util.array[i + 2] + "-" + (Util.install - extra) + ".");

            } else {
                Util.array[i + 1] = Util.array[i + 1] - extra;
            }
            nextInstall = Util.array[i + 1];
            System.out.println("nextInstall" + i + " =" + Util.array[i + 1]);


        } else {
            Util.array[i] = paying;
            System.out.println("arry " + i + " =" + Util.array[i + 1] + "+" + (Util.install - paying) + ".");
            Util.array[i + 1] = Util.array[i + 1] + (nextInstall - paying);
            nextInstall = Util.array[i + 1];
            System.out.println("nextInstall" + i + " =" + Util.array[i]);
        }

    }
}
