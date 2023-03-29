<template>
  <v-sheet>
    <v-container fluid class="fondo">
      <v-row no-gutters>
        <v-card outlined color="transparent" width="100%">
          <v-row no-gutters>
            <v-col cols="12" md="3"></v-col>

            <v-col cols="12" md="6">

              <div class="align">
                <!--Etiqueta Titulo Mapas-->
                <v-row class=" justify-center titulo_label">
                  <v-card elevation="25">
                    <v-card-text class="map_titulo">
                      <div class="d-flex justify-center white--text"> <span>
                          Resultados Internacionales 
                        </span></div>
                    </v-card-text>
                  </v-card>
                </v-row>

                <!--Botones Vueltas Electorales-->
                <v-row class=" justify-center item_vuelta">
                  <v-btn
                    :style="{ backgroundColor: this.expand ? '#F88C0F' : 'white', color: this.expand ? 'white' : 'black', }"
                    tile @click="primeraV">
                    PRIMERA VUELTA
                  </v-btn>
                  <v-btn
                    :style="{ backgroundColor: this.expand ? 'white' : '#F88C0F', color: this.expand ? 'black' : 'white', }"
                    tile @click="segundaV">
                    SEGUNDA VUELTA
                  </v-btn>
                </v-row>
              </div>
            </v-col>
          </v-row>
          <!--Tarjeta de Mapas-->
          <div v-if="(!expand)">
            <v-row v-show="!expand">
              <v-col cols="12" md="9">
                <span :key="id_codMapa">
                  <CodMapaExtranjero :id_1=id_codMapa @mapaTitulo="(i) => tituloMapa = i" />
                </span>
              </v-col>
              <v-col cols="12" md="3">
                <span v-bind:key="numvuelta">
                  <TCandidatoV2 @tarjeta="(i) => id_codMapa = i" :etiquetaTarjeta=this.partido />
                </span>
              </v-col>
            </v-row>
          </div>

          <div v-else>
            <v-row v-show="expand">
              <v-col cols="12" md="9">
                <span v-bind:key="id_codMapa">
                  <CodMapaExtranjero :id_1=id_codMapa />
                </span>
              </v-col>
              <v-col cols="12" md="3">
                <span :key="numvuelta">
                  <TCandidatoV1 @tarjetaV1="(i) => id_codMapa = i" :etiquetaTarjeta2=this.partido />
                </span>

              </v-col>
            </v-row>
          </div>

        </v-card>
      </v-row>
    </v-container>


  </v-sheet>
</template>

<script>

import CodMapaExtranjero from './CodMapaExtranjero.vue';
import TCandidatoV1 from './TarjetaCandidato';
import TCandidatoV2 from './SV_TarjetaCandidato';


export default {
  name: "MapaExtranjero",
  props: { expand_b: String, expand2_b: String },
  beforeUpdate() {
    console.log("id_codmap antes: " + this.id_codMapa);

  },
  updated() {
    console.log("id_codmap despues: " + this.id_codMapa);

  },
  data() {

    var vuelta = ['1', '2'];
    const provincia = require('../assets/Informacion/provincias_cantones.json');
    const candidato = require('../assets/Informacion/candidatosV2.json');

    return {
      /*Variables de Select */
      select: '',
      select2: '',
      type: '',
      provs: null,
      cantons: null,
      types: vuelta,
      arregloPartido: null,
      partido: '',
      arreglo_prov: provincia,
      candidatos: candidato,
      /*Dibujar Sheet */
      drawer: null,
      numvuelta: '2',
      /* */
      id_codMapa: [],
      /*Auxiliares Metodos */
      aux_prov: [],
      aux_prov2: [],
      aux_canton: [],
      aux_idprov: [],
      auxpartido: [],
      auxpartido2: [],
      expand: this.expand_b,
      tituloMapa: '0',
      titulo: 'RESULTADOS INTERNACIONALES'

    }
  },
  components: { TCandidatoV1, TCandidatoV2, CodMapaExtranjero },
  methods: {

    primeraV() {
      this.expand = true;
      this.$emit('add', 0)

      this.numvuelta = (this.numvuelta == '1') ? '1' : '0';
      console.log("VueltaNum " + this.numvuelta)

      this.id_codMapa = ["1raVuelta", "", "", ""]
      this.titulo = 'RESULTADOS INTERNACIONALES'
      console.log(this.candidatos)
    },
    segundaV() {
      this.expand = false;
      this.asignarTitulo2()
      this.$emit('add', 1);
      this.numvuelta = '2'
      this.numvuelta = (this.numvuelta == '2') ? '2' : '0';
      console.log("VueltaNumB2 " + this.numvuelta)
      this.id_codMapa = ["2daVuelta", "", "", ""]
      this.titulo = 'RESULTADOS INTERNACIONALES'
    },



  }
}
</script>



<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');

.fondo {
  width: 100%;
  font-family: 'Open Sans', sans-serif;
  background-image: url('@/assets/fondo2.png');
  background-position: center;
  background-size: cover;
}

.titulo_label {
  margin-top: 10px;

}

.align {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.item_vuelta {
  padding: 10px;

}


</style>