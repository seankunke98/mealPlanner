import axios from 'axios';

export default {

    getRandomRecipes() {
        return axios.get('/recipes/random')
    },

    getRecipe(id) {
        return axios.get(`/recipes/${id}/details`)
    },

    getNowPlaying() {
        return axios.get('/now-playing')
    },

    getMoviesWithFilters(filter) {
        return axios.post(`/movies/filter`, filter)
    }



}