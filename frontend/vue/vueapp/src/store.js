
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const store = new Vuex.Store(
    {
        state:{
            user: {
                name: "bob",
                age: 10,
            }
        },
        getters:{
            userProfile: state =>{
                return {
                    name: state.user.name.toUpperCase(),
                    age: state.user.age

                }

            }
        },
        mutations:{
            reduceAge: (state, payload) =>{
                state.user.age -= parseInt(payload);
            }
        },
        actions:{
            reduceAge: (context, payload) =>{
                setTimeout(function(){
                    context.commit("reduceAge", payload);
                }, 1000);
            }
        }

    }
);
