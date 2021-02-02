package com.example.finder.DAO;


import com.example.finder.DTO.Response.CharacterDTO;

import java.util.List;

public interface FinderDAO {
    List<CharacterDTO> findCharactersByName(String name);
}
