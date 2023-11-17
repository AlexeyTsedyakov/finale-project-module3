package com.example.finaleprojectmodule3.game;

import lombok.Value;

import java.util.List;

@Value
public class Scene {
    String name;
    List<String> paragraphs;
    boolean isDeath;
    boolean isWin;
    List<Choice> choices;

    public int getChoiceIndex(Choice choice) {
        return choices.indexOf(choice);
    }
}

