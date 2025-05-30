package test;

import manager.ApplicationManager;

public class TestBase {
    protected ApplicationManager getApp() {
        return ApplicationManager.getInstance();
    }
}
