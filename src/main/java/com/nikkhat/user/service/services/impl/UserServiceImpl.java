package com.nikkhat.user.service.services.impl;

import com.nikkhat.user.service.entity.Hotel;
import com.nikkhat.user.service.entity.Rating;
import com.nikkhat.user.service.entity.User;
import com.nikkhat.user.service.exceptions.ResourceNotFoundException;
import com.nikkhat.user.service.externalService.HotelService;
import com.nikkhat.user.service.repository.UserRepository;
import com.nikkhat.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {

       String randomUserId= UUID.randomUUID().toString();   // generate unique Userid
       user.setUserId(randomUserId);
        return this.userRepository.save(user);
    }


    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }


    //get single user
    @Override
    public User getUser(String userId) {

              User user= this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException(" user With Given Id is not found On Server !!  given User Id :"+userId));

            //fetch rating of the above User From Rating service

        // localhost:8084/api/getAllRatingsbyUserId/64afc0a3-072c-48a3-b5bc-26cb20ee5c2e

        Rating[] ratingsOfUsers = restTemplate.getForObject("http://RATING-SERVICE/api/getAllRatingsbyUserId/"+user.getUserId(), Rating[].class);

        logger.info("{}", ratingsOfUsers);
       List<Rating> ratings= Arrays.stream(ratingsOfUsers).toList();
       List<Rating>ratingList= ratings.stream().map(rating -> {

            //api call to hotel service to get the hotel

            // return rating

//           ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/getHotel/"+rating.getHotelId(),Hotel.class);

//           Hotel hotel=forEntity.getBody();
           Hotel hotel =hotelService.getHotel(rating.getHotelId());
//           logger.info("response status code {}",forEntity.getStatusCode());

           //set the hotel Rating
           rating.setHotel(hotel);
            return rating;

        }).collect(Collectors.toList());

       //set ratings
        user.setRatings(ratingList);
              return user;

    }

    @Override
    public void deleteUser(String userId) {

    }
}
