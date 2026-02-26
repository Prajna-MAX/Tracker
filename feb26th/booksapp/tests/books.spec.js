import { mount } from '@vue/test-utils'
import { createStore } from 'vuex'
import Books from '../src/Books.vue'
import { describe, it, expect } from 'vitest'
 
describe('Books Component', () => {
 
  it('renders books from store', () => {
 
    const store = createStore({
      state() {
        return {
          books: [{ id: 1, title: 'Test Book', author: 'A' }]
        }
      }
    })
 
    const wrapper = mount(Books, {
      global: {
        plugins: [store]
      }
    })
 
    expect(wrapper.text()).toContain('A')
  })
 
})