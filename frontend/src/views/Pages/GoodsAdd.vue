<template>
  <div>
    <base-header class="pb-6 pb-8 pt-5 pt-md-6 bg-gradient-success">
    </base-header>
    
    <b-container fluid class="mt--6">
      <b-row>
        <!-- 이미지 정보 -->
        <b-col xl="4" class="order-xl-1 mb-5">
          <b-card>
            <b-row align-v="center" slot="header" >
              <b-col cols="8">
                <h3 class="mb-0">대표 이미지 </h3>
              </b-col>
            </b-row>
              <b-img class="popupImageItem mb-3" :src="previewImageFile" @error="getNoimage"/>
              <b-form-file
              id="file1"
              accept="image/*"
              v-model="file1"
              :state="Boolean(file1)"
              placeholder="Choose a file or drop it here..."
              drop-placeholder="Drop file here..."
              @change="onFileSelected"
              plain
              ></b-form-file>
          </b-card>
        </b-col>

        <b-col xl="8" class="order-xl-2">
            <card>
              <b-row align-v="center" slot="header" >
                <b-col cols="8">
                  <h3 class="mb-0">상품 정보</h3>
                </b-col>
              </b-row>

              <b-form>
                <h6 class="heading-small text-muted mb-2">기본 정보</h6>

                <div class="pl-lg-4 mb-4">
                  <b-row>
                    <b-col md="12">
                      <base-input
                        type="text"
                        label="상품명"
                        placeholder="상품명"
                        v-model="prd.name"
                      >
                      </base-input>
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col lg="6">
                      <base-input label="상위 카테고리">
                        <b-form-select v-model="prd.category1" :options="category1" @change="getCategoryList2"></b-form-select>
                      </base-input>
                    </b-col>
                    <b-col lg="6">
                      <base-input label="하위 카테고리">
                        <b-form-select v-model="prd.category_id" :options="category2"></b-form-select>
                      </base-input>
                    </b-col>
                  </b-row>
                </div>

                <h6 class="heading-small text-muted mb-2">추가 정보</h6>
                <div class="pl-lg-4">
                  <b-row>        
                    <b-col lg="12">
                        <label class="form-control-label">
                          해시태그(복수선택가능)
                          </label>
                        <b-badge class="ml-2" variant="primary" v-b-tooltip.hover.right title="해시태그 선택 시 해당되는 날짜가 되면 상품 가격 산출에 영향을 줍니다.">도움말</b-badge>
                        
                        <b-form-tags
                          id="tags-component-select"
                          v-model="prd.seledtedTags"
                          size="lg"
                          class="mb-2"
                          add-on-change
                          no-outer-focus
                        >
                          <template v-slot="{ tags, inputAttrs, inputHandlers, disabled, removeTag }">
                            <ul v-if="tags.length > 0" class="list-inline d-inline-block mb-2">
                              <li v-for="tag in tags" :key="tag" class="list-inline-item">
                                <b-form-tag
                                  @remove="removeTag(tag)"
                                  :title="tag"
                                  :disabled="disabled"
                                  variant="info"
                                  class="mb-2"
                                ># {{ tag }}</b-form-tag>
                              </li>
                            </ul>
                            <b-form-select  
                              v-bind="inputAttrs"
                              v-on="inputHandlers"
                              :disabled="disabled || availableOptions.length === 0" 
                            >
                            <template #first>
                              <option v-for="(item, index) in availableOptions" :key="index" :attr="item.id">{{ item.name }}</option>
                            </template>
                            </b-form-select>
                          </template>
                        </b-form-tags> 
                    </b-col>     
                  </b-row>
                </div>
    
                <hr class="my-4">
                <h6 class="heading-small text-muted mb-2">가격 정보</h6>

                <div class="pl-lg-4">
                  <b-row>
                    <b-col lg="6">
                      <base-input
                        type="number"
                        label="원가(매입가)"
                        placeholder="0"
                        v-model="prd.cost"
                      >
                      </base-input>
                    </b-col>
                    <b-col lg="3">
                      <base-input
                        type="number"
                        label="마진율 하한"
                        placeholder="30"
                        v-model="prd.margin_min"
                      >
                      </base-input>
                    </b-col>
                    <b-col lg="3">
                      <span class="wave">~</span>
                      <base-input
                        type="number"
                        label="마진율 상한"
                        placeholder="50"
                        v-model="prd.margin_max"
                      >
                      </base-input>
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col md="12" class="text-right mb-3">
                      <b-button type="button" class="hashtag" variant="primary" @click="getPredictPrice" :disabled="predictBtnDisabled">
                        <div>
                          <i class="ni ni-button-play"></i>
                          <span>예상 적정가 산출</span>
                        </div>
                      </b-button>
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col md="6">
                    </b-col>
                    <b-col lg="3">
                      <base-input
                        type="number"
                        label="판매가"
                        placeholder="0"
                        v-model="prd.price"
                      >
                      </base-input>
                    </b-col>
                    <b-col lg="3">
                      <label class="form-control-label">
                        마진율
                      </label>
                      <div class="margin-rate-div form-control">{{margin_rate}}   %</div>
                    </b-col>
                  </b-row>
                  
                  <b-row class="mt-3">        
                    <b-col xl="12" md="12" class="hashtag-add-col text-right">
                        <b-button class="hashtag-add-button btn-kurly" @click="addGoods">등록하기</b-button>
                    </b-col>
                  </b-row>
                </div>

              </b-form>
            </card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
  export default {
    components: {
    },
    data() {
      return {
        file1: null,
        previewImageFile: '',
        prd: {
          image: '',
          name: '',
          category1: '', //상위 카테고리
          category_id: '', //하위 카테고리
          email: this.$cookie.get("user")? JSON.parse(this.$cookie.get("user")).email: '',
          seledtedTags: [],
          tags: [],
          cost: '',
          margin_min: '',
          margin_max: '',
          price: ''
        },
        options: ['Apple', 'Orange', 'Banana', 'Lime', 'Peach', 'Chocolate', 'Strawberry'],
        value: [],
        //category1: this.$sample.categoryList1,
        //category2: this.$sample.categoryList2
        //hashtagList: this.$sample.hashtagList
        category1: [],
        category2: [],
        hashtagList: [],
      }
    },
    computed: {
      availableOptions() {
        return this.hashtagList.filter(item => this.prd.seledtedTags.indexOf(item.name) === -1)
      },
      margin_rate() {
        if(this.prd.price == 0 || this.prd.cost == 0) { return 0; }
        var margin = Math.round(((this.prd.price - this.prd.cost) / this.prd.price * 100) * 100) / 100;
        return margin;
      },
      predictBtnDisabled() {
        if(!!this.prd.category_id && this.prd.cost > 0 && this.prd.margin_min > 0 && this.prd.margin_max > 0 && Number(this.prd.margin_min) <= Number(this.prd.margin_max)) {
          return false;
        }
        return true;
      }
    },
    created() {
      this.getCategoryList1();
      this.getHashtagList();
    },
    methods: {
      getNoimage(e) {
        e.target.src = require("assets/noimage.jpg");
      },
      onFileSelected(event){
          var input = event.target;
          if (input.files && input.files[0]) {              
              var reader = new FileReader();
              reader.onload = (e) => {
                      this.previewImageFile = e.target.result;
              }             
              reader.readAsDataURL(input.files[0]);
          }
      },
      getCategoryList1() {
        var url = "category/1";
        var params = {
          parent_id: 0
        };

        this.$axios.get(url, {params})
          .then((res) => { //요청 성공   
            this.category1 = res.data;

            this.category1 = this.category1.map(d => {
              return {
                ...d,
                value: d.id,
                text: d.name
              }
            });
          })
          .catch((error) => { //요청 실패
            console.log("상위 카테고리 목록을 가져오는 데 실패하였습니다.");
          });
      },
      getCategoryList2() {
        var url = "category/2";
        var params = {
          parent_id: this.prd.category1
        };

        this.$axios.get(url, {params})
          .then((res) => { //요청 성공   
            this.category2 = res.data;

            this.category2 = this.category2.map(d => {
              return {
                ...d,
                value: d.id,
                text: d.name
              }
            });
          })
          .catch((error) => { //요청 실패
            console.log("하위 카테고리 목록을 가져오는 데 실패하였습니다.");
          });        
      },
      getHashtagList() {
        var url="/tag";

        this.$axios.get(url)
        .then((res) => { //요청 성공   
          this.hashtagList = res.data;

          this.hashtagList = this.hashtagList.map(d => {
              return {
                ...d,
                value: d.id,
                text: d.name
              }
            });
        })
        .catch((error) => { //요청 실패
          console.log("해시태그 목록을 불러오는 데 실패하였습니다.");
        });
      },
      getPredictPrice() { //적정가 산출 버튼 클릭 시
        //유효성체크 
        if(!(this.prd.margin_min && this.prd.margin_max && this.prd.category_id, this.prd.cost)){
          this.$swal.fire({
              title: `Fail`,
              text: `입력하지 않은 값이 있습니다.`,
              buttonsStyling: false,
              confirmButtonClass: 'btn btn-warning',
              icon: 'warning'
            });
            return false;
        }
        var url = 'http://3.37.92.138:8001/new_price/predict';
        var params = {
          margin_min: Number(this.prd.margin_min),
          margin_max: Number(this.prd.margin_max),
          category_id: Number(this.prd.category_id),
          cost: Number(this.prd.cost)
        };
        
        this.$axios.post(url, params)
        .then((res) => { //요청 성공
          this.prd.price = res.data.price;
        })
        .catch((error) => { //요청 실패
          this.$swal.fire({
            title: `Fail`,
            text: `적정가 산출에 실패하였습니다.`,
            buttonsStyling: false,
            confirmButtonClass: 'btn btn-warning',
            icon: 'warning'
          });
        });
      },
      async addGoods() {   
        //유효성 체크
        if(!(this.file1 && this.prd.name && this.prd.category1 && this.prd.category_id 
            && this.prd.cost && this.prd.margin_min && this.prd.margin_max && this.prd.price)) {
              this.$swal.fire({
                title: `Fail`,
                text: `입력하지 않은 값이 있습니다.`,
                buttonsStyling: false,
                confirmButtonClass: 'btn btn-warning',
                icon: 'warning'
              });
              return false;
          }

        // 해시태그 id 구하기
        this.prd.tags = [];
        this.prd.seledtedTags.forEach(tag => {
              var temp = this.hashtagList.filter(item => item.name == tag);
              if(temp && temp.length > 0 ) { this.prd.tags.push(temp[0].id); }
        });

        // 이미지 s3에 업로드
        this.prd.image = await this.ImageUploadToS3();
      
        var url = "/goods";
        var params = this.prd;

        this.$axios.post(url, params)
          .then((res) => { //요청 성공   
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
      async ImageUploadToS3() {
        AWS.config.update({
          region: this.$aws_info.bucketRegion,
          credentials: new AWS.CognitoIdentityCredentials({
            IdentityPoolId: this.$aws_info.IdentityPoolId
          })
        });

        var s3 = new AWS.S3({
          apiVersion: "2006-03-01",
          params: { Bucket: this.$aws_info.albumBucketName }
        });
        
        var files = document.getElementById('file1').files;
        if(!files.length) {
          return '';
        }

        var fileName = this.file1.name;
        var slice = fileName.split(".");
        var albumName = "goods/" + this.prd.category1 + "/" + this.prd.category_id + "/";
        var photoKey = albumName + slice[0] + "_" + new Date().getTime() + "." + slice[1];

        var upload = new AWS.S3.ManagedUpload({
            params: {
              Bucket: this.$aws_info.albumBucketName,
              Key: photoKey,
              Body: this.file1
            }
          });

          var data = await upload.promise();

          return data.Location;
      }
    }
  }
</script>
<style scoped> 
.popupImageItem {  
    width: 100%;
}
.wave {
  position:absolute;
  left: -5px;
  top: 40px;
}
.margin-rate-div {
  border: 0;
  text-align: right;
}

.tooltip{
  opacity: 1 !important;
  width: 350px;
}

</style>
