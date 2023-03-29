<!--Zona Resultados Nacionales Mapas, -->
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
                <v-row class="justify-center titulo_label">
                  <v-card elevation="25">
                    <v-card-text class="map_titulo">
                      <div class="d-flex justify-center white--text">
                        <span> {{ this.titulo }} </span>
                      </div>
                    </v-card-text>
                  </v-card>
                </v-row>

                <!--Botones Vueltas Electorales-->
                <v-row class="justify-center item_vuelta">
                  <v-btn
                    :style="{
                      backgroundColor: this.expand ? '#F88C0F' : 'white',
                      color: this.expand ? 'white' : 'black',
                    }"
                    tile
                    @click="primeraV"
                  >
                    PRIMERA VUELTA
                  </v-btn>
                  <v-btn
                    :style="{
                      backgroundColor: this.expand ? 'white' : '#F88C0F',
                      color: this.expand ? 'black' : 'white',
                    }"
                    tile
                    @click="segundaV"
                  >
                    SEGUNDA VUELTA
                  </v-btn>
                </v-row>
              </div>
            </v-col>

            <v-col cols="12" md="3">
              <div class="align2">
                <!--Boton Busqueda-->
                <v-fab-transition>
                  <v-btn
                    active-class="deep-purple "
                    color="#12A2C2"
                    dark
                    absolute
                    left
                    fab
                    @click.stop="drawer = !drawer"
                  >
                    <v-icon>search</v-icon>
                  </v-btn>
                </v-fab-transition>
                <!--Boton Limpiar-->
                <v-fab-transition>
                  <v-btn
                    active-class="deep-purple "
                    color="#12A2C2"
                    dark
                    absolute
                    right
                    fab
                    @click.stop="limpiar()"
                  >
                    <v-icon>cleaning_services</v-icon>
                  </v-btn>
                </v-fab-transition>
              </div>
            </v-col>
          </v-row>

          <!--Tarjeta de Mapas-->
          <div v-if="!expand">
            <v-row v-show="!expand">
              <v-col cols="12" md="9">
                <span :key="id_codMapa">
                  <CodMapa :id_1="id_codMapa" @mapaTitulo="(i) => (tituloMapa = i)" />
                </span>
              </v-col>
              <v-col cols="12" md="3">
                <span v-bind:key="numvuelta">
                  <TCandidatoV2
                    @tarjeta="(i) => (id_codMapa = i)"
                    :etiquetaTarjeta="this.partido"
                  />
                </span>
              </v-col>
            </v-row>
          </div>

          <div v-else>
            <v-row v-show="expand">
              <v-col cols="12" md="9">
                <span v-bind:key="id_codMapa">
                  <CodMapa :id_1="id_codMapa" />
                </span>
              </v-col>
              <v-col cols="12" md="3">
                <span :key="numvuelta">
                  <TCandidatoV1
                    @tarjetaV1="(i) => (id_codMapa = i)"
                    :etiquetaTarjeta2="this.partido"
                  />
                </span>
              </v-col>
            </v-row>
          </div>
        </v-card>
      </v-row>
    </v-container>

    <!--Filtros de Botón de Búsqueda-->
    <v-navigation-drawer
      v-model="drawer"
      absolute
      temporary
      width="350px"
      color="#12A2C2"
    >
      <v-row class="filtro">
        <v-col cols="12">
          <div class="txt">SELECCIONAR EN FILTRO</div>

          <div class="txt">VUELTA*</div>
          <div>
            <v-select
              v-model="type"
              :items="types"
              dense
              outlined
              hide-details
              class="ma-5"
            ></v-select>
            <span>Seleccionado: {{ type }}</span>
          </div>
          <div class="txt">PARTIDO POLITICO*</div>
          <div>
            <v-select
              v-model="partido"
              :items="arregloPartido"
              dense
              outlined
              hide-details
              class="ma-5"
            ></v-select>
            <span>Seleccionado: {{ partido }}</span>
          </div>
          <!--Ejecutar el metodo-->
          <div :items="`${selectProv()}`"></div>
          <div class="txt">PROVINCIA*</div>
          <div>
            <v-select
              v-model="select"
              :items="provs"
              dense
              outlined
              hide-details
              class="ma-5"
            ></v-select>
            <span>Seleccionado: {{ select }}</span>
          </div>

          <div class="txt">CANTÓN</div>
          <v-select
            v-model="select2"
            :items="cantons"
            dense
            outlined
            hide-details
            class="ma-5"
          ></v-select>
          <span>Seleccionado: {{ select2 }}</span>
          <div>*Campo Obligatorio</div>
        </v-col>
        <!--Botónes Búsqueda-->

        <v-col cols="12" md="6">
          <v-btn @click="datosBusqueda2()"> BUSCAR </v-btn>
        </v-col>
      </v-row>
    </v-navigation-drawer>
  </v-sheet>
