<template>
    <div class="chartdiv" ref="chartdiv">
</div>
</template>


<script>


import * as am4core from "@amcharts/amcharts4/core";
import * as am4maps from "@amcharts/amcharts4/maps";

import am4themes_animated from "@amcharts/amcharts4/themes/animated";

am4core.useTheme(am4themes_animated);

export default {
    name: 'CodMapa',

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
        var cm = this.id_1[2] == "" ? 0 : this.id_1[2];
        var cm2 = this.id_1[3] == "" ? 0 : this.id_1[3];
        console.log("vuelta:" + cv + " candidato:" + cd)
        console.log("provincia:" + cm + " canton:" + cm2)
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

        function goHome() {
            cm = 0;
            cm2 = 0;
            console.log("adentro pais");
            pais.geodataSource.url = "mapa/" + cm + "/" + cm2 + ".json";
            pais.dataSource.url = "Datos/" + cv + "/" + cd + "/" + cm + "/" + cm2 + ".json";
            //pais.data = pais.dataSource.url;
            pais.dataSource.load();
            pais.reverseGeodata = true;
            console.log("Datos Pais: " + pais.data);

            pais.dataSource.events.on("parseended", function (ev) {
                // parsed data is assigned to data source's `data` property
                var data = ev.target.data;
                for (var i = 0; i < data.length; i++) {
                    if (cd == "General") {
                        paisPolygon.propertyFields.fill = "fill";
                        paisPolygon.tooltipText = "[bold] {id} {PROVINCIA}[/] {votos} votos\n [bold]{candidato1}[/] {votos1} votos ({porcentaje1}%) \n [bold]{candidato2}[/] {votos2} votos ({porcentaje2}%)";
                    } else {
                        console.log(min, max);
                        //Asigna colores para el mapa de calor
                        pais.heatRules.push({
                            "property": "fill",
                            "target": pais.mapPolygons.template,
                            "min": am4core.color(min),
                            "max": am4core.color(max),
                            "logarithmic": true
                        });
                        paisPolygon.tooltipText = "[bold] {id} {PROVINCIA}[/] \n [bold]{candidato}[/] \n {votos} votos ({value}%) ";
                    }
                }
            });

            console.log("Adentro pais")
            chart.exporting.filePrefix = "Ecuador";
            chart.exporting.adapter.add("data", function (data) {
                data.data = [];
                for (var i = 0; i < pais.data.length; i++) {
                    var row = pais.data[i];
                    if (cd == "General") {
                        data.data.push({
                            "Id": row.id,
                            "Provincia": row.PROVINCIA,
                            "Total de Votos": row.votos,
                            "Candidato 1": row.candidato1,
                            "Votos Candidato 1": row.votos1,
                            "Candidato 2": row.candidato2,
                            "Votos Candidato 2": row.votos2,
                        });
                    }
                    else {
                        data.data.push({
                            "Id": row.id,
                            "Provincia": row.PROVINCIA,
                            "Candidato": row.candidato,
                            "Votos Candidato": row.votos,
                            "Porcentaje": row.value,
                        });
                    }
                }
                return data;
            });
        }

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
            console.log("on");
            chart.goHome();
            goHome();
            pais.geodataSource.load();
            pais.show();
            provincia.hide();
            canton.hide();

        });
        //Lee el archivo al reves para que se caraguen los mapas correctamente
        //pais.reverseGeodata = true;
        // Se configura la información que va a aparecer al poner encima el mouse
        var paisPolygon = pais.mapPolygons.template;

        paisPolygon.nonScalingStroke = true;
        // Linea que divide las provincias
        paisPolygon.strokeWidth = 1.5;

        //Pinta de distinto color la provincia al poner el mouse encima
        var hs = paisPolygon.states.create("hover");
        hs.properties.fill = am4core.color("#f23a7a");

        // Cantones series - Se configura los mapas de las provincias
        var provincia = chart.series.push(new am4maps.MapPolygonSeries());
        provincia.useGeodata = true;
        provincia.hide();
        // Esconde el mapa del Ecuador y muestra el mapa de las provincias
        provincia.geodataSource.events.on("done", function () {
            pais.hide();
            provincia.show();
        });

        // Se configura la información que va a aparecer al poner encima el mouse
        var provinciaPolygon = provincia.mapPolygons.template;
        // Linea que divide las provincias
        provinciaPolygon.strokeWidth = 1.5;

        //Pinta de distinto color el cantón al poner el mouse encima
        var hs2 = provinciaPolygon.states.create("hover");
        hs2.properties.fill = am4core.color("#367B25");

        // cantons series
        var canton = chart.series.push(new am4maps.MapPolygonSeries());
        canton.useGeodata = true;
        canton.hide();
        //Carga los cantones y esconde el mapa de las provincias
        canton.geodataSource.events.on("done", function () {
            //pais.hide();
            provincia.hide();
            canton.show();
        });

        // Se configura la información que va a aparecer al poner encima el mouse
        var cantonPolygon = canton.mapPolygons.template;
        // Linea que divide las provincias
        paisPolygon.strokeWidth = 1.5;
        //Pinta de distinto color la parroquia al poner el mouse encima
        var hs3 = cantonPolygon.states.create("hover");
        hs3.properties.fill = am4core.color("#367B25");

        // Menu para exportar los mapas en imágenes y png 
        chart.exporting.menu = new am4core.ExportMenu();
        // Posición del botón
        chart.exporting.align = "right";
        chart.exporting.menu.items[0].icon = "download.svg"

        //Carga datos
        var prov = 0;

        if (cm == cm2 && cm != 0) {
            console.log("adentro provincia");
            provincia.geodataSource.url = "mapa/" + cm + "/" + cm2 + ".json";
            provincia.dataSource.url = "Datos/" + cv + "/" + cd + "/" + cm + "/" + cm2 + ".json";
            provincia.data = provincia.dataSource.url;
            provincia.dataSource.load();
            provincia.reverseGeodata = true;
            prov = cm;
            console.log("Datos Provincia: " + provincia.data);
            provincia.dataSource.events.on("parseended", function (ev) {
                // parsed data is assigned to data source's `data` property
                var data = ev.target.data;
                //var datos = ev.target.data;
                for (var i = 0; i < data.length; i++) {
                    //console.log("Datos: " + data[i].id);
                    //console.log("Datos Clone: " + datos[i].id);

                    if (cd == "General") {
                        provinciaPolygon.propertyFields.fill = "fill";
                        provinciaPolygon.tooltipText = "[bold] {id} {DPA_DESCAN}[/] {votos} votos\n [bold]{candidato1}[/] {votos1} votos ({porcentaje1}%) \n [bold]{candidato2}[/] {votos2} votos ({porcentaje2}%)";
                    } else {
                        //Asigna colores para el mapa de calor
                        provincia.heatRules.push({
                            "property": "fill",
                            "target": provincia.mapPolygons.template,
                            "min": am4core.color(min),
                            "max": am4core.color(max),
                            "logarithmic": true
                        });
                        provinciaPolygon.tooltipText = "[bold] {id} {DPA_DESCAN}[/] \n [bold]{candidato}[/] \n {votos} votos ({value}%) ";
                    }
                }
            });
            chart.exporting.filePrefix = "Provincia";
            chart.exporting.adapter.add("data", function (data) {
                data.data = [];
                for (var i = 0; i < provincia.data.length; i++) {
                    var row = provincia.data[i];
                    if (cd == "General") {
                        data.data.push({
                            "Id Canton": row.id,
                            "Canton": row.DPA_DESCAN,
                            "Total de Votos": row.votos,
                            "Candidato 1": row.candidato1,
                            "Votos Candidato 1": row.votos1,
                            "Candidato 2": row.candidato2,
                            "Votos Candidato 2": row.votos2,
                        });
                    }
                    else {
                        data.data.push({
                            "Id Canton": row.id,
                            "Canton": row.DPA_DESCAN,
                            "Candidato": row.candidato,
                            "Votos Candidato": row.votos,
                            "Porcentaje": row.value,
                        });
                    }
                }
                return data;
            });

        } else if (cm == 0 && cm2 == 0) {
            console.log("adentro pais");
            pais.geodataSource.url = "mapa/" + cm + "/" + cm2 + ".json";
            pais.dataSource.url = "Datos/" + cv + "/" + cd + "/" + cm + "/" + cm2 + ".json";
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
                        paisPolygon.tooltipText = "[bold] {id} {PROVINCIA}[/] {votos} votos\n [bold]{candidato1}[/] {votos1} votos ({porcentaje1}%) \n [bold]{candidato2}[/] {votos2} votos ({porcentaje2}%)";
                    } else {
                        console.log(min, max);
                        //Asigna colores para el mapa de calor
                        pais.heatRules.push({
                            "property": "fill",
                            "target": pais.mapPolygons.template,
                            "min": am4core.color(min),
                            "max": am4core.color(max),
                            "logarithmic": true
                        });
                        paisPolygon.tooltipText = "[bold] {id} {PROVINCIA}[/] \n [bold]{candidato}[/] \n {votos} votos ({value}%) ";
                    }
                }
            });

            console.log("Adentro pais")
            chart.exporting.filePrefix = "Ecuador";
            chart.exporting.adapter.add("data", function (data) {
                data.data = [];
                for (var i = 0; i < pais.data.length; i++) {
                    var row = pais.data[i];
                    if (cd == "General") {
                        data.data.push({
                            "Id Provincia": row.id,
                            "Provincia": row.PROVINCIA,
                            "Total de Votos": row.votos,
                            "Candidato 1": row.candidato1,
                            "Votos Candidato 1": row.votos1,
                            "Candidato 2": row.candidato2,
                            "Votos Candidato 2": row.votos2,
                        });
                    }
                    else {
                        data.data.push({
                            "Id Provincia": row.id,
                            "Provincia": row.PROVINCIA,
                            "Candidato": row.candidato,
                            "Votos Candidato": row.votos,
                            "Porcentaje": row.value,
                        });
                    }
                }
                return data;
            });

        } else if (cm != cm2) {
            //dataName = "Ecuador";
            console.log("adentro canton");
            canton.geodataSource.url = "mapa/" + cm + "/" + cm2 + ".json";
            canton.dataSource.url = "Datos/" + cv + "/" + cd + "/" + cm + "/" + cm2 + ".json";
            canton.data = canton.dataSource.url;
            canton.dataSource.load();
            canton.reverseGeodata = true;
            prov = cm;
            console.log("Datos Canton: " + canton.data);
            canton.dataSource.events.on("parseended", function (ev) {
                // parsed data is assigned to data source's `data` property
                var data = ev.target.data;
                //var datos = ev.target.data;
                for (var i = 0; i < data.length; i++) {
                    if (cd == "General") {
                        cantonPolygon.propertyFields.fill = "fill";
                        cantonPolygon.tooltipText = "[bold] {id} {parroquia}[/] {votos} votos\n [bold]{candidato1}[/] {votos1} votos ({porcentaje1}%) \n [bold]{candidato2}[/] {votos2} votos ({porcentaje2}%)";
                    } else {
                        //Asigna colores para el mapa de calor
                        canton.heatRules.push({
                            "property": "fill",
                            "target": canton.mapPolygons.template,
                            "min": am4core.color(min),
                            "max": am4core.color(max),
                            "logarithmic": true
                        });
                        cantonPolygon.tooltipText = "[bold] {id} {parroquia}[/] \n [bold]{candidato}[/] \n {votos} votos ({value}%) ";
                    }
                }
            });
            chart.exporting.filePrefix = "Canton";
            chart.exporting.adapter.add("data", function (data) {
                data.data = [];
                for (var i = 0; i < canton.data.length; i++) {
                    var row = canton.data[i];
                    if (cd == "General") {
                        data.data.push({
                            "Id Parroquia": row.id,
                            "Parroquia2": row.DPA_DESPAR,
                            "Parroquia": row.parroquia,
                            "Total de Votos": row.votos,
                            "Candidato 1": row.candidato1,
                            "Votos Candidato 1": row.votos1,
                            "Candidato 2": row.candidato2,
                            "Votos Candidato 2": row.votos2,
                        });
                    }
                    else {
                        data.data.push({
                            "Id Parroquia": row.id,
                            "Parroquia2": row.DPA_DESPAR,
                            "Parroquia": row.parroquia,
                            "Candidato": row.candidato,
                            "Votos Candidato": row.votos,
                            "Porcentaje": row.value,
                        });
                    }
                }
                return data;
            });

        }

        //Eventos al dar click con el mouse (País)
        paisPolygon.events.on("hit", function (ev) {

            //Zoom a la provincia al dar click
            ev.target.series.chart.zoomToMapObject(ev.target);

            /* Transición del mapa del Ecuador a los mapas de provincia
                  Obtiene el id de la provincia a la que da click y carga el 
                  GeoJSON de la provincia
            */

            //funcion retorno de las provincias
            function devuelta() {
                return (x = ev.target.dataItem.dataContext.id);
            }
            function devuelta2() {
                return (y = ev.target.dataItem.dataContext.id);
            }
            //creacion de las varibles globales
            if (cm == 0) {
                prov = devuelta();
            } else {
                prov = cm;
            }
            console.log("provincia:" + cm + " canton:" + cm2)
            console.log("prov " + prov);
            var x = ["mapa/" + prov + "/" + devuelta() + ".json"];
            var y = ["Datos/" + cv + "/" + cd + "/" + prov + "/" + devuelta2() + ".json"];
            var aux = y.toString();
            var str = x.toString();

            if (ev.target.dataItem.dataContext.id == devuelta()) {
                ev.target.isHover = true;
                //Carga el GeoJSON de la provincia
                provincia.geodataSource.url = str;
                provincia.dataSource.url = aux;
                //provincia.data = provincia.dataSource.url;
                console.log("click: " + provincia.dataSource.url);

                provincia.dataSource.events.on("parseended", function (ev) {
                    // parsed data is assigned to data source's `data` property
                    var data = ev.target.data;
                    for (var i = 0; i < data.length; i++) {
                        if (cd == "General") {
                            provinciaPolygon.propertyFields.fill = "fill";
                            provinciaPolygon.tooltipText = "[bold] {id} {DPA_DESCAN}[/] {votos} votos\n [bold]{candidato1}[/] {votos1} votos ({porcentaje1}%) \n [bold]{candidato2}[/] {votos2} votos ({porcentaje2}%)";
                        } else {
                            console.log(min, max);
                            //Asigna colores para el mapa de calor
                            provincia.heatRules.push({
                                "property": "fill",
                                "target": provincia.mapPolygons.template,
                                "min": am4core.color(min),
                                "max": am4core.color(max),
                                "logarithmic": true
                            });
                            provinciaPolygon.tooltipText = "[bold] {id} {DPA_DESCAN}[/] \n [bold]{candidato}[/] \n {votos} votos ({value}%) ";
                        }
                    }
                });

                provincia.geodataSource.load();
                provincia.dataSource.load();
                provincia.reverseGeodata = true;

                chart.exporting.filePrefix = "Provincia";
                chart.exporting.adapter.add("data", function (data) {
                    data.data = [];
                    for (var i = 0; i < provincia.data.length; i++) {
                        console.log("Adentro provincia");
                        var row = provincia.data[i];
                        if (cd == "General") {
                            data.data.push({
                                "Id Canton": row.id,
                                "Canton": row.DPA_DESCAN,
                                "Total de Votos": row.votos,
                                "Candidato 1": row.candidato1,
                                "Votos Candidato 1": row.votos1,
                                "Candidato 2": row.candidato2,
                                "Votos Candidato 2": row.votos2,
                            });
                        }
                        else {
                            data.data.push({
                                "Id Canton": row.id,
                                "Canton": row.DPA_DESCAN,
                                "Candidato": row.candidato,
                                "Votos Candidato": row.votos,
                                "Porcentaje": row.value,
                            });
                        }
                    }
                    return data;
                });
            }

        });

        //Eventos al dar click con el mouse (Provincias)
        provinciaPolygon.events.on("hit", function (ev) {
            //Zoom al cantón al dar click
            ev.target.series.chart.zoomToMapObject(ev.target);
            /* Transición del mapa de la provincia a los mapas del cantón
                  Obtiene el id del cantón a la que da click y carga el 
                  GeoJSON del cantón
            */
            function devuelta() {
                return (x = ev.target.dataItem.dataContext.id);
            }
            function devuelta2() {
                return (y = ev.target.dataItem.dataContext.id);
            }

            //creacion de las varibles globales
            var x = ["mapa/" + prov + "/" + devuelta() + ".json"];
            //var cd = "General"
            var y = ["Datos/" + cv + "/" + cd + "/" + prov + "/" + devuelta2() + ".json"];
            var aux = y.toString();
            var str = x.toString();

            if (ev.target.dataItem.dataContext.id == devuelta()) {
                ev.target.isHover = true;
                //Carga el GeoJSON del canton
                canton.geodataSource.url = str;
                canton.dataSource.url = aux;
                console.log("click canton: " + canton.geodataSource.url);

                canton.dataSource.events.on("parseended", function (ev) {
                    // parsed data is assigned to data source's `data` property
                    var data = ev.target.data;
                    for (var i = 0; i < data.length; i++) {
                        //console.log(cd);
                        if (cd == "General") {
                            cantonPolygon.propertyFields.fill = "fill";
                            cantonPolygon.tooltipText = "[bold] {id} {parroquia}[/] {votos} votos\n [bold]{candidato1}[/] {votos1} votos ({porcentaje1}%) \n [bold]{candidato2}[/] {votos2} votos ({porcentaje2}%)";
                        } else {
                            //Asigna colores para el mapa de calor
                            canton.heatRules.push({
                                "property": "fill",
                                "target": canton.mapPolygons.template,
                                "min": am4core.color(min),
                                "max": am4core.color(max),
                                "logarithmic": true
                            });
                            cantonPolygon.tooltipText = "[bold] {id} {parroquia}[/] \n [bold]{candidato}[/] \n {votos} votos ({value}%) ";
                        }
                    }
                });

                canton.geodataSource.load();
                canton.dataSource.load();
                canton.reverseGeodata = true;

                chart.exporting.filePrefix = "Canton";
                chart.exporting.adapter.add("data", function (data) {
                    data.data = [];
                    for (var i = 0; i < canton.data.length; i++) {
                        var row = canton.data[i];
                        if (cd == "General") {
                            data.data.push({

                                "Id Parroquia": row.id,
                                "Parroquia": row.parroquia,
                                "Parroquia2": row.DPA_DESPAR,
                                "Total de Votos": row.votos,
                                "Candidato 1": row.candidato1,
                                "Votos Candidato 1": row.votos1,
                                "Candidato 2": row.candidato2,
                                "Votos Candidato 2": row.votos2,
                            });
                        }
                        else {
                            data.data.push({
                                "Id Parroquia": row.id,
                                "Parroquia": row.parroquia,
                                "Parroquia2": row.DPA_DESPAR,
                                "Candidato": row.candidato,
                                "Votos Candidato": row.votos,
                                "Porcentaje": row.value,
                            });
                        }
                    }
                    return data;
                });
            }

        });

    }

}

</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.chartdiv {
    width: 100%;
    height: 500px;

}
</style>