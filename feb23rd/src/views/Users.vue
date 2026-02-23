<template>
  <h2>Users</h2>

  <table border="1">
    <tr>
      <th>Name</th>
      <th>Email</th>
      <th>Gender</th>
            <th>skills</th>

    </tr>

    <tr v-for="user in users" :key="user.id">
      <td>{{ user.name }}</td>
      <td>{{ user.email }}</td>
      <td>{{ user.gender }}</td>
       <td>{{ user.skills }}</td>
    </tr>
  </table>
</template>

<script>
import api from '../services/api'

export default {
  data() {
    return { users: [] }
  },
  mounted() {
    this.loadUsers()
  },
  methods: {
    loadUsers() {
      api.getUsers().then(res => {
        this.users = res.data
      })
    },
    editUser(id) {
      this.$router.push(`/edit/${id}`)
    },
    removeUser(id) {
      api.deleteUser(id).then(() => {
        this.loadUsers()
      })
    }
  }
}
</script>
