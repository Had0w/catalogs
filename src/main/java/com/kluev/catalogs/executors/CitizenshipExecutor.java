package com.kluev.catalogs.executors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kluev.catalogs.entities.Citizenship;
import com.kluev.catalogs.entities.EducYear;
import com.kluev.catalogs.servises.CitizenshipServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import static com.kluev.catalogs.executors.Commands.*;

public class CitizenshipExecutor implements Executor {

    @Autowired
    private CitizenshipServiceImp citizenshipServiceImp;

    @Override
    public void execute(String command, String json) {
        Citizenship citizenship = deserialization(json);
        if(ADD.getCommandName().equals(command)) {
            citizenshipServiceImp.save(citizenship);
        }
        else if(EDIT.getCommandName().equals(command)) {

        }
        else if(DELETE.getCommandName().equals(command)) {

        }
    }

    @Override
    public Citizenship deserialization(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Citizenship citizenship = new Citizenship();
        try {
            citizenship = objectMapper.readValue(json, Citizenship.class);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка сериализации");
        }
        return citizenship;
    }
}
