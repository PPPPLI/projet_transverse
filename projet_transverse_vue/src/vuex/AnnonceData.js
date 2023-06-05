export default {

    namespaced:true,

    actions:{},

    mutations:{

        changeSituation(state,val){

            state.situation = val;
        },

        changeType(state,val){

            state.type = val;
        },

        changeSex(state,val){

            state.sex = val;
        },

        changeColor(state,val){

            state.color = val;
        },

        changeRace(state,val){

            state.race = val;
        },

        changeDate(state,val){

            state.animalDate = val;
        },
        changeNomVille(state,val){

            state.nomVille = val;
        },
        changeCpVille(state,val){

            state.cpVille = val;
        }
    },

    state:{

        situation: '',
        type:'',
        sex:'',
        color:'',
        animalDate:'',
        nom:'',
        race:'',
        nomVille:'',
        cpVille:'',
        rueVille:'',
        description:''
    },

    getters:{}
}