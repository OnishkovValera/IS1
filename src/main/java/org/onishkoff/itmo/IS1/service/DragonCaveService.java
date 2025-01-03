package org.onishkoff.itmo.IS1.service;


import lombok.RequiredArgsConstructor;
import org.onishkoff.itmo.IS1.exception.DragonCaveNotFoundException;
import org.onishkoff.itmo.IS1.model.DragonCave;
import org.onishkoff.itmo.IS1.repository.DragonCaveRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DragonCaveService {


    private final DragonCaveRepository dragonCaveRepository;

    public DragonCave findDragonCaveById(Long id) {
        return dragonCaveRepository.findById(id).orElseThrow(DragonCaveNotFoundException::new);
    }

}
