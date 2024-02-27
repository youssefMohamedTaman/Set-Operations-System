import java.util.ArrayList;
import java.util.Scanner;
public class Set {
    Scanner scan = new Scanner(System.in);
    private ArrayList<String> universe = new ArrayList<>();
     private int subsetsNum ;
     private ArrayList<Integer> subsets = new ArrayList<>();




    public Set(ArrayList<String> input) {
        this.universe = input ;
     }


    public void setSubsetsNum(int subsetsNum) {
        this.subsetsNum = subsetsNum;
    }

    public void setSubsets(ArrayList<Integer> subsets) {
        this.subsets = subsets;
    }

    public void print(int indexOfSubset) {
        int subsetRepresentative = subsets.get(indexOfSubset-1) ;
        boolean flag = false ;
        for (int i = 0; i < universe.size(); i++) {
            int valueOfBit = BitManipulation.getBit(subsetRepresentative, i);
            if (valueOfBit ==1) {
                System.out.printf(universe.get(i) + " ");
                flag = true ;
            }
            }
        if (!flag) {
            System.out.println("ϕ");
        }
        }


    private void printRepresentation(int Representative) {
        boolean flag = false ;
        for (int i = 0; i < universe.size(); i++) {
            int valueOfBit = BitManipulation.getBit(Representative, i);
            if (valueOfBit ==1) {
                System.out.printf(universe.get(i) + " ");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("ϕ");
        }
    }


    public void union(int firstsSubsetIndex, int secondSubsetIndex) {
        int firstSubsetRepresent = subsets.get(firstsSubsetIndex-1);
        int secondSubsetRepresent = subsets.get(secondSubsetIndex-1);
        int unionRepresent = firstSubsetRepresent | secondSubsetRepresent ;
        printRepresentation(unionRepresent); ;
    }

    private int intersectionOperation(int firstN, int secondN) {
        return (firstN & secondN);
    }

    public void intersection(int firstsSubsetIndex, int secondSubsetIndex) {
        int firstSubsetRepresent = subsets.get(firstsSubsetIndex-1);
        int secondSubsetRepresent = subsets.get(secondSubsetIndex-1);
        printRepresentation(intersectionOperation(firstSubsetRepresent , secondSubsetRepresent)); ;
    }

    public void complement(int subsetIndex) {
        int subsetRepresent = subsets.get(subsetIndex-1);
        int complement = ~subsetRepresent ;
        printRepresentation(complement);
    }

    public void difference(int firstIndex, int secondIndex) {
        printRepresentation(intersectionOperation(subsets.get(firstIndex-1) , ~subsets.get(secondIndex-1))); ;

    }
    public int cardinality(int index) {
        int representative = subsets.get(index - 1);
        int counter =0  ;
        while (representative > 0) {
            if (BitManipulation.getBit(representative , 0) == 1) {
                counter++ ;
            }
            representative = representative >> 1 ;
        }
        return (counter);
    }

    public void addSet() {
        System.out.println("Input the size of the subset:");
        int subsetSize = scan.nextInt();
        scan.nextLine();
        int subsetRepresentative = 0;
        for (int j = 0; j < subsetSize; j++) {
            System.out.printf("Input the #%d value:\n", j + 1);
            int index = universe.indexOf(scan.nextLine());
            subsetRepresentative = BitManipulation.setBit(subsetRepresentative, index);
        }

        subsets.add(subsetRepresentative);
    }


    public int getSubsetsNum() {
        return subsetsNum;
    }
}
