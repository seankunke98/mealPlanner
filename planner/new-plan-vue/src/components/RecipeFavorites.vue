<template>
  <div class="carousel-container">
    <div>
      <v-app id="main">
        <h2 class="watch-later">WATCH LATER</h2>
        <v-carousel
          height="auto"
          class="container"
          v-model="model"
          hide-delimiters
        >
          <v-carousel-item
            v-for="recipe in savedRecipes"
            :key="recipe.id"
            hide-delimiter
          >
            <recipe-card :recipe="recipe" class="cell" />
          </v-carousel-item>
        </v-carousel>
      </v-app>
    </div>

    <div>
      <v-app id="main2">
        <h2 class="heart">FAVORITED</h2>
        <v-carousel
          height="auto"
          class="container"
          v-model="anotherModel"
          hide-delimiters
        >
          <v-carousel-item
            v-for="recipe in favoritedRecipes"
            :key="recipe.id"
            hide-delimiter
          >
            <recipe-card :recipe="recipe" class="cell" />
          </v-carousel-item>
        </v-carousel>
      </v-app>
    </div>
  </div>
</template>


<script>
import DbService from "../services/DbService";
import RecipeCard from "../components/RecipeCard.vue";

export default {
  name: "favorite-movies",
  components: {
    RecipeCard,
  },
  data() {
    return {
      savedRecipes: [],
      favoritedRecipes: [],
      model: [],
      anotherModel: [],
    };
  },
  methods: {},

  created() {
    DbService.getSavedRecipes().then((response) => {
      this.savedRecipes = response.data;
    }),
      DbService.getFavoritedRecipes().then((response) => {
        this.favoritedRecipes = response.data;
      });
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

.movie-icon {
  height: 50px;
  color: white;
}

div.carousel-container {
  display: flex;
  text-align: center;
  justify-content: center;
  justify-content: space-evenly;
}

div .card.cell {
  height: 580px;
  width: 350px;
  border: 2px solid white;
  border-radius: 40px;
}

.container {
  width: 700px;
  /* height: 5000px; */
}

.watch-later {
  font-size: 30px;
  background: #1b1b1b;
  border-radius: 40px;
  margin-top: 30px;
  margin-bottom: 10px;
  padding: 20px;
  color: white;
  border: 2px solid white;
}

.heart {
  font-size: 30px;
  background: #1b1b1b;
  border-radius: 40px;
  margin-top: 30px;
  margin-bottom: 10px;
  padding: 20px;
  color: white;
  border: 2px solid white;
}

#main {
  width: 360px;
  margin-left: 200px;
}

#main2 {
  width: 360px;
  margin-right: 200px;
}

::v-deep .v-application--wrap {
  min-height: fit-content;
}

.theme--light.v-application {
  background: none;
}
</style>