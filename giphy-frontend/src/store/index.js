import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    giphys: []
  },
  mutations: {
    SET_GIPHYS(state, giphysArray) {
      state.giphys = giphysArray;
    }
  },
  actions: {

  },
  modules: {

  }
})
