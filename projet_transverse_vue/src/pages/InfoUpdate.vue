<template>

    <div id="firstDiv">

        <pre id="title">Mes informations</pre>
        <pre class="partTwo">Prénom*                                                         Nom*</pre>
        <input type="text" class="prenomInput" v-model="prenom" @focus="msgOff" required>
        <input type="text" class="prenomInput" v-model="nom" @focus="msgOff" required>
        <pre class="partTwo">Email*                                                                       Téléphone*</pre>
        <input type="text" class="prenomInput" id="email" :value="email" placeholder="monadresse@email.com" readonly disabled>
        <input type="text" class="prenomInput" id="tel" v-model="tel" @change="keepCallForm" @focus="msgOff" required>
        <pre class="partTwo">Ville*                                                          Code postal*</pre>

        <select class="prenomInput" @change ="getCp" @focus="msgOff">
            <option selected disabled>{{ villeId }}</option>
            <option v-for="ville in villeList" :value="ville.nomVille" :key="ville.cpVille">{{ville.nomVille}}</option>

        </select>
        <input type="text" class="prenomInput" id="cpVal" v-model="villeCp" @focus="msgOff">

        <pre class="partTwo">Rue</pre>
        <input type="text" class="prenomInput" id="rueVal" v-model="rue" @focus="msgOff">

        <h2 class="partOne" id="titre2">Informations de connexion</h2>
        <pre class="partTwo">Mot de passe*                                               Confirmation de mot de passe*</pre>
        <input type="password" class="prenomInput" v-model="password" @focus="msgOff" required>
        <input type="password" class="prenomInput" v-model="checkPass" @focus="msgOff" required>
        <button id="sendBtn" @click="sendInformation" >Mettre à jour mes infos</button><span id="alertMsg" v-show="marker">Compléter les informations nécessaires !</span>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "InfoUpdate",
        data(){

            return{

                villeList:[],
                villeCp: '',
                nom:this.$cookies.get('nom'),
                prenom:this.$cookies.get('prenom'),
                email:this.$cookies.get('email'),
                tel:this.$cookies.get('tel'),
                villeId:this.$cookies.get('idLocalisation'),
                password:this.$cookies.get('pwd'),
                checkPass:this.$cookies.get('pwd'),
                rue:'',
                marker:false
            }
        },

        methods:{

            msgOff(){

                this.marker = false;
            },

            keepCallForm(){


                if(this.tel.substring(0,3) !== '+33'){

                    this.tel = '+33';


                }

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

                if(this.prenom.trim() === ''){
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



                axios.get('/api/userupdate',{
                    params:{
                        nomUtilisateur:this.nom,
                        prenomUtilisateur:this.prenom,
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

                            console.log(response.data)
                            this.$cookies.set('pwd',this.password,'7d');
                            this.$cookies.set('email',this.email,'7d');
                            this.$cookies.set('nom',this.nom,'7d');
                            this.$cookies.set('prenom',this.prenom,'7d');
                            this.$cookies.set('tel',this.tel,'7d');
                            //this.$cookies.set('idLocalisation',response.data.locationId,'7d');


                        }else{

                            this.$message({
                                message: 'Essayer plus tard',
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

            axios.get('/api/getLocalisation',{
                params:{

                    idLocalisation:this.$cookies.get('idLocalisation')
                }
            }).then(

                response => {

                    this.villeId = response.data.villeLocalisation;
                    this.villeCp = response.data.cpLocalisation;
                    this.rue = response.data.rueLocalisation;
                }
            ).catch(error => {

                console.log(error)
            })



        }
    }
</script>

<style scoped>

    #firstDiv{

        position: relative; top: -180px; left: 400px;
        width: 900px;
        height: 800px;
        border: solid 1px black;
        box-shadow: 5px 5px 12px 1px lightgray;
    }

    #title{

        font-family: cursive;
        position: relative;top: 10px; left: 182px;
        font-size: 30px;
        font-weight: lighter;
        color: black;
    }



    .partOne{

        font-family: cursive;
        position: relative;top: 0;
        left: 182px;
        font-size: 18px;
        color:  black;

    }

    .partTwo{

        font-family: cursive;

        position: relative;top: 20px;
        left: 182px;
        font-size: 15px;
        color: black;
        margin-top: 20px;
        cursor: default;
    }

    .prenomInput {

        position: relative; left: 80px; top: 10px;
        width: 200px;
        height: 40px;
        font-size: 15px;
        border-radius: 10px;
        border: solid 1px;
        padding-left: 10px;
        background-color: linen;
        margin-left: 100px;

    }

    #email{

        width: 250px;
    }

    #tel{
        width: 150px;
    }

    #titre2{

        margin-top: 50px;
    }



    #cpVal{
        width: 215px;

    }


    #rueVal{
        width: 515px;
        background-color: linen;
    }

    #sendBtn{


        position: relative; top: 115px; left: -455px;
        background-color: linen;
        border: solid black 1px;
        font-family: cursive;
        cursor: pointer;
        color: black;
        font-size: 20px;
        margin-left: 8px;
        margin-right: 8px;
        border-radius: 13px;
        padding: 10px;
        transition: background-color 1s, color 1s;
        text-decoration: none;

    }

    #sendBtn:hover{

        color: linen;
        background-color: black;

    }

    #alertMsg{

        color: indianred;
        font-family: cursive;
        position: relative; left: 500px; top: 80px;
        font-weight: bold;
    }
</style>