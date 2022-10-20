<template>
  <div id="app">
    <nav id ="nav">
      <router-link :to="{name: 'Home'}">Home</router-link> |
      <router-link :to="{name: 'About'}">About</router-link> |
      <router-link :to="{name: 'Giphys'}">Giphys</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<script>
import GiphyService from './services/GiphyService.js'

export default {
  name: "app",
  created() {
    GiphyService.getAllDogGiphys()
      .then( (response) => {
        // console.log(response);
        if (response.status === 200) {
          // console.log(response.data);
          this.$store.commit('SET_GIPHYS', response.data);
        }
      } );
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
