package com.techelevator.dao;

import com.techelevator.model.Gif;
import com.techelevator.model.GifDetail;

import java.util.List;

public interface GiphyDao {

    //create
    GifDetail saveGiphy(GifDetail gif);

    //read
    List<GifDetail> getAllGiphys();

    GifDetail getGiphyById(int id);

    //update


    //delete
}
