<template>
    <v-app dark>

        <app-nav-bar-drawer/>

        <v-main>
            <nuxt/>
        </v-main>

    </v-app>
</template>

<script>
export default {
    data() {
        return {}
    }
}
</script>

<style lang="scss">
*{
    letter-spacing: .5px;
}
.v-application {
    &.theme--light {
        background-color: var(--v-light-base);
    }

    @for $i from 1 through 16 {
        .elevation-#{$i} {
            box-shadow: 0 0 #{$i * 4}px 0 rgba(0, 0, 0, 0.1) !important;
        }
    }
}

[class*="container"],[class^="container"],
[class*="col"],[class^="col"],{
    padding-top: initial !important;
    padding-bottom: initial !important;
}

[class*="row"],[class^="row"],{
    margin-top: initial !important;
    margin-bottom: initial !important;
}


.neumerophism{
    box-shadow: 5px 5px 14px 0 rgba(0, 0, 0, 0.08), -12px -12px 10px 0 rgba(255, 255, 255, 0.4);
}

</style>
