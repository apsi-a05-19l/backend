package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.dtos.ActivityDTO;
import com.mkopec.apsi_backend.dtos.ActivityPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ActivityMapper {

    public abstract ActivityDTO toActivityDTO(Activity activity);

    @Mapping(target = "points", source = "activityPoints")
    @Mapping(target = "name", source = "activityName")
    public abstract Activity toActivity(ActivityPostDTO activityDTO);

    @Mapping(target = "activityPoints", source = "points")
    @Mapping(target = "activityName", source = "name")
    public abstract ActivityPostDTO toActivityPostDTO(Activity activity);

    public abstract List<ActivityDTO> toActivityDTOs(List<Activity> activities);
}
