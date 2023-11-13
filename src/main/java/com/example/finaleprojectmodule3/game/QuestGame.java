package com.example.finaleprojectmodule3.game;

import com.google.gson.Gson;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

@Getter
public class QuestGame {
    private final Map<String, Scene> sceneMap;

    private QuestGame() {
        sceneMap = new HashMap<>();
        try {
            initializeSceneMap();
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

    private void initializeSceneMap() throws IOException, URISyntaxException {
        Path storylinesPath = getStorylinesPath();
        Files.walkFileTree(storylinesPath, new StorylinesFileVisitor());
    }

    private Path getStorylinesPath() throws FileNotFoundException, URISyntaxException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL storylinesURL = classLoader.getResource("storylines");

        if (storylinesURL == null) {
            throw new FileNotFoundException("Missing directory \"storylines\" in resources!");
        }

        return Path.of(storylinesURL.toURI());
    }

    private class StorylinesFileVisitor implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            loadStoryline(file.toFile());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }

    private void loadStoryline(File file) throws IOException {
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(file)) {
            Scene scene = gson.fromJson(fileReader, Scene.class);
            sceneMap.put(scene.getName(), scene);
        }
    }

    public Scene getScene(String sceneName) {
        return sceneMap.get(sceneName);
    }
}
