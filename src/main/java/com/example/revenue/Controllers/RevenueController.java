package com.example.revenue.Controllers;

import com.example.revenue.Models.Revenue;
import com.example.revenue.Services.RevenueService;
import com.example.revenue.UserClient;
import com.example.revenue.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revenues")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;
    @Autowired
    private UserClient userClient;

    // ✅ GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Revenue> getRevenueById(@PathVariable Long id) {
        Revenue revenue = revenueService.getRevenueById(id);

        if (revenue != null) {
            return new ResponseEntity<>(revenue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ GET all
    @GetMapping
    public ResponseEntity<List<Revenue>> getAllRevenues() {
        return new ResponseEntity<>(revenueService.getAllRevenues(), HttpStatus.OK);
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<Revenue> addRevenue(@RequestBody Revenue revenue) {
        Revenue createdRevenue = revenueService.addRevenue(revenue);
        return new ResponseEntity<>(createdRevenue, HttpStatus.CREATED);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Revenue> updateRevenue(@PathVariable Long id,
                                                 @RequestBody Revenue newRevenue) {

        Revenue updatedRevenue = revenueService.updateRevenue(id, newRevenue);

        if (updatedRevenue != null) {
            return new ResponseEntity<>(updatedRevenue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRevenue(@PathVariable Long id) {

        String response = revenueService.deleteRevenue(id);

        if (response.equals("Revenue supprimé")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/User/{id}")
    public ResponseEntity<UserDTO> getRevenueByUserId(@PathVariable Long id) {
        UserDTO userDTO = userClient.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }


}