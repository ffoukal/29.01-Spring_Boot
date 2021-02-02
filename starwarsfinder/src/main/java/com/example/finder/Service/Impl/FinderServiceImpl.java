package com.example.finder.Service.Impl;

import com.example.finder.DAO.FinderDAO;
import com.example.finder.DTO.Request.SearchDTO;
import com.example.finder.DTO.Response.CharacterDTO;
import com.example.finder.Service.FinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinderServiceImpl implements FinderService {

    private final FinderDAO data;

    @Autowired
    public FinderServiceImpl(FinderDAO data) {
        this.data = data;
    }

    @Override
    public List<CharacterDTO> getCharactersByName(SearchDTO search) {
        return data.findCharactersByName(search.getSearchValue());
    }
}
