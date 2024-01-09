package ru.startandroid.develop.test.models;

public class LevelPic {
    public String id;
    public String task;
    public String answerString;
    public String questionType;
    public String lesson;
    public String variant1;
    public String variant2;
    public String variant3;

    @Override
    public String toString() {
        return id + "," + task + ", " + questionType + ",  " +answerString + ", " + lesson +", " + variant1 + ", " + variant2 + ", " + variant3;
    }
}