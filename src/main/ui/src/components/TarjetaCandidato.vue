<template>
    <div>
        <!--Tarjeta Desplegable-->
        <v-select v-model="enabled" :items="slots" color="#FFF" class="elevation-6 partido" label="Partido Político"
            clearable></v-select>


        <v-data-table :items="itemsArray" hide-default-footer item-key="id"
            class="TarjetaColores">

            <template v-slot:body="{ items }">
                <v-layout column style="height: 400px">
                    <v-flex style="overflow: auto">
                        <div v-if="isEnabled('Resultados Generales')">
                            <div class="tablaGeneral1">
                                <tbody>
                                    <tr v-for="item in itemsCandidato" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartidoNombre" :style="{ background: item.color }"></div>
                                        </td>
                                        <td>
                                            <div class="espacioPartidoNombre">{{ item.nombrePartido }}</div>
                                        </td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Alianza Creo 21 Psc 6')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[0].partido" :src="itemsCandidato[0].url"
                                        :alt="itemsCandidato[0].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[0].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p1 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('1-5 Unión Por La Esperanza')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[1].partido" :src="itemsCandidato[1].url"
                                        :alt="itemsCandidato[1].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[1].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p2 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Movimiento De Unidad Plurinacional Pachakutik')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[2].partido" :src="itemsCandidato[2].url"
                                        :alt="itemsCandidato[2].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[2].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p3 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Partido Izquierda Democrática')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[3].partido" :src="itemsCandidato[3].url"
                                        :alt="itemsCandidato[3].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[3].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p4 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Movimiento Amigo')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[4].partido" :src="itemsCandidato[4].url"
                                        :alt="itemsCandidato[4].nombre" />
                                    <div class="nombreCandidato"> {{ itemsCandidato[4].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p5 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Partido Político Avanza')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[5].partido" :src="itemsCandidato[5].url"
                                        :alt="itemsCandidato[5].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[5].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p6 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Partido Sociedad Patriótica 21 De Enero')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[6].partido" :src="itemsCandidato[6].url"
                                        :alt="itemsCandidato[6].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[6].nombre }} </div>
                                </div>
                            </div>

                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p7 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Movimiento Ecuatoriano Unido')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[7].partido" :src="itemsCandidato[7].url"
                                        :alt="itemsCandidato[7].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[7].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p8 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Movimiento Alianza País')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[8].partido" :src="itemsCandidato[8].url"
                                        :alt="itemsCandidato[8].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[8].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p9 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Partido Político Sociedad Unida Más Acción')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[9].partido" :src="itemsCandidato[9].url"
                                        :alt="itemsCandidato[9].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[9].nombre }} </div>
                                </div>

                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p10 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Movimiento Construye')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[10].partido" :src="itemsCandidato[10].url"
                                        :alt="itemsCandidato[10].nombre" />
                                    <div class="nombreCandidato">{{ itemsCandidato[10].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p11 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Alianza Honestidad')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[11].partido" :src="itemsCandidato[11].url"
                                        :alt="itemsCandidato[11].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[11].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p12 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Movimiento Democracia Sí')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[12].partido" :src="itemsCandidato[12].url"
                                        :alt="itemsCandidato[12].nombre" />
                                    <div class="nombreCandidato">{{ itemsCandidato[12].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p13 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Partido Fuerza Ec')">
                            <div class="InfoCandidato">
                                <div></div>
                                <div>
                                    <img class="img" :key="itemsCandidato[13].partido" :src="itemsCandidato[13].url"
                                        :alt="itemsCandidato[13].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[13].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p14 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Unión Ecuatoriana')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[14].partido" :src="itemsCandidato[14].url"
                                        :alt="itemsCandidato[14].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[14].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p15 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                        <div v-if="isEnabled('Movimiento Nacional Podemos')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[15].partido" :src="itemsCandidato[15].url"
                                        :alt="itemsCandidato[15].nombre" />
                                    <div class="nombreCandidato">
                                        {{ itemsCandidato[15].nombre }} </div>
                                </div>
                            </div>
                            <div class="tablaColores">
                                <tbody>
                                    <tr v-for="item in items" :key="item.name">
                                        <td> <!--{{ Colores }}-->
                                            <div class="colorPartido" :style="{ background: item.p16 }"></div>
                                        </td>
                                        <td class="porcentaje">{{ item.porcentaje }}</td>
                                    </tr>
                                </tbody>
                            </div>
                        </div>
                    </v-flex>
                </v-layout>
            </template>

        </v-data-table>
    </div>

</template>

<script>

const desserts = [
    {porcentaje: '0% - 25%', p1: '#bdd7e7', p2: '#fdbe85', p3: '#cbaada', p4: '#fcdabc', p5: '#B1E1E7', p6: '#f8bbd0', p7: '#F5B7B1', p8: '#bdbdbd', p9: '#A4DFBF', p10: '#c7b69f', p11: '#f9e79f', p12: '#b4e4f9',p13: '#ffc9c2', p14: '#fcf099', p15: '#cbe5f6', p16: '#DFA4CB'},
    {porcentaje: '26% - 50%', p1: '#6baed6', p2: '#fd8d3c', p3: '#A569BD', p4: '#f8c89c', p5: '#64C3CE', p6: '#f48fb1', p7: '#F1948A', p8: '#8c8c8c', p9: '#7DCEA0', p10: '#907761', p11: '#F4D03F', p12: '#54C3F2', p13: '#fb887d', p14: '#f3d367', p15: '#85c1e9', p16: '#CF77B0'},
    {porcentaje: '51% - 75%', p1: '#3182bd', p2: '#e6550d', p3: '#8E44AD', p4: '#f2b77c', p5: '#40b6c4', p6: '#f06292', p7: '#EC7063', p8: '#5f5f5f', p9: '#52BE80', p10: '#7e634e',p11: '#F1C40F', p12: '#27B4EF', p13: '#ef7e73', p14: '#c29b2b', p15: '#5dade2', p16: '#c5599f'},
    {porcentaje: '76% - 100%', p1: '#08519c', p2: '#a63603', p3: '#7D3C98', p4: '#e69237', p5: '#35A0AC', p6: '#e91e63', p7: '#E74C3C', p8: '#4a4a4a', p9: '#229954', p10: '#553d2a', p11: '#D4AC0D', p12: '#1097D1', p13: '#e37469', p14: '#8f6e0f', p15: '#3498db', p16: '#b5408c'}
]


const candidato = [
    { partido: 1, nombre: 'GUILLERMO LASSO', url: require('@/assets/Candidatos/150px/1.png'), color: '#045A8D', nombrePartido: 'Alianza Creo 21 Psc 6', json: '1' },
    { partido: 2, nombre: 'ANDRES ARAUZ', url: require('@/assets/Candidatos/150px/2.png'), color: '#EF8A62', nombrePartido: '1-5 Unión Por La Esperanza', json: '2' },
    { partido: 3, nombre: 'YAKU PEREZ', url: require('@/assets/Candidatos/150px/3.png'), color: '#54278f', nombrePartido: 'Movimiento De Unidad Plurinacional Pachakutik', json: '3' },
    { partido: 4, nombre: 'XAVIER HERVAS', url: require('@/assets/Candidatos/150px/14.png'), color: '#fcbd00', nombrePartido: 'Partido Izquierda Democrática', json: '4' },
    { partido: 5, nombre: 'PEDRO JOSE FREILE', url: require('@/assets/Candidatos/150px/13.png'), color: '#41b6c4', nombrePartido: 'Movimiento Amigo', json: '5' },
    { partido: 6, nombre: 'ISIDRO ROMERO', url: require('@/assets/Candidatos/150px/9.png'), color: '#d81b60', nombrePartido: 'Partido Político Avanza', json: '6' },
    { partido: 7, nombre: 'LUCIO GUTIERREZ', url: require('@/assets/Candidatos/150px/11.png'), color: '#cb4335', nombrePartido: 'Partido Sociedad Patriótica 21 De Enero', json: '7' },
    { partido: 8, nombre: 'GERSON ALMEIDA', url: require('@/assets/Candidatos/150px/4.png'), color: '#808080', nombrePartido: 'Movimiento Ecuatoriano Unido', json: '8' },
    { partido: 9, nombre: 'XIMENA PEÑA', url: require('@/assets/Candidatos/150px/15.png'), color: '#239b56', nombrePartido: 'Movimiento Alianza País', json: '9' },
    { partido: 10, nombre: 'GUILLERMO CELI', url: require('@/assets/Candidatos/150px/7.png'), color: '#553d2a', nombrePartido: 'Partido Político Sociedad Unida Más Acción', json: '10' },
    { partido: 11, nombre: 'JUAN FERNANDO VELASCO', url: require('@/assets/Candidatos/150px/10.png'), color: '#d4ac0d', nombrePartido: 'Movimiento Construye', json: '11' },
    { partido: 12, nombre: 'CESAR MONTUFAR', url: require('@/assets/Candidatos/150px/16.png'), color: '#006691', nombrePartido: 'Alianza Honestidad', json: '12' },
    { partido: 13, nombre: 'GUSTAVO LARREA', url: require('@/assets/Candidatos/150px/8.png'), color: '#fa8072', nombrePartido: 'Movimiento Democracia Sí', json: '13' },
    { partido: 14, nombre: 'CARLOS SAGNAY', url: require('@/assets/Candidatos/150px/6.png'), color: '#765900', nombrePartido: 'Partido Fuerza Ec', json: '14' },
    { partido: 15, nombre: 'GIOVANNY ANDRADE', url: require('@/assets/Candidatos/150px/5.png'), color: '#00ffff', nombrePartido: 'Unión Ecuatoriana', json: '15' },
    { partido: 16, nombre: 'PAUL CARRASCO', url: require('@/assets/Candidatos/150px/12.png'), color: '#cb35a3', nombrePartido: 'Movimiento Nacional Podemos', json: '16' },
]
var partidos = [
    'Resultados Generales',
    'Alianza Creo 21 Psc 6',
    '1-5 Unión Por La Esperanza',
    'Movimiento De Unidad Plurinacional Pachakutik',
    'Partido Izquierda Democrática',
    'Movimiento Amigo',
    'Partido Político Avanza',
    'Partido Sociedad Patriótica 21 De Enero',
    'Movimiento Ecuatoriano Unido',
    'Movimiento Alianza País',
    'Partido Político Sociedad Unida Más Acción',
    'Movimiento Construye',
    'Alianza Honestidad',
    'Movimiento Democracia Sí',
    'Partido Fuerza Ec',
    'Unión Ecuatoriana',
    'Movimiento Nacional Podemos',
]
export default {
    name: "TarjetaCandidato",
    props: { etiquetaTarjeta2: String },
    data: () => ({
        enabled: 'Resultados Generales',
        itemsArray: desserts,
        itemsCandidato: candidato,
        scrollInvoked: 0,
        slots: partidos,

    }),

    methods: {
        buscarJson(slot) {

            /*for(let i=0; i<candidato.length; i++){
                
                if(slot==this.itemsCandidato[i].nombrePartido ){
                    console.log("1 "+this.itemsCandidato[i].json );
                    return this.itemsCandidato[i].json;                  
                }else{
                    console.log("2");
                    return'Ec';
                }
               
            }*/

            let resultado = this.itemsCandidato.find(cand => cand.nombrePartido === slot);
            if (resultado == null) {
                resultado = 'Ec'
                console.log(" Objeto2" + resultado);
                return [];
            } else {
                console.log(" Objeto" + resultado.json);
                return resultado.json;
            }


        },
        isEnabled(slot) {
            //console.log("------------------------Label emit"+this.enabled + this.etiquetaTarjeta)            
            let aux=''
            if(this.etiquetaTarjeta2!=""){
                this.enabled=this.etiquetaTarjeta2;
                 aux = this.enabled === slot; 
            }else{
                 aux = this.enabled === slot; 
                if (aux) { this.$emit('tarjetaV1', ["1raVuelta",this.buscarJson(this.enabled),"",""]) } 
                console.log("json: " + this.buscarJson(this.enabled))
            }
            return aux

        },
        tarjetaPrimeraVuelta() {

        },
        foto() {
            this.val = this.val + 1
            return this.val
        }

    },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&family=Oswald&display=swap');

.color {
    padding: 0%;
    padding-left: 1%;
    padding-right: 10px;
}

.partido {
    padding-top: 20px;
    padding-left: 10px;
    padding-right: 10px;
    background-color: #12A2C2;
    width: 100%;
    border-radius: 4px;
}

.colorPartido {
    width: 20px;
    height: 20px;
    margin-right: 30px;
    margin-left: 10px;
    margin-bottom: 10px;
    margin-top: 10px;
}

.re {
    width: 100%;
}

.TarjetaColores {
    
    background: rgba(255, 255, 255, 0.5);
    width: 100%;
    border-radius: 4px;
}

.tablaGeneral1 {
    display: flex;
    align-items: center;
    justify-content: center;
    font-family: 'Oswald', sans-serif;
    font-size: 15px;
}

.tablaColores {
    display: flex;
    align-items: center;
    justify-content: center;
    font-family: 'Oswald', sans-serif;
    font-size: 15px;
}

.InfoCandidato {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 90%;
    margin-top: 5%;
    margin-bottom: 20px;
}

.img {
    width: 125px;
    height: 125px;
}

.nombreCandidato {
    text-align: center;
    font-family: 'Oswald', sans-serif;
    font-size: 20px;
}

.porcentaje {
    margin-bottom: 10px;
}

.espacioPartidoNombre {
    margin-right: 25px;
    margin-top: 10px;
}

.colorPartidoNombre {
    width: 20px;
    height: 20px;
    margin-right: 50px;
    margin-left: 10px;
    margin-bottom: 10px;
    margin-top: 10px;
}
</style>