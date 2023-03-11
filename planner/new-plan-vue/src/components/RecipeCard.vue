<template>
  
  <v-card class="mx-auto" width="400" height="500">
      <v-card-title class="title" v-on:click.prevent="openDetails()">
        {{ recipe.title }}
      </v-card-title>
      <v-img v-bind:src="recipe.image" height="200" width="300"/>
      <v-card-subtitle >Cook Time: {{ recipe.readyInMinutes }} minutes.</v-card-subtitle>
      <v-container>
        <v-row>
          <v-col cols="6">
      <v-card-text>Dairy Free: <font-awesome-icon v-if="recipe.dairyFree" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="6">
      <v-card-text>Vegan: <font-awesome-icon v-if="recipe.vegan" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="6">
      <v-card-text>Vegetarian: <font-awesome-icon v-if="recipe.vegetarian" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="6">
      <v-card-text>Gluten Free: <font-awesome-icon v-if="recipe.glutenFree" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    </v-row>
    </v-container>
  </v-card>

</template>


<script>
import RecipeService from "../services/RecipeService";


export default {
  name: "recipe-card",
  props: {
    recipe: Object,
  },
  data() {
    return {
      
    };
  },

  methods: {
    getRecipes() {
      RecipeService.getRandomRecipes().then((response) => {
        if (response.status == 200) {
          this.recipes = response.data;
        }
      });
    },
    openDetails() {
      {
        this.$router.push(`/recipes/${this.recipe.id}/information`);
      }
    },
    
    reloadPage() {
      window.location.reload();
    },
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: "Allerta Stencil";
}

.title {
  cursor: pointer
}

.title:hover {
  color: blue
}


</style>