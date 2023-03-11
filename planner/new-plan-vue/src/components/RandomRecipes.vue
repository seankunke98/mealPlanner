<template>
  <div>
    <recipe-card
      v-bind:recipe="recipe"
      v-for="recipe in $store.state.recipes"
      v-bind:key="recipe.id"
    />
  </div>
</template>

<script>
import MovieService from "../services/RecipeService";
import RecipeCard from "../RecipeCard.vue";

export default {
  components: {
    RecipeCard,
  },

  data() {
    return {
      movie: {
        original_title: "",
        overview: "",
        release_date: "",
        id: this.id,
        poster_path: "",
        genre_ids: "",
        vote_average: "",
      },
    };
  },

  methods: {
    getMovies() {
      MovieService.getNowPlaying().then((response) => {
        if (response.status === 200) {
          this.$store.commit("SET_MOVIES", response.data);
        }
      });
    },
  },

  created() {
    MovieService.getMovie(this.movie.id).then((response) => {
      if (response.status == 200) {
        this.movie = response.data;
      }
    }),
      this.getMovies();
  },
};
</script>

<style>
</style>