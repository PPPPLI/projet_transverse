<template>
    <div id="firstDiv">
        <img id="img1" :src="srcs" class="imgAnimal">
        <pre id="span1" class="spanAnimal">
            Type:    <span>{{animals[0]}}</span><br>
            Sexe:    <span>{{animals[1]}}</span><br>
            Color:   <span>{{animals[2]}}</span><br>
            Race:    <span>{{animals[3]}}</span><br>
            Etat:    <span>{{animals[4]}}</span>
        </pre>
        <pre id="span11" class="spanAnimal">
            Ville:    <span>{{animals[5]}}</span><br>
            Code postal:    <span>{{animals[6]}}</span><br>
            Rue:    <span>{{animals[7]}}</span><br>
            Date de perte:   <span>{{animals[8]}}</span><br>
            Description:    <span>{{animals[9]}}</span>
        </pre>
        <button class="sendBtn" id="btn2" v-show="restMarker2" @click="change2">Signaler la découverte</button>
        <p id="p1" v-show="!restMarker1">Merci de votre message, nous allons vous contacter dans un bref délais</p>
        <hr id="hr1">


        <img id="img2" src="../assets/upload/4.jpg" class="imgAnimal">
        <pre id="span2" class="spanAnimal">
            Type:    <span>Chien</span><br>
            Sexe:    <span>Mâle</span><br>
            Color:   <span>Roux et blanc</span><br>
            Race:    <span>Shih Tzu</span><br>
            Etat:    <span>Perdu</span>
        </pre>
        <pre id="span22" class="spanAnimal">
            Ville:    <span>Ajaccio</span><br>
            Code postal:    <span>20000</span><br>
            Rue:    <span>20 Rue de vannes</span><br>
            Date de perte:    <span>2023-05-07</span><br>
            Description:    <span>Test</span>
        </pre>
        <button class="sendBtn" id="btn3" v-show="restMarker3" @click="change3">Signaler la découverte</button>
        <p id="p2" v-show="!restMarker2">Merci de votre message, nous allons vous contacter dans un bref délais</p>
        <hr id="hr2">


        <img id="img3"  src="../assets/upload/1.jpg" class="imgAnimal">
        <pre id="span3" class="spanAnimal">
            Type:    <span>Chat</span><br>
            Sexe:    <span>Mâle</span><br>
            Color:   <span>Roux et blanc</span><br>
            Race:    <span>Chat de la maison</span><br>
            Etat:    <span>Perdu</span>
        </pre>
        <pre id="span33" class="spanAnimal">
            Ville:    <span>Paris</span><br>
            Code postal:    <span>75000</span><br>
            Rue:    <span>15 grande boulevard</span><br>
            Date de perte:    <span>2023-01-25</span><br>
            Description:    <span>Test</span>
        </pre>
        <button class="sendBtn" id="btn4" v-show="restMarker4" @click="change4">Signaler la découverte</button>
        <p id="p3" v-show="!restMarker3">Merci de votre message, nous allons vous contacter dans un bref délais</p>

        <hr id="hr3">



        <img id="img4" src="../assets/upload/2.jpg" class="imgAnimal">
        <pre id="span4" class="spanAnimal">
            Type:    <span>Chat</span><br>
            Sexe:    <span>Femelle</span><br>
            Color:   <span>Gris</span><br>
            Race:    <span>Siamois</span><br>
            Etat:    <span>Perdu</span>
        </pre>
        <pre id="span44" class="spanAnimal">
            Ville:    <span>Albi</span><br>
            Code postal:    <span>81000</span><br>
            Rue:   <span>20 Rue de rospierre</span><br>
            Date de perte:    <span>2023-03-16</span><br>
            Description:    <span>Test</span>
        </pre>
        <button class="sendBtn" id="btn5" v-show="restMarker5" @click="change5">Signaler la découverte</button>
        <p id="p4" v-show="!restMarker4">Merci de votre message, nous allons vous contacter dans un bref délais</p>

        <hr id="hr4">


        <img id="img5"  src="../assets/upload/3.jpg" class="imgAnimal">
        <pre id="span5" class="spanAnimal">
            Type:    <span>Chat</span><br>
            Sexe:    <span>Femelle</span><br>
            Color:   <span>Tricolore</span><br>
            Race:    <span>Chat de la maison</span><br>
            Etat:    <span>Perdu</span>
        </pre>
        <pre id="span55" class="spanAnimal">
            Ville:    <span>Amiens</span><br>
            Code postal:    <span>80000</span><br>
            Rue:    <span>50 rue de vanves</span><br>
            Date de perte:    <span>2023-05-21</span><br>
            Description:    <span>Test</span>
        </pre>
        <button class="sendBtn" id="btn1" v-show="restMarker1" @click="change1">Signaler la découverte</button>
        <p id="p5" v-show="!restMarker5">Merci de votre message, nous allons vous contacter dans un bref délais</p>
        <div class="block" id="pagenation">
            <el-pagination
                id="main"
                background
                layout="prev, pager, next"
                :total="100">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "RetrouverAnimal",
        data(){
            return{

                animals:["","","","","","","","","",""],
                srcs:'',
                restMarker1:true,
                restMarker2:true,
                restMarker3:true,
                restMarker4:true,
                restMarker5:true
            }
        },

        methods:{
            change1(){

                this.restMarker1 = false;
            },
            change2(){

                this.restMarker2 =false;
            },
            change3(){

                this.restMarker3 =false;
            },
            change4(){

                this.restMarker4 =false;
            },
            change5(){

                this.restMarker5 =false;
            }
        },

        mounted() {

            axios.get('/api/getanimal',{

                params:{

                    etat:'perdu'
                }
            }).then(
                response=>{
                    if(response.data.length > 0){

                        for (let i = 0; i <response.data.length ; i++){
                            this.srcs = response.data[0].photoAnimal;
                            this.srcs = require("@/assets/upload/" + this.srcs)
                            this.animals[0] = response.data[0].typeAnimal;
                            this.animals[1] = response.data[0].sexeAnimal
                            this.animals[2] = response.data[0].couleurAnimal
                            this.animals[3] = response.data[0].raceAnimal;
                            this.animals[4] = response.data[0].etatAnimal
                            this.animals[5] = response.data[0].localisation.villeLocalisation
                            this.animals[6] = response.data[0].localisation.cpLocalisation
                            this.animals[7] = response.data[0].localisation.rueLocalisation
                            this.animals[8] = response.data[0].dateAnimal
                            this.animals[8] = new Date(this.animals[8]).toDateString()
                            this.animals[9] = response.data[0].descriptionAnimal

                        }

                    }
                }
            )
        }
    }
