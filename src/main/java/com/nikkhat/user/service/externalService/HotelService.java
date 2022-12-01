package com.nikkhat.user.service.externalService;

import com.nikkhat.user.service.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/api/getHotel/{id}")
    Hotel getHotel(@PathVariable ("id") String id);

}
