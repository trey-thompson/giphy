package com.techelevator.controller;

import com.techelevator.model.Gif;
import com.techelevator.model.GifDetail;
import com.techelevator.service.GiphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GiphyController {

    @Autowired
    GiphyService giphyService;


    @GetMapping("/giphy")
    public List<Gif> getAllGiphysBySearchTerm(@RequestParam String query) {
        return giphyService.getSearchResults(query);
    }

    @GetMapping("/giphy/details/{id}")
    public GifDetail getGifDetails(@PathVariable String id) {
        return giphyService.getGiphyDetails(id);
    }

}
