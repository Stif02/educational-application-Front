package ru.startandroid.develop.test.controller;

import java.util.List;

import feign.Param;
import feign.RequestLine;
import ru.startandroid.develop.test.models.QWriteRightAnswer;

public interface QWRAController {
    @RequestLine(value = "GET /QWriteRightAnswer/{id}")
    public QWriteRightAnswer greeting(@Param (value="id")Integer id);
    @RequestLine(value = "GET /QWriteRightAnswer")
    public List<QWriteRightAnswer> all();
}
