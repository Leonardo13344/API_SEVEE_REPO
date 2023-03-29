<template>
  <v-footer dark padless height="auto" >
    <v-card flat tile width="100%" class="PiePagina">
      <v-row class="mb-2">
        <v-card-text class="Titulo" > <span>Sistema Ecuatoriano de Visualización de Estadísticas</span></v-card-text>
        <v-card-text class="Titulo_C">Colaboracion  IAEN - UCE</v-card-text>
      </v-row>
      <v-row class="img_colaboradores mb-2">
        
         <v-img alt="Imagen IAEN"
                        src="../assets/uce.png"
                        transition="scale-transition"  
                        width="50"   
                        contain
                    />
                    <v-img alt="Imagen IAEN"
                        src="../assets/Logo_IAEN.png"
                        transition="scale-transition"  
                        width="150"   
                        contain
                    />
                    <v-img alt="Imagen IAEN"
                        src="../assets/Agora_Logo.png"
                        transition="scale-transition"  
                        width="70"   
                        contain
                    />
      </v-row>
        
    </v-card>
    <h2 class="titulo-final" >Copyright &copy; 20223  | Derechos reservados</h2>
  </v-footer>
</template>

<script>
export default {
  name: 'FooterApp',
  data: () => ({
  
  }),
};
</script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');
  .PiePagina{
    font-family: 'Open sans';
    margin-block-end: auto;
    display: flex;
    width: 100%;
    justify-content: center;
    margin: auto;
    padding-bottom: 20px;
    border-bottom: 1px solid #ccc ;

  }
  .Titulo{
    font-family: 'Oswald';
    font-size: 25px;  

  }
  .Titulo_C{
    font-family: 'Oswald';
    font-size: 18px;
    
  }
  .img_colaboradores{
    margin-top: 20px;
  }
  .titulo-final{
    text-align: center;
    
    justify-content: center;
    font-size: 15px;
    margin: 15px 0 0 0;
    margin-left: 550px;
    color: #9e979e;
    

}
</style>