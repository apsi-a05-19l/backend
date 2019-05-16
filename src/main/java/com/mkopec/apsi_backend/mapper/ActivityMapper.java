package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.dtos.ActivityDTO;
import org.mapstruct.Mapper;

@Mapper
public abstract class ActivityMapper {

    public abstract ActivityDTO toActivityDTO(Activity activity);

    public abstract Activity toActivity(ActivityDTO activityDTO);
}
