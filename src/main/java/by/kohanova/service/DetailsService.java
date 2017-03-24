package by.kohanova.service;


import by.kohanova.model.Details;

import java.util.List;

public interface DetailsService {

    List<Details> findAll();

    Details update(Details object);

    Details find(Integer id);


}

