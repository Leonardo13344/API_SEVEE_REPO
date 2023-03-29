<template>
  <v-main>
    <NavBar/>
    <!--Pie de Pagina-->
      <FooterApp />
    </v-main>
  </template>
  
  <script>
   import NavBar from './components/NavBar.vue'
   import FooterApp from './components/FooterApp';
  
  export default {
    name: 'App',
    data: () => ({
      return: {
      }
    }),
    components: {FooterApp, NavBar},
    computed: {
    }
  }
  </script>
  

<style scoped>
.navbar {
  width: 100%;
  margin: 0%;
}

.img {
  width: 150px;
  margin: 5%;
}

.card {
  margin-top: 5px;
}

.area-nav {
  margin-right: 30px;
}

.margen{
  margin-bottom: 0%;
}


</style>