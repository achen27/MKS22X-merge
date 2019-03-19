import java.util.Arrays;

public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){ //wrapper
    //int[] temp = new int[data.length];
    mergeH(data,0,data.length-1); //helper
  }

  private static void mergeH(int[] data, int lo, int hi){ //sort helper
    if (lo >= hi){
      return;
    }
    mergeH(data,lo,(lo+hi)/2); //spliting array in halves
    mergeH(data,(lo+hi)/2+1,hi);
    merge(data,lo,(lo+hi)/2+1,hi); //helper method to merge
  }

  public static void merge(int[] data, int lo, int mid, int hi){ //sort helper helper
    int[] temp = new int[hi-lo+1]; //temp array
    int a = lo; //stores values in variables
    int b = mid;
    for(int i = 0; i < temp.length; i++){ //sorting values into temp
      if (a < mid && b <= hi){ //while indexes are still in the two groups
        if (data[a] <= data[b]){
          temp[i] = data[a];
          a++;
        } else {
          temp[i] = data[b];
          b++;
        }
      } else if (a >= mid){ //a is out of bounds
        temp[i] = data[b];
        b++;
      } else { //b is out of bounds
        temp[i] = data[a];
        a++;
      }
    }

    int i = lo; //idx for original array
    for(int j = 0; j < temp.length; j++){ //loop through temp
      data[i] = temp[j]; //copying
      i++;
    }

  }

  private static void insertionsort(int[] data, int lo, int hi){
    for (int i = 1; i < data.length; i++){
      int temp = data[i];
      int j = i;
      while (j > 0 && data[j-1] > temp){//shift until the number on the left is not larger
        data[j] = data[j-1];
        j--;
      }
      data[j] = temp;
    }
  }

  public static void main(String[]args){
    int[] ary = {4,3,2,10,12,1,5,6};
    Merge.insertionsort(ary,0,ary.length-1);
    System.out.println(Arrays.toString(ary));
    /*System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Merge.mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
    //int[] ary = {38,27,43,3,9,82,10};
    //mergesort(ary);*/
  }
}
