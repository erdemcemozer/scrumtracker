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
                <link-dialog :open="addDialog" :form="form" @add-task="addTask($event)"/>
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
                <template #item.action="{ item }">
                    <div class="d-flex">
                        <v-tooltip top>
                            <template #activator="{ on }">
                                <v-btn icon color="grey" v-on="on" @click="edit(item)">
                                    <v-icon v-text="'mdi-pencil'"/>
                                </v-btn>
                            </template>
                            {{ $t('edit') }}
                        </v-tooltip>

                        <v-tooltip top>
                            <template #activator="{ on }">
                                <v-btn icon color="grey" v-on="on" class="ml-3">
                                    <v-icon v-text="'mdi-delete-outline'"/>
                                </v-btn>
                            </template>
                            {{ $t('delete') }}
                        </v-tooltip>
                    </div>
                </template>
            </v-data-table>
        </v-card>

    </v-container>
</template>

<script>
import LinkDialog from "@/components/pages/announcements/AnnouncementsDialog";

export default {
    name: "announcements",
    components: {
        LinkDialog
    },
    data() {
        return {
            pageTitle: this.$t('announcements'),
            search: '',
            addDialog: false,
            form: null,
            headers: [
                {
                    text: this.$t('announcementTitle'),
                    align: 'start',
                    sortable: false,
                    value: 'announcementTitle',
                },
                {
                    text: this.$t('description'),
                    sortable: false,
                    value: 'announcementDescription',
                },
                {
                    text: "Date",
                    sortable: false,
                    value: 'releaseDate',
                },
                {text: null, value: 'action', sortable: false, width: 20},
            ],
            desserts: [],
        }
    },
    async created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
        await this.$store.dispatch('GET_ANNOUNCEMENTS').then(()=>{
                this.desserts = this.$store.state.announcements
            }
        )
    },
    watch: {
        '$store.state.announcements'(val) {
            this.desserts = val
            this.$nuxt.refresh()
        }
    },
    methods: {
        addTask(task) {
            this.addDialog = task
        },
        edit(item) {
            this.dialog = false
            this.form = item
        }
    }
}
</script>
