package com.mkopec.apsi_backend.controller;


import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.dtos.ActivityDTO;
import com.mkopec.apsi_backend.mapper.ActivityMapper;
import com.mkopec.apsi_backend.service.ActivityService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    private ActivityMapper mapper = Mappers.getMapper(ActivityMapper.class);

    @GetMapping("/all")
    public List<ActivityDTO> getAllActivities() {
        List<Activity> activityList = activityService.getAllActivities();
        List<ActivityDTO> activityDTOList = new ArrayList<>();

        for (Activity p : activityList) {
            activityDTOList.add(mapper.toActivityDTO(p));
        }
        return activityDTOList;
    }
}
