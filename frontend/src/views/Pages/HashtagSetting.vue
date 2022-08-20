<template>
  <div>
    <base-header class="pb-6 pb-8 pt-5 pt-md-6 bg-gradient-success">
      <!-- Card stats -->
      <b-card class="hashtag-add-card">
      <b-row>
        <b-col xl="5" md="12">
            <label for="example-date-input" class="col-md-12 col-form-label form-control-label">해시태그명</label>
            <b-col md="12">
                <b-form-input list="my-list-id"></b-form-input>

                <datalist id="my-list-id">
                    <option>Manual Option</option>
                    <option v-for="size in 10" :key="size">{{ size }}</option>
                </datalist>
            </b-col>
        </b-col>
        <b-col xl="3" md="12">
            <label for="example-date-input" class="col-md-12 col-form-label form-control-label">시작일</label>
            <b-col md="12">
            <base-input type="date" value="2018-11-23" id="example-date-input"/>
            </b-col>
        </b-col>
        <b-col xl="3" md="12">
            <label for="example-date-input" class="col-md-12 col-form-label form-control-label">종료일</label>
            <b-col md="12">
            <base-input type="date" value="2018-11-23" id="example-date-input"/>
            </b-col>
        </b-col>
         <b-col xl="1" md="12" class="hashtag-add-col text-right">
            <b-button class="hashtag-add-button" variant="outline-primary">등록하기</b-button>
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
          <hashtag-table/>
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
  import HashtagTable from "../Tables/HashtagTable";

  export default {
    components: {
      HashtagTable,
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

.hashtag-add-col {
    line-height: 7.7;
}


</style>
