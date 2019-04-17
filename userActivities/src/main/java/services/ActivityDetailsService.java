package services;

import models.activityDetails;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.stereotype.Service;
import repositories.activityDetailsRepository;
import java.util.Collection;
import java.util.Optional;

@Service
public class ActivityDetailsService {

    private final activityDetailsRepository _detailsRepository;

    public ActivityDetailsService(activityDetailsRepository detailsRepo) {
        _detailsRepository = detailsRepo;
    }

    public Collection<activityDetails> getAllActivityDetails() {
        Collection<activityDetails> result = this._detailsRepository.findAll();
        if (result.isEmpty()) {
            throw new NullArgumentException("There are no existing activity details!");
        }
        return result;
    }

    public Optional<activityDetails> getActivityDetailById(Long id) {
        Optional<activityDetails> result = this._detailsRepository.findById(id);
        if (!result.isPresent()) {
            throw new NullArgumentException("User activity detail with this ID" + id + " was NOT found!");
        }
        return result;
    }


}