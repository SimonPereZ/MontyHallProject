package se.comhem.test.montyhall;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.comhem.test.montyhall.manager.MontyHallManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MontyHallManagerTest {

    @Autowired
    private MontyHallManager testManager;

    @Test
    public void testCalculateWinRate() {
        double winRate = testManager.calculateWinRate(1000L, 777L);
        Assert.assertEquals(77.7, winRate, 0.1);
    }
}
