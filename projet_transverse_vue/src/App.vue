<template>
    <div id="app">

        <PageAccueilHeader @trigger="getInscription"></PageAccueilHeader>
        <Inscription v-show="showInscription" ></Inscription>
        <router-view ></router-view>
        <Notice ></Notice>
        <AccueilFooter></AccueilFooter>
    </div>
</template>

<script>

    import PageAccueilHeader from "@/components/PageAccueilHeader";
    import AccueilFooter from "@/components/Footer";
    import Notice from "@/components/Notice";
    import Inscription from './components/Inscription'

    export default {
        name: 'App',
        data(){

          return {

              showInscription:false
          }
        },
        components: {
        PageAccueilHeader,AccueilFooter,Notice,Inscription
        },

        methods:{

            getInscription(val){

                this.showInscription = val;
            }
        },

    }
</script>

<style>

</style>
