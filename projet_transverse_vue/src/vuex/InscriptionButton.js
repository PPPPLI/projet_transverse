export default {

    namespaced:true,

    mutations:{

        updateInscription(state){

            state.showInscription = !this.state.showInscription;
        },

        changeSize(state){

            state.changeBackground = false;
        },

        reChangeSize(state){

            state.changeBackground = true;
        },

        changeUsername(state,newName){

            state.userState = newName;
        },

        changeConnectionBtn(state,newState){

            state.connectionBtnState = newState;
        }
    },

    state:{

        showInscription: false,
        changeBackground: true,
        userState: 'Connexion',
        connectionBtnState: true

    }
}