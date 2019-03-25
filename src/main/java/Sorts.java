import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Sorts {

    //Bubble Sort Algorithm
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
                System.out.println(i);
                break;
            }
        }
        return unsortedList;
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

    public static void main(String[] args) {
        ArrayList<Integer> list;
        Random rand = new Random();
        int n = rand.nextInt(1000);
        list = new ArrayList<Integer>();
        for (int i=0; i<1000; i++){
            list.add(rand.nextInt(1000));
        }

//        System.out.println(list);
        LocalDateTime startTime = LocalDateTime.now();
        //list=bubbleSort(list);
        list=quickSort(list);
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Start time: " + startTime);
        System.out.println("End time  : " + endTime);
        System.out.println("Duration  : " + Duration.between(startTime, endTime).toMillis());
        System.out.println(list.size());
//        System.out.println(list);
    }



}
