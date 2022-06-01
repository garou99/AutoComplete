package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DictionaryService {

    public List<String> getEnglishWords() {
        try {
            Map<String, Object> commonWords = new ObjectMapper().readValue("dictionary.json", HashMap.class);
            return (List<String>) commonWords.get("commonWords");
        } catch (JsonProcessingException e) {
            log.info("Not able to read the json " + e.getLocalizedMessage());
            return null;
        }
    }
}
