package com.example.finaleprojectmodule3.game;

import com.google.gson.JsonParseException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    @Test
    void getResourcePath_givenBadName_returnException() {
        String name = "nonexistentFolder";
        String message = "File/directory not found: nonexistentFolder is missing in resources!";
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () -> Util.getResourcePath(name));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void getResourcePath_givenStartScenePath_withNoExceptionThrown() {
        String startScenePath = "storylines/startScene.json";
        assertDoesNotThrow(() -> Util.getResourcePath(startScenePath));
    }

    @Test
    void loadScene_givenBadFile_returnException() throws FileNotFoundException, URISyntaxException {
        Path badScenePath = Util.getResourcePath("badScene.json");
        assertThrows(JsonParseException.class, () -> Util.loadScene(badScenePath.toFile()));
    }

    @Test
    void loadScene_givenGoodFile_returnScene() throws IOException, URISyntaxException {
        Path goodScenePath = Util.getResourcePath("goodScene.json");
        Scene scene = getTestScene();
        assertEquals(scene, Util.loadScene(goodScenePath.toFile()));
    }

    @Test
    void initializeSceneMap_withNoExceptionThrown() {
        Map<String, Scene> sceneMap = new HashMap<>();
        assertDoesNotThrow(() -> Util.initializeSceneMap(sceneMap));
    }

    private Scene getTestScene() {
        String choiceName = "test";
        String nextScene = "test";
        Choice choice = new Choice(choiceName, nextScene);

        String sceneName = "goodScene";
        List<String> paragraphs = List.of("test");
        boolean isDeath = false;
        boolean isWin = false;
        List<Choice> choices = List.of(choice);

        return new Scene(sceneName, paragraphs, isDeath, isWin, choices);
    }
}