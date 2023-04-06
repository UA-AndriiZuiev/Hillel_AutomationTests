package com.hillel.homework_11.data;

import com.hillel.homework_11.util.ConfigProvider;
import org.testng.annotations.DataProvider;

public class DataProviderMethods {
    @DataProvider
    public static Object[][] Source() {
        return new Object[][]{
                {ConfigProvider.topicForTest().get(0),
                        ConfigProvider.NEWSCOUNT_FRONTENDPAGE},
                {ConfigProvider.topicForTest().get(1).toString(),
                        ConfigProvider.NEWSCOUNT_QAPAGE},
                {ConfigProvider.topicForTest().get(2).toString(),
                        ConfigProvider.NEWSCOUNT_GAMEDEVPAGE}
        };
    }
}