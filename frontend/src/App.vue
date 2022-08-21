<template>
  <router-view></router-view>
</template>

<script>
export default {
}
</script>

<style>
.bg-gradient-success {
  background: linear-gradient(14deg, #885EA7 0, #512772 100%) !important;
}

.btn-outline-primary {
    color: #512772;
    background-color: transparent;
    background-image: none;
    border-color: #512772;
}
.btn-outline-primary:hover, .btn-outline-primary:not(:disabled):not(.disabled):active {
   background-color: #512772;
}

.btn-kurly {
  color: #fff;
  background-color: #512772;
  background-image: none;
  border-color: #512772;
}
.btn-kurly:hover, .btn-kurly:not(:disabled):not(.disabled):active {
  background-color: #fff;
  color: #512772;
  border-color: #512772;
}

.badge-info {
  color: #512772;
  background-color: transparent;
  border: 0.5px solid #512772;
  padding: 0.35rem 0.65rem;
  align-items: center !important;
}

input[type="number"] {
  text-align: right;
}

.modal-dialog {
  min-width: 1000px !important;
}

table .thead-light th div.cell {
  font-size: 18px;
  font-weight: bold;
  color: #1d2126;
}

table .thead-light {
  height: 55px;
}

table tbody .el-table__row div.cell {
  font-size: 16px;
}
</style>