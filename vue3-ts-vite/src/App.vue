<template>
  <router-view></router-view>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
  data: () => {
    return {

    }
  },
  mounted() {
    if (import.meta.env.MODE === "development") {
      console.log(import.meta.env)
    } else {
      console.log("当前环境为：" + import.meta.env.MODE)
    }
  },
})
</script>