<script lang="ts" setup>
import HeaderVue from "@/components/common/Header.vue"
import MyAsider from "@/components/common/Asider.vue"
import MyMain from "@/components/common/Main.vue"
import MyFooter from "@/components/common/Footer.vue"
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <header-vue></header-vue>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <my-asider></my-asider>
        </el-aside>
        <el-main>
          <my-main></my-main>
        </el-main>
      </el-container>
      <el-footer height="60px">
        <my-footer></my-footer>
      </el-footer>
    </el-container>
  </div>
</template>