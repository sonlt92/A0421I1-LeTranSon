package com.letranson.furama.service;

import com.letranson.furama.bean.Position;

public interface PositionService {
    Iterable<Position> findAll();
}