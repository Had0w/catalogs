package com.kluev.catalogs.executors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kluev.catalogs.entities.Citizenship;
import com.kluev.catalogs.servises.CitizenshipServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.kluev.catalogs.executors.Commands.*;

@Component
public class CitizenshipExecutor implements Executor {

    private CitizenshipServiceImp citizenshipServiceImp;

    @Autowired
    public void setCitizenshipServiceImp(CitizenshipServiceImp citizenshipServiceImp) {
        this.citizenshipServiceImp = citizenshipServiceImp;
    }

    @Override
    public void execute(String command, String json) {
        Citizenship citizenship = deserialization(json);
        if(citizenship.getId() != 0) {
            if (ADD.getCommandName().equals(command) ||
                    EDIT.getCommandName().equals(command)) {
                citizenshipServiceImp.save(citizenship);
            } else if (DELETE.getCommandName().equals(command)) {
                citizenshipServiceImp.delete(citizenship);
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
