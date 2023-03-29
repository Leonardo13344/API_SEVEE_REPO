<template>
  <v-row justify="space-around">
    <!--Etiqueta Titulo Mapas-->
    <div class="desplazamiento">
      <v-row class=" justify-center titulo_label">
        <v-card elevation="25">
          <v-card-text class="map_titulo">
            <div class="d-flex justify-center white--text"> GRÁFICOS DE RESULTADOS</div>
          </v-card-text>
        </v-card>
      </v-row>

    </div>

    <v-card :class="`loader${condicionEstilo()}0`">
      <div :class="`loader${condicionEstilo()}1`">
        <GChart type="ColumnChart" :data="chartData" :options=opcionesNormal() />
      </div>

      <div :class="`loader${condicionEstilo()}2`">
        <GChart type="ColumnChart" :data="chartDataSombra" :options=opcionesSombra() />
      </div>

      <div :class="`img_presidente${condicionEstilo()}`">
        <img :class="`espaciado_img_presidente${condicionEstilo()}`" v-for="(item) in arrayImgPresidente()" :key="item.id"
          :src="item.url" :alt="item.name" />
      </div>

      <div :class="`img_partido${condicionEstilo()}`">
        <div :class="`espaciado_partido${condicionEstilo()}`" v-for="(item) in arrayImgPartidoPolitico()" :key="item.id">
          <img :class="`altura_${Math.trunc(((info[item.id - 1] * 100) / Math.max(...info)) / 10)}`" :src="item.url"
            :alt="item.name" />
        </div>
      </div>

      <div :class="`txt${condicionEstilo()}`">
        <h1 :class="`espaciado_txt${condicionEstilo()}`" v-for="(item, index) in info" :key=index
          :style="`color: ${arrayColors[index]}; font-size: 25px`">
          {{ item | currencydecimal }}%
        </h1>
      </div>

    </v-card>

  </v-row>
</template>

<script >
import { ref } from 'vue';
import { GChart } from 'vue-google-charts/legacy';
import axios from 'axios';

var llenarArray = function (json, presidentes, colores) {
  let array = new Array()
  //console.log("Prueba "+this.vuelta)
  for (let i = 0; i < 16; i++) { //2--16
    array.push(json[i].deathIncrease / 100)
  }

  let chartData, chartDataSombra
  [chartData, chartDataSombra] = arreglosExtra(array, presidentes, colores)

  return [array, chartData, chartDataSombra];
};
/*
var llenarArray = function(json, presidentes, colores) {
  let array = new Array()
  //extra
  let aux = 0
  //for extra y aux 
  for(let i=0; i<1; i++){ //1---5
    for (let i in json) {
    array.push(json[i].rate_float/10000)
      if(aux<1){      
        array.push(json[i].rate_float/10000)
        aux++
      }
    }
  }
  let chartData, chartDataSombra 
  [chartData, chartDataSombra] = arreglosExtra(array, presidentes, colores)

  return [array, chartData, chartDataSombra];
};*/

var arreglosExtra = function (info, presidentes, arrayColors) {
  //comenzar a definir los array necesarios
  let chartData = [['Candidato', 'Porcentaje', { role: 'style' }]];
  let chartDataSombra = [['Candidato', 'Porcentaje', { role: 'style' }]];

  for (var i = 0; i < info.length; i++) {
    chartData.push([presidentes[i], info[i], 'fill-color: ' + arrayColors[i]]);
    chartDataSombra.push([presidentes[i], info[i], 'fill-color: black ']);
  }
  return [chartData, chartDataSombra]
}

