<template>
    <div>
        <h1>this is user photo {{ userProfile.age}}</h1>
    </div>
</template>
<script>
    import {mapGetters} from 'vuex';
    export default {
        computed:{
            ...mapGetters([
                'userProfile'
            ])
        }
    }
</script>
