<template>
    <div class="hello" ref="chartdiv">
    </div>
</template>
  

<script>
import * as am4core from "@amcharts/amcharts4/core";
import * as am4maps from "@amcharts/amcharts4/maps";

import am4themes_animated from "@amcharts/amcharts4/themes/animated";

am4core.useTheme(am4themes_animated);

export default {
    name: 'CodMapaExtranjero',

    props: { id_1: [], nvuelta: String },

    methods: {
    },

    mounted() {


        // Create map instance
        var chart = am4core.create(this.$refs.chartdiv, am4maps.MapChart);
        // Set projection
        chart.projection = new am4maps.projections.Miller();
        //adicion del controlador del zoom
        chart.zoomControl = new am4maps.ZoomControl();

        // Pais series - Se carga el mapa de Ecuador
        var pais = chart.series.push(new am4maps.MapPolygonSeries());
        // Make map load polygon data (provincias y los nombres) from GeoJSON
        pais.useGeodata = true;

        //Variable Globales
        var cv = this.id_1[0] == "" ? "1raVuelta" : this.id_1[0];
        var cd = this.id_1[1] == "" ? "General" : this.id_1[1];
        //var cm = this.id_1[2] == "" ? 0 : this.id_1[2];
        //var cm2 = this.id_1[3] == "" ? 0 : this.id_1[3];
        console.log("vuelta:" + cv + " candidato:" + cd)
        //console.log("provincia:" + cm + " canton:" + cm2)
        var min = "";
        var max = "";

        //Colores
        switch (cd) {
            case "1":
                min = "#bdd7e7";
                max = "#08519c";
                break;
            case "2":
                min = "#fdbe85";
                max = "#a63603";
                break;
            case "3":
                min = "#cbaada";
                max = "#7D3C98";
                break;
            case "4":
                min = "#fcdabc";
                max = "#e69237";
                break;
            case "5":
                min = "#B1E1E7";
                max = "#35A0AC";
                break;
            case "6":
                min = "#f8bbd0";
                max = "#e91e63";
                break;
            case "7":
                min = "#F5B7B1";
                max = "#E74C3C";
                break;
            case "8":
                min = "#bdbdbd";
                max = "#4a4a4a";
                break;
            case "9":
                min = "#A4DFBF";
                max = "#229954";
                break;
            case "10":
                min = "#c7b69f";
                max = "#553d2a";
                break;
            case "11":
                min = "#f9e79f";
                max = "#D4AC0D";
                break;
            case "12":
                min = "#b4e4f9"
                max = "#1097D1";
                break;
            case "13":
                min = "#ffc9c2";
                max = "#e37469";
                break;
            case "14":
                min = "#fcf099";
                max = "#8f6e0f";
                break;
            case "15":
                min = "#cbe5f6";
                max = "#3498db";
                break;
            case "16":
                min = "#DFA4CB";
                max = "#b5408c";
                break;
        }

        // Se configura la información que va a aparecer al poner encima el mouse
        var paisPolygon = pais.mapPolygons.template;
        paisPolygon.nonScalingStroke = true;
        // Linea que divide las provincias
        paisPolygon.strokeWidth = 1.5;
        //Pinta de distinto color la provincia al poner el mouse encima
        var hs = paisPolygon.states.create("hover");
        hs.properties.fill = am4core.color("#f23a7a");

        //console.log("adentro pais");
        pais.geodataSource.url = "mapa/Regiones/world.json";
        pais.dataSource.url = "Datos/" + cv + "/" + cd + "/Regiones/world.json";
        pais.data = pais.dataSource.url;
        pais.dataSource.load();
        pais.reverseGeodata = true;
        console.log("Datos Pais: " + pais.data);

        pais.dataSource.events.on("parseended", function (ev) {
            // parsed data is assigned to data source's `data` property
            var data = ev.target.data;
            for (var i = 0; i < data.length; i++) {
                if (cd == "General") {
                    paisPolygon.propertyFields.fill = "fill";
                    paisPolygon.tooltipText = "[bold]{name}[/] {votos} {aux}\n [bold]{candidato1}[/] {votos1} {aux} {porcentaje1} \n [bold]{candidato2}[/] {votos2} {aux} {porcentaje2}";

                } else {
                    paisPolygon.tooltipText = "[bold]{name}[/] \n [bold]{candidato}[/] \n {votos} {aux} ";

                    console.log(min, max);
                    //Asigna colores para el mapa de calor
                    pais.heatRules.push({
                        "property": "fill",
                        "target": pais.mapPolygons.template,
                        "min": am4core.color(min),
                        "max": am4core.color(max),
                        "logarithmic": true
                    });
                    //paisPolygon.tooltipText = "[bold]{id} {name}[/] {votos} {aux}\n [bold]{candidato1}[/] {votos1} {aux} {porcentaje1} \n [bold]{candidato2}[/] {votos2} {aux} {porcentaje2}";
                }
            }
        });


        // Menu para exportar los mapas en imágenes y png 
        chart.exporting.menu = new am4core.ExportMenu();
        // Posición del botón
        chart.exporting.align = "right";
        chart.exporting.menu.items[0].icon = "download.svg"
        console.log("Adentro pais")
        chart.exporting.filePrefix = "Ecuador";
        chart.exporting.adapter.add("data", function (data) {
            data.data = [];
            for (var i = 0; i < pais.data.length; i++) {
                var row = pais.data[i];
                if (cd == "General") {
                    data.data.push({
                        "Pais": row.name,
                        "Total de Votos": row.votos,
                        "Candidato 1": row.candidato1,
                        "Votos Candidato 1": row.votos1,
                        "Candidato 2": row.candidato2,
                        "Votos Candidato 2": row.votos2,
                    });
                }
                else {
                    data.data.push({
                        "Pais": row.name,
                        "Candidato": row.candidato,
                        "Votos Candidato": row.votos,
                        "Porcentaje": row.value,
                    });
                }
            }
            return data;
        });


        // Se agrega el botón para regresar al mapa del Ecuador
        var back = new am4core.Button();
        back.events.on("hit", function () {
            chart.goHome();
        });
        back.icon = new am4core.Sprite();
        back.padding(7, 5, 7, 5);
        back.width = 30;
        back.icon.path =
            "M16,8 L14,8 L14,16 L10,16 L10,10 L6,10 L6,16 L2,16 L2,8 L0,8 L8,0 L16,8 Z M16,8";
        back.marginBottom = 8;
        back.parent = chart.zoomControl;
        back.insertBefore(chart.zoomControl.plusButton);
        //Al dar click muestra el mapa del Ecuador y esconde los mapas de provincia y cantón
        back.events.on("hit", function () {
            pais.show();
            chart.goHome();
        });
    }

}

</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello {
    width: 100%;
    height: 500px;

}
</style>