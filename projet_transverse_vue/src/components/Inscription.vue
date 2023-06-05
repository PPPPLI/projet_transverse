<template>

    <div id="headerDiv">
        <div id="buttonDiv">
            <hr>
        </div>
        <div id="backgroundDiv1" v-show="changeBackground"></div>
        <div id="backgroundDiv2" v-show="!changeBackground"></div>
    </div>

</template>

<script>

    import {mapState} from 'vuex'

    export default {
        name: "InscriptionWindow",

        computed:{
            ...mapState('InscriptionButton',['changeBackground'])
        }
    }
</script>

<style scoped>

    #backgroundDiv1{

        position: absolute; top: 130px; left: 0px;
        width: 100%;
        height: 82%;
        background-color: black;
        opacity: 20%;
        z-index: 499;
    }


    #backgroundDiv2{

        position: absolute; top: 130px; left: 0px;
        width: 100%;
        height: 1500px;
        background-color: black;
        opacity: 20%;
        z-index: 499;
    }

    #buttonDiv{
        position: absolute; top: 130px; left: 0px;
        width: 100%;
        height: 10%;
        background-color: white;
        z-index: 500;
        opacity: 100%;
    }
</style>