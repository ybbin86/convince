<template>
<header class="container-fluid">
    <div class="">
        <nav class="main-nav">
            <Burger></Burger>
            <Sidebar></Sidebar>
        </nav>

        <b-row class="text-center">
          <b-col><img src="@/assets/headerLogo.png"></b-col>
          <b-col><img src="@/assets/AdminLogo.png"></b-col>
        </b-row>
    </div>
</header>
</template>

<script>
import Burger from '@/components/Menu/Burger.vue';
import Sidebar from '@/components/Menu/Sidebar.vue';

export default {
  name: 'LayoutHeader',
  components: {
    Burger,
    Sidebar
  }
}
</script>

<style scoped>
header {
  border-bottom: 0.5px solid #c9c9c9;
  height: 80px;
}
.main-nav {
  float: left;
  width: 50px;
}
img {
  display:inline-block;
}
.row {
  height:80px;
  line-height: 80px;
}
.row .col:first-child {
  text-align:initial;
  z-index: 10001;
}
.row .col:first-child img {
  margin-left: 20px;
}
.row .col:nth-child(2) {
  text-align:end;
}
</style>
