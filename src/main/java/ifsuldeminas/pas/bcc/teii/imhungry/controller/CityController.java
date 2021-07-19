package ifsuldeminas.pas.bcc.teii.imhungry.controller;

import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.City;
import ifsuldeminas.pas.bcc.teii.imhungry.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CityController {
    @Autowired
    private CityRepository _cityRepository;

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public List<City> Get() {
        return _cityRepository.findAll();
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> GetById(@PathVariable(value = "id") long id)
    {
        Optional<City> city = _cityRepository.findById(id);
        if(city.isPresent())
            return new ResponseEntity<City>(city.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/city", method =  RequestMethod.POST)
    public City Post(@Valid @RequestBody City city)
    {
        return _cityRepository.save(city);
    }
}
