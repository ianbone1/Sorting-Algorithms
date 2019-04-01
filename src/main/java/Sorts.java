import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Sorts {

    public static void main(String[] args) {

        int listSize = 1000;
        ArrayList<Integer> list= new ArrayList<>();
        ArrayList<Integer> bubbleList = new ArrayList<>();
        ArrayList<Integer> quickList = new ArrayList<>();
        ArrayList<Integer> mergeList = new ArrayList<>();
        ArrayList<Integer> shellList = new ArrayList<>();

        Random rand = new Random();
        int nextNum;
        for (int i=0; i<listSize; i++){
            nextNum=rand.nextInt(listSize);
            list.add(nextNum);
            bubbleList.add(nextNum);
            quickList.add(nextNum);
            mergeList.add(nextNum);
            shellList.add(nextNum);
        }

        String sort1 = "Quick sort";
        String sort2 = "Shell Sort";
        String sort3 = "Bubble Sort";
        String sort4 = "Merge Sort";

        System.out.println("List size to sort is: " + list.size());
        LocalDateTime startTime = LocalDateTime.now();

        quickList=QuickSort.quickSort(quickList);
        LocalDateTime sort1stop = LocalDateTime.now();

        shellList=ShellSort.shellSort(shellList);
        LocalDateTime sort2stop = LocalDateTime.now();

        bubbleList= BubbleSort.bubbleSort(bubbleList);
        LocalDateTime sort3stop = LocalDateTime.now();

        mergeList=MergeSort.mergeSort(mergeList);

        LocalDateTime sort4stop = LocalDateTime.now();

        System.out.println("Start time: " + startTime);
        System.out.println(sort1 + " took  : " + Duration.between(startTime, sort1stop).toMillis());
        System.out.println(sort2 + " took  : " + Duration.between(sort1stop, sort2stop).toMillis());
        System.out.println(sort3 + " took  : " + Duration.between(sort2stop, sort3stop).toMillis());
        System.out.println(sort4 + " took  : " + Duration.between(sort3stop, sort4stop).toMillis());

    }
}
