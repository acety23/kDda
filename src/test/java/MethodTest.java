import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author tiyong
 * @date 27/09/2024 10:14
 */
public class MethodTest {

    @Test
    public void test() {
        List<String> list = Lists.asList("kobe", "michael", new String[]{"dwyane"});
        System.out.println(StringUtils.join(list));
    }
}
