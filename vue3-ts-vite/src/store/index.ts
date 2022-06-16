import { defineStore } from 'pinia'

export const useMainStore = defineStore('main', {
    state: () => {
        return {
            person: {
                name: 'shine',
                age: 18,
                gender: 'male'
            }
        }
    },
    getters: {
        getPersonHash(state) {
            return state.person.age
        }
    },
    actions: {
        addPersonName(step: number) {
            this.person.age += step
        },
        async add() {
            t
        }
    },
})

