package com.nikhilmangali1.Prime.service;

import org.springframework.stereotype.Service;

@Service
public class PrimeService {
    public boolean isPrime(int num) {
        if(num<2){
            return false;
        }
        if(num == 2) {
            return true;
        }
        for(int i = 2; i<=Math.sqrt(num);i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
