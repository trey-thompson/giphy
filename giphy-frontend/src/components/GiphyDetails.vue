<template>
  <div id="giphy-details">
    <h1>Giphy Details</h1>
    <img :src="giphy.url" alt="giphy image"/>
    <div>
        <button v-on:click="saveGiphy()">Save Giphy to Favorites</button>
    </div>
    <h2>{{ giphy.title }}</h2>
    <h2>Rating: {{ giphy.rating}}</h2>
    <h2>Description: {{ giphy.description }}</h2>
  </div>
</template>

<script>
import GiphyService from '../services/GiphyService.js'

export default {
    name: 'giphy-details',
    data() {
        return {
            giphy: Object
        }
    },
    created() {
        GiphyService.getGiphyDetail(this.$route.params.id)
            .then( (response) => {
                console.log(response);
                this.giphy = response.data;
            });
    },
    methods: {
        saveGiphy() {
            GiphyService.saveGiphy(this.giphy)
                .then( (response) => {
                    if (response.status === 200) {
                        alert(this.giphy.title + " has been saved!");
                        this.$router.push({name: 'Giphys'});
                    }
                    // console.log(response);
                })
        }
    }

}
</script>

<style>
#giphy-details {
    align-items: center;
}

</style>