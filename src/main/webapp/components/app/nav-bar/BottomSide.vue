<template>
    <div class="d-flex px-3 py-2" :class="miniVariantStatus ? 'justify-center flex-wrap' : 'justify-space-between'">

        <app-nav-bar-language :mini-variant="miniVariantStatus"/>

        <v-btn icon @click="setMiniVariant" class="neumerophism">
            <v-icon v-text="`mdi-arrow-${miniVariantStatus ? 'right' : 'left'}`"/>
        </v-btn>

    </div>
</template>

<script>
export default {
    name: "BottomSide",
    props:{
        miniVariantStatus:{
            type: Boolean
        }
    },
    data(){
        return{
            miniVariant: false,
        }
    },
    async fetch() {
        await this.getMiniVariant()
    },
    methods:{
        setMiniVariant(){
            this.miniVariant = !this.miniVariant;
            this.$storage.setCookie('miniVariant', this.miniVariant)
            this.$store.commit('SET_MINI_VARIANT', this.miniVariant)
        },

        getMiniVariant(){
            this.$store.commit('SET_MINI_VARIANT', !!this.$storage.getCookie('miniVariant'))
        }
    }
}
</script>
