<template>
  <div>
    <base-header class="pb-6 pb-8 pt-5 pt-md-6 bg-gradient-success">
      <!-- Card stats -->
      <b-row>
            <b-col xl="12" md="12" class="mb-4">
                <div class="top3-title"> 8월 판매량 TOP3 </div>
            </b-col>
        </b-row>
      <b-row>
        <b-col xl="4" md="12" v-for="(item, index) in list" :key="index">
            <b-card class="text-center mb-4" >
                <b-card-title>
                        TOP {{index+1}}
                </b-card-title>
                
                <!-- Card body -->
                <b-row align-v="center">
                    <b-col md="auto">
                        <div class="top3-image-div avatar">
                            <b-img :src="item.image"
                            fluid
                            class="img-center shadow shadow-lg--hover top3-image"/>
                        </div>
                    </b-col>
                    <b-col class="ml--2">
                        <h2 class="mb-2">
                            <a href="javascript:;">{{item.name}}</a>
                        </h2>
                        <h2 class="text-muted mb-4">{{item.price | numCommaFilter}} 원</h2>
                        <b-button type="button" v-for="hash in item.tags" :key="hash" class="hashtag" variant="outline-primary" size="sm">
                        <div>
                            <i class="ni">#</i>
                            <span>{{hash}}</span>
                        </div>
                        </b-button>
                    </b-col>
                </b-row>
            </b-card>
        </b-col>
      </b-row>
    </base-header>
    <b-container fluid class="mt--7">
      <b-row>
        <b-col>
          <goods-table/>
        </b-col>
      </b-row>
      <div class="mt-5"></div>
    </b-container>
  </div>
</template>
<script>
  import GoodsTable from "../Tables/GoodsTable";

  export default {
    components: {
      GoodsTable,
    },
    data() {
      return {
        list: this.$sample.goodsList.data
      };
    },
    created() {
    },
     methods: {
      getNoimage(e) {
        e.target.src = require("assets/noimage.jpg");
      }
    }
  };
</script>
<style>
.top3-title {
    width: 200px;
    height: 40px;
    line-height: 40px;
    background: #fff;
    text-align: center;
    margin: 0 auto;
    font-weight: bold;
    border: 1px solid rgba(0, 0, 0, 0.05);
    border-radius: 0.375rem;
}
.card-title  {
    font-size: 1.25rem;
    color: #512772;
}

h2 a{
  color: #59368F;
}

.top3-image-div {
    width: 150px;
    height: 150px;
    overflow: hidden;
}
.top3-image {
    width: 150px;
    min-height: 150px;
}
</style>
