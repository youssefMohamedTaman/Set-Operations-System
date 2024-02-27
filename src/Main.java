import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        System.out.println("Input the size of the universe");
        int size = scan.nextInt();
        scan.nextLine();                                          // reads leftover characters in input buffer.
        ArrayList<String> universe = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.printf("Input the value #%d:\n", i + 1);
            String input = scan.nextLine();
            if (!universe.contains(input)) {
                universe.add(input);
            }
        }
        Set set = new Set(universe);


        System.out.println("Input the number of subsets:");
        int subsetsNum = scan.nextInt();
        scan.nextLine();
        set.setSubsetsNum(subsetsNum);
        ArrayList<Integer> subsets = new ArrayList<>(subsetsNum);
        for (int i = 0; i < subsetsNum; i++) {
            System.out.printf("Input the size of #%d subset:\n", i + 1);
            int subsetSize = scan.nextInt();
            scan.nextLine();
            int subsetRepresentative = 0;
            for (int j = 0; j < subsetSize; j++) {
                System.out.printf("Input the #%d value:\n", j + 1);
                int index = universe.indexOf(scan.nextLine());
                if(index != -1) {
                    subsetRepresentative = BitManipulation.setBit(subsetRepresentative, index);
                }
            }
            subsets.add(subsetRepresentative);
        }
        set.setSubsets(subsets);

        boolean flag = false;
        while (!flag){

            System.out.println("\n");
            System.out.println("1) Union of two sets\n2) Intersection of two sets\n3) Complement of a set\n4) Difference between two sets\n5) Cardinality of a set\n6) Print a set\n7)add set\n8)end program" );
        int choice = scan.nextInt();
        scan.nextLine();
            switch (choice) {

                case 1:
                    System.out.println("input the index of the first set");
                    int firstSet = scan.nextInt();
                    scan.nextLine();
                    System.out.println("input the index of the second set");
                    int secondSet = scan.nextInt();
                    scan.nextLine();
                    set.union(firstSet, secondSet);
                    break;
                case 2:
                    System.out.println("input the index of the first set");
                    firstSet = scan.nextInt();
                    scan.nextLine();
                    System.out.println("input the index of the second set");
                    secondSet = scan.nextInt();
                    scan.nextLine();
                    set.intersection(firstSet, secondSet);
                    break;
                case 3:
                    System.out.println("input the index of the set");
                    firstSet = scan.nextInt();
                    scan.nextLine();
                    set.complement(firstSet);
                    break;
                case 4:
                    System.out.println("input the index of the first set");
                    firstSet = scan.nextInt();
                    scan.nextLine();
                    System.out.println("input the index of the second set");
                    secondSet = scan.nextInt();
                    scan.nextLine();
                    set.difference(firstSet, secondSet);
                    break;
                case 5:
                    System.out.println("input the index of the set");
                    firstSet = scan.nextInt();
                    scan.nextLine();
                    System.out.println(set.cardinality(firstSet));
                    break;
                case 6:
                    System.out.println("input the index of the set");
                    firstSet = scan.nextInt();
                    scan.nextLine();
                    set.print(firstSet);
                    break;
                case 7:
                   set.addSet();
                   break;
                case 8:
                    flag = true ;


            }


        }
    }

    }


