package com.example.finaleprojectmodule3.game;

public class Choice {
    private String text;
    private Dialog nextDialog;

    public Choice(String text) {
        this.text = text;
    }

    public void setNextDialog(Dialog nextDialog) {
        this.nextDialog = nextDialog;
    }
}
