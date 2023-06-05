<template>
    <div id="mainDiv">
        <router-link :to="{
            name:'main'
        }"><img id="headerImg" src="../assets/logo.jpg"></router-link>
        <b id="headerText">{{msg}}</b>

        <router-link :to="{
            name:'main'
        }" class="headerNavigation" id="firstLink">{{linkMsg[0]}}</router-link>

        <router-link :to="{
            name:'retrouver'
        }" class="headerNavigation">{{linkMsg[1]}}</router-link>
        <router-link :to="{
            name:'perdu'
        }" class="headerNavigation">{{linkMsg[2]}}</router-link>

        <router-link :to="{
            name:'annonce'
        }" class="headerNavigation">{{linkMsg[3]}}</router-link>

        <router-link :to="{
            name:'signaler'
        }" class="headerNavigation">{{linkMsg[4]}}</router-link>

        <a id="monEspace"  @click="drawer = !drawer" @keyup.esc="drawer = false" type="primary"><i class="el-icon-s-custom" ></i>  {{userState}}</a>

        <el-drawer
            id="drawer"
            :visible.sync="drawer"
            :direction="direction"
            :modal= 'modalNeed'
            :show-close="false"
            :close-on-press-escape="true"
            >
            <span id="inscriptionBtn">
                <router-link :to="{
                    name : 'connection'
                }" class="insBtn btnC"  @click.native="goToInscription()" @click.n.native="reChangeSize" v-show="connectionBtnState">Je me connecte</router-link>
                 <router-link to="/espace" class="insBtn btnC"  @click.native="goToInscription()" @click.n.native="reChangeSize" v-show="!connectionBtnState">Espace personel</router-link>

                <router-link :to='{
                    name: "main"
                }' class="InsLInk" id="deconnection" @click.native="signOut" @click.n.native="changeSize" v-show="!connectionBtnState">Déconnection</router-link>

                <router-link :to='{
                    name: "inscription"
                }' class="InsLInk" @click.native="goToInscription()" @click.n.native="changeSize" v-show="connectionBtnState">Je crée mon compte</router-link>
            </span>
        </el-drawer>
    </div>
</template>

<script>


    import {mapMutations,mapState} from "vuex";

    export default {
        name: "PageAccueilHeader",
        data(){

            return{
                msg: 'PetFinder',
                linkMsg:['Accueil','Animaux Retrouvés','Animaux Perdus','Faire Une Annonce','Contact'],
                direction: 'ttb',
                modalNeed:false,
                drawer:false
            }
        },

        watch:{
            drawer:{
                handler(newValue){

                    this.$emit('trigger',newValue);
                }
            }
        },

        computed:{

            ...mapState('InscriptionButton',['userState','connectionBtnState'])
        },

        methods:{

            ...mapMutations('InscriptionButton',['changeSize','reChangeSize','changeUsername','changeConnectionBtn']),

            goToInscription(){

                this.drawer = false;
            },

            signOut(){

                this.changeUsername('Connection');
                this.changeConnectionBtn(true);
                this.drawer = false;
            }
        },

    }
</script>

<style scoped>


    #headerImg{
        width: 450px;
        position:absolute; left: -100px; top: -90px;
   }

    #headerText{

        font-family: cursive;
        display: inherit;
        position: relative; left: 160px; top: 50px;
        font-size: 40px;
        color: #F56C6C;
        cursor: none;
        text-decoration: none;
        width: 900px;
    }

    .headerNavigation{

        font-family: cursive;
        display: inline;
        margin-left: 5px;
        position: relative; top:15px; left: 400px;
        font-size: 20px;
        text-decoration: none;
        color: #E36464;
        border-left: solid #E36464 1px;
        padding: 10px;
    }

    #firstLink{
        border: none;
    }

    #firstLink:hover{

        color: #634A4A;

    }

    .headerNavigation:hover{

        color: #634A4A;
    }

    #monEspace{
        font-family: cursive;
        cursor: pointer;
        color:#E36464;
        font-size: 20px;
        position: relative; top: 15px; left: 500px;
        text-decoration: none;
    }

    #monEspace:hover{

        color: #634A4A;
    }

    .el-icon-s-custom{

        font-size: 30px;
    }

    #drawer{
        position: absolute; top: 150px; left: 0px;
        width: 100%;
        height: 300px;

    }

    #inscriptionBtn{

        position: absolute;
        left: 38%;
        top: 20%;

    }

    .insBtn{

        font-family: cursive;
        cursor: pointer;
        color:white;
        font-size: 20px;
        margin-left: 8px;
        margin-right: 8px;
        border-radius: 20px;
        padding: 5px;
        box-shadow: 5px 5px 12px 1px lightgray;
        transition: background-color 1s, color 1s;
        text-decoration: none;
        border: solid black 1px;
    }


    .btnC{
        background-color: #B04D4D;
    }

    .btnC:hover{

        color: #B04D4D;
        background-color: white;

    }

    #deconnection{

        margin-left: 50px;
    }



    .InsLInk{

        background-color: cadetblue;
        border: solid black 1px;
        font-family: cursive;
        cursor: pointer;
        color:white;
        font-size: 20px;
        margin-left: 8px;
        margin-right: 8px;
        border-radius: 20px;
        padding: 5px;
        box-shadow: 5px 5px 12px 1px lightgray;
        transition: background-color 1s, color 1s;
        text-decoration: none;
    }

    .InsLInk:hover{

        color: cadetblue;
        background-color: white;
    }


</style>