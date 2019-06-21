package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.repository.ActivityRepository;
import com.mkopec.apsi_backend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository repository;
    private final PersonRepository personRepository;

    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    @Transactional
    public Activity saveActivity(Activity newActivity, Integer memberID) {
        Person person = personRepository.getOne(memberID);
        newActivity.setPerson(person);
        newActivity.setDate(Calendar.getInstance());
        newActivity.setActivityTagId(1);
        return repository.save(newActivity);
    }

    @Transactional
    public void deleteActivity(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    public Activity updateActivity(Activity newOne) {
        Activity old = repository.getOne(newOne.getId());
        old.setName(newOne.getName());
        old.setPoints(newOne.getPoints());
        return repository.save(old);
    }
}