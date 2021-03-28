<template>
    <v-row justify="space-between" class="pt-5 pt-md-10">

        <v-col cols="12" md="5" order-md="1" class="mb-5 mb-md-10">
            <slot name="form"/>
        </v-col>

        <v-col cols="12" md="6" class="mb-5 mb-md-10 grey">
            <slot name="presentation"/>
        </v-col>

    </v-row>
</template>

<script>
export default {
    name: "Grid"
}
</script>
