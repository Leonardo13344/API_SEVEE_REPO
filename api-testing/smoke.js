import http from 'k6/http';
import { check, group, sleep, fail } from 'k6';

export const options = {
    insecureSkipTLSVerify: true,
    noConnectionReuse: false,
    vus: 1, // 1 user looping for 1 minute
    duration: '1m',

    thresholds: {
        http_req_duration: ['p(99)<1500'], // 99% of requests must complete below 1.5s
    },
};

export default () => {
    http.get('http://localhost:8080/API/Sevee/V1/votos/votosListaCandidatoGeneroGeneral/false')
    sleep(1);
};
