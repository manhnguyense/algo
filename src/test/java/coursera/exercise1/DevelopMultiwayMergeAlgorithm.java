package coursera.exercise1;

import org.junit.jupiter.api.Test;
import sort.GsonUtils;

public class DevelopMultiwayMergeAlgorithm {

    @Test
    public void test() {
        int[] a = {-2, 4, 5, 8};
        int[] b = {-1, 3, 6, 7};

        System.out.println(GsonUtils.toString(twoWayMerge(a, b)));

    }
    /*
    We studied the problem of merging 2 sorted lists lst1 and lst2 into a single sorted list in time  Θ(𝑚+𝑛)
     where  𝑚 is the size of lst1 and  𝑛 is the size of lst2. Let twoWayMerge(lst1, lst2)
     represent the python function that returns the merged result using the approach presented in class.

     In this problem, we will explore algorithms for merging k different sorted lists,
      usually represented as a list of sorted lists into a single list.

      Suppose we have  𝑘 lists that we will represent as lists[0], lists[1], ..., lists[k-1]
      for convenience and the size of these lists are all assumed to be the same value  𝑛 .

      We wish to solve multiway merge by merging two lists at a time:
      mergedList = lists[0] # start with list 0
  for i = 1, ... k-1 do
      mergedList = twoWayMerge(mergedList, lists[i])
  return mergedList
Knowing the running time of the twoWayMerge algorithm as mentioned above, what is the overall running time of the algorithm in terms of  𝑛,𝑘
 .
     */

    public int[] twoWayMerge(int[] a, int[] b) {
        int nA = a.length;
        int nB = b.length;
        int[] result = new int[nA + nB];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nA && j < nB) {
            if (a[i] <= b[j]) {
                result[index] = a[i];
                i++;
            } else {
                result[index] = b[j];
                j++;
            }
            index++;
        }
        while (i < nA) {
            result[index] = a[i];
            i++;
            index++;
        }
        while (j < nB) {
            result[index] = b[j];
            j++;
            index++;
        }
        return result;
    }

}
