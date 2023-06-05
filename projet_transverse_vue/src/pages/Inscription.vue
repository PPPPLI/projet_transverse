<template>
    <div id="headerDiv">

        <i class="el-icon-arrow-left" id="backIcon">
            <router-link :to="{
            name: 'main'
        }" id="backLink"><span id="titleSpan">Retour </span> </router-link>
        </i>

        <h2 class="titre">Créer mon espace</h2>
        <h4 class="partOne">1. Informations personnelles</h4>
        <pre class="partTwo">Prénom*                                                                 Nom*</pre>
        <input type="text" class="prenomInput" v-model="prenom" @focus="msgOff" required>
        <input type="text" class="prenomInput" v-model="nom" @focus="msgOff" required>
        <pre class="partTwo">Email*                                                                                 Téléphone*</pre>
        <input type="text" class="prenomInput" id="email" v-model="email" placeholder="monadresse@email.com" @focus="msgOff">
        <input type="text" class="prenomInput" id="tel" v-model="tel" @change="keepCallForm" @focus="msgOff" required>
        <pre class="partTwo">Civilité*</pre>
        <input type="radio" name="sex" value="madame" class="prenomInput sex" v-model="civilite" @focus="msgOff"><pre id="radioText">Mme        Mr</pre>
        <input type="radio" name="sex" value="monsieur" class="prenomInput sex" v-model="civilite" @focus="msgOff">
        <pre class="partTwo">Ville*                                                                   Code postal*</pre>
        <select class="prenomInput" @change ="getCp" @focus="msgOff">
            <option selected disabled>- Choisir une ville -</option>
            <option v-for="ville in villeList" :value="ville.nomVille" :key="ville.cpVille">{{ville.nomVille}}</option>

        </select>
        <input type="text" class="prenomInput" id="cpVal" v-model="villeCp" readonly>
        <pre class="partTwo">Rue</pre>
        <input type="text" class="prenomInput" id="rueVal" v-model="rue" @focus="msgOff">

        <h2 class="partOne" id="titre2">2. Informations de connexion</h2>
        <pre class="partTwo">Mot de passe*                                                        Confirmation de mot de passe*</pre>
        <input type="password" class="prenomInput" v-model="password" @focus="msgOff" required>
        <input type="password" class="prenomInput" v-model="checkPass" @focus="msgOff" required>

        <input type="checkbox" class="prenomInput term" :checked="termChecked" :value="termChecked" @click="termChange1"  @focus="msgOff">
        <p id="checkText1" @click="termChange1">Je consens que ces données soient envoyées à la Petfinder pour la création de mon compte adoptant</p>
        <p id="checkText2" @click="termChange2">En validant, j'accepte de recevoir des informations de la Petfinder, par e-mail, téléphone
            ou tout <br><br>autre moyen de communication</p>
        <input type="checkbox" class="prenomInput term" :checked="termChecked2" :value="termChecked2" @click="termChange2"  @focus="msgOff">
        <button id="sendBtn" @click="sendInformation" >Création de mon espace</button><span id="alertMsg" v-show="marker">Compléter les informations nécessaires !</span>



    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "userInscription",
        data(){

            return{

                termChecked:false,
                termChecked2:false,
                villeList:[],
                villeCp: '',
                nom:'',
                prenom:'',
                email:'',
                tel:'+33',
                civilite:'',
                villeId:'',
                password:'',
                checkPass:'',
                rue:'',
                marker: false
            }
        },

        methods: {

            msgOff(){

                this.marker = false;
            },

            keepCallForm(){



                if(this.tel.substring(0,3) != '+33'){

                    this.tel = '+33';


                }

            },

            termChange1(){

                this.termChecked = !this.termChecked;
            },

            termChange2(){

                this.termChecked2 = !this.termChecked2;
            },

            getCp(event){

                this.villeId = event.target.value;

                axios.get('/api/villes/getCp',{
                    params:{
                        nomVille: event.target.value
                    }
                }).then(
                    response => {

                        this.villeCp = response.data.cpVille;
                    }

                ).catch(error => {

                    console.log(error);
                })
            },

            sendInformation(){


                if(this.nom.trim() === '' || this.nom === null){
                    this.marker = true
                    return
                }

                if(this.prenom.trim() == ''){
                    this.marker = true
                    return
                }

                let numReg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
                let numRe = new RegExp(numReg);
                let val = this.email.trim();

                if(numRe.test(val) !== true ||  val === "") {
                    this.marker = true
                    return
                }




                numReg = /^(0|\+33)[1-9]( *[0-9]{2}){4}$/
                val = this.tel.trim();
                numRe = new RegExp(numReg);

                if(numRe.test(val) !== true || val === ""){
                    this.marker = true
                    return
                }

                if(this.civilite === ''){
                    this.marker = true
                    return
                }

                if(this.villeId === ''){
                    this.marker = true
                    return
                }

                if(this.villeCp === '' || this.villeCp.length < 4 || this.villeCp.length > 5){
                    this.marker = true
                    return
                }

                if(this.rue.trim() === ''){
                    this.marker = true
                    return;
                }

                if(this.password.trim() === '' || this.checkPass.trim() === '' || this.password !== this.checkPass || this.password.length < 8){
                    this.marker = true
                    return
                }

                if(this.termChecked === false){
                    this.marker = true
                    return
                }



                axios.get('/api/adduser',{
                    params:{
                        nomUtilisateur:this.nom,
                        prenomUtilisateur:this.prenom,
                        civilite:this.civilite,
                        emailUtilisateur:this.email,
                        telUtilisateur:this.tel,
                        passwordUtilisateur:this.password,
                        villeId: this.villeId,
                        cpVille:this.villeCp,
                        rueLocalisation:this.rue

                    }
                }).then(
                    response => {

                        if(response.data > 0){

                            this.$message({
                                message: 'Message envoyé',
                                type: 'success'
                            });

                            this.$cookies.set('pwd',this.password,'7d');
                            this.$cookies.set('email',this.email,'7d');

                                this.termChecked = false,
                                this.termChecked2 = false,
                                this.villeCp = '',
                                this.nom ='',
                                this.prenom ='',
                                this.email ='',
                                this.tel ='+33',
                                this.civilite ='',
                                this.villeId ='',
                                this.rue = '',
                                this.password ='',
                                this.checkPass ='',


                            this.$router.push("/connection");
                        }else{

                            this.$message({
                                message: 'Inscription échouée',
                                type: 'error'
                            });
                        }



                    }
                ).catch(error => {

                    console.log(error);
                })

            }

        },

        created() {

            axios.get('/api/villes').then(
                response => {
                    for(let i = 0; i < response.data.length; i++){

                        this.villeList.push(response.data[i]);
                    }
                }

            ).catch(error => {

                console.log(error);
            })
        }

    }
