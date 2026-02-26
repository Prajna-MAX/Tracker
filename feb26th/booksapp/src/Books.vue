<template>
  <div>
    <ul v-if="books.length">
      <li v-for="book in books" :key="book.id">
        {{ book.title }} - {{ book.author }}
      </li>
    </ul>
 
    <p v-else>No books available</p>
  </div>
</template>
 
<script>
export default {
  computed: {
    books() {
      return this.$store.state.books
    }
  }
}
</script>
 