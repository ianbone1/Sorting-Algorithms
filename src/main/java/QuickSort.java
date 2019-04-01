import java.util.ArrayList;

public class QuickSort {

    public QuickSort() {

    }

    //QuickSort Algorithm
    public static ArrayList<Integer> quickSort(ArrayList<Integer> list){

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

        lesserThanPivot = quickSort(lesserThanPivot);
        greaterThanPivot = quickSort(greaterThanPivot);

        lesserThanPivot.add(pivot);
        lesserThanPivot.addAll(greaterThanPivot);

        return lesserThanPivot;
    }
}
