<template>
    <div class="text-center">
        <v-dialog v-model="dialog" width="500">
            <template #activator="{ on, attrs }">

                <v-btn class="neumerophism"
                       text rounded height="40" block
                       v-bind="attrs"
                       v-on="on">

                <v-icon v-text="'mdi-link-variant-plus'" class="mr-2"/>
                {{ $t('addLink') }}
                </v-btn>

            </template>

            <v-card class="pa-10">

                <h3 class="mb-6 text-center" v-text="$t('addLinkAndDescription')"/>

                <v-row justify="center">
                    <v-col cols="12">
                        <v-text-field v-model="link"
                                      label="Link:"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-link-variant"/>

                    </v-col>
                    <v-col cols="12">

                        <v-text-field v-model="description"
                                      :label="$t('description')+':'"
                                      outlined dense rounded required
                                      prepend-inner-icon="mdi-comment-text-outline"/>

                    </v-col>

                    <div class="d-flex justify-end mt-2">
                        <v-btn rounded depressed block
                               color="primary" type="submit" @click.prevent="submit" class="px-10">
                            {{ $t('add') }}
                        </v-btn>
                    </div>

                </v-row>
            </v-card>

        </v-dialog>
    </div>
</template>

<script>
export default {
    name: "Dialog",
    data(){
        return {
            dialog: false,
            link: null,
            description: null
        }
    },
    methods:{
        submit(){
            this.dialog = false
            this.$store.dispatch('POST_USEFUL_LINKS_ADD', {link: this.link, description: this.description}).then(()=>{
                this.$nuxt.refresh()
            })
        }
    }
}
</script>

