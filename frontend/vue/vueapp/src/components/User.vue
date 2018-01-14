<template>
<div>
    <p>main User</p>
    <button @click="reduceAge(2)">reduce age</button>
    <ve-line :data="chartData"></ve-line>
    <router-view></router-view>

    <heatmap></heatmap>
</div>

</template>
<script>
    import {mapActions} from "vuex"; 
	import VeLine from 'v-charts/lib/line';
	import HeatMap from './HeatMap.vue';
    export default {
        data(){
            return {
                chartData:{

					columns: ['日期', '销售量'],
					rows: [
						{ '日期': '1月1日', '销售量': 123 },
						{ '日期': '1月2日', '销售量': 1223 },
						{ '日期': '1月3日', '销售量': 2123 },
						{ '日期': '1月4日', '销售量': 4123 },
						{ '日期': '1月5日', '销售量': 3123 },
						{ '日期': '1月6日', '销售量': 7123 }
					]
                }
            }
        },
		components:{
			've-line': VeLine,
			'heatmap': HeatMap,
		},
        watch: {
            '$route' (to, from){
                console.log(to, from);
            }
        },        
        created: function(){
            console.log("created");
        },
        mounted: function(){
            console.log("mounted");
        },
        methods: {
            ...mapActions([
                'reduceAge'
            ]),
        }
    }
</script>
