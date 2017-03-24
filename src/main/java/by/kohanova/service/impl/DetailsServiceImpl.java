package by.kohanova.service.impl;

import by.kohanova.model.Details;
import by.kohanova.repository.DetailsRepository;
import by.kohanova.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsServiceImpl implements DetailsService {

    private final DetailsRepository detailsRepository;

    @Autowired
    public DetailsServiceImpl(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    @Override
    public List<Details> findAll() {
        return detailsRepository.findAll();
    }

    @Override
    public Details update(Details object) {
        return detailsRepository.save(object);
    }

    @Override
    public Details find(Integer id) {
        return detailsRepository.findOne(id);
    }
}

