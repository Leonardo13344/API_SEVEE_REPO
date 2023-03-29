<template>
  <v-main>
    <v-app>
      <template>
        <!--Barra de Navegacion -->
        <v-toolbar>
          <v-col cols="4" md="4">

            <v-img alt="Sevee Logo" src="./assets/logo_sevee.png" transition="scale-transition" width="150" contain />

          </v-col>
          <v-col cols="8" md="8">

            <v-tabs v-model="tabs" class="d-none d-sm-flex">
              <!--Tabla de navegacion-->
              <template>
                <v-tabs-slider color="orange"></v-tabs-slider>
                <v-tab class="area-nav">Inicio </v-tab>
                <v-tab class="area-nav"> Votantes Nacionales </v-tab>
                <v-tab class="area-nav"> Votantes Internacionales </v-tab>
                <v-tab class="area-nav">Acerca De</v-tab>
              </template>
            </v-tabs>
          </v-col>
        </v-toolbar>





        <!--Distribucion de Ventanas por Botones -->
        <v-card class="card">
          <v-tabs-items v-model="tabs">
            <v-tab-item>
              <v-card flat>
                <InicioPagina />
              </v-card>
            </v-tab-item>
            <v-tab-item>
              <v-card flat>
                <VotantesNacionales />
              </v-card>
            </v-tab-item>
            <v-tab-item>
              <v-card flat>
                <VotantesExtranjero />
              </v-card>
            </v-tab-item>
            <v-tab-item>
              <v-card flat>
                <AcercaDe />
              </v-card>
            </v-tab-item>
          </v-tabs-items>
        </v-card>

      </template>
    </v-app>

    <!--Pie de Pagina-->
    <FooterApp />
  </v-main>

</template>

<script>
//import HelloWorld from './components/HelloWorld';
import VotantesNacionales from './components/VotantesNacionales.vue';
import VotantesExtranjero from './components/VotantesExtranjero.vue';


import InicioPagina from './components/InicioPagina';
import AcercaDe from './components/AcercaDe';
import FooterApp from './components/FooterApp';



export default {
  name: 'App',

  components: {
    VotantesNacionales,
    VotantesExtranjero,
    InicioPagina,
    AcercaDe,
    FooterApp
  },

  data() {
    return {
      tabs: null,
    }
  },
};
</script>

<style scoped>
.card {
  margin-top: 0.5%;
}

.fondo {
  width: 100%;
  font-family: 'Open Sans', sans-serif;
  border-style: none;
  background-image: url('@/assets/fondo.png');
  background-size: cover;

}


.Encabezado {
  font-family: 'Source Sans Pro', sans-serif;
  /*font-family: 'Oswald', sans-serif;*/


}

.Card_Encabezado {

  width: 100%;
  /*margin-top: 10px;*/
}

.espacio {
  width: 550px;
}

.area-Btn {
  align-items: stretch;
  align-content: flex-start;
  height: 100px;
  margin-top: 2px;
}

.area-nav {
  flex: 100;
}
</style>