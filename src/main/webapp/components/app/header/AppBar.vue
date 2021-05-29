<template>
    <v-app-bar app flat tile clipped-right color="transparent">

        <client-only v-if="$vuetify.breakpoint.smAndDown">
            <v-app-bar-nav-icon @click="$store.commit('SET_NAVBAR_TOGGLE', true)"/>
        </client-only>

        <v-container>
            <v-app-bar-title v-text="title"/>
        </v-container>

    </v-app-bar>
</template>

<script>
export default {
    name: "AppBar",
    computed:{
        title(){
            return this.$store.state.pageTitle
        }
    }
}
</script>
