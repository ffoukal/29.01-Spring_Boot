package com.example.finder.Service;

import com.example.finder.DTO.Request.SearchDTO;
import com.example.finder.DTO.Response.CharacterDTO;

import java.util.List;

public interface FinderService {
    List<CharacterDTO> getCharactersByName(SearchDTO search);
}