export default {
  components: {
    GChart,
  },
  data() {
    console.log("inicio")
    //console.log(this.vuelta)
    var arrayColors = ['#045A8D', '#EF8A62', '#9B59B6', '#808080', '#00ffff', '#765900', '#443122', '#d86a60', '#d81b60', '#F5E222', '#F70E2E', '#a83383', '#31abb9', '#fcbd00', '#2EBA6E', '#0096ce', 'red', 'brown', 'green', 'black']
    var presidentes = ['Guillermo \n Lasso', 'Andrés \n Arauz', 'Yaku \n Perez', 'Gerson \n Almeida', 'Giovanny \n Andrade', 'Carlos \n Sagnay', 'Guillermo \n Celi', 'Gustavo \n Larrea', 'Isidro \n Romero', 'Juan F. \n Velasco', 'Lucio \n Gutierrez', 'Paul \n Carrasco', 'Pedro \n Freile', 'Xavier \n Hervas', 'Ximena \n Peña', 'Cesar \n Montufar']
    var porcentaje = [59.75, 89.74, 15.74, 10.04, 32.75, 19.74, 15.74, 10.04, 32.75, 19.74, 15.74, 10.04, 32.75, 19.74, 15.74, 10.04]

    var opciones = [700, 4360]

    return {
      presidentes,
      porcentaje,
      arrayColors,
      opciones,
      info: null,
      chartData: null,
      chartDataSombra: null,
      img_partido_politico: null,
      img_presidentes: null,
      chartOptions: null,
      chartOptions1: null,
    }
  },
  async created() {
    await axios
      .get('https://api.covidtracking.com/v1/states/ca/daily.json')
      .then(response => ([this.info, this.chartData, this.chartDataSombra] = llenarArray(response.data, this.presidentes, this.arrayColors)))

    //https://covidtracking.com/data/api
    //https://api.covidtracking.com/v1/states/ca/daily.json
    //await axios
    //  .get('https://api.coindesk.com/v1/bpi/currentprice.json')
    //  .then(response => ([this.info, this.chartData, this.chartDataSombra] = llenarArray(response.data.bpi, this.presidentes, this.arrayColors)))
  },
  methods: {
    /*arrayData(){
     this.chartData = [['Candidato', 'Porcentaje', { role: 'style' }]];
     if(this.info != null){
       for(var i=0; i <this.info.length; i++){
       this.chartData.push(  [this.presidentes[i], this.info[i], 'fill-color: '+ this.arrayColors[i]] );
       }
     }
     return this.chartData
   },
   arrayDataSombra(){
     this.chartDataSombra = [['Candidato', 'Porcentaje', { role: 'style' }]];
     if(this.info != null){
       for(var i=0; i <this.info.length; i++){
       this.chartDataSombra.push(  [this.presidentes[i], this.info[i], 'fill-color: black '] );
       }
     }
     return this.chartDataSombra
   },*/
    arrayImgPartidoPolitico() {
      this.img_partido_politico = ref([{}])
      if (this.info != null) {
        for (var i = 0; i < this.info.length; i++) {
          this.img_partido_politico.push({ id: (i + 1), url: require("@/assets/Partidos/" + (i + 1) + ".png"), name: 'imagen' + i },);
        }
        this.img_partido_politico.shift()
      }
      return this.img_partido_politico
    },
    arrayImgPresidente() {
      this.img_presidentes = ref([{}])
      if (this.info != null) {
        for (var i = 0; i < this.info.length; i++) {
          this.img_presidentes.push({ id: (i + 1), url: require("@/assets/Candidatos/" + (i + 1) + ".png"), name: 'imagen' + i },);
        }
        this.img_presidentes.shift()
      }
      return this.img_presidentes
    },
    opcionesNormal() {
      this.chartOptions = {
        legend: { position: 'none' },
        bar: { groupWidth: "25%" },
        vAxis: {
          gridlines: { count: 0, color: 'transparent' }, textStyle: { fontSize: 1 }, viewWindow: 'maximized',
          baselineColor: 'transparent'
        },
        hAxis: { textStyle: { fontSize: 20, fontName: 'Century' }, textPosition: 'out', viewWindow: 'maximized' },
        width: this.opciones[this.condicionEstilo()],
        height: 400,
        chartArea: { left: 0, top: 0, width: '100%', height: '75%' },
        enableInteractivity: 'false',
        backgroundColor: 'none',
        explorer: { axis: 'horizontal', keepInBounds: true }
      }
      return this.chartOptions
    },
    opcionesSombra() {
      this.chartOptions1 = {
        legend: { position: 'none' },
        bar: { groupWidth: "25%" },
        vAxis: { gridlines: { count: 0, color: 'transparent' }, textStyle: { fontSize: 1 }, viewWindow: 'maximized', baselineColor: 'transparent' },
        hAxis: { textPosition: 'none', viewWindow: 'maximized' },
        width: this.opciones[this.condicionEstilo()],
        height: 400,
        chartArea: { left: 0, top: 0, width: '100%', height: '75%' },
        enableInteractivity: 'false',
        backgroundColor: 'none',
        dataOpacity: 0.5,
      }
      return this.chartOptions1
    },
    condicionEstilo() {
      if (this.info != null) {
        return (this.info.length > 2) ? 1 : 0
      }
    }
  },
  filters: {
    currencydecimal(value) {
      return value.toFixed(2)
    }
  },
}
</script>

