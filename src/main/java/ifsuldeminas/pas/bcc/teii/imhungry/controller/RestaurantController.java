package ifsuldeminas.pas.bcc.teii.imhungry.controller;

import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.Restaurant;
import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.User;
import ifsuldeminas.pas.bcc.teii.imhungry.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    private RestaurantRepository _restaurantRepository;

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
    public List<Restaurant> Get() {
        return _restaurantRepository.findAll();
    }

    @RequestMapping(value = "/restaurant", method =  RequestMethod.POST)
    public Restaurant Post(@Valid @RequestBody Restaurant restaurant)
    {
        return _restaurantRepository.save(restaurant);
    }

    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Restaurant> restaurant = _restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            _restaurantRepository.delete(restaurant.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/restaurant/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Restaurant> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Restaurant newUser)
    {
        Optional<Restaurant> oldRestaurant = _restaurantRepository.findById(id);
        if(oldRestaurant.isPresent()){
            Restaurant restaurant = oldRestaurant.get();
            restaurant.setAddress(newUser.getAddress());
            restaurant.setCnpj(newUser.getCnpj());
            _restaurantRepository.save(restaurant);
            return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
    public ResponseEntity<Restaurant> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Restaurant> user = _restaurantRepository.findById(id);
        if(user.isPresent())
            return new ResponseEntity<Restaurant>(user.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
