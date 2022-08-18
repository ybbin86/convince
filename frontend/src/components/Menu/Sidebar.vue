<template>
<div class="sidebar">    
    <transition name="slide">
        <div :class="{ 'sidebar-panel': isPanelOpen, 'sidebar-panel2' : !isPanelOpen }">
            <slot>
                <ul class="sidebar-panel-nav">
                    <li>
                        <router-link to="/">
                            <img src="@/assets/icon/chart.png">
                            <div v-if="isPanelOpen">대시보드</div>
                        </router-link>
                    </li>
                    <li>
                        <router-link to="/hashtag">
                            <img src="@/assets/icon/hashtag.png">
                            <div v-if="isPanelOpen">해시태그</div>
                        </router-link>
                    </li>
                    <li>
                        <router-link to="/add">
                            <img src="@/assets/icon/add.png">
                            <div v-if="isPanelOpen">상품등록</div>
                        </router-link>
                    </li>
                    <li>
                        <router-link to="/preview">
                            <img src="@/assets/icon/preview.png">
                            <div v-if="isPanelOpen">미리보기</div>
                        </router-link>
                    </li>
                </ul>
            </slot>
        </div>
    </transition>

</div>
</template>
<script>
import { store, mutations } from '@/store';

export default {
    methods: {
        closeSidebarPanel: mutations.toggleNav
    },
    computed: {
        isPanelOpen() {
            return store.isNavOpen
        }
    },
    watch: {
        '$route' () {
            if(store.isNavOpen){
                this.closeSidebarPanel();
            }
        }
    }
}
</script>
<style>
.sidebar-panel {
   background: rgb(229 229 229 / 30%);
}
.sidebar-panel2 {
    background: rgb(229 229 229 / 30%);
    overflow-y: auto;
    position: fixed;
    left: 0;
    top: 0;
    height: 100%;
    z-index: 500;
    padding-top: 80px;
    width: 80px;
}
.slide-enter-active,
.slide-leave-active
{
    transition: transform 0.2s ease;
}

.slide-enter,
.slide-leave-to {
    transform: translateX(-100%);
    transition: all 150ms ease-in 0s
}
.sidebar-backdrop {
    width: 100%;
    height: 100%;
    position: fixed;
    top: 0;
    left: 0;
    cursor: pointer;
    z-index: 1000;
}
.sidebar-panel {
    overflow-y: auto;
    position: fixed;
    left: 0;
    top: 0;
    height: 100%;
    z-index: 900;
    padding-top: 80px;
    width: 300px;
}

ul.sidebar-panel-nav {
    list-style: none;
    padding: 35px 0;
}
ul.sidebar-panel-nav li {
    padding: 0px 0;
    height: 90px;
}
ul.sidebar-panel-nav li a {
    text-decoration: none;
}
ul.sidebar-panel-nav li img {
    width: 35px;
    position: absolute;
    lefT: 20px;
}
ul.sidebar-panel-nav li div {
    font-size: 20px;
    color: #222222;
    line-height: 1.8;
    text-decoration: none;
}

</style>