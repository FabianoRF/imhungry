package ifsuldeminas.pas.bcc.teii.imhungry.controller;

import ifsuldeminas.pas.bcc.teii.imhungry.model.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository _addressRepository;

    @RequestMapping(value = "/address", method =  RequestMethod.POST)
    public Address Post(@Valid @RequestBody Address address)
    {
        Address createdAddress = _addressRepository.save(address);
        return createdAddress;
    }

    @RequestMapping(value = "/address/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Address> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Address newAddress)
    {
        Optional<Address> oldAddress = _addressRepository.findById(id);
        if(oldAddress.isPresent()){
            Address address = oldAddress.get();
            address.setCity(newAddress.getCity());
            address.setDistrict(newAddress.getDistrict());
            address.setComplement(newAddress.getComplement());
            address.setNumber(newAddress.getNumber());

            _addressRepository.save(address);
            return new ResponseEntity<Address>(address, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Address> address = _addressRepository.findById(id);
        if(address.isPresent()){
            _addressRepository.delete(address.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public ResponseEntity<Address> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Address> address = _addressRepository.findById(id);
        if(address.isPresent())
            return new ResponseEntity<Address>(address.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
