package ifsuldeminas.pas.bcc.teii.imhungry.controller;

import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.Food;
import ifsuldeminas.pas.bcc.teii.imhungry.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {

    @Autowired
    private FoodRepository _foodRepository;

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public List<Food> Get() {
        return _foodRepository.findAll();
    }

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public ResponseEntity<Food> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Food> food = _foodRepository.findById(id);
        if(food.isPresent())
            return new ResponseEntity<Food>(food.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/food", method =  RequestMethod.POST)
    public Food Post(@Valid @RequestBody Food food)
    {
        return _foodRepository.save(food);
    }

    @RequestMapping(value = "/food/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Food> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Food newFood)
    {
        Optional<Food> oldFood = _foodRepository.findById(id);
        if(oldFood.isPresent()){
            Food food = oldFood.get();
            food.setTitle(newFood.getTitle());
            food.setDescription(newFood.getDescription());
            food.setPrice(newFood.getPrice());
            food.setQuantity(newFood.getQuantity());
            _foodRepository.save(food);
            return new ResponseEntity<Food>(food, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/food/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Food> pessoa = _foodRepository.findById(id);
        if(pessoa.isPresent()){
            _foodRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
