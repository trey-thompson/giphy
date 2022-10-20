import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getAllGiphysBySearchTerm(searchTerm) {
        return http.get(`/giphy?query=${searchTerm}`);
    },
    getAllDogGiphys() {
        return http.get(`/giphy?query=dogs`);
    },
    getGiphyDetail(id) {
        return http.get(`/giphy/details/${id}`);
    },
    saveGiphy(giphy) {
        return http.post("/add", giphy);
    }
}