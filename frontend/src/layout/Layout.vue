<template>
  <div style="height:100%">
      <layout-header></layout-header>

      <layout-content></layout-content>

      <layout-footer></layout-footer>
  </div>
</template>

<script>
    import LayoutHeader from './LayoutHeader.vue'
    import LayoutFooter from './LayoutFooter.vue'
    import LayoutContent from './LayoutContent.vue'
    import { store, mutations } from '@/store';

    export default {
        name: 'Layout',
        components: {
            LayoutHeader,
            LayoutFooter,
            LayoutContent
        },
        methods: {
            closeSidebarPanel: mutations.toggleNav,
        },
        computed: {
            isPanelOpen() {
                return store.isNavOpen
            }
        }
    }
</script>

<style scoped>

</style>
