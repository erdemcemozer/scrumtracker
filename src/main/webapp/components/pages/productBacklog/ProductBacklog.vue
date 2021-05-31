<template>
    <v-container>
        <v-card flat tile color="transparent">
            <div class="d-flex pa-3 mb-4">
                <v-text-field color="transparent"
                              class="neumerophism py-1 mt-0 fill-width mr-3"
                              v-model="search"
                              append-icon="mdi-magnify"
                              :label="$t('search')"
                              single-line flat rounded
                              hide-details/>
                <product-backlog-dialog :open="addDialog" :formEdit="form" @add-task="addTask($event)"/>
            </div>

            <v-divider/>

            <v-data-table light
                          :headers="headers"
                          :items="desserts"
                          :search="search"
                          class="transparent">

                <template #item.tasks="{item}">

                    <v-icon v-text="'mdi-arrow-right-thin-circle-outline'" class="mr-2" v-if="$vuetify.breakpoint.mdAndUp"/>

                    <span :href="item.tasks">
                        {{ item.tasks }}
                    </span>
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
                                <v-btn icon color="grey" v-on="on" class="ml-3" @click="deleteIssue(item)">
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
import ProductBacklogDialog from "~/components/pages/productBacklog/ProductBacklogDialog";

export default {
    name: "ProductBacklog",
    components: {
        ProductBacklogDialog
    },
    data() {
        return {
            pageTitle: this.$t('productBacklog'),
            search: '',
            addDialog: null,
            form: null,
            headers: [
                {
                    text: this.$t('title'),
                    align: 'start',
                    sortable: false,
                    value: 'issueTitle',
                },
                {
                    text: this.$t('description'),
                    sortable: false,
                    value: 'issueDesc',
                },
                {
                    text: this.$t('type'),
                    sortable: false,
                    value: 'issueType',
                },
                {
                    text: this.$t('sprintName'),
                    sortable: false,
                    value: 'issueSprintName',
                },
                {
                    text: this.$t('priority'),
                    sortable: false,
                    value: 'issuePriority',
                },
                {
                    text: this.$t('estimation'),
                    sortable: false,
                    value: 'issueEstimation',
                },
                {
                    text: this.$t('status'),
                    sortable: false,
                    value: 'issueStatus',
                },
                {
                    text: this.$t('owner'),
                    sortable: false,
                    value: 'issueOwner',
                },
                {text: null, value: 'action', sortable: false, width: 20},

            ],
            desserts: [
                {
                    /*issueTitle: 'Task 1',
                    issueDesc: 'Description',
                    issueType: 'Sprint 1',
                    issueSprintName: 'blocker',
                    issuePriority: 'major',
                    issueEstimation: 'kime atandı',
                    issueStatus: 'bug',
                    issueOwner: 'Sadettin'

                    issueTitle: null,
                    issueDesc: null,
                    issueType: null,
                    issueSprintName: null,
                    issuePriority: null,  // dropdown
                    issueEstimation: null,
                    issueStatus: null, // dropdown -> bug, story, task, feature, improvement, epic
                    issueOwner: null // databaseden dropdown*/

                },
            ],
        }
    },
    async created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
        await this.$store.dispatch('GET_ISSUES').then(()=>{
                this.desserts = this.$store.state.issues
            }
        )
    },
    watch: {
        '$store.state.issues'(val) {
            this.desserts = [...val]
            console.log('val111',val)
            this.$nuxt.refresh()
        }
    },
    methods: {
        addTask(task) {
            this.addDialog = task
        },
        edit(item) {
            this.addDialog = true
            this.form = item
            //console.log('formm', this.form)
        },
        deleteIssue(item) {
            this.$store.dispatch('POST_DELETE_ISSUE', item)
        }
    }
}
</script>

