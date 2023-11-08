package com.example.finaleprojectmodule3.game;

import lombok.Value;

import java.util.List;

@Value
public class Scene {
    String name;
    String text;
    boolean isDeath;
    boolean isWin;
    List<Choice> choices;
}
