package com.fujitsu.delivery_fee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery-fee")
public class DeliveryFeeController {
    private final DeliveryFeeService deliveryFeeService;

    public DeliveryFeeController(DeliveryFeeService deliveryFeeService) {
        this.deliveryFeeService = deliveryFeeService;
    }

    @GetMapping
    public ResponseEntity<?> getDeliveryFee(@RequestParam String city, @RequestParam String vehicleType) {
        try {
            double fee = deliveryFeeService.calculateDeliveryFee(city, vehicleType);
            return ResponseEntity.ok(fee);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
