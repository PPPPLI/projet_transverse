<template>

    <div id="firstDiv">
        <router-link :to="{
            name:'retrouver'
        }">
            <img id="img1" class="img" src="../assets/mainPage/1.jpg" @mouseover="show" @mouseleave="show">
            <h2 id="msg1" v-show="img1">{{linkMsg[1]}}</h2>
        </router-link>

        <router-link :to="{
            name:'perdu'
        }">
            <img id="img2" class="img" src="../assets/mainPage/2.jpg" @mouseover="show" @mouseleave="show">
            <h2 id="msg2" v-show="img2">{{linkMsg[2]}}</h2>
        </router-link>

        <router-link :to="{
            name:'annonce'
        }">
            <img id="img3" class="img" src="../assets/mainPage/3.jpg" @mouseover="show" @mouseleave="show">
            <h2 id="msg3" v-show="img3">{{linkMsg[3]}}</h2>
        </router-link>

        <router-link :to="{
            name:'signaler'
        }">
            <img id="img4" class="img" src="../assets/mainPage/4.jpg" @mouseover="show" @mouseleave="show">
            <h2 id="msg4" v-show="img4">{{linkMsg[4]}}</h2>
        </router-link>

    </div>

</template>

<script>

    export default {
        name: "AccueilPage",
        data(){

            return {
                img1: false,
                img2:false,
                img3:false,
                img4:false,
                linkMsg:['Accueil','Animaux Retrouvés','Animaux Perdus','Faire Une Annonce','Contact','Connexion']
            }
        },

        methods: {

            show(event){

               if(event.target.id === "img1"){

                   this.img1 = !this.img1;
               }else if(event.target.id === "img2"){

                   this.img2 = !this.img2;

               }else if(event.target.id === "img3"){

                   this.img3 = !this.img3;
               }else{
                   this.img4 = !this.img4;
               }

            }
        }
    }
</script>

<style scoped>

    #img1{

        display: inline;
        justify-content: center;
        align-content: center;
        width: 200px;
        position: relative; top: 150px;
        margin-left: 170px;
    }

    #img2{


        display: inline;
        justify-content: center;
        align-content: center;
        width: 200px;
        position: relative; top: 130px;
        margin-left: 80px;
    }

    #img3{


        display: inline;
        justify-content: center;
        align-content: center;
        width: 350px;
        position: relative; top:160px;
        margin-left: 40px;
    }

    #img4{


        display: inline;
        justify-content: center;
        align-content: center;
        width: 250px;
        position: relative; top:140px;
        margin-left: 50px;
    }

    .img:hover{

        background-color: lightgray;
        opacity: 0.4;

    }

    #msg1{
        font-family: cursive;
        position: absolute; top: 350px; left: 170px;
        color: #B04D4D;
    }

    #msg2{
        font-family: cursive;
        position: absolute; top: 350px; left: 450px;
        color: #B04D4D;
    }

    #msg3{
        font-family: cursive;
        position: absolute; top: 350px; left: 770px;
        color: #B04D4D;
    }

    #msg4{
        font-family: cursive;
        position: absolute; top: 350px; left: 1150px;
        color: #B04D4D;
    }

    #firstDiv{

        height: 350px;
    }

</style>