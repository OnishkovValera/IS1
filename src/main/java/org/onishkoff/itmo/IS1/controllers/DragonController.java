package org.onishkoff.itmo.IS1.controllers;

import lombok.RequiredArgsConstructor;
import org.onishkoff.itmo.IS1.dto.model.request.DragonDtoRequest;
import org.onishkoff.itmo.IS1.dto.model.response.DragonDto;
import org.onishkoff.itmo.IS1.repository.CoordinateRepository;
import org.onishkoff.itmo.IS1.service.DragonService;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/collection/dragon")
@RequiredArgsConstructor
public class DragonController {

    private final CoordinateRepository coordinateRepository;
    private final DragonService dragonService;

    @GetMapping("/{id}")
    public DragonDto getDragon(@PathVariable Integer id){
        return dragonService.getDragon(id);
    }

    @GetMapping
    public Page<DragonDto> getDragons(@RequestParam(defaultValue = "0") Integer pageNumber,
                                      @RequestParam(defaultValue = "10") Integer pageSize
                                      ){
        return dragonService.getDragons(pageNumber, pageSize);
    }

    @PostMapping
    public DragonDto createDragon(@RequestBody @Validated DragonDtoRequest dragonDto){
        return dragonService.createDragon(dragonDto);
    }

}
