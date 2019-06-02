package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.dtos.ActivityDTO;
import com.mkopec.apsi_backend.dtos.ActivityPostDTO;
import com.mkopec.apsi_backend.mapper.ActivityMapper;
import com.mkopec.apsi_backend.service.ActivityService;
import com.mkopec.apsi_backend.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final PersonService personService;
    private final ActivityMapper mapper;

    @GetMapping
    public List<ActivityDTO> getAllActivities() {
        return mapper.toActivityDTOs(activityService.getAllActivities());
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ActivityPostDTO postActivity(@RequestBody ActivityPostDTO activityPostDTO, @PathVariable Integer id) {

        Activity activity = mapper.toActivity(activityPostDTO);
        activity.setDate(Calendar.getInstance());
        activity.setPerson(personService.getSinglePerson(id));
        activity.setActivityTagId(1);

        Activity savedActivity = activityService.saveActivity(activity);

        return mapper.toActivityPostDTO(savedActivity);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
    }
}
