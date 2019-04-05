import java.util.ArrayList;

public class MergeSort {

    private ArrayList<Integer> sortList;

    public MergeSort(ArrayList<Integer> unsortedList){
        this.sortList = unsortedList;
    }

    public ArrayList<Integer> getSortList() {
        return this.sortList;
    }

    // Merge Sort
    private ArrayList<Integer> merge(ArrayList<Integer> leftHalf, ArrayList<Integer> rightHalf) {
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

    private ArrayList<Integer> doSort(ArrayList<Integer> sortMe) {
        if (sortMe.size() == 1) return sortMe;
        int length=sortMe.size();
        int middle = length/2;

        ArrayList<Integer> leftHalf = new ArrayList<>(sortMe.subList(0, middle));
        ArrayList<Integer> rightHalf = new ArrayList<>(sortMe.subList(middle, length));

        leftHalf = this.doSort(leftHalf);
        rightHalf = this.doSort(rightHalf);

        return this.merge(leftHalf, rightHalf);
    }

    public void sort(){
        this.doSort(this.sortList);
    }
}
