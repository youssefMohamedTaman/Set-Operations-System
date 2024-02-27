import java.util.Scanner;

public class BitManipulation {

    static Scanner scan = new Scanner(System.in);


    private static void checkValidPosition(int position) {
        while (position < 0 || position>=32) {
            System.out.println("Invalid index, Please input a valid index.");
            position = scan.nextInt();
        }
    }
    public static  int getBit(int number, int position) {
        checkValidPosition(position) ;
        int requiredBit = 1 << position ;
        int valueOfBit = 0 ;
        if ((number & requiredBit) == requiredBit) {
            valueOfBit = 1 ;
        }
        return(valueOfBit);
    }
    public static int setBit(int number, int position) {
        checkValidPosition(position) ;
        int requiredBit = 1 << position ;
        return (number | requiredBit);
    }
    public static int clearBit(int number, int position) {
        checkValidPosition(position) ;
       int requiredBit = ~(1 << position) ;
        return (number & requiredBit);
    }
    public  static int updateBit(int number, int position, boolean value) {
        checkValidPosition(position) ;
        if (value) {
            return (setBit(number, position));
        }
        else{
            return (clearBit(number, position));
        }
    }
}
