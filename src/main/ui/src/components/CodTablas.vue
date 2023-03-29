<template>
  <div id="app">
    <div class="container">
      <!--
            <h1 class="caja">{{ titulo }}</h1>
            -->

      <!--Etiqueta Titulo Mapas-->
      <v-row class="justify-center titulo_label">
        <v-card elevation="25">
          <v-card-text class="map_titulo">
            <div class="d-flex justify-center white--text">RESULTADOS NACIONALES</div>
          </v-card-text>
        </v-card>
      </v-row>

      <table class="content-table">
        <thead>
          <tr>
            <th>Candidato</th>
            <th>Partido Politico</th>
            <th>Porcentaje</th>
            <th>Hombres</th>
            <th>Mujeres</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="dato in datos" :key="dato.id">
            <td>{{ dato.nombreCandidato }}</td>
            <td>{{ dato.nombrePartido }}</td>
            <td>{{ ((dato.porcentaje / 10235781) * 100).toFixed(3) }}%</td>
            <td>{{ dato.totalHombres }}</td>
            <td>{{ dato.totalMujeres }}</td>
          </tr>
        </tbody>
      </table>
      <P>Fuente: CNE</P>
    </div>
  </div>
</template>
<script>
import { muestraTablaGenerales } from "../helpers/votos.js";
export default {
  data() {
    return {
      titulo: "Tablas Resultados Nacionales",
      datos: null,
    };
  },
  methods: {
    async buscarTablas() {
      this.datos = await muestraTablaGenerales(false);
    },
  },
  mounted() {
    this.buscarTablas();
  },
};
</script>

<style>
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

* {
  /* Change your font family */
  font-family: "Oswald", sans-serif;
}

.container {
  width: 100%;
  margin: 8px auto;
}

.caja {
  background-color: #12a2c2;
  width: 50%;
  margin: 5px auto;
  text-align: center;
  box-shadow: 3px 3px 10px rgba(0, 0, 0);
  font-size: 1.2em;
}

.titulo {
  color: #000000;
  width: 50%;
  margin: 15px auto;
  text-align: center;
  font-size: 0.9em;
}

.content-table {
  margin-top: 70px;
  font-family: "Source Sans Pro", sans-serif;

  background-color: #12a2c233;
  border-collapse: collapse;
  margin: 25px auto;
  font-size: 0.9em;

  width: 100%;
  overflow: hidden;
  box-shadow: 3px 3px 15px rgba(0, 0, 0, 0.5);
}

.content-table th {
  font-family: "Oswald", sans-serif;
  padding: 12px 15px;
  border-bottom: 3px solid #f1787885;
  border-right: 3px solid #12a2c233;
  color: #000000;
  text-align: center;
  font-weight: normal;

  width: 90%;
  overflow: hidden;
  box-shadow: 3px 3px 15px rgba(0, 0, 0, 0.5);
}

.content-table td {
  font-family: "Source Sans Pro", sans-serif;

  padding: 12px 15px;
  border-bottom: 3px solid #f1787885;
  border-right: 3px solid #12a2c233;
  color: #000000;
  text-align: center;
  font-weight: normal;
}

.content-table tr:hover {
  background-color: #12a2c233;
}

.text {
  font-family: "Source Sans Pro", sans-serif;
  font-size: medium;
  color: black;
}

.align {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
