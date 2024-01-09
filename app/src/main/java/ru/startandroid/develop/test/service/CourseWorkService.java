package ru.startandroid.develop.test.service;

import java.util.HashMap;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import ru.startandroid.develop.test.controller.QSOOFController;
import ru.startandroid.develop.test.controller.QSOOTPController;
import ru.startandroid.develop.test.controller.QWRAController;

public class CourseWorkService {

    private HashMap<Class, Object> clients = new HashMap<>();

    private String url = "http://10.0.2.2:5000";

    public CourseWorkService() {
        addToClients(QSOOFController.class, "/api");
        addToClients(QSOOTPController.class, "/api");
        addToClients(QWRAController.class, "/api");
    }

    private <T> void addToClients(Class<T> tClass, String postFix) {
        T client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(tClass, url + postFix);
        clients.put(tClass, client);
    }

    public QSOOFController getQSOOFController() {
        return getClient(QSOOFController.class);
    }
    public QSOOTPController getQSOOTPController() {
        return getClient(QSOOTPController.class);
    }
    public QWRAController getQWRAController() {
        return getClient(QWRAController.class);
    }

    public <T> T getClient(Class<T> tClass) {
        Object obj = clients.get(tClass);
        if (!tClass.isInstance(obj)) {
            throw new IllegalArgumentException("Ожидался другой класс");
        }
        return (T) obj;
    }
}
