import apijson.JSON;
import com.cmbi.toss.tradeoperate.TradeOperateApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * SpringbootSentinelredisApplicationTests
 *
 * @author caopengpeng
 * @Date 2021/11/25 11:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TradeOperateApplication.class)
public class SpringbootSentinelredisApplicationTests {

    @Autowired
    @Qualifier("bossRedisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    public void sentinelSet() {
        Map map = new HashMap();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        String data = JSON.toJSONString(map);
        redisTemplate.opsForValue().set("111", data);
        System.out.println("======写成功==============" + data);

    }

    @Test
    public void sentinelGet() {
        Object str = redisTemplate.opsForValue().get("111");
        System.out.println("======获取成功==============" + str);
    }
}