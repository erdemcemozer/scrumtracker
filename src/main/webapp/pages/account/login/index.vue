<template>
    <v-container class="fill-height d-flex align-center">
        <account-grid>

            <template #presentation>
                <account-presentation/>
            </template>

            <template #form>
                <account-login/>
            </template>

        </account-grid>
    </v-container>
</template>

<script>
export default {
    name: "index",
    layout: 'account'
}
</script>
