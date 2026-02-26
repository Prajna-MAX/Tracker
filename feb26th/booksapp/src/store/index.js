import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
state:{
    books: []
},
getters:{
allBooks:(state)=>state.books
},
actions:{
async fetchBooks({commit}){
    const response = await axios.get('http://localhost:3000/books')
    commit('setBooks', response.data);
}
},
mutations:{
setBooks:(state, books) => (state.books = books),
addBook:(state, book) => state.books.push(book)
},
actions:{
    async fetchBooks({commit}){
        const response = await axios.get('http://localhost:3000/books')
        commit('setBooks', response.data);
    },
async addBook({commit}, book){
    const response = await axios.post('http://localhost:3000/books', book)
    commit('addBook', response.data);
},
async login({ commit }, { email, password }) {
 
      if (email === 'admin@test.com' && password === '1234') {
        const token = 'enterprise-token'
 
        commit('SET_TOKEN', token)
 
        return true
      }
 
      return false
    }
 
}}   
)