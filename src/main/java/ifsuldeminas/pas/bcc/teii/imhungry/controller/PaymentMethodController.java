package ifsuldeminas.pas.bcc.teii.imhungry.controller;

import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.PaymentMethod;
import ifsuldeminas.pas.bcc.teii.imhungry.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PaymentMethodController {
    @Autowired
    private PaymentMethodRepository _paymentMethodRepository;

    @RequestMapping(value = "/payment-method", method = RequestMethod.GET)
    public List<PaymentMethod> Get() {
        return _paymentMethodRepository.findAll();
    }

    @RequestMapping(value = "/payment-method", method =  RequestMethod.POST)
    public PaymentMethod Post(@Valid @RequestBody PaymentMethod paymentMethod)
    {
        return _paymentMethodRepository.save(paymentMethod);
    }

    @RequestMapping(value = "/payment-method/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<PaymentMethod> paymentMethod = _paymentMethodRepository.findById(id);
        if(paymentMethod.isPresent()){
            _paymentMethodRepository.delete(paymentMethod.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/payment-method/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<PaymentMethod> Put(@PathVariable(value = "id") long id, @Valid @RequestBody PaymentMethod newMethod)
    {
        Optional<PaymentMethod> oldPaymentMethod = _paymentMethodRepository.findById(id);
        if(oldPaymentMethod.isPresent()){
            PaymentMethod paymentMethod = oldPaymentMethod.get();
            paymentMethod.setCardName(newMethod.getCardName());
            _paymentMethodRepository.save(paymentMethod);
            return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/payment-method/{id}", method = RequestMethod.GET)
    public ResponseEntity<PaymentMethod> GetById(@PathVariable(value = "id") long id)
    {
        Optional<PaymentMethod> paymentMethod = _paymentMethodRepository.findById(id);
        if(paymentMethod.isPresent())
            return new ResponseEntity<PaymentMethod>(paymentMethod.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
