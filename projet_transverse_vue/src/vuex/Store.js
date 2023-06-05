import vuex from 'vuex'
import vue from 'vue'

vue.use(vuex);

import InscriptionButton from "./InscriptionButton";
import Annonce from "./AnnonceData";
export default new vuex.Store({

    modules:{

        InscriptionButton,Annonce
    }

})
