package com.kluev.catalogs.executors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface Executor {
    void execute(String command, String json);

    Object deserialization(String json);

//   default <T> T deserialization(String json, Class <T> clazz) {
//       ObjectMapper objectMapper = new ObjectMapper();
//       try {
//           T obj = (T)clazz.getConstructor();
//           obj = (T)objectMapper.readValue(json, obj.getClass());
//           return obj;
//       } catch (JsonProcessingException e) {
//           e.printStackTrace();
//       } catch (NoSuchMethodException e) {
//           e.printStackTrace();
//       }
//       return null;
//   }
}
