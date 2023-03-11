<template>
  <div class="home">
    <recipe-list />
  </div>
</template>



<script>

import RecipeList from "../components/RecipeList.vue"

export default {
  components: {
    RecipeList
  },

  name: "home-view",
};
</script>

<style scoped>
* {
  font-family: "Allerta Stencil";
  margin: 0;
  padding: 0;
}

#flex {
  display: flex;
  flex-direction: column;
  align-content: stretch;
  height: 96vh;
}

.header {
  color: white;
  justify-content: center;
  margin: 1%;
  background: #1b1b1b;
  margin-top: -56px;
  margin-left: 250px;
  width: 400px;
}

.movieDetails {
  display: flex;
}

.now-playing {
  font-size: 30px;
  background: #1b1b1b;
  border-radius: 40px;
  margin-top: 30px;
  margin-bottom: 10px;
  padding: 20px;
  color: white;
  text-align: center;
  border: 5px solid white;
}
</style>