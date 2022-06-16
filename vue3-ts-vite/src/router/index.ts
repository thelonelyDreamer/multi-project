import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
const routerHistory = createWebHistory()

const routers: RouteRecordRaw[] = [
    { path: "/index", name: "home", component: () => import('../views/Index.vue') },
    { path: "/test/echarts", name: "test-charts", component: () => import('@/views/test/Echarts.vue') },
    { path: "/", redirect: "/index" }
]

const router = createRouter({
    history: routerHistory,
    routes: routers,
})

export default router
