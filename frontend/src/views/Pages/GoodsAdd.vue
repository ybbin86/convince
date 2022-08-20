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
              <b-img class="popupImageItem mb-3" :src="uploadImageFile" @error="getNoimage"/>
              <b-form-file
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

              <b-form @submit.prevent="updateProfile">
                <h6 class="heading-small text-muted mb-2">기본 정보</h6>

                <div class="pl-lg-4 mb-4">
                  <b-row>
                    <b-col md="12">
                      <base-input
                        type="text"
                        label="상품명"
                        placeholder="상품명"
                        v-model="user.username"
                      >
                      </base-input>
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col lg="6">
                      <base-input label="대카테고리">
                        <b-form-select v-model="selected" :options="options"></b-form-select>
                      </base-input>
                    </b-col>
                    <b-col lg="6">
                      <base-input label="중카테고리">
                        <b-form-select v-model="selected" :options="options"></b-form-select>
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
                          v-model="test"
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
                                ># {{ tag }}</b-form-tag>
                              </li>
                            </ul>
                            <b-form-select  
                              v-bind="inputAttrs"
                              v-on="inputHandlers"
                              :disabled="disabled || availableOptions.length === 0"
                              :options="availableOptions"         
                            >
                            <template #first>
                              <!-- This is required to prevent bugs with Safari -->
                              <option value="1">1</option>
                              <option value="2">2</option>
                              <option value="3">3</option>
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
                        v-model="user.address"
                      >
                      </base-input>
                    </b-col>
                    <b-col md="3">
                      <base-input
                        type="number"
                        label="마진율 하한"
                        placeholder="30"
                        v-model="user.address"
                      >
                      </base-input>
                    </b-col>
                    <b-col md="3">
                      <span class="wave">~</span>
                      <base-input
                        type="number"
                        label="마진율 상한"
                        placeholder="50"
                        v-model="user.city"
                      >
                      </base-input>
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col md="12" class="text-right mb-3">
                      <b-button type="button" class="hashtag" variant="primary">
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
                    <b-col md="4">
                      <base-input
                        type="number"
                        label="판매가"
                        placeholder="0"
                        v-model="user.address"
                      >
                      </base-input>
                    </b-col>
                    <b-col md="2">
                      <label class="form-control-label">
                        마진율
                      </label>
                      <div class="margin-rate-div form-control">0   %</div>
                    </b-col>
                  </b-row>
                  
                  <b-row class="mt-3">        
                    <b-col xl="12" md="12" class="hashtag-add-col text-right">
                        <b-button class="hashtag-add-button btn-kurly">등록하기</b-button>
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
  import EditProfileForm from './UserProfile/EditProfileForm.vue';
  import UserCard from './UserProfile/UserCard.vue';

  export default {
    components: {
      EditProfileForm,
      UserCard
    },
    data() {
      return {
        file1: null,
        uploadImageFile: '',
        user: {
          company: 'Creative Code Inc.',
          username: 'michael23',
          email: '',
          firstName: 'Mike',
          lastName: 'Andrew',
          address: 'Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09',
          city: 'New York',
          country: 'USA',
          postalCode: '',
          aboutMe: `Lamborghini Mercy, Your chick she so thirsty, I'm in that two seat Lambo.`
        },
        options: ['Apple', 'Orange', 'Banana', 'Lime', 'Peach', 'Chocolate', 'Strawberry'],
        value: [],
      }
    },
    computed: {
      availableOptions() {
        return this.options.filter(opt => this.value.indexOf(opt) === -1)
      }
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
                      this.uploadImageFile = e.target.result;
              }             
              reader.readAsDataURL(input.files[0]);
          }
      }
    }
  };
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
