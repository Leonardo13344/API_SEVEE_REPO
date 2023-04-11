import { sleep } from 'k6';
import http from 'k6/http';


// const totalVu = 20;
// export const options = {
//   summaryTimeUnit: "ms",
//   setupTimeout: "180s",
//   scenarios: {
//     test: {
//       exec: "test",
//       executor: "per-vu-iterations",
//       vus: totalVu,
//       iterations: 50,
//     },
//   },
// };

export let options = {
  
  stages: [
    { duration: '5m', target: 100 }, // simulate ramp-up of traffic from 1 to 100 users over 5 minutes.
    { duration: '10m', target: 100 }, // stay at 100 users for 10 minutes
    { duration: '5m', target: 0 }, // ramp-down to 0 users
  ],
  // thresholds: {
  //   'http_req_duration': ['p(99)<1500'], // 99% of requests must complete below 1.5s
  //   'logged in successfully': ['p(99)<1500'], // 99% of requests must complete below 1.5s
  // },
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


