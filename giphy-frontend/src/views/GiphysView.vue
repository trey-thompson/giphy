<template>
  <div>
    <h1>Giphys!</h1>
    <giphy-list />
  </div>
</template>

<script>
import GiphyList from '../components/GiphyList.vue'

export default {
    name: "giphys-view",
    components: {
      GiphyList
    },
    data() {
        return {

        }
    }
}
</script>

<style>

</style>