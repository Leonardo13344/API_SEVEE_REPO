<template>
    <div>
        <!--Tarjeta Desplegable-->
        <v-select v-model="enabled" :items="slots" color="#FFF" class="elevation-6 partido" label="Partido Político"
            clearable></v-select>


        <v-data-table :items="itemsArray" hide-default-footer item-key="id"
            class="TarjetaColores ">

            <template v-slot:body="{ items }">
                <v-layout column style="height: 400px">
                    <v-flex style="overflow: auto">
                        <div v-if="isEnabled('Resultados Generales')">
                            <div class="InfoCandidato">
                                <div>
                                    <div v-for="item in itemsCandidato" :key="item.name">
                                        <img class="img" :src="item.url" />
                                        <div class="nombreCandidato">{{ item.nombre }}</div>
                                        <div class="Nombre">{{ item.nombrePartido }}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div v-if="isEnabled('Alianza Creo 21 Psc 6')">
                            <div class="InfoCandidato">
                                <div>
                                    <img class="img" :key="itemsCandidato[0].partido" :src="itemsCandidato[0].url"
                                        :alt="itemsCandidato[0].nombre" />
                                    <div class="nombreCandidato">{{ itemsCandidato[0].nombre }} </div>
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
                                    <div class="nombreCandidato"> {{ itemsCandidato[1].nombre }} </div>
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
                    </v-flex>
                </v-layout>
            </template>

        </v-data-table>


    </div>
</template>

<script>
const desserts = [
    { porcentaje: '0%-25%', p1: '#bdd7e7', p2: '#fdbe85', },
    { porcentaje: '26%-50%', p1: '#6baed6', p2: '#fd8d3c', },
    { porcentaje: '51%-75%', p1: '#3182bd', p2: '#e6550d', },
    { porcentaje: '76%-100%', p1: '#08519c', p2: '#a63603', },

]

const candidato = [
    { partido: 1, nombre: 'Guillermo Lasso', url: require('@/assets/Candidatos/150px/1.png'), color: '#045A8D', nombrePartido: 'Alianza Creo 21 Psc 6', json: '1' },
    { partido: 2, nombre: 'Andres Arauz', url: require('@/assets/Candidatos/150px/2.png'), color: '#EF8A62', nombrePartido: '1-5 Unión Por La Esperanza', json: '2' },
]
var partidos = [
    'Resultados Generales',
    'Alianza Creo 21 Psc 6',
    '1-5 Unión Por La Esperanza',
]
export default {
    name: "SV_TarjetaCandidato",
    props: { etiquetaTarjeta: String },
    data: () => ({
        enabled: 'Resultados Generales',
        itemsArray: desserts,
        itemsCandidato: candidato,
        scrollInvoked: 0,
        slots: partidos,
        val: 0,

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
            if(this.etiquetaTarjeta!=""){
                this.enabled=this.etiquetaTarjeta;
                 aux = this.enabled === slot; 
            }else{
                 aux = this.enabled === slot; 
                if (aux) { this.$emit('tarjeta', ["2daVuelta",this.buscarJson(this.enabled),"",""]) } 
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

.colorPartido {
    width: 20px;
    height: 20px;
    margin-right: 30px;
    margin-left: 10px;
    margin-bottom: 10px;
    margin-top: 10px;
}

.partido {

    padding-top: 20px;
    padding-left: 10px;
    padding-right: 10px;
    background-color: #12A2C2;
    width: 100%;
    border-radius: 4px;
}

.re {
    width: 100%;
}

.TarjetaColores {
    padding-top: 20px;
    padding-left: 10px;
    padding-right: 10px;
    background: rgba(255, 255, 255, 0.5);
    width: 100%;
    border-radius: 4px;


}

.tablaGeneral1 {
    align-items: center;
    margin-left: 50px;
    font-family: 'Oswald', sans-serif;
    font-size: 15px;
    margin-bottom: 20px;
    margin-top: 10PX;
}

.tablaColores {
    display: flex;
    align-items: center;
    justify-content: center;
    align-self: center;
    font-family: 'Oswald', sans-serif;
    font-size: 15px;
    margin-bottom: 20px;
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

    font-family: 'Oswald', sans-serif;
    font-size: 20px;
    text-align: center;

}

.porcentaje {
    margin-bottom: 10px;
    margin-left: 50px;
    margin-right: 70px;
}

.Nombre {
    font-family: 'Oswald', sans-serif;
    font-size: 16px;
    text-align: center;
    margin-bottom: 20px;
}
</style>