<template>
  <v-container fluid class="contenedor">
    <v-row no-gutters>
      <v-card flat color="c-Inicio" width="100%">
        <v-window touchless v-model="onboarding">
          <v-window-item :value="0">
            <div>
              <MapaNacional v-bind:expand_b=this.boolean1 @add="(i) => numero_vuelta = i"></MapaNacional>
            </div>
          </v-window-item>

          <v-window-item :value="1">
            <div>
              <div class="d-flex justify-center mb-6 size" v-if="numero_vuelta == 0">
                <CodGraficos />
              </div>
              <div class="d-flex justify-center mb-6 size" v-else>
                <CodGraficos2 />
              </div>
            </div>
          </v-window-item>

          <v-window-item :value="2">
            <div class="size">
              <CodTablas :id_1="numero_vuelta" v-bind:key="numero_vuelta" />
            </div>
          </v-window-item>

        </v-window>

        <v-divider></v-divider>

        <v-card-actions background-color="white" class="justify-space-between">
          <v-btn text @click="prev">
            <v-icon>mdi-chevron-left</v-icon>
          </v-btn>
          <v-item-group v-model="onboarding" class="text-center" mandatory>
            <v-item v-for="n in length" :key="`btn-${n}`" v-slot="{ active, toggle }">
              <v-btn :input-value="active" icon @click="toggle">
                <v-icon>mdi-record</v-icon>
              </v-btn>
            </v-item>
          </v-item-group>
          <v-btn text @click="next">
            <v-icon>mdi-chevron-right</v-icon>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>

    <v-row no-gutters class="margen" v-if="numero_vuelta == 0">
      <InfoGeneral />
    </v-row>
    <v-row no-gutters class="margen" v-else>
      <InfoGeneral2 />
    </v-row>

  </v-container>
</template>
  
<script>
import InfoGeneral from './InfoGeneral';
import InfoGeneral2 from './InfoGeneral2';
import MapaNacional from './MapaNacional';
import CodGraficos from './CodGraficos.vue';
import CodGraficos2 from './CodGraficos2.vue';
import CodTablas from './CodTablas.vue';

export default {
  name: "VotantesNacionales",
  data: () => {

    return {
      length: 3,
      onboarding: 0,
      boolean1: true,
      ruleta: 0,
      numero_vuelta: 0,
      idMapa1: "API_1",
      idMapa2: "API_2",
    }

  },
  methods: {
    next() {
      this.onboarding = this.onboarding + 1 === this.length
        ? 0
        : this.onboarding + 1
    },
    prev() {
      this.onboarding = this.onboarding - 1 < 0
        ? this.length - 1
        : this.onboarding - 1
    },
  },
  components: { InfoGeneral, InfoGeneral2, MapaNacional, CodGraficos, CodGraficos2, CodTablas }

}
</script>
  
<style >
@import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');

.contenedor {
  margin-top: 5px;
  padding: 0%;
  padding-top: 0%;
}

.c-Inicio {
  font-family: 'Open Sans', sans-serif;
  border-style: none;
  padding: 0%;
  background-image: url('@/assets/fondo2.png');
  background-size: cover;
  background-position: center;
}

.map_titulo {
  font-size: 30px;
  font-family: 'Oswald';
  width: 500px;
  background-color: #12A2C2;
  border-radius: 5px;
}

.titulo_label {
  margin-top: 10px;
}

.size {
  height: 700px;
}

.margen {
  border-radius: 0px;
  padding-bottom: 3px;
}
</style>