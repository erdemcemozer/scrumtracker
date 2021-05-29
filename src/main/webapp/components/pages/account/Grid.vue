<template>
    <v-row justify="space-between" class="pt-md-10" :class="$vuetify.breakpoint.smAndDown ? 'pt-0' : 'pt-5'">

        <v-col cols="12" class="my-2" v-if="$vuetify.breakpoint.smAndDown">
                <logo-component/>
        </v-col>

        <v-col cols="12" md="5" order-md="1" class="mb-5 mb-md-10">
            <slot name="form"/>
        </v-col>

        <v-col cols="12" md="6" class="mb-5 mb-md-10 neumerophism">
            <slot name="presentation"/>
        </v-col>

    </v-row>
</template>

<script>
import LogoComponent from "@/components/pages/account/Logo";
export default {
    name: "Grid",
    components: {
        LogoComponent
    }
}
</script>
