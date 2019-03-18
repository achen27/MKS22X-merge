import java.util.Arrays;

public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    mergeH(data,0,data.length-1);
  }

  private static void mergeH(int[] data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    mergeH(data,lo,(lo+hi)/2);
    mergeH(data,(lo+hi)/2+1,hi);
    merge(data, lo, (lo+hi)/2, hi);
  }

  public static void merge(int[] data, int lo, int mid, int hi){
    int[] temp = new int[hi-lo];
    for (int i = 0; i <= hi; i++){

    }
    while (a < (lo+hi)/2 && b < hi){
      if (a <= b){
        temp[j] = data[a];
        a++;
      } else {
        temp[j] = data[b];
        b++;
      }
      j++;
    }
  }

  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
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
}
}
