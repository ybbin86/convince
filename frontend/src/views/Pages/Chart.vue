<template>
  <card type="default" header-classes="bg-transparent">
      <b-row align-v="center" slot="header">
        <b-col>
          <h5 class="h3 text-white mb-0">{{info.name}}</h5>
          <h6 class="text-light ls-1 mb-1">{{chartPeriod}}</h6>
        </b-col>
      </b-row>
      <b-row>
        <b-col md="12">
          <line-chart
            ref="bigChart"
            :chart-data="bigLineChart.chartData"
            :extra-options="bigLineChart.extraOptions"
          >
          </line-chart>
        </b-col>
      </b-row>
    </card>
</template>
<script>
  // Charts
  import * as chartConfigs from '@/components/Charts/config';
  import LineChart from '@/components/Charts/LineChart';

  export default {
    components: {
      LineChart
    },
    props: {
      info: {
        id: '',
        name: ''
      }
    },
    data() {
      return {
        //list: this.$sample.chartData,
        bigLineChart: {
          chartData: {},
          extraOptions: chartConfigs.blueChartOptions,
        },
      };
    },
    mounted() {
      this.getData();
    },
    computed: {
      chartPeriod: function() { //오늘 날짜와 오늘로부터 일주일 전 날짜 구하기
        var d = new Date();
        var today = d.toJSON().slice(0,10);

        var dd = d.setDate(d.getDate()-7);
        var beforeDay = new Date(dd).toJSON().slice(0,10);

        return beforeDay + ' ~ ' + today;
      }
    },
    methods: {
      getData() {
        var url="/dashboard/" + this.info.id;

        this.$axios.get(url)
        .then((res) => { //요청 성공  
          let chartData = {
            datasets: [
              {
                label: '금액',
                data: res.data.data
              }
            ],
            labels: res.data.label,
          };
          
          this.bigLineChart.chartData = chartData;
        })
        .catch((error) => { //요청 실패
          console.log("차트 데이터를 불러오는 데 실패하였습니다.");
        });

      }
    }
  };
</script>
<style>
.el-table .cell{
  padding-left: 0px;
  padding-right: 0px;
}
#line-chart {
  height: 400px !important;
}
</style>