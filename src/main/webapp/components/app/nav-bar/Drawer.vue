<template>
    <v-navigation-drawer v-model="drawer"
                         app
                         fixed
                         floating
                         color="light"
                         :mini-variant="miniVariant"
                         mini-variant-width="64"
                         width="280"
                         class="elevation-12"
                         :class="[{'rounded-r-xl': $vuetify.breakpoint.lgAndUp}]">

<!--        :expand-on-hover="expandOnHover"-->
        <template #prepend>
            <app-nav-bar-top-side/>
        </template>

        <app-nav-bar-nav-menu :miniVariantStatus="miniVariant"/>

        <template #append>
            <app-nav-bar-bottom-side :miniVariantStatus="miniVariant"/>
        </template>

    </v-navigation-drawer>
</template>

<script>
export default {
    name: "NavBarDrawer",
    data () {
        return {
            drawer: this.$vuetify.breakpoint.mdAndUp,
        }
    },
    computed:{

        navbarToggle(){
            return this.$store.state.navbarToggle
        },

        miniVariant(){
            return this.$store.state.miniVariant
        },

        expandOnHover(){
            return this.miniVariant === true
        }
    },
    watch:{
        navbarToggle(val){
            this.drawer = val
        },
        drawer(val){
            if(val === false){
                this.$store.commit('SET_NAVBAR_TOGGLE', false)
            }
        },
    }
}
</script>
