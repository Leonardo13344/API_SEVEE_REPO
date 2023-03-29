
<template>
  <v-app>
    <nav>
      <v-toolbar >
        <v-toolbar-title class="headline text-uppercase">
          <div class="img_logo">
            <v-img alt="Sevee Logo" src="../assets/Sevee_NavBar.svg" transition="scale-transition" contain />
          </div>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <div >
          <v-menu offset-y>
            <template v-slot:activator="{ on, attrs }">
              <v-btn color="#246CB6" class="hidden-md-and-up" dark v-bind="attrs" v-on="on">
                <v-icon>mdi-menu</v-icon>
              </v-btn>
            </template>
            <v-list class="btnNav">
              <v-list-item>
                <v-list-item-title>
                  <router-link class="link2" :to="{ name: 'inicio' }">Inicio</router-link>
                </v-list-item-title>
              </v-list-item>
              <v-list-item>
                <v-list-item-title>
                  <router-link class="link2 " :to="{ name: 'VotantesNacionales' }">Votantes Nacionales</router-link>
                </v-list-item-title>
              </v-list-item>
              <v-list-item>
                <v-list-item-title>
                  <router-link class="link2" :to="{ name: 'VotantesExtranjero' }">Votantes Extranjero</router-link>
                </v-list-item-title>
              </v-list-item>
              <v-list-item>
                <v-list-item-title>
                  <router-link class="link2" :to="{ name: 'AcercaDe' }">Acerca De</router-link>
                </v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
        </div>

        <v-toolbar-items class="hidden-sm-and-down">
          <!--<v-btn flat  color="white"></v-btn>-->
          <div class="nav">
            <router-link class="link" :to="{ name: 'inicio' }">Inicio</router-link>
            <router-link class="link" :to="{ name: 'VotantesNacionales' }">Votantes Nacionales</router-link>
            <router-link class="link" :to="{ name: 'VotantesExtranjero' }">Votantes Extranjero</router-link>
            <router-link class="link" :to="{ name: 'AcercaDe' }">Acerca De</router-link>
          </div>
        </v-toolbar-items>
      </v-toolbar>
    </nav>
    <v-content>
      <router-view />
    </v-content>


  </v-app>
</template>
 
<script>


export default {
  name: 'NavBar',
  data: () => ({
    return: {
    }
  }),
  components: {},
  computed: {
  }
}
</script>
 
<style scoped>

.img_logo {
  width: 50%;
  margin-left: 5%;
  padding: 10px;
}

.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-family: 'Oswald';

}

.btnNav {
  width: 100%;
  text-align: center;
}

.link {
  margin: 30px;
  text-align: center;
  font-weight: 400;
  list-style: none;
  text-decoration: none;
  font-size: 18px;
}

.link2 {
  font-weight: 400;
  padding: 50px;
  list-style: none;
  text-decoration: none;
  font-size: 18px;
}

.router-link-exact-active {
  font-weight: 500;
  color: #F88C0F;
}
</style>