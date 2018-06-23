package Selection;

import java.awt.*;
import java.lang.reflect.Array;

/**
 * Created by apple on 2018/6/20.
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {

                if (less(nums[j], nums[min])) {
                    System.out.println(min + "less min");
                    System.out.println(j + "less j");
                    min = j;

                }
                System.out.println(min + "swap min");
                System.out.println(i + "swap i");
                swap(nums, i, min);

            }

        }
    }

    public static void main(String[] args){

        Integer[] arr ={1,6,3};
        Selection<Integer> test = new Selection();
        test.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }


    }


}
