<template>
    <div id="headerDiv">

        <i class="el-icon-arrow-left" id="backIcon">
            <router-link :to="{
            name: 'main'
        }" class="backLink"><span id="titleSpan1">Retour </span> </router-link>
        </i>

        <h2 class="titre">Se connecter à Petfinder</h2>

        <pre class="partTwo">Identifiant (email)*                                               Mot de passe*</pre>
        <input type="text" class="prenomInput" v-model="emailCheck" required>
        <input type="password" class="prenomInput" v-model="passwordCheck" required>
        <el-button id="sendBtn" @click="sendInformation" >Accéder</el-button>


        <router-link :to="{
            name: 'main'
        }" class="backLink"><span id="titleSpan3">Mot de passe oublié ?</span></router-link>



        <i class="el-icon-arrow-right" id="leftIcon">
            <router-link :to="{
            name: 'inscription'
        }" class="backLink"><span id="titleSpan2">Je n'ai pas encore de compte</span> </router-link>
        </i>

    </div>
</template>

<script>
    import axios from "axios";
    import store from "@/vuex/Store";
    export default {
        name: "UserConnection",
        data(){

            return{
                emailCheck:'',
                passwordCheck:'',
                alertMsg:[false,false]
            }
        },

        methods:{
            sendInformation() {

                let count = 0;

                let numReg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
                let numRe = new RegExp(numReg);
                let val = this.emailCheck.trim();

                if(numRe.test(val) !== true ||  val === "") {

                    this.alertMsg[0] = true;
                    count++;
                    return
                }

                if(this.passwordCheck.trim() === '' || this.passwordCheck.length < 8 ){

                    this.alertMsg[1] = true;
                    count++
                    return
                }

                if(count === 0){

                    axios.get('/api/login',{

                        params:{
                            email:this.emailCheck,
                            pwd:this.passwordCheck
                        }
                    }).then(
                        response => {

                            if(response.data.nomUtilisateur !== 'empty'){

                                this.$cookies.set('pwd',response.data.passwordUtilisateur,'7d');
                                this.$cookies.set('email',response.data.emailUtilisateur,'7d');
                                this.$cookies.set('nom',response.data.nomUtilisateur,'7d');
                                this.$cookies.set('prenom',response.data.prenomUtilisateur,'7d');
                                this.$cookies.set('tel',response.data.telUtilisateur,'7d');
                                this.$cookies.set('idLocalisation',response.data.localisation.idLocalisation,'7d');
                                store.commit('InscriptionButton/changeUsername', response.data.prenomUtilisateur +' '+response.data.nomUtilisateur)
                                store.commit('InscriptionButton/changeConnectionBtn', false)
                                this.$router.push('/')
                            }else{

                                this.$message({
                                    message: 'Identifiant ou mot de passe incorrect',
                                    type: 'error'
                                });
                            }
                        }
                    ).catch(error => {

                        console.log(error)
                    })
                }

            }
        },
        mounted(){

            if(this.$cookies.isKey("email") != null || this.$cookies.isKey("pwd") != null || this.$cookies.get("email") !== 'undefined' || this.$cookies.get("pwd") !== 'undefined'){

                this.emailCheck = this.$cookies.get("email");
                this.passwordCheck = this.$cookies.get("pwd")
            }else {

                this.passwordCheck = '';
                this.emailCheck = '';
            }
        }
}
</script>

<style scoped>

    #titleSpan1{

        position: relative; top: -4px;
    }

    #titleSpan2{

        position: relative; top: -7px; left: -235px;
        font-size: 17px;
    }

    #titleSpan3{

        width: 147px;
        position: absolute; top: 90px; left: -110px;
        color: white;
        font-size: 16px;
        padding-bottom: 1px;
    }

    #titleSpan3:hover{

        border-bottom: 1px solid;

    }

    #headerDiv{

        position: relative; top: 100px; left: 250px;
        border: 0;
        padding: 0;
        background-color:indianred;
        width: 1000px;
        height: 380px;
        border: solid black;
        box-shadow: 5px 5px 12px 1px lightgray;
    }

    #backIcon{

        position: relative; left: 40px; top: 30px;
        font-size: 30px;
        color: white;
        font-weight: 800;
        transition: left 1s;
    }

    #backIcon:hover{

        position: relative; left: 30px; top: 30px;
    }

    #leftIcon{

        position: relative; left: 820px; top: 120px;
        font-size: 30px;
        color: white;
        font-weight: 800;
        transition: left 1s;
    }

    #leftIcon:hover{

        position: relative; left: 830px; top: 120px;
    }



    .backLink{

        position: relative;
        display: inline;
        font-size: 20px;
        color: white;
        font-weight: 800;
        text-decoration: none;
    }


    .titre{

        font-family: cursive;
        display:grid;
        justify-content: center;
        position: relative;top: 30px;
        font-size: 20px;
        color: white;
        align-content: center;
    }


    .partTwo{

        font-family: cursive;
        display:grid;
        justify-content: left;
        position: relative;top: 50px; left: 180px;
        font-size: 15px;
        color: white;
        margin-top: 20px;
        cursor: default;
    }

    .prenomInput {

        display: inline;
        justify-content: center;
        position: relative;
        top: 45px;
        left: 175px;
        width: 300px;
        height: 40px;
        font-size: 15px;
        border-radius: 10px;
        border: solid 1px;
        padding-left: 10px;
        margin-right: 40px;

    }

    #sendBtn{


        position: relative; top: 125px; left: -540px;
        background-color: #634A4A;
        border: solid black 1px;
        font-family: cursive;
        cursor: pointer;
        color:white;
        font-size: 15px;
        margin-left: 8px;
        margin-right: 8px;
        border-radius: 17px;
        padding: 10px;
        transition: background-color 1s, color 1s;
        text-decoration: none;

    }

    #sendBtn:hover{

        color: #634A4A;
        background-color: white;

    }


</style>