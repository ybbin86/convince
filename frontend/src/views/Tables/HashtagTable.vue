<template>
    <b-card no-body class="pb-5">
        <b-card-header class="border-0">
            <h3 class="mb-0">해시태그 목록</h3>
        </b-card-header>

        <el-table class="table-responsive table"
                  header-row-class-name="thead-light"
                  :data="list">
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
                             prop="insDate"
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
        currentPage: 1,
        value: ['apple', 'orange', 'banana', 'pear', 'peach'],
        list: [
            {name: '복날', period: '2022.06.01~2022.06.30', insDate: '2022-08-10 22:22:22'},
            {name: '복날', period: '2022.06.01~2022.06.30', insDate: '2022-08-10 22:22:22'},
            {name: '복날', period: '2022.06.01~2022.06.30', insDate: '2022-08-10 22:22:22'},
            {name: '복날', period: '2022.06.01~2022.06.30', insDate: '2022-08-10 22:22:22'},
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

.el-table {
  min-height: 650px;
  overflow: overlay;
}
</style>