package ru.startandroid.develop.test.models;

public class Level {
   public String id;
   public String task;
   public String answerString;
   public String questionType;
   public String lesson;
   public String variant1;
   public String variant2;
   public String variant3;
   public String variant4;

   // public Level(String id, String task, String answerString, String questionType, String lesson, String variant1, String variant2, String variant3, String variant4) {
   // }



   @Override
    public String toString() {
        return id + "," + task + ", " + questionType + ",  " +answerString + ", " + lesson +", " + variant1 + ", " + variant2 + ", " + variant3+ ", " + variant4;
    }


}

