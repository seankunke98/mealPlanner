import axios from 'axios';

export default {
    favorite(id) {
        return axios.put(`/recipes/favorited/${id}`)
    },

    unFavorite(id) {
        return axios.delete(`/recipes/unfavorited/${id}`)
    },

    save(id) {
        return axios.put(`/recipes/saved/${id}`)
    },

    unsave(id) {
        return axios.delete(`/recipes/unsaved/${id}`)
    },

    getFavoritedRecipes() {
        return axios.get(`/favorited`)
    },

    getSavedRecipes() {
        return axios.get(`/saved`)
    },




}