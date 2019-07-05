package com.axle.chassisdemo.demo.service;

import ke.axle.chassis.utils.LoggerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoggerServiceImpl implements LoggerService {
    @Override
    public void log(String description, String entity, Object entityId, String activity, String activityStatus, String notes) {

    }

    @Override
    public boolean isInitiator(String Entity, Object entityId, String activity) {
        return false;
    }

    @Override
    public void log(String description, String entity, Object entityId, Long userId, String activity, String activityStatus, String notes) {

    }
}
