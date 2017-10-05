package com.springmvc.auditing;

import java.time.ZonedDateTime;


public class CurrentDateTimeService implements DateTimeService {

    @Override
    public ZonedDateTime getCurrentDateAndTime() {
        return ZonedDateTime.now();
    }
}