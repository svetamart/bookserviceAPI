package com.example.bookserviceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DataProcessingController {
    private final DataProcessingService dataProcessingService;

    @Autowired
    public DataProcessingController(DataProcessingService bookProcessingService) {
        this.dataProcessingService = bookProcessingService;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<Book>> sortBooksByName() {
        return new ResponseEntity<>(dataProcessingService.sortBooksByName(), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter/{year}", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> filterBooksByYear(@PathVariable("year") Integer year) {
        return new ResponseEntity<>(dataProcessingService.filterBooksByYear(year), HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{author}", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable("author") String author) {
        return new ResponseEntity<>(dataProcessingService.findBooksByAuthor(author), HttpStatus.OK);
    }
}
