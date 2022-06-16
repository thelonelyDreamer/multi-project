import { createApp } from 'vue'
import App from './App.vue'
import './assets/global/index.scss'
import axios from './axios'
import router from './router'
import { createPinia } from 'pinia'

const pinia = createPinia()
const app = createApp(App)
app.use(axios)
app.use(router)
app.use(pinia)
app.mount('#app')

router.beforeEach((to, from, next) => {
    console.log(to, from, next)
    next()
})