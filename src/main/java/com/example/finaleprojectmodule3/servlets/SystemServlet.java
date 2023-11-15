package com.example.finaleprojectmodule3.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

@WebServlet(value = "/system")
public class SystemServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = "C:\\Users\\a.cedyakov\\Desktop\\storylines\\startScene.json";
        Path path = Path.of("C:\\Users\\a.cedyakov\\Desktop\\storylines");

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try  {
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    JsonObject jsonObject = null;
                    FileReader fileReader = null;
                    try {
                        fileReader = new FileReader(file.toFile());
                        jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
                        String text = jsonObject.get("text").getAsString();
                        text = "<p>" + text + "</p>";
                        text = text.replaceAll("\\n\\n", "</p>\n<p>");
                        jsonObject.addProperty("text", text);
                        resp.getWriter().println(text);
                    } finally {
                        fileReader.close();
                    }

                    try (FileWriter fileWriter = new FileWriter(file.toFile())) {
                        Gson gson = new Gson();
                        gson.toJson(jsonObject, fileWriter);
                    }

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
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
