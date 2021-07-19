package ifsuldeminas.pas.bcc.teii.imhungry.controller;

import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.Orders;
import ifsuldeminas.pas.bcc.teii.imhungry.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository _orderRepository;

    @RequestMapping(value = "/order", method =  RequestMethod.POST)
    public Orders Order(@Valid @RequestBody Orders order)
    {
        return _orderRepository.save(order);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Orders> Get() {
        return _orderRepository.findAll();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public ResponseEntity<Orders> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Orders> order = _orderRepository.findById(id);
        if(order.isPresent())
            return new ResponseEntity<Orders>(order.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
