<template>

    <div>
        <a style="text-decoration: none; color: #F56C6C" href="PageAccueilHeader.vue">
            <h2 id="footer">© PetFinder </h2>
        </a>
    </div>

</template>

<script>
export default {
    name: "AccueilFooter"
}
</script>

<style scoped>


    div{


        position: relative; bottom: 0;left: 0; top: 170px;
        display: grid;
        justify-content: center;
        align-content: center;
        color: #F56C6C;
        font-family: cursive;
        z-index: 200;
        height: 50px;

    }

    #footer{
        margin: 0px 0px 5px auto;
    }

</style>