<template>
  <footer class="container-fluid">
        <p>&copy; Copyright 2022.08 - Made by 납뜩이</p>
  </footer>
</template>

<script>

export default {
  name: 'LayoutFooter',
  components: {
  }
}
</script>

<style scoped>
footer {
  background: #e5e5e5;
  height: 70px;
  width: 100%;
  bottom: 0;
  display: table;
}

footer p {
  vertical-align: middle;
  display: table-cell;
}
</style>
