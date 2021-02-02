package com.example.finder.Controller;

import com.example.finder.DTO.Request.SearchDTO;
import com.example.finder.DTO.Response.CharacterDTO;
import com.example.finder.Service.FinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinderController {

    private final FinderService service;

    @Autowired
    public FinderController(FinderService service) {
        this.service = service;
    }

    @PostMapping("/api/starwars/characters")
    public List<CharacterDTO> searchCharacters(@RequestBody SearchDTO search){
        return service.getCharactersByName(search);
    }
}
