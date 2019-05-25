package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities() { return activityRepository.findAll(); }

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public void deleteActivity(Integer id) {
        activityRepository.deleteById(id);
    }
}