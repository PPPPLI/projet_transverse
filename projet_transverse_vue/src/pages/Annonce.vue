<template>
    <div id="firstDiv">
        <select class="selector" @focus="msgOff" @change="setSituationVal" v-show="situationMarker">
            <option selected disabled>- Choisir une situation -</option>
            <option v-for="(situation,index) in situations" :key=index :value="situation">{{situation}}</option>
        </select>


        <select class="selector" @change ="getCp" @focus="msgOff" v-show="villeMarker">
            <option selected disabled>- Choisir une ville -</option>
            <option v-for="ville in villeList" :value="ville.nomVille" :key="ville.cpVille">{{ville.nomVille}}</option>
        </select>
        <input type="text" class="textInput" id="cpInfo" v-model="villeCp" v-show="villeMarker" readonly>
        <input type="text" class="textInput" id="rueInfo" v-model="villeRue" v-show="villeMarker">
        <textarea  class="textInput" id="desInfo" v-model="descriptionText" v-show="restMarker" ></textarea>
        <input type="file" class="textInput" id="fileLoad"  accept="image/jpeg" v-show="restMarker">


        <img src="../assets/annoncePage/1.png" id="img1" v-show="chatMarker">
        <img src="../assets/annoncePage/2.png" id="img2" v-show="chienMarker">
        <img src="../assets/annoncePage/3.png" id="img3" v-show="furetMarker">
        <select class="selector" id="typeSelector" @focus="msgOff" @change="setTypeVal" v-show="typeMarker">
            <option selected disabled>- Choisir une type d'animal -</option>
            <option v-for="(animal,index) in types" :key=index :value="animal">{{animal}}</option>
        </select>
        <select class="selector" id="sexSelector" @focus="msgOff" @change="setSexVal" v-show="sexMarker">
            <option selected disabled>- Mâle ou Femelle -</option>
            <option v-for="(sex,index) in sexs" :key=index :value="sex">{{sex}}</option>
        </select>
        <select class="selector" id="colorSelector"  @focus="msgOff" @change="setColorVal" v-show="colorMarker">
            <option selected disabled>- Choisir la couleur -</option>
            <option v-for="(color,index) in colors" :key=index :value="color">{{color}}</option>
        </select>

        <select class="selector race" id="catRaceSelector"  @focus="msgOff" @change="setRaceVal" v-show="catRaceMarker">
            <option selected disabled>- Choisir la race -</option>
            <option v-for="(cat,index) in cats" :key=index :value="cat">{{cat}}</option>
        </select>

        <select class="selector race" id="dogRaceSelector"  @focus="msgOff" @change="setRaceVal" v-show="dogRaceMarker">
            <option selected disabled>- Choisir la race -</option>
            <option v-for="(dog,index) in dogs" :key=index :value="dog">{{dog}}</option>
        </select>

        <select class="selector race" id="furetRaceSelector"  @focus="msgOff" @change="setRaceVal" v-show="furetRaceMarker">
            <option selected disabled>- Choisir la race -</option>
            <option v-for="(furet,index) in furets" :key=index :value="furet">{{furet}}</option>
        </select>

        <input type="date" class="selector race" id="findDate"  @focus="msgOff" @change="setDateVal" v-show="dateMarker">


        <div class="msg" v-show="!marker">
            <span v-show="situationMarker">Quelle est la situation de l'animal?</span>
            <span v-show=villeMarker>Ville de découverte/perte</span>
            <span id="typeMsg"  v-show="typeMarker">Son type?</span>
            <span id="rueMsg"  v-show="villeMarker">Rue</span>
            <span id="descriptionMsg"  v-show="restMarker">Description</span>
            <span class="raceMsg"  v-show="catRaceMarker">Sa race?</span>
            <span class="raceMsg"  v-show="dogRaceMarker">Sa race?</span>
            <span class="raceMsg"  v-show="furetRaceMarker">Sa race?</span>
            <span id="colorMsg"  v-show="colorMarker">Sa couleur?</span>
            <span id="villeMsg"  v-show="villeMarker">Code postal</span>
            <span id="sexMsg"  v-show="sexMarker">Sa sexe?</span>
            <span id="dateMsg"  v-show="dateMarker">La date de découverte/perte</span>
        </div>

        <button class="sendBtn" @click="sendInformation" v-show="btnMarker">Suivant</button><span id="alertMsg" v-show="marker">Compléter les informations nécessaires !</span>
        <button class="sendBtn" id="sendAnnonce" v-show="restMarker" @click="importFilePost">Envoyer</button>
    </div>
