<template>
    <div>
        <img src="../assets/signalPage/1.png"/><br>
        <b id="title">Contact</b>
        <p id="info">info@petfinder.fr | Tél : 01 23 45 67 89</p><br>
        <form id="sendMessage">
            <input type="text" placeholder="Nom" class="inputText" ref="nom" v-model="nomUtilisateur" @focus="off"><b v-show="nomShow" class="info">Veuillez renseigner ce champ</b><br>
            <input type="text" placeholder="E-mail" class="inputText" ref="mail" v-model="mailUtilisateur" @focus="off"><b v-show="mailShow" class="info">Veuillez renseigner un email</b><br>
            <input type="text" placeholder="Téléphone" class="inputText" ref="tel" v-model="telUtilisateur" @focus="off"><b v-show="telShow" class="info">Veuillez renseigner un numéro de téléphone</b><br>
            <textarea placeholder="Rédigez votre message ici..." class="inputText" rows="5" ref="text" v-model="desciptionFeedback" @focus="off"></textarea><b v-show="textShow" class="info">Veuillez renseigner ce champ</b>
            <el-button :plain="true" @click="open2" id="btn">Envoyer</el-button>
        </form>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "NoticeSignaler",
        data(){

            return{
                nomUtilisateur:'',
                mailUtilisateur:'',
                telUtilisateur: '',
                desciptionFeedback:'',
                nomShow:false,
                mailShow:false,
                telShow:false,
                textShow:false
            }
        },
        methods:{


            open2() {


                let val = this.mailUtilisateur.trim();
                let numReg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
                let numRe = new RegExp(numReg);
                let trigger = 0;

                if(this.nomUtilisateur === null || this.nomUtilisateur.trim() === ""){

                    this.nomShow = true;
                    trigger++;
                }
                if(numRe.test(val) !== true || val === null || val === ""){

                    this.mailShow = true;
                    trigger++;
                }

                val = this.telUtilisateur.trim();
                numReg = /^(0|\+33)[1-9]( *[0-9]{2}){4}$/
                numRe = new RegExp(numReg);
                if(val === null || numRe.test(val) !== true || val === ""){

                    this.telShow = true;
                    trigger++;
                }

                if(this.desciptionFeedback === null || this.desciptionFeedback === ""){

                    this.textShow = true;
                    trigger++
                }

                if(trigger !== 0){

                    return;
                }

                axios.get('/api/feedback',

                    {params:{

                                nomUtilisateur:this.nomUtilisateur,
                                mailUtilisateur:this.mailUtilisateur,
                                telUtilisateur:this.telUtilisateur,
                                desciptionFeedback:this.desciptionFeedback

                    }}).then(
                        response => {
                            if(response.data > 0){

                                this.$message({
                                    message: 'Message envoyé',
                                    type: 'success'
                                });
                            }

                            this.nomUtilisateur = '';
                            this.mailUtilisateur = '';
                            this.telUtilisateur = '';
                            this.desciptionFeedback = '';
                        }

                ).catch(error => {

                    console.log(error);
                })

            },

            off(){

                if(this.telShow){

                    this.telUtilisateur = "+33"
                }
                this.nomShow = false;
                this.textShow= false;
                this.telShow = false;
                this.mailShow = false;

            }
        }
    }
</script>

<style scoped>

    img{

        width: 200px;
        position: relative; top: 100px;
        margin-left: 650px;
    }

    #title{

        position: relative; top: 110px;
        font-size: 25px;
        font-family: cursive;
        display: grid;
        align-content: center;
        justify-content: center;
    }

    #info{

        position: relative; top: 100px;
        font-size: 15px;
        color: gray;
        font-family: cursive;
        display: grid;
        align-content: center;
        justify-content: center;
    }

    .inputText{

        position: relative; top: 90px;
        font-size: 15px;
        color: gray;
        font-family: cursive;
        display: inline-grid;
        align-content: center;
        justify-content: center;
        margin-top: 3px;
        margin-left: 520px;
        width: 450px;
        padding-left: 7px;
        padding-top: 5px;
    }

    #btn{

        position: relative; top: 90px;
        font-size: 18px;
        color: white;
        font-family: cursive;
        display: inline-grid;
        align-content: center;
        justify-content: center;
        margin-top: 3px;
        border: solid 1px cadetblue;
        margin-left: 880px;
        width: 100px;
        padding: 10px;
        background-color: cadetblue;
        transition: all 1s;
    }

    #btn:hover{

        background-color: white;
        color: cadetblue;
        border: solid 1px cadetblue;
    }

    .info{
        position: relative; top: 85px;
        margin-left: 10px;
        color: #F56C6C;

    }
</style>