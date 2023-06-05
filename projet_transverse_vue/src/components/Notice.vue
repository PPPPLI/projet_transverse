<template>

    <div id="v">

        <router-link :to="{
            name:'Mentions',

        }" id="text1"><i class="el-icon-document"></i> Mentions légales
        </router-link>

        <router-link :to='{
            name: "Politique",

        }' id="text2"><i class="el-icon-notebook-1"></i> Politique de confidentialité
        </router-link>

        <router-link :to="{
            name:'cookies',

        }" id="text3"><i class="el-icon-notebook-2"></i> Politique de cookies
        </router-link>

        <router-link :to="{
            name:'signaler'
        }" id="text4"><i class="el-icon-loading"></i> Nous signaler</router-link>

    </div>

</template>

<script>

    export default {
        name: "NoticeMain",
        computed:{


        }

    }
</script>

<style scoped>


    #text1{

        display: inline;
        color: #F56C6C;
        font-family: cursive;
        text-decoration: none;
        margin-left: 400px;
    }

    #text2{

        display: inline;
        color: #F56C6C;
        font-family: cursive;
        text-decoration: none;
        margin: 0px 15px 0px;

    }

    #text3{

        display: inline;
        color: #F56C6C;
        font-family: cursive;
        text-decoration: none;
        margin: 0px 10px 0px;

    }

    #text4{

        display: inline;
        color: #F56C6C;
        font-family: cursive;
        text-decoration: none;
        margin: 0px 10px 0px;
    }

    #text1:hover, #text2:hover, #text3:hover, #text4:hover{

        color: #634A4A;
    }


    #v{

        display: inline-block;
        justify-content: center;
        align-content: center;
        position: relative; bottom: 10px; top: 150px;


    }



</style>