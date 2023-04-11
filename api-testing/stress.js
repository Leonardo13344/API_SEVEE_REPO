import http from "k6/http";
import { sleep } from "k6";

export const options = {
  scenarios: {
    stress: {
      executor: "ramping-arrival-rate",
      preAllocatedVUs: 500,
      timeUnit: "1s",
      stages: [
        { duration: "2m", target: 10 }, // below normal load
        { duration: "5m", target: 10 },
        { duration: "2m", target: 20 }, // normal load
        { duration: "5m", target: 20 },
        { duration: "2m", target: 30 }, // around the breaking point
        { duration: "5m", target: 30 },
        { duration: "2m", target: 40 }, // beyond the breaking point
        { duration: "5m", target: 40 },
        { duration: "10m", target: 0 }, // scale down. Recovery stage.
      ],
    },
  },
};



const API_BASE_URL = 'http://localhost:8080/API/Sevee/V1/votos'
export default () => {
    http.batch([
        ['GET', `${API_BASE_URL}/votosListaCandidatoGeneroGeneral/false`],
        ['GET', `${API_BASE_URL}/votosGenero/false/F`],
        ['GET', `${API_BASE_URL}/votosValidos/false`]
    ]);

    

};