</script>

<style scoped>

    #titleSpan{

        position: relative; top: -4px;
    }

    #headerDiv{

        position: relative; top: 100px; left: 250px;
        border: 0;
        padding: 0;
        background-color: cadetblue;
        width: 1000px;
        height: 1170px;
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

    #backLink{

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
        font-size: 30px;
        color: white;
        align-content: center;
    }

    .partOne{

        font-family: cursive;
        display:grid;
        justify-content: center;
        position: relative;top: 50px; left: -200px;
        font-size: 18px;
        color: white;

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

    #email{

        width: 360px;
    }

    #tel{
        width: 240px;
    }

    #titre2{

        margin-top: 50px;
    }

    .sex{

        font-size: 5px;
        width: 25px;
        height: 25px;
        margin-right: 75px;
        margin-top: 10px;
    }

    .term{

        display: block;
        font-size: 5px;
        width: 25px;
        height: 25px;
        margin-right: 75px;
        margin-top: 10px;
        position: relative; top: 80px;
        margin-bottom: 40px;
    }

    #radioText{

        position: absolute; top: 444px; left: 220px;
        font-size: 18px;
        color:lightgoldenrodyellow;
        font-weight: bold;

    }

    #cpVal{
        width: 313px;
    }

    #rueVal{
        width: 655px;
    }

    #checkText1{

        position: absolute; top: 898px; left: 215px;
        font-size: 14px;
        color:white;
        font-weight: bold;
        cursor: pointer;
    }

    #checkText2{

        position: absolute; top:963px; left: 215px;
        font-size: 14px;
        color:white;
        font-weight: bold;
        cursor: pointer;
    }


    #sendBtn{


        position: relative; top: 115px; left: 360px;
        background-color: darkslategray;
        border: solid black 1px;
        font-family: cursive;
        cursor: pointer;
        color:white;
        font-size: 20px;
        margin-left: 8px;
        margin-right: 8px;
        border-radius: 17px;
        padding: 10px;
        transition: background-color 1s, color 1s;
        text-decoration: none;

    }

    #sendBtn:hover{

        color: darkslategray;
        background-color: white;

    }

    #alertMsg{

        color: indianred;
        font-family: cursive;
        position: relative; left: 75px; top: 65px;
        font-weight: bold;
    }
</style>

