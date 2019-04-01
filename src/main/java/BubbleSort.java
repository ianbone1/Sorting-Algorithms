import java.util.ArrayList;

public class BubbleSort {

    //Bubble Sort Algorithm

    public BubbleSort(){

    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> unsortedList){
        Boolean swapped = false;
        Integer temp =0;
        for (int i =0; i<unsortedList.size(); i++){
            swapped=false;
            for (int j=1; j<unsortedList.size(); j++){
                if (unsortedList.get(j) < unsortedList.get(j-1)){
                    temp=unsortedList.get(j);
                    unsortedList.remove(j);
                    unsortedList.add(j,unsortedList.get(j-1));
                    unsortedList.remove(j-1);
                    unsortedList.add(j-1, temp);
                    swapped=true;
                }
            }
            if (!swapped){
                break;
            }
        }
        return unsortedList;
    }
}
