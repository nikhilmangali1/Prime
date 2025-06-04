package com.nikhilmangali1.Prime.controller;

import com.nikhilmangali1.Prime.service.PrimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prime")
public class PrimeController {

    private final PrimeService primeService;

    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> isPrime(@PathVariable String number) {
        try {
            int num = Integer.parseInt(number);

            if (num < 0) {
                return ResponseEntity.badRequest().body(Map.of(
                        "error", "Negative numbers are not allowed."
                ));
            }

            boolean isPrime = primeService.isPrime(num);

            return ResponseEntity.ok(Map.of(
                    "number", num,
                    "isPrime", isPrime
            ));

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "Invalid input!"
            ));
        }
    }
}
