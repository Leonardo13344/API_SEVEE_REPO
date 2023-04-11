import { sleep } from 'k6';
import http from 'k6/http';

export let options = {
    insecureSkipTLSVerify: true,
    noConnectionReuse: false,
    
    vus: 1,
    duration: '20s'
};

const API_BASE_URL = 'http://localhost:8080/API/Sevee/V1/votos'
export default () => {
    http.batch([
        ['GET', `${API_BASE_URL}/votosListaCandidatoGeneroGeneral/false`],
        ['GET', `${API_BASE_URL}/votosGenero/false/F`],
        ['GET', `${API_BASE_URL}/votosValidos/false`]
    ]);

    sleep(1);
    
};
