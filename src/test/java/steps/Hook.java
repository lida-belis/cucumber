package steps;

import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseUtil {
    private BaseUtil baseUtil;

    public Hook(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Before
    public void initializeTest() {
        System.out.println("Start test!");
    }

    @After
    public void teraDown() {
        System.out.println("Finish test!");
        baseUtil.driver.close();
    }
}
