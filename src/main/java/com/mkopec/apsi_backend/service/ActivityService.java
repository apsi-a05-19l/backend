package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() { return activityRepository.findAll(); }
}