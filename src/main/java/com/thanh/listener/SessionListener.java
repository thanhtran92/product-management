package com.thanh.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionListener implements HttpSessionAttributeListener {

    private static int activeSessions = 0;

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        activeSessions++;
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (activeSessions > 0) {
            activeSessions--;
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

}
