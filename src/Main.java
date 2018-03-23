import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int remainingAmount;

        Scanner sc = new Scanner(System.in);
        System.out.println("enter amount");
        Util.totalAmount = sc.nextInt();

        System.out.println("enter totalMonths");
        Util.totalMonths = sc.nextInt();
        Util.array = new int[Util.totalMonths];


        System.out.println("enter month to pay as decided amount");
        Util.month = sc.nextInt();//no. of month they want to pay exact amount

        System.out.println("enter  decided amount to pay on which no. of  installment");
        Util.depositAmount = sc.nextInt();




//        System.out.println(Util.install);
//        System.out.println(Util.array.length);
        Util.install = Util.totalAmount / Util.totalMonths;
        Util.remainingAmount = Util.totalAmount - Util.depositAmount;
        Util.extra = Math.abs(Util.depositAmount - Util.install);
        try {
            for (int i = 0; i <= Util.array.length; i++) {
                Util.array[i] = Util.install;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Methods methodObject = new Methods();
        System.out.println("Enter No. to select the Option to apply");
        System.out.println("1.Basic Structure");
        System.out.println("2.Logic Splitting");
        System.out.println("3.Custom Splitting");
        int choice = sc.nextInt();
        switch (choice){
            case 1  :   Util.display();
                        break;

            case 2  :
                        if(Util.install == 0){
                            Util.display();
                        }else{
                        System.out.println(methodObject.repeats());
                        if (Util.install == Util.depositAmount) {
                        System.out.println("No need of applying Logic");
                        System.out.println("----------------------");
                        Util.display();
                        }
                        if (Util.install < Util.depositAmount) {
                        methodObject.sub();
                        }
                        if (Util.install > Util.depositAmount) {
                        methodObject.add();
                        }
                        }
                        break;
            case 3  :   methodObject.custom();
                        break;
        }


    }
}
