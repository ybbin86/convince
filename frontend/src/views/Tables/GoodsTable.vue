<template>
    <b-card no-body>  
      <b-card-header class="border-0">
          <span class="float-right"><h5>※ 1시간 기준으로 가격이 변동됩니다.</h5></span>
          <h3 class="mb-0">상품목록</h3>
      </b-card-header>

      <el-table class="table-responsive table"
                header-row-class-name="thead-light"
                :data="tableData">
          <el-table-column label="제품이미지"
                            min-width="180px"
                            prop="name">
              <template v-slot="{row}">
                  <b-media no-body class="align-items-center">
                      <a href="#" class="mr-3">
                          <b-img alt="Image placeholder" :src="row.image"  @error="getNoimage"/>
                      </a>
                  </b-media>
              </template>
          </el-table-column>

          <el-table-column label="품목"
                            prop="category_name"
                            min-width="100px">
          </el-table-column>

          <el-table-column label="상품명"
                            prop="name"
                            min-width="200px">
          </el-table-column>

          <el-table-column label="해시태그"
                            min-width="180px"
                            class="hashtag">
            <template v-slot="{row}">
              <b-button type="button" v-for="tag in row.tags" :key="tag" class="hashtag" variant="outline-primary" size="sm">
                <div>
                  <i class="ni">#</i>
                  <span>{{tag}}</span>
                </div>
              </b-button>
            </template>
          </el-table-column>

          <el-table-column :label="label[0]"
                            min-width="230px">
            <template v-slot="{row}">
                    {{row.price}} /
                    <span class="mr-2" type="" :class="`text-${row.sub_price_class}`">
                        <i :class="`ni ni-bold-${row.sub_price_updown}`"></i>
                        <span class="subprice-text">{{row.sub_price | numCommaFilter }} 원</span>
                    </span>
                    <b-button v-b-modal.chart-modal class="ml-3" size="sm" variant="outline-primary" @click="chartInfo = row"><i class="ni ni-chart-bar-32"></i></b-button>
           </template>
          </el-table-column>

          <el-table-column :label="label[1]"
                  min-width="90px"
                  prop="dynamic_margin">
          </el-table-column>

          <el-table-column label="원가"
                            min-width="100px"
                            prop="cost">
          </el-table-column>

          <el-table-column label="마진율"
                            min-width="140px"
                            prop="margin">
          </el-table-column>

          
          <el-table-column :label="label[2]"
                            min-width="100px"
                            prop="margin">
            <template v-slot="{row}">
              <b-form-checkbox switch v-model="row.dynamic_pricing_flag" @change="toggleDyprFlag(row)" ></b-form-checkbox>
            </template>
          </el-table-column>
      </el-table>

      <b-card-footer class="py-4 d-flex justify-content-center">
        <b-pagination v-model="currentPage" :total-rows="total" :per-page="perPage" @change="getGoodsList()"></b-pagination>
      </b-card-footer>

      <!-- Modal -->          
      <b-modal id="chart-modal" title="실시간 가격 변동 차트 (기준 7일)" hide-footer centered >
        <chart :info="chartInfo"></chart>
      </b-modal>
  </b-card>
</template>
<script>
  import { Table, TableColumn} from 'element-ui'
  import Chart from '../Pages/Chart.vue'

  export default {
    name: 'goods-table',
    components: {
      Chart,
      [Table.name]: Table,
      [TableColumn.name]: TableColumn
    },
    data() {
      return {
        currentPage: 1,
        perPage: 10,   
        total: 0,
        //list: this.$sample.goodsList.data,
        list: [],
        label: [`실시간 가격\n(변동가)`, `실시간\n마진율`, `D·P\n 여부`],
        chartInfo: {}
      };
    }, 
    computed: {
      tableData() {
        if(!this.list || this.list.length == 0) {
          return [];
        }

        return this.list.map(d => {
          return {
            ...d,
            dynamic_margin: Math.round(((d.price - d.cost) / d.price * 100) * 100) / 100 + ' %',
            margin: d.margin_min + ' % ~ ' + d.margin_max + ' %',
            cost: this.$options.filters.numCommaFilter(d.cost) + ' 원',
            price: this.$options.filters.numCommaFilter(d.price) + ' 원',
            sub_price: d.price && d.before_price ? d.price-d.before_price : 0,
            sub_price_class: d.price-d.before_price > 0 ? 'danger' : d.price-d.before_price < 0 ? 'info' : '',
            sub_price_updown: d.price-d.before_price > 0 ? 'up' : d.price-d.before_price < 0 ? 'down' : '',
            dynamic_pricing_flag: d.dynamic_pricing == 1 ? true:false,
          }
        });
      }
    },
    created() {
      this.getGoodsList();
    },
    methods: {
      getNoimage(e) {
        e.target.src = require("assets/noimage.jpg");
      },
      toggleDyprFlag(row) {
        this.$nextTick(() => {
          var url="/goods/" + row.id;

          var params = {
            dynamic_pricing: row.dynamic_pricing_flag == true? 1 : 0,
          };

          this.$axios.put(url, params)
          .then((res) => { //요청 성공   
            var msg = 'Dynamic Pricing이 적용 되었습니다.';
            
            if(!row.dynamic_pricing_flag) {
              msg = 'Dynamic Pricing이 해제 되었습니다.';
            }
            this.$swal.fire({
              title: `Success`,
              text: msg,
              buttonsStyling: false,
              confirmButtonClass: 'btn btn-success',
              icon: 'success'
            });
          })
          .catch((error) => { //요청 실패
            this.$swal.fire({
              title: `Fail`,
              text: `요청에 실패하였습니다.`,
              buttonsStyling: false,
              confirmButtonClass: 'btn btn-warning',
              icon: 'warning'
            });
          });
        });
      },
      getGoodsList() {
        this.$nextTick(() => {
          var url="/goods";

          var params = {
            page: this.currentPage-1,
            size: this.perPage,
            sort: 'id:desc'
          };
          
          const token = this.$cookie.get('token');
          this.$axios.get(url, {
            headers: {'jwt-auth-token': token},
            params: {
              page: this.currentPage-1,
              size: this.perPage,
              sort: 'id:desc'
            }
          })
          .then((res) => { //요청 성공 
            this.total = res.data.total;
            this.list = res.data.data;
          })
          .catch((error) => { //요청 실패
            console.log("상품 목록을 불러오는 데 실패하였습니다.");
          });
        });
      }
    }
  }
</script>

<style scoped>
img {
  width: 150px;
  height: 150px;
}
.ni-bold-up {
  vertical-align: revert;
}
.ni-bold-down {
  vertical-align: middle;
}
.custom-switch {
  display: grid;
}
</style>