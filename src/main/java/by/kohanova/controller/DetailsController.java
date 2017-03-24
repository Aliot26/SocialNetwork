package by.kohanova.controller;

import by.kohanova.model.Details;
import by.kohanova.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/details")
public class DetailsController {
    private final DetailsService detailsService;

    @Autowired
    public DetailsController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Details> loadAll() {
        try {
            return detailsService.findAll();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateDetails(@RequestBody Details details){
        try {
            detailsService.update(details);
        } catch (Exception e) {
            System.out.println("Error in updating user's details");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> loadDetailsById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(detailsService.find(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
