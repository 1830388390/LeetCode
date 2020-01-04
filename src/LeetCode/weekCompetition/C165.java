package LeetCode.weekCompetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C165 {


    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        if (tomatoSlices == 0 && cheeseSlices == 0) {
            return Arrays.asList(0, 0);
        }

        /**
         * small*2 + big*4 = tomato;
         * small + big = cheese;
         */

        if ((tomatoSlices - cheeseSlices * 2) % 2 == 1) {
            return new ArrayList<>();
        }
        int big = (tomatoSlices - cheeseSlices * 2) / 2;
        int small = cheeseSlices - big;
        if (small < 0 || big < 0) {
            return new ArrayList<>();
        }
        return Arrays.asList(big, small);

    }

    public int countSquares(int[][] matrix) {
        return 0;
    }
}
