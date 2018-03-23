public class Util {
    public static int totalMonths = 0;
    public static int[] array;

    /*month - Which moth to be paid
     depositAmount - amount Pays
     totalAmount - total amount
     remaingAmount - total - pays
     extra - how much extra or less paid then basic installment */
    public static int month, depositAmount, install, totalAmount, remainingAmount, extra, total = 0;


    //displaying the Installment list
    public static void display() {
        int count = 1;
        for (int i = 0; i < array.length; i++) {

            System.out.println("installment " + count + "--- " + array[i]);
            count++;
        }
    }

    //calculate total amount in the array
    public static int all() {

        for (int i = 0; i < array.length; i++) {
            total = total + array[i];
//            System.out.println("total " + total);

        }
        return total;
    }

}
