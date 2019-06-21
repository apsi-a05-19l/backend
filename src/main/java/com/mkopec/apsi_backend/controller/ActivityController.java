package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.dtos.ActivityDTO;
import com.mkopec.apsi_backend.dtos.ActivityPostDTO;
import com.mkopec.apsi_backend.mapper.ActivityMapper;
import com.mkopec.apsi_backend.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityMapper mapper;

    @GetMapping
    public List<ActivityDTO> getAllActivities() {
        return mapper.toActivityDTOs(activityService.getAllActivities());
    }

    @PostMapping("/{memberID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ActivityPostDTO postActivity(@RequestBody ActivityPostDTO activityPostDTO, @PathVariable Integer memberID) {
        Activity activity = mapper.toActivity(activityPostDTO);
        return mapper.toActivityPostDTO(activityService.saveActivity(activity, memberID));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ActivityPostDTO updateActivity(@RequestBody ActivityPostDTO postDTO) {
        Activity newOne = mapper.toActivity(postDTO);
        return mapper.toActivityPostDTO(activityService.updateActivity(newOne));
    }
}
