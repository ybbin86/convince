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
        <b-col xl="4" md="12" >
            <b-card title="TOP1" class="text-center mb-4" >
                <!-- Card body -->
                <b-row align-v="center">
                    <b-col md="auto">
                        <b-img src="img/theme/team-1.jpg"
                        fluid
                        rounded="circle"
                        class="img-center shadow shadow-lg--hover" style="width: 140px;" />
                    </b-col>
                    <b-col class="ml--2">
                        <h2 class="mb-2">
                            <a href="javascript:;">납뜩이 사과</a>
                        </h2>
                        <h2 class="text-muted mb-4">5500원</h2>
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
                    </b-col>
                </b-row>
            </b-card>
        </b-col>
        <b-col xl="4" md="12">
            <b-card title="TOP2" class="text-center mb-4">
                <!-- Card body -->
                <b-row align-v="center">
                    <b-col md="auto">
                        <b-img src="img/theme/team-1.jpg"
                        fluid
                        rounded="circle"
                        class="img-center shadow shadow-lg--hover" style="width: 140px;" />
                    </b-col>
                    <b-col class="ml--2">
                        <h2 class="mb-2">
                            <a href="javascript:;">납뜩이 사과</a>
                        </h2>
                        <h2 class="text-muted mb-4">5500원</h2>
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
                    </b-col>
                </b-row>
            </b-card>
        </b-col>
        <b-col xl="4" md="12">
            <b-card title="TOP3" class="text-center mb-4">
                <!-- Card body -->
                <b-row align-v="center">
                    <b-col md="auto">
                        <b-img src="img/theme/team-1.jpg"
                        fluid
                        rounded="circle"
                        class="img-center shadow shadow-lg--hover" style="width: 140px;" />
                    </b-col>
                    <b-col class="ml--2">
                        <h2 class="mb-2">
                            <a href="javascript:;">납뜩이 사과</a>
                        </h2>
                        <h2 class="text-muted mb-4">5500원</h2>
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
  import { Dropdown, DropdownItem, DropdownMenu, Table, TableColumn } from 'element-ui';
  import projects from '../Tables/projects'
  import users from '../Tables/users'
  import GoodsTable from "../Tables/GoodsTable";

  export default {
    components: {
      GoodsTable,
      [Dropdown.name]: Dropdown,
      [DropdownItem.name]: DropdownItem,
      [DropdownMenu.name]: DropdownMenu,
      [Table.name]: Table,
      [TableColumn.name]: TableColumn
    },
    data() {
      return {
        projects,
        users,
      };
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
</style>
