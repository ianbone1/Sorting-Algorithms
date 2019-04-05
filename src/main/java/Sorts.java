import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Sorts {

    public static void main(String[] args) {

        int listSize = 1000;
        //build a random list
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        Random rand = new Random();
        int nextNum;
        for (int i=0; i<listSize; i++){
            nextNum=rand.nextInt(listSize);
            list1.add(nextNum);
            list2.add(nextNum);
            list3.add(nextNum);
            list4.add(nextNum);
        }

        //setup sort lists
        BubbleSort bubbleList = new BubbleSort(list1);
        QuickSort quickList   = new QuickSort(list2);
        MergeSort mergeList   = new MergeSort(list3);
        ShellSort shellList   = new ShellSort(list4);


        String sort1 = "Quick sort";
        String sort2 = "Shell Sort";
        String sort3 = "Bubble Sort";
        String sort4 = "Merge Sort";

        System.out.println("List size to sort is: " + list1.size());
        LocalDateTime startTime = LocalDateTime.now();

        quickList.sort();
        LocalDateTime sort1stop = LocalDateTime.now();

        shellList.sort();
        LocalDateTime sort2stop = LocalDateTime.now();

        bubbleList.sort();
        LocalDateTime sort3stop = LocalDateTime.now();

        mergeList.sort();
        LocalDateTime sort4stop = LocalDateTime.now();

        System.out.println("Start time: " + startTime);
        System.out.println(sort1 + " took  : " + Duration.between(startTime, sort1stop).toMillis());
        System.out.println(sort2 + " took  : " + Duration.between(sort1stop, sort2stop).toMillis());
        System.out.println(sort3 + " took  : " + Duration.between(sort2stop, sort3stop).toMillis());
        System.out.println(sort4 + " took  : " + Duration.between(sort3stop, sort4stop).toMillis());

    }
}
