import { describe, it, expect } from 'vitest'
import store from '../src/store'
import MockAdapter from 'axios-mock-adapter'
import axios from 'axios'
import Books from '../src/store/index.js'

const mock = new MockAdapter(axios)

describe('Vuex Actions', () => {

  it('fetchBooks action commits SET_BOOKS mutation', async () => {
    mock.onGet('http://localhost:3000/books')
        .reply(200, [
          { id: 1, title: 'Test Book' }
        ])
    await store.dispatch('fetchBooks')
    expect(store.state.books).toEqual([
      { id: 1, title: 'Test Book' }
    ])
  })
  it('addBook action commits ADD_BOOK mutation', async () => {

    const newBook = { id: 2, title: 'New Book' }

    mock.onPost('http://localhost:3000/books')
        .reply(201, newBook)

    await store.dispatch('addBook', newBook)

    expect(store.state.books).toContainEqual(newBook)
  })

})


describe('Vuex Mutations', () => {

  it('setBooks mutation updates state', () => {
    const books = [{ id: 1, title: 'Test' }]
    store.commit('setBooks', books)

    expect(store.state.books)
  })
  it('addBooks mutation updates state', () => {
    const book = { id: 2, title: 'New Book' }
    store.commit('addBook', book)

    expect(store.state.books).toContainEqual(book)
  })
it('availableBooks getter works', () => {
  store.state.books = [
    { id: 1, available: true },
    { id: 2, available: false }
  ]
  const result = store.getters.allBooks
  expect(result.length).toBe(2)
})

})

describe('Vuex Getters', () => {
  it('allBooks getter returns all books', () => {
    store.state.books = [
      { id: 1, title: 'Book 1' },
      { id: 2, title: 'Book 2' }
    ]
    const result = store.getters.allBooks
    expect(result).toEqual(store.state.books)
  })

})
