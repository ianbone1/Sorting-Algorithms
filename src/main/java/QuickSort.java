import java.util.ArrayList;

public class QuickSort {

    private ArrayList<Integer> sortList;

    public QuickSort(ArrayList<Integer> unsortedList) {
        this.sortList = unsortedList;
    }

    public ArrayList<Integer> getSortList() {
        return sortList;
    }

    //QuickSort Algorithm
    private ArrayList<Integer> doSort(ArrayList<Integer> list){

        if (list.size() <= 1) return list; // Already sorted

        Integer pivot = list.get(list.size()-1); // Use last as pivot

        ArrayList<Integer> lesserThanPivot = new ArrayList<Integer>();
        ArrayList<Integer> greaterThanPivot = new ArrayList<Integer>();

        for (int index = 0; index < list.size()-1; index++)
        {
            if (list.get(index).compareTo(pivot) < 0) //compareTo Returns -1 if this is smaller, 0 if equal, 1 if greater
                lesserThanPivot.add(list.get(index));
            else
                greaterThanPivot.add(list.get(index));
        }

        lesserThanPivot = this.doSort(lesserThanPivot);
        greaterThanPivot = this.doSort(greaterThanPivot);

        lesserThanPivot.add(pivot);
        lesserThanPivot.addAll(greaterThanPivot);

        return lesserThanPivot;
    }

    public void sort(){
        this.doSort(this.sortList);
    }


}
