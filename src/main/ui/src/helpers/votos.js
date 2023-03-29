import axios from "axios";

//Ausentes

export const muestraVotos = async (body) => {
    //return await obtenerEmpleadoAPI(id);
    return await muestraVotosAusentes(body);
}

const muestraVotosAusentes = async (vuelta) => {
    const data = axios.get(`http://localhost:8085/API/Sevee/V1/actas/ausentes/${vuelta}`).then(r => r.data)
    console.log(data)
    return data
}

//Busqueda Izquierda

export const busquedaIzquierda = async (vuelta, provincia, canton) => {
    return await busquedaIzquierdaFachada(vuelta, provincia, canton);
}

const busquedaIzquierdaFachada = async (vuelta, provincia, canton) => {
    const data = axios.get(`http://localhost:8085/API/Sevee/V1/votos/filtroIzquierda/${vuelta}/${provincia}/${canton}`).then(r => r.data);
    console.log(data);
    return data;
}



//Total Genero

export const totalGenero = async (vuelta, genero) => {
    return await totalGeneroFachada(vuelta, genero);
}

const totalGeneroFachada = async (vuelta, genero) => {
    const data = axios.get(`http://localhost:8085/API/Sevee/V1/votos/votosGenero/${vuelta}/${genero}`).then(r => r.data);
    console.log(data);
    return data;
}

//Total Sufragio

export const totalSufragio = async (vuelta) => {
    return await totalSufragioFachada(vuelta);
}

const totalSufragioFachada = async (vuelta) => {
    const data = axios.get(`http://localhost:8085/API/Sevee/V1/votos/votosValidos/${vuelta}`).then(r => r.data);
    console.log(data);
    return data;
}

//TablaResultadosGnerales

export const muestraTablaGenerales = async (vuelta) => {
    //return await obtenerEmpleadoAPI(id);
    return await muestraTablaGeneralesFachada(vuelta);
}

const muestraTablaGeneralesFachada = async (vuelta) => {
    const data = axios.get(`http://localhost:8085/API/Sevee/V1/votos/votosListaCandidatoGeneroGeneral/${vuelta}`).then(r => r.data)
    return data
}
