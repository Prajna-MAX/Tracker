<template>
  <h2>Add User</h2>

  <input v-model="name" placeholder="Name" />
  <input v-model="email" placeholder="Email" />

  <div>
    <label>
      <input type="radio" value="Male" v-model="gender" />
      Male
    </label>

    <label>
      <input type="radio" value="Female" v-model="gender" />
      Female
    </label>
  </div>

 <div>
  <p>Select Skills:</p>

  <label>
    <input type="checkbox" value="Java" v-model="skills" />
    Java
  </label>

  <label>
    <input type="checkbox" value="Python" v-model="skills" />
    Python
  </label>

  <label>
    <input type="checkbox" value="Vue" v-model="skills" />
    Vue
  </label>

  <label>
    <input type="checkbox" value="React" v-model="skills" />
    React
  </label>
</div>

  <button @click="saveUser">Save</button>
</template>

<script>
import api from '../services/api'

export default {
  data() {
    return {
      name: '',
      email: '',
      gender: '',
      skills:[]
    }
  },
  methods: {
    saveUser() {
      if (!this.name || !this.email || !this.gender) {
        alert("Please fill all fields")
        return
      }

      api.addUser({
        name: this.name,
        email: this.email,
        gender: this.gender,
        skills:this.skills
      }).then(() => {
        this.$router.push('/users')
      })
    }
  }
}
</script>