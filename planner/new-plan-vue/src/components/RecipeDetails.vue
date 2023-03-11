<template>
  <v-card width="2000">
      <v-card-title class="title">{{ recipe.title }}</v-card-title>
      <v-img class="picture" height="400" width="600" v-bind:src="recipe.image" />
      <v-card-subtitle >Cook Time: {{ recipe.readyInMinutes }} minutes.</v-card-subtitle>
      <v-container>
        <v-row class="flex-row">
          <v-col cols="2" class="flex-grow-0">
      <v-card-text>Dairy Free: <font-awesome-icon v-if="recipe.dairyFree" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="2" class="flex-grow-0">
      <v-card-text>Vegan: <font-awesome-icon v-if="recipe.vegan" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="2" class="flex-grow-0">
      <v-card-text>Vegetarian: <font-awesome-icon v-if="recipe.vegetarian" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="2" class="flex-grow-0">
      <v-card-text>Gluten Free: <font-awesome-icon v-if="recipe.glutenFree" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    </v-row>
    </v-container>
      <v-card-text>{{ recipe.instructions }}</v-card-text>

    
  </v-card>
</template>

<script>
import MovieService from "../services/RecipeService";

export default {
  data() {
    return {
      recipe: {
        title: '',
        pricePerServing: '',
        dairyFree: '',
        vegan: '',
        glutenFree: '',
        vegetarian: '',
        instructions: '',
        readyInMinutes: '',
        image: '',
        servings: '',
        id: '',
        sourceUrl: '',
      },
    };
  },
  methods: {
    retrieveMovie() {
      MovieService.getRecipe(this.$route.params.id).then((response) => {
        if (response.status == 200) {
          this.recipe = response.data;
        }
      });
    },
    browseMovies() {
      this.$router.push({ name: "movies" });
    },

    homePage() {
      this.$router.push({ name: "home" });
    },
  },
  created() {
    this.retrieveMovie();
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  display: block;
}

.star {
  color: gold;
  height: 25px;
  background: #1b1b1b;
}

.vote-number {
  font-size: 25px;
  margin-top: 2px;
}

.movie-card {
  display: flex;
  background: #1b1b1b;
  margin-top: 5%;
  border-radius: 10px;
  width: 100vh;
  margin-inline: auto;
  border: 8px solid white;
}

.picture {
  
  align-content: center;
  margin-inline: auto;
}


.title {
  text-align: center;
  align-content: center;
  margin-inline: auto;
  margin-top: 15px;
  margin-bottom: 15px;
  font-size: 40px;
}

</style>