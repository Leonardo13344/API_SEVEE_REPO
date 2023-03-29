import Inicio from '../components/InicioPagina'
import VotantesNacionales from '../components/VotantesNacionales.vue';
import VotantesExtranjero from '../components/VotantesExtranjero.vue';
import AcercaDe from '../components/AcercaDe';

export default  [
    {
      path:'/',
      component: Inicio,
      name:'inicio'
    },
    {
      path:'/votantesNacionales',
      component: VotantesNacionales,
      name: 'VotantesNacionales'
    },
    {
      path:'/VotantesExtranjero',
      component: VotantesExtranjero,
      name: 'VotantesExtranjero'
    },
    {
      path:'/acerca',
      component: AcercaDe,
      name: 'AcercaDe'
    }
  ];