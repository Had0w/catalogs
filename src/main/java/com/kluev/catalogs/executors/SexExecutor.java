package com.kluev.catalogs.executors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kluev.catalogs.entities.Sex;
import com.kluev.catalogs.servises.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.kluev.catalogs.executors.Commands.*;

@Component
public class SexExecutor implements Executor {

    private SexService sexService;

    @Autowired
    public void setSexService(SexService sexService) {
        this.sexService = sexService;
    }

    @Override
    public void execute(String command, String json) {
        Sex sex = deserialization(json);
        if(sex.getId() != 0) {
            if (ADD.getCommandName().equals(command) ||
                    EDIT.getCommandName().equals(command)) {
                sexService.save(sex);
            } else if (DELETE.getCommandName().equals(command)) {
                sexService.delete(sex);
            }
        }
    }

    @Override
    public Sex deserialization(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Sex sex = new Sex();
        try {
            sex = objectMapper.readValue(json, Sex.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return sex;
    }
}
