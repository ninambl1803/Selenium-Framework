package automation.basic;

import org.testng.Assert;
import org.testng.annotations.Test;
import static automation.Main.kiem_tra_nguyen_am;

public class MainTest {

    @Test
    void a_la_nguyen_am(){
        Assert.assertTrue(kiem_tra_nguyen_am("a"));
    }
    @Test
    void number_khong_la_nguyen_am(){
        Assert.assertFalse(kiem_tra_nguyen_am("1"));
    }
}
