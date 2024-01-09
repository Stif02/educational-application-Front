package ru.startandroid.develop.test.controller;

import java.util.List;

import feign.Param;
import feign.RequestLine;
import ru.startandroid.develop.test.models.QSelectOutOfFour;

public interface QSOOFController {
    @RequestLine(value = "GET /QSelectOutOfFour/{id}")
    public QSelectOutOfFour greeting(@Param(value = "id") Integer id);

    @RequestLine(value = "GET /QSelectOutOfFour")
    public List<QSelectOutOfFour> all();
}
