/**
 * Define Interface PCBS
 *
 * @author Jeramee Oliver
 * @version 9/17/2023
 */

public class JerameeOliverCSCI331Proj1 {

    public static long test(int n, int version) {
        PCB_V1 pcbs1 = new PCB_V1(5);
        PCB_V2 pcbs2 = new PCB_V2(5);

        long start = System.currentTimeMillis();

        // creates 1st child of PCB[0] at PCB[1]
        /* creates 2nd child of PCB[0] at PCB[2] */
        /* creates 1st child of PCB[2] at PCB[3] */
        /* creates 3rd child of PCB[0] at PCB[4] */
        /* destroys all descendants of PCB[0], which includes processes PCB[1] through PCB[4] */
        /* descendants is spelled with an "a" see above */
        /* descendents is the name of a punk rock band. */
        if (version == 1) {
            for (int i = 0; i < n; i++) {
                pcbs1.create(0);
                pcbs1.create(0);
                pcbs1.create(2);
                pcbs1.create(0);
                pcbs1.destroy(0);
            }
        } else {
            for (int i = 0; i < n; i++) {
                pcbs2.create(0);
                pcbs2.create(0);
                pcbs2.create(2);
                pcbs2.create(0);
                pcbs2.destroy(0);
            }
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) {
        // easy to modify how many times to run the loop
        // here I used 1000000
        long t1 = test(1000000, 1); // version 1 time
        long t2 = test(1000000, 2); // version 2 time
        long difference = t1 - t2;

        System.out.println("Version 1 used " + t1 + " milliseconds");
        System.out.println("Version 2 used " + t2 + " milliseconds");

        if (difference > 0)
            System.out.println("Version 1 is " + difference + " milliseconds slower");
        else
            System.out.println("Version 2 is " + -difference + " milliseconds slower");
    }

}