</template>

<script>
import CodMapa from "./CodMapa";

import TCandidatoV1 from "./TarjetaCandidato";
import TCandidatoV2 from "./SV_TarjetaCandidato";

export default {
  name: "MapaNacional",
  props: { expand_b: String, expand2_b: String },
  beforeUpdate() {
    console.log("id_codmap antes: " + this.id_codMapa);
  },
  updated() {
    console.log("id_codmap despues: " + this.id_codMapa);
  },
  data() {
    var vuelta = ["1", "2"];
    const provincia = require("../assets/Informacion/provincias_cantones.json");
    const candidato = require("../assets/Informacion/candidatosV2.json");
    return {
      /*Variables de Select */
      select: "",
      select2: "",
      type: "",
      provs: null,
      cantons: null,
      types: vuelta,
      arregloPartido: null,
      partido: "",
      arreglo_prov: provincia,
      candidatos: candidato,
      /*Dibujar Sheet */
      drawer: null,
      numvuelta: "2",
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
      tituloMapa: "0",
      titulo: "RESULTADOS NACIONALES",
    };
  },

  components: { CodMapa, TCandidatoV1, TCandidatoV2 },
  methods: {
    limpiar() {
      this.type = "";
      this.select = "";
      this.select2 = "";
      this.partido = "";
      this.primeraV();
      this.drawer = false;
    },
    primeraV() {
      this.expand = true;
      this.$emit("add", 0);

      this.numvuelta = this.numvuelta == "1" ? "1" : "0";
      console.log("VueltaNum " + this.numvuelta);

      this.id_codMapa = ["1raVuelta", "", "", ""];
      this.titulo = "RESULTADOS NACIONALES";
      console.log(this.candidatos);
    },
    segundaV() {
      this.expand = false;
      this.asignarTitulo2();
      this.$emit("add", 1);
      this.numvuelta = "2";
      this.numvuelta = this.numvuelta == "2" ? "2" : "0";
      console.log("VueltaNumB2 " + this.numvuelta);
      this.id_codMapa = ["2daVuelta", "", "", ""];
      this.titulo = "RESULTADOS NACIONALES";
    },

    datosBusqueda2() {
      //let vuelta = this.expand ? '1raVuelta' : '2daVuelta'
      let varVuelta = this.type == "1" ? "1raVuelta" : "2daVuelta";
      this.type == "1" ? (this.expand = true) : (this.expand = false);
      this.type == "1" ? (this.numvuelta = "2") : (this.numvuelta = "2");
      let politico = this.candidatos.find(
        (elemento) => elemento.nombrePartido === this.partido
      );

      let condicionPartido =
        politico.nombrePartido == "Resultados Generales" ? "" : politico.json;

      if (this.select == "") {
        let candidato =
          this.select == ""
            ? (this.id_codMapa = [varVuelta, condicionPartido, "", ""])
            : "";
        console.log(candidato);
        this.drawer = false;
      } else if (this.select2 == "") {
        const resultado = this.arreglo_prov.find(
          (varProvincia) => varProvincia.provincia === this.select
        );
        this.id_codMapa = [varVuelta, condicionPartido, resultado.id, resultado.id];
        console.log("----------Id provincia--------" + this.id_codMapa);
      } else {
        const resultado = this.arreglo_prov.find(
          (varProvincia) => varProvincia.provincia === this.select
        );
        const arregloCantones = resultado.cantones;
        const cantonSelect = arregloCantones.find(
          (varCanton) => varCanton.nombre === this.select2
        );
        this.id_codMapa = [varVuelta, condicionPartido, resultado.id, cantonSelect.idcan];
        console.log("Id Boton" + this.id_codMapa);
        this.drawer = false;
      }

      this.asignarTitulo();
      this.drawer = false;
      this.select2 = "";

      console.log("Id" + this.id_codMapa);
    },
    asignarTitulo() {
      const textoTitulo = this.arreglo_prov.find(
        (datos) => datos.id === this.id_codMapa[2]
      );
      const arregloTexto = textoTitulo.cantones;
      const textCanton = arregloTexto.find(
        (datosCanton) => datosCanton.idcan === this.id_codMapa[3]
      );
      let condicionTexto = this.select2 != "" ? textCanton.nombre : textoTitulo.provincia;
      this.titulo = "RESULTADOS " + condicionTexto;
    },
    asignarTitulo2() {
      console.log(this.tituloMapa);
      //const textoTitulo = this.arreglo_prov.find(datos => datos.id === this.tituloMapa);
    },
    selectProv() {
      for (let l = 0; l < this.candidatos.length; l++) {
        this.auxpartido[l] = this.candidatos[l].nombrePartido;
      }
      for (let m = 0; m < 3; m++) {
        this.auxpartido2[m] = this.candidatos[m].nombrePartido;
      }
      if (this.type == "1" || this.type == "2") {
        let condicionPartido =
          this.type == "1"
            ? (this.arregloPartido = this.auxpartido)
            : (this.arregloPartido = this.auxpartido2);
        console.log(condicionPartido);

        for (let i = 0; i < this.arreglo_prov.length; i++) {
          this.aux_prov[i] = this.arreglo_prov[i].provincia;
        }
        this.provs = this.aux_prov;
        for (let j = 0; j < this.arreglo_prov.length; j++) {
          if (this.select == this.arreglo_prov[j].provincia) {
            this.aux_canton = this.arreglo_prov[j].ncantones;
            this.cantons = this.aux_canton;
          }
        }
      }
      //console.log("Cantones" + this.cantons)
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Oswald&display=swap");

.color {
  background-color: darkmagenta;
}

.titulo {
  margin-top: 10px;
  align-items: center;
  justify-content: center;
  position: absolute;
  display: flex;
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

.align2 {
  margin: 10%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

.fondo {
  width: 100%;

  padding-top: 0%;

  font-family: "Open Sans", sans-serif;
  background-image: url("@/assets/fondo2.png");
  background-position: center;
  background-size: cover;
}

.item_vuelta {
  padding: 10px;
}

.filtro {
  padding-top: 20px;
  padding-left: 30px;
}

.txt {
  font-family: "Oswald";
  font-size: 15px;
}

.item_opc {
  margin_top: 55px;
}

.titulo_label {
  margin-top: 20px;
}

.map_titulo {
  font-size: 30px;
  font-family: "Oswald";

  width: 500px;
  background-color: #12a2c2;
  border-radius: 5px;
}

.item_vuelta {
  padding-top: 10px;
}

.map {
  margin-top: 20px;
}

.select_partido {
  margin: auto;
  padding-right: 10px;
  background-color: blue;
}

.d_carrucel {
  width: 100%;
}

.card {
  padding-top: 60px;
}
</style>
