<template>
    <div>
        <h1>this is user index</h1>
        <button @click="getJson">click</button>
    </div>
</template>
<script>
    export default {
        data(){
            return {
                info: {}
            }
        },
        methods:{
            getJson: function(){
                const root = 'http://jsonplaceholder.typicode.com'; 
                this.axios.get(root + '/posts/1').then(response =>{
                    this.info = response.data;
                    //console.log(response);
                });
                //this.$router.push({path: '/user/profile'})
                this.$router.push({name: 'userProfile'})
            }
        }
    }
</script>