</template>

<script>

    import store from "@/vuex/Store";
    import {mapState} from "vuex";
    import axios from "axios";
    axios.defaults.headers.post['Content-Type'] = 'multipart/form-data'

    export default {
        name: "AnnoncePage",
        data(){

            return {

                villeList:[],
                descriptionText:'',
                villeCp:'',
                villeRue:'',
                types: ['Chat','Chien','Furet'],
                situations:['Retrouvé','Perdu'],
                sexs:['Mâle','Femelle','- Je ne sais pas -'],
                colors:['Noir','Roux','Gris','Roux et blanc','Noir et blanc','Gris et blanc','Tricolore'],
                cats: ["European","Abyssin","Maine Coon","Siamois","Persan","Bengal","Sphynx","Rag doll","Chartreux","Norvégien","- Je ne sais pas -"],
                dogs: ["Labrador Retriever" ,"Berger allemand","Golden Retriever","Bulldog anglais","Caniche","Yorkshire Terrier","Boxer","Rottweiler","Teckel (Dachshund)","Teckel (Dachshund)","Berger belge","Beagle","Beagle","Staffordshire Bull Terrier","Shih Tzu","Bouledogue français","Bouledogue français","Bouledogue français","Doberman","Schnauzer","Coton de tulear","- Je ne sais pas -"],
                furets:["Furet albinos","Furet sable","Furet panda","Furet chocolat","Furet champagne","Furet cannelle","Furet silver","Furet noir ","Furet panda chocolat","Furet point","- Je ne sais pas -"],
                marker:false,
                situationMarker:true,
                typeMarker:false,
                sexMarker:false,
                colorMarker:false,
                chatMarker: false,
                chienMarker:false,
                furetMarker:false,
                catRaceMarker: false,
                dogRaceMarker: false,
                furetRaceMarker: false,
                dateMarker: false,
                btnMarker:false,
                villeMarker:false,
                uploadMarker:false,
                restMarker:false,


            }
        },

        computed:{

            ...mapState('Annonce',['situation','type','sex','color','animalDate','nom','race','nomVille','cpVille','rueVille','description'])
        },
        methods:{



            importFilePost(){

                let file = new FormData();
                file.append('file',document.getElementById('fileLoad').files[0]);
                // file.append('nomAnimal',this.nom);
                // file.append('typeAnimal',this.type);
                // file.append('sexeAnimal',this.sex);
                // file.append('couleurAnimal',this.color);
                // file.append('dateAnimal', this.animalDate);
                // file.append('etatAnimal', this.situation);
                // file.append('descriptionAnimal',this.description);
                // file.append('raceAnimal',this.race);
                // file.append('nomVille', this.nomVille);
                // file.append('cpVille', this.cpVille);
                // file.append('rueVille', this.rueVille);
                // file.append('emailUtilisateur',this.$cookies.get('email'))


                axios.post('/api/animal', file

                ).then(

                    response =>{



                        if(response.data >0){

                            axios.get("/api/adddemande",{
                                params:{

                                    idAnimal : response.data,
                                    nomAnimal:this.nom,
                                    typeAnimal:this.type,
                                    sexeAnimal:this.sex,
                                    couleurAnimal:this.color,
                                    dateAnimal:this.animalDate,
                                    etatAnimal:this.situation,
                                    descriptionAnimal:this.descriptionText,
                                    raceAnimal:this.race,
                                    nomVille:this.nomVille,
                                    cpVille:this.cpVille,
                                    rueVille:this.villeRue,
                                    emailUtilisateur:this.$cookies.get('email')
                                }
                            }).then(
                                response =>{

                                    if(response.data >= 0){

                                        this.$message({
                                            message: 'Annonce crée',
                                            type: 'success'
                                        });


                                        //store.commit('Annonce/changeNom',event.target.value)
                                        store.commit('Annonce/changeType','')
                                        store.commit('Annonce/changeSex','')
                                        store.commit('Annonce/changeColor','')
                                        store.commit('Annonce/changeDate','')

                                        this.descriptionText = '';
                                        store.commit('Annonce/changeNomVille','')
                                        this.villeRue = '';
                                        this.villeCp = '';
                                        this.situationMarker = true
                                        this.typeMarker = false
                                        this.sexMarker = false
                                        this.colorMarker = false
                                        this.chatMarker = false
                                        this.chienMarker = false
                                        this.furetMarker = false
                                        this.catRaceMarker = false
                                        this.dogRaceMarker = false
                                        this.furetRaceMarker = false
                                        this.dateMarker = false
                                        this.btnMarker = false
                                        this.villeMarker = false
                                        this.uploadMarker = false
                                        this.restMarker = false


                                        if(this.situation === "Perdu"){
                                            store.commit('Annonce/changeSituation','')
                                            this.$router.push('/retrouver');
                                        }else{
                                            store.commit('Annonce/changeSituation','')
                                            this.$router.push("/perdu");
                                        }


                                    }else{

                                        this.$message({
                                            message: 'Essayer plus tard',
                                            type: 'error'
                                        });
                                    }
                                }
                            )
                        }else{
                            console.log("123")
                            this.$message({
                                message: 'Essayer plus tard',
                                type: 'error'
                            });
                        }

                    }
                ).catch(error => {

                    console.log(error)
                })
            },


            getCp(event){


                axios.get('/api/villes/getCp',{
                    params:{
                        nomVille: event.target.value
                    }
                }).then(
                    response => {

                        store.commit('Annonce/changeNomVille',event.target.value)
                        this.villeCp = response.data.cpVille;
                        store.commit('Annonce/changeCpVille',this.villeCp)
                        this.restMarker = true
                    }

                ).catch(error => {

                    console.log(error);
                })
            },

            setSituationVal(event){

                this.typeMarker = true
                store.commit('Annonce/changeSituation',event.target.value)
            },

            setDateVal(event){
                this.btnMarker = true
                store.commit('Annonce/changeDate',event.target.value)
            },

            setTypeVal(event){

                if(event.target.value === 'Chat'){
                    this.furetMarker = false
                    this.chienMarker = false
                    this.chatMarker = true
                }else if(event.target.value === 'Chien'){
                    this.furetMarker = false
                    this.chatMarker = false
                    this.chienMarker = true
                }else if(event.target.value === 'Furet'){

                    this.furetMarker = true
                    this.chatMarker = false
                    this.chienMarker = false
                }


                store.commit('Annonce/changeType',event.target.value);

                if(this.type === 'Chat'){

                    this.catRaceMarker = true;
                    this.dogRaceMarker = false;
                    this.furetRaceMarker = false;
                }else if(this.type === 'Chien'){

                    this.catRaceMarker = false;
                    this.dogRaceMarker = true;
                    this.furetRaceMarker = false;

                }else if(this.type === 'Furet'){

                    this.catRaceMarker = false;
                    this.dogRaceMarker = false;
                    this.furetRaceMarker = true;

                }
            },

            setSexVal(event){

                this.dateMarker = true
                store.commit('Annonce/changeSex',event.target.value);
            },

            setColorVal(event){

                this.sexMarker = true
                store.commit('Annonce/changeColor',event.target.value);
            },

            setRaceVal(event){

                this.colorMarker = true
                store.commit('Annonce/changeRace',event.target.value);
            },

            msgOff(){

                this.marker = false;
            },

            sendInformation(){

                this.situationMarker = false
                this.typeMarker = false
                this.sexMarker = false
                this.colorMarker = false
                this.chatMarker = false
                this.chienMarker = false
                this.furetMarker =  false
                this.catRaceMarker = false
                this.dogRaceMarker = false
                this.furetRaceMarker = false
                this.dateMarker = false
                this.btnMarker = false
                this.villeMarker = true
            },


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

    #firstDiv{


        height: 600px;
        width: 700px;
    }

    .selector{

        position: absolute; top:250px; left: 460px;
        display: inline;
        width: 300px;
        height: 40px;
        font-size: 20px;
        border-radius: 10px;
        border: solid 3px darkslategray;
        color: darkslategray;
        text-align: center;
        box-shadow: 5px 5px 12px 1px lightgray;
    }


    .textInput{

        position: absolute; top:295px; left: -200px;
        width: 300px;
        height: 32px;
        font-size: 20px;
        border-radius: 10px;
        border: solid 3px darkslategray;
        color: darkslategray;
        text-align: center;
        box-shadow: 5px 5px 12px 1px lightgray;

    }
    .sendBtn{


        position: absolute; top: 535px; left: 976px;
        background-color: darkslategray;
        border: solid black 1px;
        width: 150px;
        height: 50px;
        cursor: pointer;
        color:white;
        font-size: 23px;
        border-radius: 10px;
        transition: background-color 1s, color 1s;
        box-shadow: 5px 5px 12px 1px lightgray;
        text-decoration: none;

    }

    .sendBtn:hover{

        color: darkslategray;
        background-color: white;

    }

    #alertMsg{

        color: indianred;
        font-family: cursive;
        position: absolute; top: 541px; left: 700px;
        font-weight: bold;
    }

    .msg{

        font-family: cursive;
        position: absolute; left: 460px; top: 210px;
        font-weight: bold;
    }

    #typeSelector{

        position: absolute; top:355px; left: 460px;
    }

    #typeMsg{

        position: absolute; left: 0; top: 110px;
    }

    #rueMsg{

        position: absolute; left: 0; top: 110px;
    }

    #sexSelector{


        position: absolute; top:355px; left: 820px;
    }

    .raceMsg{

        width: 80px;
        position: absolute; left: 0; top: 210px;
    }

    #sexMsg{

        width: 80px;
        position: absolute; left: 365px; top: 110px;
    }

    #colorSelector{

        position: absolute; top:250px; left: 820px;
    }

    #cpInfo{

        position: absolute; top:250px; left: 820px;
    }

    #colorMsg{

        position: absolute; left: 365px;
        width: 100px;
    }

    #villeMsg{
        position: absolute; left: 365px;
        width: 100px;
    }

    #img1{

        width: 200px;
        position: absolute; top: 255px; left: 100px;
    }

    #img2{

        width: 250px;
        position: absolute; top: 215px; left: 50px;
    }

    #img3{

        width: 200px;
        position: absolute; top: 315px; left: 70px;
    }

    .race{

        position: absolute; top:455px; left: 460px;
    }

    #findDate{

        position: absolute; top:450px; left: 820px;
    }

    #dateMsg{

        width: 500px;
        position: absolute; top:210px; left: 365px;
    }


    #rueInfo{

        position: absolute; top:355px; left: 460px;
        width: 645px;
        text-align: left;
        padding-left: 15px;
    }

    #desInfo{

        position: absolute; top:450px; left: 460px;
        width: 645px;
        height: 100px;
        text-align: left;
        padding-left: 15px;
    }

    #descriptionMsg{

        position: absolute; left: 0; top: 205px;
    }

    #sendAnnonce{

        position: absolute; top: 587px; left: 975px;
    }

    #fileLoad{

        padding:8px 10px 10px;
        text-align: center;
        height: 25px;
        position: absolute; top:590px; left: 460px;
        background-color: whitesmoke;
        color: #F56C6C;
        width: 460px;
        cursor: pointer;
    }


</style>
