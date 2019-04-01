import java.util.ArrayList;

public class MergeSort {

    // Merge Sort
    private static ArrayList<Integer> merge(ArrayList<Integer> leftHalf, ArrayList<Integer> rightHalf) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();

        while ((leftHalf.size() > 0) && (rightHalf.size() > 0)) {
            if (leftHalf.get(0) > rightHalf.get(0)) {
                sorted.add(rightHalf.remove(0));
            } else {
                sorted.add(leftHalf.remove(0));
            }
        }

        while (leftHalf.size() > 0) {
            sorted.add(leftHalf.remove(0));
        }

        while (rightHalf.size() > 0) {
            sorted.add(rightHalf.remove(0));
        }

        return sorted;
    }

    public  static ArrayList<Integer> mergeSort(ArrayList<Integer> sortMe) {
        if (sortMe.size() == 1) return sortMe;
        int length=sortMe.size();
        int middle = length/2;

        ArrayList<Integer> leftHalf = new ArrayList<Integer>(sortMe.subList(0, middle));
        ArrayList<Integer> rightHalf = new ArrayList<Integer>(sortMe.subList(middle, length));

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        return merge(leftHalf, rightHalf);
    }

}
