package com.mkopec.apsi_backend.controller;


import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.dtos.ActivityDTO;
import com.mkopec.apsi_backend.dtos.ActivityPostDTO;
import com.mkopec.apsi_backend.mapper.ActivityMapper;
import com.mkopec.apsi_backend.service.ActivityService;
import com.mkopec.apsi_backend.service.PersonService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private PersonService personService;

    private ActivityMapper mapper = Mappers.getMapper(ActivityMapper.class);

    @GetMapping
    public List<ActivityDTO> getAllActivities() {
        List<Activity> activityList = activityService.getAllActivities();
        return mapper.toActivityDTOs(activityList);
    }

    @PostMapping("/{id}")
    public ActivityPostDTO postActivity(@RequestBody ActivityPostDTO activityPostDTO, @PathVariable Integer id) {

        Activity activity = mapper.toActivity(activityPostDTO);
        activity.setDate(Calendar.getInstance());
        activity.setPerson(personService.getSinglePerson(id));
        activity.setActivityTagId(1);

        Activity savedActivity = activityService.saveActivity(activity);

        return mapper.toActivityPostDTO(savedActivity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
    }
}
