import Vuerouter from 'vue-router'
import Main from '../pages/AccueilPage'
import Notice from '../pages/NoticeText'
import Politique from '../pages/NoticePolitique'
import cookies from "@/pages/cookies";
import signaler from "@/pages/Signaler";
import inscription from '../pages/Inscription'
import connection from '../pages/Connection'
import espacePersonel from "@/pages/EspacePersonel";
import infoUpdate from "@/pages/InfoUpdate";
import annonce from "../pages/Annonce";
import perdu from "@/pages/Perdu";
import retrouver from "@/pages/Retrouver";

const router = new Vuerouter({

    routes:[



        {
            path:'/',
            name:'main',
            component: Main
        },

        {
            path:'/Mentions/',
            name:'Mentions',
            component:Notice,

        },

        {
            path:'/Politique/',
            name:'Politique',
            component:Politique,

        },

        {
          path:'/cookies/',
          name:'cookies',
          component:cookies,

        },

        {
            path:'/signaler/',
            name:'signaler',
            component:signaler
        },

        {
            path:'/inscription/',
            name:'inscription',
            component:inscription
        },

        {
            path:'/connection',
            name:'connection',
            component:connection
        },

        {
            path:'/espace',
            component:espacePersonel,
            children:[

                {path:'update', component:infoUpdate}

            ]
        },

        {
            path:'/annonce',
            name:'annonce',
            component:annonce
        },

        {
            path:'/perdu',
            name:'perdu',
            component:perdu
        },

        {
            path:'/retrouver',
            name:'retrouver',
            component:retrouver
        }

    ]

})

router.afterEach(() => {

    window.scrollTo(0,0)
})

export default router;