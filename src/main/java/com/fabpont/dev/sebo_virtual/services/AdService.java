package com.fabpont.dev.sebo_virtual.services;

import com.fabpont.dev.sebo_virtual.DTO.request.AdRequestDTO;
import com.fabpont.dev.sebo_virtual.DTO.response.AdResponseDTO;
import com.fabpont.dev.sebo_virtual.Enum.AdStatus;
import com.fabpont.dev.sebo_virtual.entities.Ad;
import com.fabpont.dev.sebo_virtual.entities.Book;
import com.fabpont.dev.sebo_virtual.entities.User;
import com.fabpont.dev.sebo_virtual.exceptions.ResourceNotFoundException;
import com.fabpont.dev.sebo_virtual.repositories.AdRepository;
import com.fabpont.dev.sebo_virtual.repositories.BookRepository;
import com.fabpont.dev.sebo_virtual.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Transactional
    public AdResponseDTO createAd(AdRequestDTO adcreateDTO) throws ResourceNotFoundException {
        User user = userRepository.findById(adcreateDTO.getUseId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado com o ID: " + adcreateDTO.getUseId()));

        Book book = bookRepository.findById(adcreateDTO.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Livro nao encontrado com o Id: " + adcreateDTO.getBookId()));

        Ad ad = new Ad();
        ad.setUser(user);
        ad.setBook(book);
        ad.setPrice(adcreateDTO.getPrice());
        ad.setBookCondition(adcreateDTO.getBookCondition());
        ad.setAdStatus(AdStatus.ACTIVE);
        ad.setAdDate(LocalDateTime.now());

        Ad savedAd = adRepository.save(ad);

        return AdResponseDTO.fromEntity(savedAd); //Retorna AdResponseDTO, não AdCreateDTO


    }
    public void deleteById(Long adId) throws ResourceNotFoundException {
        if (!adRepository.existsById(adId)) {
            throw new ResourceNotFoundException("Anúncio não encontrado com o ID: " + adId);
        }
        adRepository.deleteById(adId);
    }

    public Optional<Ad> findById(Long id) {
        return adRepository.findById(id);
    }


}
