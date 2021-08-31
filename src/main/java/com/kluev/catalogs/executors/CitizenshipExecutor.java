package com.kluev.catalogs.executors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kluev.catalogs.entities.Citizenship;
import com.kluev.catalogs.servises.CitizenshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.kluev.catalogs.executors.Commands.*;

@Component
public class CitizenshipExecutor implements Executor {

    private CitizenshipService citizenshipService;

    @Autowired
    public void setCitizenshipServiceImp(CitizenshipService citizenshipService) {
        this.citizenshipService = citizenshipService;
    }

    @Override
    public void execute(String command, String json) {
        Citizenship citizenship = deserialization(json);
        if(citizenship.getId() != 0) {
            if (ADD.getCommandName().equals(command) ||
                    EDIT.getCommandName().equals(command)) {
                citizenshipService.save(citizenship);
            } else if (DELETE.getCommandName().equals(command)) {
                citizenshipService.delete(citizenship);
            }
        }
    }

    @Override
    public Citizenship deserialization(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Citizenship citizenship = new Citizenship();
        try {
            citizenship = objectMapper.readValue(json, Citizenship.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return citizenship;
    }
}
