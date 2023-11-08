package com.example.finaleprojectmodule3.game;

public class ChoiceTree {
//    private Dialog root;
//
//    public ChoiceTree() {
//        initialize();
//    }
//
//    public Dialog getRoot() {
//        return root;
//    }
//
//    private void initialize() {
//        root = new Dialog(TextConstants.MESSAGE);
//
//        // Dialogs.
//        Dialog dialog1 = new Dialog(TextConstants.MESSAGE1);
//        Dialog dialog1_1 = new Dialog(TextConstants.MESSAGE1_1);
//
//        Dialog dialog1_1_1 = new Dialog(TextConstants.MESSAGE1_1_1); // death
//
//        Dialog dialog1_1_2 = new Dialog(TextConstants.MESSAGE1_1_2);
//        Dialog dialog1_1_2_1 = new Dialog(TextConstants.MESSAGE1_1_2_1);
//        Dialog dialog1_1_2_1_1 = new Dialog(TextConstants.MESSAGE1_1_2_1_1);
//        Dialog dialog1_1_2_1_1_1 = new Dialog(TextConstants.MESSAGE1_1_2_1_1_1); // death
//        Dialog dialog1_1_2_1_1_2 = new Dialog(TextConstants.MESSAGE1_1_2_1_1_2);
//        Dialog dialog1_1_2_1_2 = new Dialog(TextConstants.MESSAGE1_1_2_1_2); // death
//        Dialog dialog1_1_2_2 = new Dialog(TextConstants.MESSAGE1_1_2_2); // death
//
//        Dialog dialog1_1_3 = new Dialog(TextConstants.MESSAGE1_1_3);
//        Dialog dialog1_1_3_1 = new Dialog(TextConstants.MESSAGE1_1_3_1); // death
//        Dialog dialog1_1_3_2 = new Dialog(TextConstants.MESSAGE1_1_3_2);
//        Dialog dialog1_1_3_2_1 = new Dialog(TextConstants.MESSAGE1_1_3_2_1); // death
//        Dialog dialog1_1_3_2_2 = new Dialog(TextConstants.MESSAGE1_1_3_2_2);
//        Dialog dialog1_1_3_2_2_1 = new Dialog(TextConstants.MESSAGE1_1_3_2_2_1);
//        Dialog dialog1_1_3_2_2_1_1 = new Dialog(TextConstants.MESSAGE1_1_3_2_2_1_1);
//        Dialog dialog1_1_3_2_2_1_1_1 = new Dialog(TextConstants.MESSAGE1_1_3_2_2_1_1_1);
//        Dialog dialog1_1_3_2_2_1_1_1_1 = new Dialog(TextConstants.MESSAGE1_1_3_2_2_1_1_1_1); // win
//        Dialog dialog1_1_3_2_2_1_1_1_2 = new Dialog(TextConstants.MESSAGE1_1_3_2_2_1_1_1_2); // death
//        Dialog dialog1_1_3_2_2_1_1_1_3 = new Dialog(TextConstants.MESSAGE1_1_3_2_2_1_1_1_3); // death
//        Dialog dialog1_1_3_2_2_1_2 = new Dialog(TextConstants.MESSAGE1_1_3_2_2_1_2); // death
//
//        Dialog dialog2 = new Dialog(TextConstants.MESSAGE2);
//        Dialog dialog2_1 = new Dialog(TextConstants.MESSAGE2_1); // death
//
//        // Choices.
//        Choice choice1 = new Choice(TextConstants.CHOICE1, dialog1);
//        Choice choice2 = new Choice(TextConstants.CHOICE2, dialog2);
//
//        Choice choice1_1 = new Choice(TextConstants.CHOICE1_1, dialog1_1);
//        Choice choice1_2 = new Choice(TextConstants.CHOICE1_2, dialog2);
//
//        Choice choice1_1_1 = new Choice(TextConstants.CHOICE1_1_1, dialog1_1_1);
//        Choice choice1_1_2 = new Choice(TextConstants.CHOICE1_1_2, dialog1_1_2);
//        Choice choice1_1_3 = new Choice(TextConstants.CHOICE1_1_3, dialog1_1_3);
//
//        Choice choice1_1_2_1 = new Choice(TextConstants.CHOICE1_1_2_1, dialog1_1_2_1);
//        Choice choice1_1_2_2 = new Choice(TextConstants.CHOICE1_1_2_2, dialog1_1_2_2);
//
//        Choice choice1_1_2_1_1 = new Choice(TextConstants.CHOICE1_1_2_1_1, dialog1_1_2_1_1);
//        Choice choice1_1_2_1_2 = new Choice(TextConstants.CHOICE1_1_2_1_2, dialog1_1_2_1_2);
//
//        Choice choice1_1_2_1_1_1 = new Choice(TextConstants.CHOICE1_1_2_1_1_1, dialog1_1_2_1_1_1);
//        Choice choice1_1_2_1_1_2 = new Choice(TextConstants.CHOICE1_1_2_1_1_2, dialog1_1_2_1_1_2);
//
//        Choice choice1_1_2_1_1_2_1 = new Choice(TextConstants.CHOICE1_1_2_1_1_2_1, dialog1_1_3_2_2_1_1_1);
//
//        Choice choice1_1_3_1 = new Choice(TextConstants.CHOICE1_1_3_1, dialog1_1_3_1);
//        Choice choice1_1_3_2 = new Choice(TextConstants.CHOICE1_1_3_2, dialog1_1_3_2);
//
//        Choice choice1_1_3_2_1 = new Choice(TextConstants.CHOICE1_1_3_2_1, dialog1_1_3_2_1);
//        Choice choice1_1_3_2_2 = new Choice(TextConstants.CHOICE1_1_3_2_2, dialog1_1_3_2_2);
//
//        Choice choice1_1_3_2_2_1 = new Choice(TextConstants.CHOICE1_1_3_2_2_1, dialog1_1_3_2_2_1);
//
//        Choice choice1_1_3_2_2_1_1 = new Choice(TextConstants.CHOICE1_1_3_2_2_1_1, dialog1_1_3_2_2_1_1);
//        Choice choice1_1_3_2_2_1_2 = new Choice(TextConstants.CHOICE1_1_3_2_2_1_2, dialog1_1_3_2_2_1_2);
//
//        Choice choice1_1_3_2_2_1_1_1 = new Choice(TextConstants.CHOICE1_1_3_2_2_1_1_1, dialog1_1_3_2_2_1_1_1);
//
//        Choice choice1_1_3_2_2_1_1_1_1 = new Choice(TextConstants.CHOICE1_1_3_2_2_1_1_1_1, dialog1_1_3_2_2_1_1_1_1);
//        Choice choice1_1_3_2_2_1_1_1_2 = new Choice(TextConstants.CHOICE1_1_3_2_2_1_1_1_2, dialog1_1_3_2_2_1_1_1_2);
//        Choice choice1_1_3_2_2_1_1_1_3 = new Choice(TextConstants.CHOICE1_1_3_2_2_1_1_1_3, dialog1_1_3_2_2_1_1_1_3);
//
//        Choice choice2_1 = new Choice(TextConstants.CHOICE2_1, dialog2_1);
//        Choice choice2_2 = new Choice(TextConstants.CHOICE2_2, dialog1);
//
//        // Set up choices.
//        root.addChoice(choice1);
//        root.addChoice(choice2);
//
//        dialog1.addChoice(choice1_1);
//        dialog1.addChoice(choice1_2);
//
//        dialog1_1.addChoice(choice1_1_1);
//        dialog1_1.addChoice(choice1_1_2);
//        dialog1_1.addChoice(choice1_1_3);
//
//        dialog1_1_1.setDeath(true);
//
//        dialog1_1_2.addChoice(choice1_1_2_1);
//        dialog1_1_2.addChoice(choice1_1_2_2);
//
//        dialog1_1_2_1.addChoice(choice1_1_2_1_1);
//        dialog1_1_2_1.addChoice(choice1_1_2_1_2);
//
//        dialog1_1_2_1_1.addChoice(choice1_1_2_1_1_1);
//        dialog1_1_2_1_1.addChoice(choice1_1_2_1_1_2);
//
//        dialog1_1_2_1_1_1.setDeath(true);
//        dialog1_1_2_1_1_2.addChoice(choice1_1_2_1_1_2_1);
//
//        dialog1_1_2_1_2.setDeath(true);
//
//        dialog1_1_2_2.setDeath(true);
//
//        dialog1_1_3.addChoice(choice1_1_3_1);
//        dialog1_1_3.addChoice(choice1_1_3_2);
//
//        dialog1_1_3_1.setDeath(true);
//        dialog1_1_3_2.addChoice(choice1_1_3_2_1);
//        dialog1_1_3_2.addChoice(choice1_1_3_2_2);
//
//        dialog1_1_3_2_1.setDeath(true);
//        dialog1_1_3_2_2.addChoice(choice1_1_3_2_2_1);
//
//        dialog1_1_3_2_2_1.addChoice(choice1_1_3_2_2_1_1);
//        dialog1_1_3_2_2_1.addChoice(choice1_1_3_2_2_1_2);
//
//        dialog1_1_3_2_2_1_1.addChoice(choice1_1_3_2_2_1_1_1);
//
//        dialog1_1_3_2_2_1_1_1.addChoice(choice1_1_3_2_2_1_1_1_1);
//        dialog1_1_3_2_2_1_1_1.addChoice(choice1_1_3_2_2_1_1_1_2);
//        dialog1_1_3_2_2_1_1_1.addChoice(choice1_1_3_2_2_1_1_1_3);
//
//        dialog1_1_3_2_2_1_1_1_1.setWin(true);
//        dialog1_1_3_2_2_1_1_1_2.setDeath(true);
//        dialog1_1_3_2_2_1_1_1_3.setDeath(true);
//
//        dialog1_1_3_2_2_1_2.setDeath(true);
//
//        dialog2.addChoice(choice2_1);
//        dialog2.addChoice(choice2_2);
//    }
}
