package com.example.finaleprojectmodule3.game;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

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
import java.util.Map;

@UtilityClass
public class Util {
    public void initializeSceneMap(Map<String, Scene> sceneMap) throws IOException, URISyntaxException {
        String folderName = "storylines";
        Path storylinesPath = getResourcePath(folderName);
        Files.walkFileTree(storylinesPath, new StorylinesFileVisitor(sceneMap));
    }

    public Path getResourcePath(String name) throws FileNotFoundException, URISyntaxException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL storylinesURL = classLoader.getResource(name);

        if (storylinesURL == null) {
            throw new FileNotFoundException("File/directory not found: " + name + " is missing in resources!");
        }

        return Path.of(storylinesURL.toURI());
    }

    private class StorylinesFileVisitor implements FileVisitor<Path> {
        private final Map<String, Scene> sceneMap;

        private StorylinesFileVisitor(Map<String, Scene> sceneMap) {
            this.sceneMap = sceneMap;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Scene scene = Util.loadScene(file.toFile());
            sceneMap.put(scene.getName(), scene);
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
    public Scene loadScene(File file) throws IOException {
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Scene.class);
        }
    }
}