<style scoped>
.desplazamiento {
  margin-top: 20px;
  align-items: center;
  justify-content: center;
  position: absolute;
  display: flex;
}

.desplazamiento1 {
  margin-top: 70px;
  align-items: center;
  justify-content: center;
  position: absolute;
  display: flex;
}

.loader00 {
  background-color: rgba(255, 255, 255, 0.0);
  border-color: white;

  overflow-x: hidden;
  overflow-y: hidden;

  width: 1500px;
  height: 700px;

  width: 100%;
  height: 100%;

  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}

.loader10 {
  background-color: rgba(255, 255, 255, 0.0);
  border-color: white;

  overflow-x: scroll;
  overflow-y: hidden;

  width: 1500px;
  height: 700px;

  width: 100%;
  height: 100%;

  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}

.loader01 {
  z-index: 1;
  margin-top: 200px;
  margin-left: 0px;
  width: 100%;
  height: 100%;
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}

.loader11 {
  z-index: 1;
  margin-top: 200px;
  margin-left: 200px;
  width: 100%;
  height: 100%;
  position: absolute;
  display: flex;
  align-items: center;
}

.loader02 {
  z-index: 0;
  margin-top: 215px;
  margin-left: 10px;
  width: 100%;
  height: 100%;
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}

.loader12 {
  z-index: 0;
  margin-top: 215px;
  margin-left: 210px;
  width: 100%;
  height: 100%;
  position: absolute;
  display: flex;
  align-items: center;
}

.img_presidente0 {
  margin-top: 450px;
  width: 100%;
  height: 100%;
  margin-left: -480px;
  z-index: 1;
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}

.img_presidente1 {
  margin-top: 450px;
  margin-left: -170px;
  width: 100%;
  z-index: 1;
  position: absolute;
  display: flex;
  align-items: center;
}

.img_partido0 {
  margin-top: -350px;
  width: 100%;
  height: 100%;
  margin-left: -250px;
  z-index: 1;
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}

.img_partido1 {
  margin-top: -350px;
  width: 100%;
  height: 100%;
  margin-left: 20px;
  z-index: 1;
  position: absolute;
  display: flex;
  align-items: center;
}

.txt0 {
  margin-top: 570px;
  width: 100%;
  height: 100%;
  margin-left: -280px;
  z-index: 1;
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
}

.txt1 {
  margin-top: 570px;
  width: 100%;
  height: 100%;
  margin-left: 0 px;
  z-index: 1;
  position: absolute;
  display: flex;
  align-items: center;
}

.espaciado_img_presidente0 {
  margin-left: 250px;
}

.espaciado_img_presidente1 {
  margin-left: 167px;
}

.espaciado_partido0 {
  margin-left: 255px;
}

.espaciado_partido1 {
  margin-left: 192px;
}

.espaciado_txt0 {
  margin-left: 290px;
}

.espaciado_txt1 {
  margin-left: 199px;
}

.altura_0 {
  margin-top: 600px;
}

.altura_1 {
  margin-top: 550px;
}

.altura_2 {
  margin-top: 500px;
}

.altura_3 {
  margin-top: 445px;
}

.altura_4 {
  margin-top: 375px;
}

.altura_5 {
  margin-top: 315px;
}

.altura_6 {
  margin-top: 260px;
}

.altura_7 {
  margin-top: 205px;
}

.altura_8 {
  margin-top: 135px;
}

.altura_9 {
  margin-top: 75px;
}

.altura_10 {
  margin-top: 40px;
}
</style>