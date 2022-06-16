<template>
    <!-- 登录页面 -->
    <div class="back">
        <global-head></global-head>
        <div class="outer-container">
            <div id="main">
                <div class="block text-center carousel">
                    <el-carousel height="300px">
                        <el-carousel-item v-for="item in imgs">
                            <img :src="item" alt="图片">
                        </el-carousel-item>
                    </el-carousel>
                </div>
                <el-form ref="ruleFormRef" :model="ruleForm" status-icon :rules="rules" label-width="120px"
                    class="demo-ruleForm loginForm">
                    <el-form-item label="Email" prop="pass">
                        <el-input v-model="ruleForm.pass" type="text" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="Password" prop="checkPass">
                        <el-input v-model="ruleForm.checkPass" type="password" autocomplete="off" />
                    </el-form-item>
                    <el-form-item label="Code" prop="age">
                        <el-input v-model.number="ruleForm.age" />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm(ruleFormRef)">Submit</el-button>
                        <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
        <div style="display: block;">底部</div>
    </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { FormInstance } from 'element-plus'
import GlobalHead from '@/components/common/GlobalHead.vue'

const ruleFormRef = ref<FormInstance>()

const checkAge = (rule: any, value: any, callback: any) => {
    if (!value) {
        return callback(new Error('Please input the age'))
    }
    setTimeout(() => {
        if (!Number.isInteger(value)) {
            callback(new Error('Please input digits'))
        } else {
            if (value < 18) {
                callback(new Error('Age must be greater than 18'))
            } else {
                callback()
            }
        }
    }, 1000)
}

const validatePass = (rule: any, value: any, callback: any) => {
    if (value === '') {
        callback(new Error('Please input the password'))
    } else {
        if (ruleForm.checkPass !== '') {
            if (!ruleFormRef.value) return
            ruleFormRef.value.validateField('checkPass', () => null)
        }
        callback()
    }
}
const validatePass2 = (rule: any, value: any, callback: any) => {
    if (value === '') {
        callback(new Error('Please input the password again'))
    } else if (value !== ruleForm.pass) {
        callback(new Error("Two inputs don't match!"))
    } else {
        callback()
    }
}

const ruleForm = reactive({
    pass: '',
    checkPass: '',
    age: '',
})

const rules = reactive({
    pass: [{ validator: validatePass, trigger: 'blur' }],
    checkPass: [{ validator: validatePass2, trigger: 'blur' }],
    age: [{ validator: checkAge, trigger: 'blur' }],
})

const submitForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.validate((valid) => {
        if (valid) {
            console.log('submit!')
        } else {
            console.log('error submit!')
            return false
        }
    })
}

const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.resetFields()
}

const imgs: string[] = [
    'https://img2.baidu.com/it/u=3534284102,616662343&fm=253&fmt=auto&app=138&f=JPEG?w=667&h=500'
]
</script>

<style lang="scss" scoped>
#main {
    padding-left: 100px;
    padding-right: 100px;
    padding-top: 20px;
    padding-bottom: 20px;
    background-color: rgb(0, 0, 0);
    border-radius: 5px;

    &::after {
        content: '';
        display: block;
        clear: both;
    }
}

.carousel {
    width: 400px;
    float: left;
}

.loginForm {
    float: left;
    margin-top: 100px;
}

.outer-container {
    padding: 20px;
    background-color: rgb(7, 0, 0);
    border-radius: 5px;
}

.back {
    padding: 0, 100px;
    min-height: 500px;
}
</style>

