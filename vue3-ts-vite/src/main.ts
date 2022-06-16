import { createApp } from 'vue'
import App from './App.vue'
import './assets/styles/index.scss'
import router from './router/index'
import { createPinia } from 'pinia'
import axios from '@/axios/index'

const app = createApp(App)
const pinia = createPinia()
app.use(router)
app.use(pinia)
app.use(axios)

app.mount('#app')
