package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import service.TrieService;

import java.util.List;

public class AutoCompleteController {

    @Autowired
    TrieService trieService;

    public ResponseEntity<List<String>> getAllWords(@RequestBody String incompleteWord) {
        return new ResponseEntity<>(trieService.getPossibleWords(incompleteWord), HttpStatus.OK);
    }
}
