import java.util.Scanner;

public class Methods {
//if amount paid extra then basic structure
    public void sub() {
        int subextras = Util.extra/repeats();
        int count = 1;
        for (int i= 0;i< repeats();i++ ){
            if(i == Util.month){
                Util.array[i] = Util.depositAmount;
            }else{
                Util.array[i] = Util.array[i] - subextras;
            }

        }
        Util.array[Util.month-1] = Util.depositAmount;
        System.out.println("After applying Little bit of Logic");
        System.out.println("----------------------");
        Util.display();


    }
//if amount paid less than basic installment
    public void add() {
        int subextras = Util.extra/repeats();
        int count = 1;
        for (int i= 0;i< repeats();i++ ){
            if(i == Util.month){
                Util.array[i] = Util.depositAmount;
            }else{
                Util.array[i] = Util.array[i] + subextras;
            }

        }
        Util.array[Util.month-1] = Util.depositAmount;
        System.out.println("After applying Little bit of Logic");
        System.out.println("----------------------");
        Util.display();
    }

    /* In my Opinion As per requirements we cannot apply a logic
        We have to Add the rules for each and every
        Amount ,so I have applied the Logic that is
        if the Amount which as to be payable
        compare with the basic structure take the % of the extra amount
        if it is lies between below 20 to 40% extra amount will be divided into one
        equal amount.
    */

    public int repeats() {
//        System.out.println(Util.install);
        int amount20 = Math.round((int) (Util.install * (20.0f / 100.0f)));
        int amount40 = Math.round((int) (Util.install * (40.0f / 100.0f)));
        int amount60 = Math.round((int) (Util.install * (60.0f / 100.0f)));
        int amount80 = Math.round((int) (Util.install * (80.0f / 100.0f)));
        int amount99 = Math.round((int) (Util.install * (99.0f / 100.0f)));



//        System.out.println(amount40 + ">" + Util.extra);
//        System.out.println(amount80 + ">" + Util.extra);

        if (amount20 > Util.extra && Util.extra < amount40) {
            return 1;
        } else if (amount40 > Util.extra && Util.extra < amount60) {
            return 1;

        } else if (amount60 > Util.extra && Util.extra < amount80) {
            return 2;

        }else if (amount80 > Util.extra && Util.extra < amount99){
                    return 3;

        }else return 0;
    }

    public void validate() {
        if (Util.all() > Util.depositAmount) {
            int kachra = Util.all() - Util.depositAmount;
            Util.array[1] = Util.array[1] - kachra;
            Util.display();

        } else if (Util.all() < Util.depositAmount) {
            int kachra = Util.all() - Util.depositAmount;
            int i = 1;
            if (Util.month == i)
                Util.array[1 + i] = Util.array[1 + i] + kachra;
            Util.display();

        } else Util.display();
    }
    public void custom(){
        System.out.println("Enter no. of months to be splitted");
        Scanner sc1 = new Scanner(System.in);
        int noOfMonths = sc1.nextInt();
            for(int k = 1;k <= noOfMonths+1;k++){
                System.out.println("Enter  "+k+" Installment");
               Util.array[k] = sc1.nextInt();
            }
        Util.display();
    }
}
