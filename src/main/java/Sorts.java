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
    private  static ArrayList<Integer> quickSort(ArrayList<Integer> list){

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

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> sortMe) {
        if (sortMe.size() == 1) return sortMe;
        int length=sortMe.size();
        int middle = length/2;

        ArrayList<Integer> leftHalf = new ArrayList<Integer>(sortMe.subList(0, middle));
        ArrayList<Integer> rightHalf = new ArrayList<Integer>(sortMe.subList(middle, length));

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        return merge(leftHalf, rightHalf);
    }

    public static void main(String[] args) {

        int listSize = 1000;
        ArrayList<Integer> list;
        Random rand = new Random();
        list = new ArrayList<>();
        for (int i=0; i<listSize; i++){
            list.add(rand.nextInt(listSize));
        }

//        System.out.println(list);
        System.out.println("List size in: " + list.size());
        LocalDateTime startTime = LocalDateTime.now();
        //list=bubbleSort(list);
        //list=quickSort(list);
        list=mergeSort(list);
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Start time: " + startTime);
        System.out.println("End time  : " + endTime);
        System.out.println("Duration  : " + Duration.between(startTime, endTime).toMillis());
        System.out.println("List size out: "+ list.size());
    }



}
