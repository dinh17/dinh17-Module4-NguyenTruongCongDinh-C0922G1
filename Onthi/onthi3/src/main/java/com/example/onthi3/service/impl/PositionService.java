package com.example.onthi3.service.impl;


import com.example.onthi3.model.Position;
import com.example.onthi3.repository.IPositionRepository;
import com.example.onthi3.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService  implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> getAllPosition() {
        return  positionRepository.findAll();
    }
}
