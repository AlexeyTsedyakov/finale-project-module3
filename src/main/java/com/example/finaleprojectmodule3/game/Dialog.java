package com.example.finaleprojectmodule3.game;

import java.util.ArrayList;
import java.util.List;

public class Dialog {
    private String mesage;
    private List<Choice> choices = new ArrayList<>();
    private boolean isDeath;

    public Dialog(String text, boolean isDeath) {
        this.mesage = text;
        this.isDeath = isDeath;
    }

    public String getText() {
        return mesage;
    }

    public List<Choice> getChildren() {
        return choices;
    }

    public boolean isDeath() {
        return isDeath;
    }

    public void addChild(Choice choice) {
        choices.add(choice);
    }
}
