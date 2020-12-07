package com.epam.hw3.hotelproject.timed;

import org.springframework.stereotype.Component;

@Component
public class TimedController implements TimedControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
