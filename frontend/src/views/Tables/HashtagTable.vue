<template>
    <b-card no-body class="pb-5">
        <b-card-header class="border-0">
            <h3 class="mb-0">해시태그 목록</h3>
        </b-card-header>
        
        <el-table class="table-responsive table"
                  header-row-class-name="thead-light"
                  :data="tableData">
            <el-table-column label="해시태그명"
                             min-width="140px">
              <template v-slot="{row}">
                    <b-button type="button" class="hashtag" variant="outline-primary" size="sm">
                      <div>
                        <i class="ni">#</i>
                        <span>{{row.name}}</span>
                      </div>
                    </b-button>
                </template>

            </el-table-column>

            <el-table-column label="기간"
                             prop="period"
                             min-width="140px">
            </el-table-column>

            <el-table-column label="등록일시"
                             prop="createdTime"
                             min-width="140px">
            </el-table-column>
        </el-table>
    </b-card>
</template>
<script>  
  import { Table, TableColumn} from 'element-ui'
  export default {
    name: 'hashtag-table',
    components: {
      [Table.name]: Table,
      [TableColumn.name]: TableColumn
    },
    data() {
      return {
        //list: this.$sample.hashtagList
        list: []
      };
    },
    computed: {
      tableData() {
        if(this.list.size  == 0) {
          return [];
        }

        return this.list.map(d => {
          return {
            ...d,
            period: d.startDate + ' ~ ' + d.endDate
          }
        });
      }
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
          console.log("해시태그 목록을 불러오는 데 실패하였습니다.");
        });
      },
    }
  }
</script>

<style scoped>
.avatar {
  width: 100px;
  height: 100px;
}

.el-table {
  min-height: 650px;
  overflow: overlay;
}
</style>