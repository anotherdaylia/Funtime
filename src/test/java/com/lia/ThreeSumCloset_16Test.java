package com.lia;

/**
 * Created by liqu on 3/16/16.
 */

import org.junit.Test;
import com.lia.Array.ThreeSumClosest_16;
public class ThreeSumCloset_16Test {

    @Test
    public void sumTest() {
        ThreeSumClosest_16 tsc = new ThreeSumClosest_16();
        int[] nums = new int[] {1,1,1,0};
        System.out.println("tsc = " + tsc.threeSumClosest(nums, -100));
    }
}
