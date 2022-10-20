package com.techelevator.dao;

import com.techelevator.model.GifDetail;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGiphyDao implements GiphyDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcGiphyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GifDetail saveGiphy(GifDetail gif) {
        /*
        	id SERIAL PRIMARY KEY,
            url varchar (100),
            giphy_id varchar(50),
            rating varchar(5),
            description varchar(500),
            title varchar(100),
            user_name varchar(100),
            height int,
            width int
         */
        String sql = "INSERT INTO giphy " +
                     "(url, giphy_id, rating, description, title, user_name, height, width) " +
                     "VALUES (?,?,?,?,?,?,?,?) " +
                     "RETURNING id;";
        Integer giphyId = jdbcTemplate.queryForObject(sql, Integer.class, gif.getUrl(), gif.getGiphyId(),
                            gif.getRating(), gif.getDescription(), gif.getTitle(), gif.getUserName(), gif.getHeight(),
                            gif.getWidth());

        try {
            return getGiphyById(giphyId);
        } catch (DataAccessException | NullPointerException e) {
            System.out.println("The giphy could not be saved at this time: " + e.getMessage());
            return null;
        }

    }

    @Override
    public List<GifDetail> getAllGiphys() {
        List<GifDetail> allGiphys = new ArrayList<>();
        String sql = "SELECT * FROM giphy;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            mapRowToGifDetail(results);
        }

        return allGiphys;
    }

    @Override
    public GifDetail getGiphyById(int id) {
        String sql = "SELECT * FROM giphy WHERE id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToGifDetail(results);
        }
        return null;
    }

    public GifDetail mapRowToGifDetail(SqlRowSet rs) {
        GifDetail gifDetail = new GifDetail();

        gifDetail.setId(rs.getInt("id"));
        gifDetail.setUrl(rs.getString("url"));
        gifDetail.setGiphyId(rs.getString("giphy_id"));
        gifDetail.setRating(rs.getString("rating"));
        gifDetail.setDescription(rs.getString("description"));
        gifDetail.setTitle(rs.getString("title"));
        gifDetail.setUserName(rs.getString("user_name"));
        gifDetail.setHeight(rs.getInt("height"));
        gifDetail.setWidth(rs.getInt("width"));

        return gifDetail;
    }
}
