import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
const routerHistory = createWebHistory()

const routers: RouteRecordRaw[] = [
    { path: "/index", name: "index", component: () => import('../view/Index.vue') },
    { path: "/", redirect: "/index" },
    { path: '/login', name: 'login', component: () => import('../view/Login.vue') },
]

const router = createRouter({
    history: routerHistory,
    routes: routers,
})

export default router

