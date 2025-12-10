package com.fabpont.dev.sebo_virtual.controllers;

import com.fabpont.dev.sebo_virtual.DTO.request.AdRequestDTO;
import com.fabpont.dev.sebo_virtual.DTO.response.AdResponseDTO;
import com.fabpont.dev.sebo_virtual.entities.Ad;
import com.fabpont.dev.sebo_virtual.exceptions.ResourceNotFoundException;
import com.fabpont.dev.sebo_virtual.services.AdService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ad")
public class AdController {

    private final AdService adService;

    @PostMapping
    public AdResponseDTO createAd(@Valid @RequestBody AdRequestDTO adRequestDTO) throws ResourceNotFoundException {
        return adService.createAd(adRequestDTO);
    }

    @DeleteMapping("/ad/{id}")
    public void deleteAd(@Valid @PathVariable Long id) throws ResourceNotFoundException {
        adService.deleteById(id);
    }
    @GetMapping("/ad/{id}")
    public Optional<Ad> getAd(@Valid @PathVariable Long id){
        return adService.findById(id);
    }

}
