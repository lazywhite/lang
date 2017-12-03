<template>
    <div>
        <h1>this is user main {{userProfile.name}}</h1>
        <slot name="extra"
    </div>
</template>
<script>
    import {mapGetters} from "vuex"; 
    export default {
        computed:{
            ...mapGetters([
                'userProfile'
            ])
        }
    }
</script>
