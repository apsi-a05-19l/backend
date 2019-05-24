package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.dtos.ActivityDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ActivityMapper {

    public abstract ActivityDTO toActivityDTO(Activity activity);

    public abstract Activity toActivity(ActivityDTO activityDTO);

    public abstract List<ActivityDTO> toActivityDTOs(List<Activity> activities);
    public abstract List<Activity> toActivities(List<ActivityDTO> activityDTOS);
}
