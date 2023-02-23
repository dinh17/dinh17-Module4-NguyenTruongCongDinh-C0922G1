package com.example.demo.service;

import com.example.demo.model.Position;
import org.omg.PortableServer.POA;

import java.util.List;

public interface IPositionService {
    List<Position> getAllPosition();
}
