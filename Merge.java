public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    mergeH(data,0,data.length-1)
  }

  private static void mergeH(int[]data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    mergesort(data,0,hi/2);
  }
}
