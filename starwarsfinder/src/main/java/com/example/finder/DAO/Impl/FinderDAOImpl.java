package com.example.finder.DAO.Impl;

import com.example.finder.DAO.FinderDAO;
import com.example.finder.DTO.Response.CharacterDTO;
import com.example.finder.Model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class FinderDAOImpl implements FinderDAO {
    @Override
    public List<CharacterDTO> findCharactersByName(String name) {
        List<Character> characters = readJson().stream()
                .filter(character -> character.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
        List<CharacterDTO> response = new ArrayList<>();

        for(Character i : characters){
            ModelMapper modelMapper = new ModelMapper();
            CharacterDTO characterResponse = modelMapper.map(i, CharacterDTO.class);
            response.add(characterResponse);
        }

        return response;
    }


    public  List<Character> readJson(){
        try{
            File file = ResourceUtils.getFile("classpath:static/starwars.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Character> characters = mapper.readValue(file, new TypeReference<List<Character>>() {});
            return characters;
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error reading or processing the JSON file");
        }
    }
}
