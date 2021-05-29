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
                <product-backlog-dialog/>
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
            headers: [
                {
                    text: 'Task',
                    align: 'start',
                    sortable: false,
                    value: 'tasks',
                },
                {
                    text: 'Sprint Name',
                    sortable: false,
                    value: 'sprintName',
                },
                {
                    text: 'Priority',
                    sortable: false,
                    value: 'priority',
                },
                {
                    text: 'Estimation',
                    sortable: false,
                    value: 'estimation',
                },
                {
                    text: 'Status',
                    sortable: false,
                    value: 'status',
                },

            ],
            desserts: [
                {
                    tasks: 'Task 1',
                    sprintName: 'Sprint 1',
                    priority: '1',
                    estimation: '1',
                    status: 'Done',

                },
                {
                    tasks: 'Task 2',
                    sprintName: 'Sprint 1',
                    priority: '1',
                    estimation: '1',
                    status: 'Done',

                },
                {
                    tasks: 'Task 3',
                    sprintName: 'Sprint 1',
                    priority: '1',
                    estimation: '1',
                    status: 'Done',

                },
                {
                    tasks: 'Task 4',
                    sprintName: 'Sprint 1',
                    priority: '1',
                    estimation: '1',
                    status: 'Done',

                },
                {
                    tasks: 'Task 5',
                    sprintName: 'Sprint 1',
                    priority: '1',
                    estimation: '1',
                    status: 'Done',

                },
                {
                    tasks: 'Task 6',
                    sprintName: 'Sprint 1',
                    priority: '1',
                    estimation: '1',
                    status: 'Done',

                },

            ],
        }
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
    }
}
</script>

