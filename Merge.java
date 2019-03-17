public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    mergeH(data,0,data.length-1);
  }

  private static void mergeH(int[] data, int lo, int hi){
    if (lo >= hi+1){
      return;
    }
    int[] temp = new int[data.length];
    int j = 0;
    mergeH(data,lo,(lo+hi)/2);
    mergeH(data,(lo+hi)/2+1,hi);
    int a = lo;
    int b = (lo+hi)/2+1;
    while (a < (lo+hi)/2+1 && b < hi+1){
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
}
