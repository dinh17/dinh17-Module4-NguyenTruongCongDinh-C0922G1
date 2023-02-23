package com.example.demo.service.impl;

import com.example.demo.model.Position;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.repository.IPositionRepository;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IPositionService;
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
