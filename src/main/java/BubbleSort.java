import java.util.ArrayList;

public class BubbleSort {

    //Bubble Sort Algorithm

    private ArrayList<Integer> sortList;

    public BubbleSort(ArrayList<Integer> unsortedList){
        this.sortList = unsortedList;
    }

    public ArrayList<Integer> getList() {
        return this.sortList;
    }

    public void sort(){
        Boolean swapped = false;
        Integer temp;
        for (int i = 0; i<this.sortList.size(); i++){
            swapped=false;
            for (int j = 1; j<this.sortList.size(); j++){
                if (this.sortList.get(j) < this.sortList.get(j-1)){
                    temp=this.sortList.get(j);
                    this.sortList.remove(j);
                    this.sortList.add(j,this.sortList.get(j-1));
                    this.sortList.remove(j-1);
                    this.sortList.add(j-1, temp);
                    swapped=true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }
}
