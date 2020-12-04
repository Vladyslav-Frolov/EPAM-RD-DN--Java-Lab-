package com.epam.hw2.hotelproject.timed;

//@Component
public class TimedController implements TimedControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
