<template>
    <v-container>

        <v-card rounded="lg" color="transparent" class="neumerophism">

            <div class="d-flex pa-3">
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

                    <v-row>
                        <v-icon v-text="'mdi-arrow-right-thin-circle-outline'" class="mr-2" v-if="$vuetify.breakpoint.mdAndUp"/>
                        <h4 class="text-subtitle-1" v-text="item.name"/>
                    </v-row>


                </template>

            </v-data-table>
        </v-card>

    </v-container>
</template>

<script>
import LinkDialog from "@/components/pages/announcements/Dialog";

export default {
    name: "announcements",
    components: {
        LinkDialog
    },
    data() {
        return {
            pageTitle: this.$t('announcements'),
            search: '',
            headers: [
                {
                    text: this.$t('announcementTitle'),
                    align: 'start',
                    sortable: false,
                    value: 'name',
                },
                {
                    text: this.$t('description'),
                    sortable: false,
                    value: 'detail',
                },

            ],
            desserts: [
                {
                    name: 'Duyuru 1',
                    detail: 'Duyuru 1 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 2',
                    detail: 'Duyuru 2 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 3',
                    detail: 'Duyuru 3 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 4',
                    detail: 'Duyuru 4 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 5',
                    detail: 'Duyuru 5 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 6',
                    detail: 'Duyuru 6 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 7',
                    detail: 'Duyuru 7 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 8',
                    detail: 'Duyuru 8 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 9',
                    detail: 'Duyuru 9 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 10',
                    detail: 'Duyuru 10 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 11',
                    detail: 'Duyuru 11 ile ilgili detaylar burada yeralmaktadır.',
                },
                {
                    name: 'Duyuru 12',
                    detail: 'Duyuru 12 ile ilgili detaylar burada yeralmaktadır.',
                },
            ],
        }
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
    }
}
</script>
