package test;

import manager.ApplicationManager;
import org.junit.Before;

public class TestBase {
    protected static ApplicationManager app;

    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
    }
}
