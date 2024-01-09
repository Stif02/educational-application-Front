package ru.startandroid.develop.test.service;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ru.startandroid.develop.test.models.QSelectOutOfFour;
import ru.startandroid.develop.test.models.QSelectOutOfThreePic;
import ru.startandroid.develop.test.models.QWriteRightAnswer;

public class RequestService {

    private CourseWorkService courseWorkService = new CourseWorkService();

    public QSelectOutOfFour getQSelectOutOfFour(Integer id) {
        try {
            QSelectOutOfFour result = courseWorkService.getQSOOFController().greeting( id);
            Log.i(this.getClass().getName(), "Запрос выполнен успешно. Результат: " + result.toString());
            return result;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Ошибка выполнения запроса", e);
            throw e;
        }
    }
    public QSelectOutOfThreePic getQSelectOutOfThreePic(Integer id){
        try {
            QSelectOutOfThreePic result = courseWorkService.getQSOOTPController().greeting(id);
            Log.i(this.getClass().getName(), "Запрос выполнен успешно. Результат: " + result.toString());
            return result;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Ошибка выполнения запроса", e);
            throw e;
        }

    }
    public QWriteRightAnswer getQWriteRightAnswer(Integer id) {
        try {
            QWriteRightAnswer result = courseWorkService.getQWRAController().greeting(id);
            Log.i(this.getClass().getName(), "Запрос выполнен успешно. Результат: " + result.toString());
            return result;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Ошибка выполнения запроса", e);
            throw e;
        }
    }
    public List<QSelectOutOfFour> getAllQSOOF() {
        try {
            List<QSelectOutOfFour> result = courseWorkService.getQSOOFController().all();
            Log.i(this.getClass().getName(), "Запрос выполнен успешно. Результат: " + result.toString());
            return result;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Ошибка выполнения запроса", e);
            throw e;
        }
    }
    public List<QSelectOutOfThreePic> getAllQSOOTP() {
        try {
            List<QSelectOutOfThreePic> result = courseWorkService.getQSOOTPController().all();
            Log.i(this.getClass().getName(), "Запрос выполнен успешно. Результат: " + result.toString());
            return result;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Ошибка выполнения запроса", e);
            throw e;
        }
    }
    public List<QWriteRightAnswer> getAllQWRA() {
        try {
            List<QWriteRightAnswer> result = courseWorkService.getQWRAController().all();
            Log.i(this.getClass().getName(), "Запрос выполнен успешно. Результат: " + result.toString());
            return result;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "Ошибка выполнения запроса", e);
            throw e;
        }
    }


}
