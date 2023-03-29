<template>

  <v-container fluid class="contenedor">
    <v-card flat tile dark padless class="rounded-0 PiePagina">
      <v-row no-gutters>
        <v-col cols="12" md="4">
          <v-container>
            <v-img alt="" src="../assets/P_Sevee.svg" transition="scale-transition" class="img" contain />
          </v-container>
        </v-col>
        <v-spacer></v-spacer>
        <v-col cols="12" md="6">
          <v-container class="container-img">
            <v-img alt="" src="../assets/P_IAEN.svg" class="img_colaboradores" transition="scale-transition" contain />
            <v-img alt="" src="../assets/P_Uce.svg" class="img_colaboradores" transition="scale-transition"  contain />
            <v-img alt="" src="../assets/P_Ac.svg" class="img_colaboradores" transition="scale-transition"  contain />
          </v-container>
        </v-col>
      </v-row>
    </v-card>
    <v-card-text class="titulo-final">
      Copyright &copy; {{ new Date().getFullYear() }} | Derechos reservados
    </v-card-text>

  </v-container>
  <!--
  <v-footer dark padless width="100%">
    <v-container flat tile width="100%">
      <div class=" pa-2 align-self-center PiePagina">
        <div class="align">
          <div class="align">
            <v-img alt="" src="../assets/P_Sevee.svg" transition="scale-transition" class="img" contain />
            <v-container class="container-img">
            <v-img alt="" src="../assets/P_IAEN.svg" transition="scale-transition" class="img" contain />
            <v-img alt="" src="../assets/P_Uce.svg" transition="scale-transition" class="img" contain />
            <v-img alt="" src="../assets/P_Ac.svg" transition="scale-transition" class="img" contain />
            </v-container>
          </div>
        </div>
      </div>
    </v-container>
    <h2 class="titulo-final">Copyright &copy; 2023 | Derechos reservados</h2>
  </v-footer>
-->

</template>

<script>

export default {
  name: 'FooterApp',
  data: () => ({

  }),
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');


.contenedor {
  margin: 0%;
  padding: 0%;
  padding-top: 0%;
  background-color: rgb(42, 41, 41);
}

.PiePagina {
  padding: 2%;
  border-bottom: 1px solid rgb(255, 255, 255)
}

.container-img {
  width: auto;
  height: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
}


.img_colaboradores {
  width: auto;
  height: 120px;
  display: inline-block;
}

.img {
  height: 140px;
}

.titulo-final {
  font-family: 'Open sans', sans-serif;
  text-align: center;
  font-size: 16px;
  color: #ccc7cc;
}
</style>