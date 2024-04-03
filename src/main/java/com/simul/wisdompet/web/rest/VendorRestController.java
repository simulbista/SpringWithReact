package com.simul.wisdompet.web.rest;


import com.simul.wisdompet.data.services.VendorService;
import com.simul.wisdompet.web.errors.BadRequestException;
import org.springframework.web.bind.annotation.*;
import com.simul.wisdompet.web.models.Vendor;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorRestController {

    private final VendorService vendorService;

    public VendorRestController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/")
    public List<Vendor> getAll(){
        return this.vendorService.getVendors();
    }

    @PostMapping("/")
    public Vendor createVendor(Vendor vendor){
        return this.vendorService.createOrUpdateVendor(vendor);
    }

    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable("id") long id){
        return this.vendorService.getVendor(id);
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable("id") long id, Vendor vendor){
        if(id!=vendor.getVendorId()){
            throw new BadRequestException("Id in path and body do not match!");
        }
        return this.vendorService.createOrUpdateVendor(vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable("id") long id){
        this.vendorService.deleteVendor(id);
    }


}
