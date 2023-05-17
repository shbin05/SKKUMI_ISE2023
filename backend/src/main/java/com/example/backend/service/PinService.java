package com.example.backend.service;


import com.example.backend.domain.place.Pin;
import com.example.backend.domain.place.Place;
import com.example.backend.domain.user.AppUser;
import com.example.backend.dto.PinDto;
import com.example.backend.repo.PinRepo;
import com.example.backend.repo.PlaceRepo;
import com.example.backend.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PinService {
    private final PinRepo pinRepo;
    private final PlaceRepo placeRepo;
    private final UserRepo userRepo;

    @Transactional
    public void write(AppUser user, PinDto.PostRequest dto){
        Place place = placeRepo.findById(dto.getPlaceId()).orElseThrow();
        Pin pin =dto.toEntity(user,place);
        pinRepo.save(pin);

    }
    @Transactional
    public void delete(Long pin_id){
        pinRepo.deleteById(pin_id);
    }

}