<template>
  <div class="d-flex space-around flex-wrap">
    <recipe-card
      v-bind:recipe="recipe"
      v-for="recipe in $store.state.recipes"
      v-bind:key="recipe.id"
    />
  </div>
</template>


<script>
import RecipeCard from "../components/RecipeCard.vue";
import RecipeService from "../services/RecipeService";

export default {
  name: "movie-list",
  components: {
    RecipeCard,
  },

  methods: {
    getMovies() {
      RecipeService.getRandomRecipes().then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_RECIPES", response.data);
        }
      });
    },
    retrieveMovie() {
      RecipeService.getMovie(this.$route.params.id);
    },
  },
  created() {
    this.getMovies();
  },
};
</script>

<style scoped>
div.movie-container {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  flex-shrink: 2;
  width: 100% !important;
}
</style>