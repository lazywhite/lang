<template>
    <div>
        {{test}}
        <h1>this is user profile</h1>
        <user-main >
        </user-main>
        <user-photo>
        </user-photo>
    </div>
</template>
<script>
    import UserMain from './UserMain.vue';
    import UserPhoto from './UserPhoto.vue';
    import Mixins from '../mixins'
    export default {
        components: {
            'user-main': UserMain,
            'user-photo': UserPhoto,
        },
        mixins: [Mixins],
        computed:{
            test:function(){
                return this.greet("bob");
            }
        }

    }

</script>
