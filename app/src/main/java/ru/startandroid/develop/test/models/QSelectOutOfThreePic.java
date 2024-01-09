package ru.startandroid.develop.test.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class QSelectOutOfThreePic {
    private Integer id;
    private String task;
    private String answerString;
    private String variant1;
    private String variant2;
    private String variant3;

}
