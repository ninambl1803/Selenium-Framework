package automation.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import static automation.Main.phan_tu_lon_nhat_trong_mang;
import static automation.Main.swap;

public class ArrayTest {
    @Test
    void maxValueIndex(){
        Assert.assertEquals(phan_tu_lon_nhat_trong_mang(new int[]{1,7,0,4,2,9}),5);
    }
    @Test
    void swapTest(){
        Assert.assertEquals(swap(new int[]{-1,2,3,-4,-7,8},1,5),new int[]{-1,8,3,-4,-7,2});
    }

}
