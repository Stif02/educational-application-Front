package ru.startandroid.develop.test.controller;

import java.util.List;

import feign.Param;
import feign.RequestLine;
import ru.startandroid.develop.test.models.QSelectOutOfThreePic;

public interface QSOOTPController {
    @RequestLine(value = "GET /QSelectOutOfThreePic/{id}")
    public QSelectOutOfThreePic greeting(@Param (value="id")Integer id);
    @RequestLine(value = "GET /QSelectOutOfThreePic")
    public List<QSelectOutOfThreePic> all();
}
