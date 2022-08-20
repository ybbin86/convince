<template>
    <b-card no-body>
        <b-card-header class="border-0">
            <h3 class="mb-0">상품목록</h3>
        </b-card-header>

        <el-table class="table-responsive table"
                  header-row-class-name="thead-light"
                  :data="list">
            <el-table-column label="제품이미지"
                             min-width="180px"
                             prop="name">
                <template v-slot="{row}">
                    <b-media no-body class="align-items-center">
                        <a href="#" class="avatar rounded-0 mr-3">
                            <img alt="Image placeholder" :src="row.img">
                        </a>
                    </b-media>
                </template>
            </el-table-column>

            <el-table-column label="카테고리"
                             prop="category"
                             min-width="140px">
            </el-table-column>

            <el-table-column label="상품명"
                             prop="name"
                             min-width="140px">
            </el-table-column>

            <el-table-column label="해시태그"
                             min-width="170px"
                             class="hashtag">
             <b-button type="button" class="hashtag" variant="outline-primary" size="sm">
              <div>
                <i class="ni">#</i>
                <span>복날</span>
              </div>
            </b-button>

            <b-button type="button" class="hashtag" variant="outline-primary" size="sm">
              <div>
                <i class="ni">#</i>
                <span>제철사과</span>
              </div>
            </b-button>

            </el-table-column>

            <el-table-column label="등록일시"
                             prop="insDate"
                             min-width="140px">
            </el-table-column>

            <el-table-column label="상품 가격(초기값)"
                             min-width="170px"
                             prop="price">
            </el-table-column>

            <el-table-column label="실시간 가격(변동가)"
                             prop="dynamicPrice"
                             min-width="240px">
            </el-table-column>
        </el-table>

        <b-card-footer class="py-4 d-flex justify-content-center">
            <base-pagination v-model="currentPage" :per-page="10" :total="50"></base-pagination>
        </b-card-footer>
    </b-card>
</template>
<script>
  import { Table, TableColumn} from 'element-ui'
  export default {
    name: 'goods-table',
    components: {
      [Table.name]: Table,
      [TableColumn.name]: TableColumn
    },
    data() {
      return {
        currentPage: 1,
        value: ['apple', 'orange', 'banana', 'pear', 'peach'],
        list: [
            {img: 'src', insDate: '2022.07.10 00:00:00', name: '아오리사과', price: '5000원', hashtag: '#복날, #제철사과', hashtagPeriod: '2022.06.01~2022.06.30', dynamicPrice: '5300/ +1000원', category: '과일류 > 사과'},
            {img: 'src', insDate: '2022.07.10 00:00:00',  name: '아오리사과', price: '5000원', hashtag: '#복날, #제철사과', hashtagPeriod: '2022.06.01~2022.06.30', dynamicPrice: '5300/ +1000원', category: '과일류 > 사과'},
            {img: 'src', insDate: '2022.07.10 00:00:00',  name: '아오리사과', price: '5000원', hashtag: '#복날, #제철사과', hashtagPeriod: '2022.06.01~2022.06.30', dynamicPrice: '5300/ +1000원', category: '과일류 > 사과'},
            {img: 'src', insDate: '2022.07.10 00:00:00',  name: '아오리사과', price: '5000원', hashtag: '#복날, #제철사과', hashtagPeriod: '2022.06.01~2022.06.30', dynamicPrice: '5300/ +1000원', category: '과일류 > 사과'}
        ]
      };
    }
  }
</script>

<style scoped>
.avatar {
  width: 100px;
  height: 100px;
}
</style>