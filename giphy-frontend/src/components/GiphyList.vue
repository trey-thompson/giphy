<template>
  <div id="giphy-list">
    <giphy-card v-for="giphy in allTheGiphys" :key="giphy.id" :giphy="giphy"/>
  </div>
</template>

<script>
import GiphyCard from './GiphyCard.vue'

export default {
  name: 'giphy-list',
  components: {
    GiphyCard
  },
  data() {
    return {
      allTheGiphys: this.$store.state.giphys
    }
  }
}
</script>

<style scoped>
#giphy-list {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}

</style>