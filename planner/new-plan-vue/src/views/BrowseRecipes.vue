<template>
  <div>
    <filter-movies />
    <movie-list />
  </div>
</template>

<script>
import RecipeList from "@/components/RecipeList";
import FilterMovies from "../components/FilterForm.vue";

export default {
  name: "browse-recipes",
  components: {
    FilterMovies,
    RecipeList,
  },
};
</script>

<style >
#app {
  height: 100% !important;
  width: 100% !important;
}
body {
  width: 100%;

  background-repeat: repeat-x;
  background-repeat: repeat-y;
}
</style>