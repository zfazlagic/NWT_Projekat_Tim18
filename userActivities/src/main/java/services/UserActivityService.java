package services;

import models.activity;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.stereotype.Service;
import repositories.activityRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserActivityService {

    private final activityRepository _activityRepository;

    public UserActivityService(activityRepository activityRepository) {
        _activityRepository = activityRepository;
    }

    public Collection<activity> getAllUserActivities() {
        Collection<activity> result = this._activityRepository.findAll();
        if (result.isEmpty()) {
            throw new NullArgumentException("There are no existing user activities!");
        }
        return result;
    }

    public Optional<activity> getActivityById(Long id) {
        Optional<activity> result = this._activityRepository.findById(id);
        if (!result.isPresent()) {
            throw new NullArgumentException("User activity with this ID" + id + " was NOT found!");
        }
        return result;
    }


}
