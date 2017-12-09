export default{
    computed:{
        user: function() {
            return this.$store.state.user;
        }
    },
    methods:{
        greet(val){
            return 'akdjf' + val;
        }
    }
    
}
