<template>
  
  <v-card class="card ma-4"  elevation="6" width="500" height="350">
      <v-card-title class="title text-truncate text-center d-inline-block" v-on:click.prevent="openDetails()">
        {{ recipe.title }}
      </v-card-title>
      <v-img v-bind:src="recipe.image" class="recipe-image" height="200" width="300"/>
      <v-card-subtitle class="rec-details">Cook Time: {{ recipe.readyInMinutes }} minutes.</v-card-subtitle>
      <v-container>
        <v-row >
          <v-col cols="6">
      <v-card-text class="text-center">Dairy Free: <font-awesome-icon v-if="recipe.dairyFree" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="6">
      <v-card-text class="text-center">Vegan: <font-awesome-icon v-if="recipe.vegan" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="6">
      <v-card-text class="text-center">Vegetarian: <font-awesome-icon v-if="recipe.vegetarian" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
    </v-col>
    <v-col cols="6">
      <v-card-text class="text-center">Gluten Free: <font-awesome-icon v-if="recipe.glutenFree" icon="fa-solid fa-check" /> <font-awesome-icon v-else icon="fa-solid fa-xmark" /></v-card-text>
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

.card {
  cursor: pointer;
  display: flex;
  flex-direction: column;
  align-content: center;
}

.card:hover {
  color: blue
}

.recipe-image {
  margin: auto;
}

.rec-details {
  margin: auto;
}

.title {
  margin-inline: 30px;
}

</style>