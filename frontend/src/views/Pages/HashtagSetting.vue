<template>
  <div>
    <base-header class="pb-6 pb-8 pt-5 pt-md-6 bg-gradient-success">
      <!-- Card stats -->
      <b-card class="hashtag-add-card">
      <b-row>
        <b-col xl="5" md="12">
            <label for="example-date-input" class="col-md-12 col-form-label form-control-label">해시태그명</label>
            <b-col md="12">
                <b-form-input list="my-list-id" v-model="hashtag.name"></b-form-input>

                <datalist id="my-list-id">
                    <option v-for="item in list" :key="item">{{ item.name }}</option>
                </datalist>
            </b-col>
        </b-col>
        <b-col xl="3" md="12">
            <label for="example-date-input" class="col-md-12 col-form-label form-control-label">시작일</label>
            <b-col md="12">
            <base-input type="date" v-model="hashtag.start_date" id="example-date-input"/>
            </b-col>
        </b-col>
        <b-col xl="3" md="12">
            <label for="example-date-input" class="col-md-12 col-form-label form-control-label">종료일</label>
            <b-col md="12">
            <base-input type="date" v-model="hashtag.end_date" id="example-date-input"/>
            </b-col>
        </b-col>
         <b-col xl="1" md="12" class="hashtag-add-col text-right">
            <b-button  class="hashtag-add-button" variant="outline-primary" @click="addHashtag">등록하기</b-button>
         </b-col>
      </b-row>
      <!-- <b-row>
        <b-col><b-button></b-button></b-col>
    </b-row> -->
      </b-card>
    </base-header>
    <b-container fluid class="mt--7">
      <b-row>
        <b-col>
          <hashtag-table ref="hashtagTable"/>
        </b-col>
      </b-row>
      <div class="mt-5"></div>
    </b-container>
  </div>
</template>
<script>
  import HashtagTable from "../Tables/HashtagTable";

  export default {
    components: {
      HashtagTable,
    },
    data() {
      return {
        hashtag: {
          name: '',
          start_date: '',
          end_date: ''
        },
        //list: this.$sample.hashtagList
        list: []
      };
    },
    created() {
      this.getHashtagList();
    },
    methods: {
      getHashtagList() {
        var url="/tag";

        this.$axios.get(url)
        .then((res) => { //요청 성공   
          this.list = res.data;
        })
        .catch((error) => { //요청 실패
        });
      },
      addHashtag() {
        if(!this.hashtag.name || !this.hashtag.start_date || !this.hashtag.end_date) {
          this.$swal.fire({
            title: `Fail`,
            text: `입력하지 않은 값이 있습니다.`,
            buttonsStyling: false,
            confirmButtonClass: 'btn btn-warning',
            icon: 'warning'
          });

          return;
        }

        var url="/tag";
        var params = this.hashtag;
        
        this.$axios.post(url, params)
        .then((res) => { //요청 성공     
        
          this.$refs.hashtagTable.getHashtagList();    
          this.hashtag = [];

          this.$swal.fire({
            title: `Success`,
            text: '등록에 성공하였습니다.',
            buttonsStyling: false,
            confirmButtonClass: 'btn btn-success',
            icon: 'success'
          });
          
        })
        .catch((error) => { //요청 실패
          this.$swal.fire({
            title: `Fail`,
            text: `등록에 실패하였습니다.`,
            buttonsStyling: false,
            confirmButtonClass: 'btn btn-warning',
            icon: 'warning'
          });
        });
      },
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

.hashtag-add-col {
    line-height: 7.7;
}


</style>
