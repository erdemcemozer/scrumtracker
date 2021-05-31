<template>
    <v-container>

        <v-card rounded="lg" color="transparent" flat tile>

            <div class="d-flex pa-3 mb-2">
                <v-text-field color="transparent"
                              class="neumerophism py-1 mt-0 fill-width mr-3"
                              v-model="search"
                              append-icon="mdi-magnify"
                              :label="$t('search')"
                              single-line flat rounded
                              hide-details/>
                <link-dialog/>
            </div>

            <v-divider/>

            <v-data-table light
                          :headers="headers"
                          :items="desserts"
                          :search="search"
                          class="transparent">

               <template #item.name="{item}">

                    <v-icon v-text="'mdi-arrow-right-thin-circle-outline'" class="mr-2" v-if="$vuetify.breakpoint.mdAndUp"/>

                    <a :href="item.name" target="_blank">
                        {{ item.name }}
                    </a>
                </template>
            </v-data-table>
        </v-card>
    </v-container>
</template>

<script>
import LinkDialog from "@/components/pages/usefulLinks/Dialog";

export default {
    name: "UsefulLinks",
    components: {
        LinkDialog
    },
    data() {
        return {
            pageTitle: this.$t('usefulLinks'),
            search: '',
            headers: [
                {
                    text: this.$t('link'),
                    align: 'start',
                    sortable: false,
                    value: 'linkName',
                },
                {
                    text: this.$t('description'),
                    sortable: false,
                    value: 'linkDescription',
                },

            ],
            desserts: [

            ],
        }
    },
    async created() {
        await this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
        await this.$store.dispatch('GET_USEFUL_LINKS').then(()=>{
              this.desserts = this.$store.state.usefulLinks
            }
        )
    },
    watch: {
        '$store.state.usefulLinks'(val) {
            this.desserts = val
            this.$nuxt.refresh()
        }
    }
}
</script>

