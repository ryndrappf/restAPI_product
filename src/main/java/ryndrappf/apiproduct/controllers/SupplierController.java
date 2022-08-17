package ryndrappf.apiproduct.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ryndrappf.apiproduct.dto.ResponseData;
import ryndrappf.apiproduct.dto.SearchData;
import ryndrappf.apiproduct.dto.SupplierData;
import ryndrappf.apiproduct.models.entities.Supplier;
import ryndrappf.apiproduct.services.SupplierService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Supplier>> create(@Valid @RequestBody SupplierData supplierData, Errors errors){
        ResponseData<Supplier> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Supplier supplier = modelMapper.map(supplierData, Supplier.class);
        responseData.setStatus(true);
        responseData.setPayLoad(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Supplier> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier findOne(@PathVariable("id") Long id){
        return supplierService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Supplier>> update(@Valid @RequestBody SupplierData supplierData, Errors errors){
        ResponseData<Supplier> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Supplier supplier = modelMapper.map(supplierData, Supplier.class);
        responseData.setStatus(true);
        responseData.setPayLoad(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/search/byEmail")
    public Supplier findByEmail(@RequestBody SearchData searchData){
        return supplierService.findByEmail(searchData.getSearchKey());
    }

    @PostMapping("/search/byNameContains")
    public List<Supplier> findByNameContains(@RequestBody SearchData searchData){
        return supplierService.findByNameContainsOrdrByIdDesc(searchData.getSearchKey());
    }

    @PostMapping("/search/bynameStartingWith")
    public List<Supplier> findByNameStartingWith(@RequestBody SearchData searchData){
        return supplierService.findByNameStartingWith(searchData.getSearchKey());
    }

    @PostMapping("/search/byNameOrEmail")
    public List<Supplier> findByNameContainsOrEmailContains(@RequestBody SearchData searchData){
        return supplierService.findByNameContainsOrEmailContains(searchData.getSearchKey(), searchData.getOtherSearchKey());
    }
}
