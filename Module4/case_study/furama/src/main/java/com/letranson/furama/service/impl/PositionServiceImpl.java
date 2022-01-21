package com.letranson.furama.service.impl;

import com.letranson.furama.bean.Position;
import com.letranson.furama.repository.PositionRepository;
import com.letranson.furama.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}