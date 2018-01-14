<template>
  <ve-heatmap :data="chartData" :chartSettings="chartSettings" :visual-map="chartVisualMap" :grid="chartGrid"></ve-heatmap>
</template>

<script>
import VeHeatMap from 'v-charts/lib/heatmap';
export default {
    components:{
        've-heatmap': VeHeatMap,
    },
    created: function () {
      this.chartSettings = {
      };
      this.chartGrid = {
        right: 200,
      }
      this.chartVisualMap = {
        //min: 0,
        max: 10,
        type: 'piecewise',
        right: 0,
        top: '50%'
      },
      this.chartData = {
        columns: ['cab', 'unum', 'value'],
        rows: [
            {cab: '201', unum: 3, value: 10},
            {cab: '202', unum: 4, value: 20},
            {cab: '203', unum: 6, value: 50},
        ]
      }
    }
  }
</script>
