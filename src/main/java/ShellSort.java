import java.util.ArrayList;

public class ShellSort {

    private ArrayList<Integer> sortList;

    public ShellSort(ArrayList<Integer> unsortedList){
        this.sortList = unsortedList;
    }

    // Shell Sort
    private ArrayList<Integer> gapInsertionSort(ArrayList<Integer> unsortedList, int start, int gap){
        for (int i=(start+gap); i<unsortedList.size(); i+=gap){
            int currentValue = unsortedList.get(i);
            int position = i;
            while ((position >= gap) && (unsortedList.get(position - gap)> currentValue)){
//                int tempValue = unsortedList.get(position);
                unsortedList.remove(position);
                unsortedList.add(position, unsortedList.get(position - gap));
                position-=gap;
            }
            unsortedList.remove(position);
            unsortedList.add(position,currentValue);
        }
        return unsortedList;
    }

    private ArrayList<Integer> shellSort(ArrayList<Integer> unsortedList){
        int sublistCount = unsortedList.size()/2;

        while (sublistCount > 0){
            for (int startPosition =0; startPosition<sublistCount; startPosition++){
                unsortedList=gapInsertionSort(unsortedList, startPosition, sublistCount);
            }
            sublistCount = sublistCount/2;
        }
        return unsortedList;
    }

    public void sort(){
        this.shellSort(this.sortList);
    }
}
