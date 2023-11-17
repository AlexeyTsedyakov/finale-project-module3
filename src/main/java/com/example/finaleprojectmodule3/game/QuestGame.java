package com.example.finaleprojectmodule3.game;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class QuestGame {
    private final Map<String, Scene> sceneMap;

    private QuestGame() {
        sceneMap = new HashMap<>();
        try {
            Util.initializeSceneMap(sceneMap);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static class QuestGameHolder {
        public static final QuestGame INSTANCE = new QuestGame();
    }

    public static QuestGame getInstance() {
        return QuestGameHolder.INSTANCE;
    }

    public Scene getScene(String sceneName) {
        return sceneMap.get(sceneName);
    }
}