</script>

<style scoped>

.imgAnimal{

    width: 200px;
    height: 200px;
    border: solid 1px;
}

.spanAnimal{

    font-family: cursive;
    font-size: 16px;

}

span{

    color: #F56C6C;
}

#firstDiv{

    height: 1550px;
}

#img1{

    position: absolute; top: 200px; left: 420px;
}

#span1{

    position: absolute; top: 180px; left: 660px;
}

#span11{

    position: absolute; top: 180px; left: 920px;
}

hr{

    position: relative; top: 350px;left: 80px;
    text-align: center;
    width: 1000px;
    color: darkgrey;
}

#hr2{

    position: relative; top: 650px;left: 80px;
}

#hr3{

    position: relative; top: 950px;left: 80px;
}

#hr4{

    position: relative; top: 1250px;left: 80px;
}

#img2{

    position: absolute; top: 510px; left: 1050px;
}

#span2{

    position: absolute; top: 500px; left: 385px;
}

#span22{

    position: absolute; top: 500px; left: 600px;
}

#img3{

    position: absolute; top: 820px; left: 420px;
}

#span3{

    position: absolute; top: 800px; left: 660px;
}

#span33{

    position: absolute; top: 800px; left: 920px;
}

#img4{

    position: absolute; top: 1130px; left: 970px;
}

#span4{
    position: absolute; top: 1120px; left: 385px;
}

#span44{
    position: absolute; top: 1120px; left: 600px;
}

#img5{

    position: absolute; top: 1450px; left: 420px;
}

#span5{

    position: absolute; top: 1430px; left: 660px;
}

#span55{

    position: absolute; top: 1430px; left: 920px;
}


#main{

    position: absolute; top: 1750px; left: 600px;
}



.sendBtn{


    position: absolute; top: 410px; left: 420px;
    background-color: darkslategray;
    border: solid black 1px;
    width: 200px;
    height: 30px;
    cursor: pointer;
    color:white;
    font-size: 17px;
    border-radius: 10px;
    transition: background-color 1s, color 1s;
    box-shadow: 5px 5px 12px 1px lightgray;
    text-decoration: none;
}

.sendBtn:hover{

    color: darkslategray;
    background-color: white;

}

p{
    position: absolute; top: 405px; left: 420px;
    font-size: 18px;
    color: red;
    border-bottom: solid 1px;
    font-weight: bold;
}
#btn2{

    position: absolute; top: 720px; left: 1053px;
}

#btn3{

    position: absolute; top: 1030px; left: 420px;
}

#btn4{

    position: absolute; top: 1340px; left: 972px;
}

#btn5{

    position: absolute; top: 1660px; left: 420px;
}

#p2{
    position: absolute; top: 720px; left: 800px;
}

#p3{
    position: absolute; top: 1030px; left: 420px;
}

#p4{
    position: absolute; top: 1340px; left: 800px;
}

#p5{

    position: absolute; top: 1660px; left: 420px;
}

</style>