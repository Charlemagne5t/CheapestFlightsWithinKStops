import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void findCheapestPriceTest1() {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;
        int expected = 700;
        int actual = new Solution().findCheapestPrice(n, flights, src, dst, k);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findCheapestPriceTest2() {
        int n = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},

        };
        int src = 0;
        int dst = 2;
        int k = 1;
        int expected = 200;
        int actual = new Solution().findCheapestPrice(n, flights, src, dst, k);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findCheapestPriceTest3() {
        int n = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},

        };
        int src = 0;
        int dst = 2;
        int k = 0;
        int expected = 500;
        int actual = new Solution().findCheapestPrice(n, flights, src, dst, k);

        Assert.assertEquals(expected, actual);
    }

}
