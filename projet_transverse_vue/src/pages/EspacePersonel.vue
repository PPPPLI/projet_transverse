<template>
    <div id="mainDiv">
        <div id="left">
        <span id="title">BIENVENUE {{userState}}</span><br/>

        <router-link to='/espace/update' class="link">Mes informations</router-link>

        <router-link :to="{

        }" class="link" @click.native="signOut">Déconnexion</router-link>

        <el-button type="text" class="link"  @click="dialogVisible = true">Supprimer mon compte</el-button>
        <el-dialog
            :center = "true"
            :roundButton="true"
            :closeOnPressEscape="true"
            :visible.sync="dialogVisible"
            width="35%"
            :modal-append-to-body= "false" id="confirmWindow"
            top="30vh">
            <span  id="msg">Êtes-vous sûr de vouloir supprimer votre compte Petfinder ?</span>
            <span slot="footer" class="dialog-footer,link">
                <el-button type="primary" @click.native="confirmDelete" class="confirmBtn" id="checkBtn">Oui, je suis sûr(e)</el-button>
                <el-button @click="dialogVisible = false" class="confirmBtn" id="cancelBtn">Non, je reste inscrit(e)</el-button>

            </span>
        </el-dialog>
        <hr id="separator">
        </div>
        <div id="right">
            <router-view></router-view>
        </div>


    </div>
</template>

<script>

    import {mapState,mapMutations} from "vuex";
    import axios from "axios";
    import Store from '@/vuex/Store';

    export default {
        name: "EspacePersonel",

        data() {
            return {
                dialogVisible: false
            };
        },

        computed:{

            ...mapState('InscriptionButton',['userState',''])
        },

        methods:{

            ...mapMutations('InscriptionButton',['changeSize','reChangeSize','changeUsername','changeConnectionBtn']),

            confirmDelete(){

                axios.get('/api/userdelete', {
                    params:{
                        email: this.$cookies.get('email'),
                        pwd: this.$cookies.get('pwd')
                    }
                }).then(response=>{

                    if(response.data > 0){

                        this.$message({
                            message: 'Compte supprimé',
                            type: 'success'
                        });

                        this.dialogVisible = false
                        this.$cookies.remove('email');
                        this.$cookies.remove('pwd');
                        Store.commit('InscriptionButton/changeUsername','Connexion');
                        Store.commit('InscriptionButton/changeConnectionBtn', true);
                        this.$router.push('/');
                    }else{

                        this.$message({
                            message: 'Echoué',
                            type: 'error'
                        });
                    }
                }).catch(error => {

                    console.log(error);
                })
            },

            signOut(){

                this.changeUsername('Connection');
                this.changeConnectionBtn(true);
                this.$router.push("/");
            }
        }
    }
</script>

<style scoped>

    #mainDiv{

        position: relative; top: 80px;
        background-color: white;
        height: 800px;
        width: 250px;
        border-right: solid lightgray 1px;
    }

    #title{

        font-family: cursive;
        font-size: 15px;
        font-weight: bolder;
        margin-left: 30px;
        display: grid;
        justify-content: left;

    }

    .link{


        display: grid;
        justify-content: left;
        font-family: cursive;
        font-size: 15px;
        position: relative; top: 20px;
        text-decoration: none;
        color: gray;
        margin-bottom: 15px;
        cursor: pointer;
        margin-left: 30px;

    }

    .link:hover{

        color: #F56C6C;
        text-decoration-line: underline;
        text-underline-offset: 5px;
    }

    #separator{

        position: relative; top: 30px;
        border: 1px dashed lightgray;
    }

    .confirmBtn{

        position: relative; bottom: 5px;
        font-family: cursive;
        font-size: 15px;
        border-radius: 5px;
        transition: color 1s , background-color 1s
    }

    #checkBtn{

        background-color: white;
        color: gray;
        border: solid white 1px;


    }

    #checkBtn:hover{

        color:red;
        border: solid red 1px;
    }

    #cancelBtn:hover{

        background-color: white;
        color: #F56C6C;
        border: #F56C6C solid 1px;
    }

    #cancelBtn{

        background-color: #F56C6C;
        color: white;
        border: #F56C6C solid 1px;
    }

    #msg{

        position: relative; left: 10px;
        font-family: cursive;
        font-size: 16px;
        font-weight: bolder;
        color: #F56C6C;
        display: inline;
        justify-content: center;
        align-content: center;
    }



</style>