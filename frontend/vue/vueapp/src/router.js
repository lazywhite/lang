import Vue from 'vue'
import VueRouter from "vue-router"
import UserProfile from "./components/UserProfile.vue"
import UserMain from "./components/UserMain.vue"
import UserIndex from "./components/UserIndex.vue"
import User from "./components/User.vue"
Vue.use(VueRouter);

const routes = [
    { path: "/user", component: User, children:[
        {path: "", component: UserIndex},
        {name: "userProfile", path: "profile", component: UserProfile},
        {path: "main", component: UserMain},
    ]}
]
export const router = new VueRouter({
    routes: routes,
    mode: "history"
})
