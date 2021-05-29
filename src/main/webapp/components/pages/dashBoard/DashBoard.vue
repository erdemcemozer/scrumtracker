<template>
    <v-container>
        DashBoard Page
    </v-container>
</template>

<script>
export default {
    name: "DashBoard",
    data() {
        return {
            pageTitle: this.$t('dashBoard'),
        }
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
    }
}
</script>

