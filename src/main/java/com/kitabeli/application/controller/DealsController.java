package com.kitabeli.application.controller;

import com.kitabeli.application.model.DealModel;
import com.kitabeli.application.service.DealsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://locahost:3000")
public class DealsController {

    @Autowired
    private DealsService activeDealsService;

    @GetMapping("/{status}/deals")
    public ResponseEntity<List<DealModel>> fetchActiveDeals(@PathVariable("status") String status){
        log.info("Received a request to fetch {} deals ", status);
        return new ResponseEntity(activeDealsService.fetchDeals(status), HttpStatus.OK);
    }

    @GetMapping("/refresh/deals")
    public ResponseEntity<List<DealModel>> creatDealsManually(){
        log.info("Received a request to refresh the deals ");
        activeDealsService.refreshDeals();
        return new ResponseEntity(activeDealsService.fetchDeals("active"), HttpStatus.CREATED);
    }
}
