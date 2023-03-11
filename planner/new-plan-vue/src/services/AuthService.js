import axios from 'axios';

export default {

  login(user) {
    return axios.post('/api/users/login', user)
  },

  register(user) {
    return axios.post('/api/users/register', user)
  }

}
