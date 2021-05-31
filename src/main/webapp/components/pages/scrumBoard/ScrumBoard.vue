<template>
    <v-container fluid>

        <v-card flat tile color="transparent">

            <div class="d-flex pa-3">
                <v-text-field color="transparent"
                              class="neumerophism py-1 mt-0 fill-width mr-3"
                              v-model="search"
                              append-icon="mdi-magnify"
                              :label="$t('search')"
                              single-line flat rounded
                              hide-details/>
            </div>

            <v-divider/>

            <div class="pa-3">

                <v-row>
                    <v-col cols="12" md="3" class="mb-5">
                        <v-card flat class="transparent" rounded="lg">

                            <div class="white d-flex align-center justify-space-between pr-2">
                                <v-card-title v-text="$t('openReopen')" class="py-2"/>

                                <v-btn icon @click="addDialog = !addDialog">
                                    <v-icon v-text="'mdi-plus-circle-outline'"/>
                                </v-btn>
                            </div>

                            <draggable :list="openTasks" group="people" style="min-height: 50px">
                                <v-hover v-slot="{ hover }" v-for="(task, i) in openTasks" :key="`${task.title}-${i}`">
                                    <v-card flat class="pa-3 mt-2" :elevation="hover ? 6 : 1">
                                      <div class="d-flex flex-row justify-space-between">
                                          <span class="d-block text-body-1 font-weight-bold mb-1" v-text="task.title"/>
                                          <v-btn icon class="mt-n2">
                                            <v-icon small color="indigo lighten-4" v-text="'mdi-close'" @click="deleteTask(i)"/>
                                          </v-btn>
                                      </div>

                                        <span class="d-block text-body-2" v-text="task.description"/>

                                    </v-card>
                                </v-hover>
                            </draggable>
                        </v-card>
                    </v-col>

                    <v-col cols="12" md="3" class="mb-5">
                        <v-card flat class="transparent" rounded="lg">
                            <v-card-title v-text="$t('inProgress')" class="white py-2"/>

                            <draggable :list="inProgressTasks" group="people" style="min-height: 50px">
                                <v-hover v-slot="{ hover }" v-for="(task, i) in inProgressTasks"
                                         :key="`${task.title}-${i}`">
                                    <v-card flat class="pa-3 mt-2" :elevation="hover ? 6 : 1">
                                      <div class="d-flex flex-row justify-space-between">
                                          <span class="d-block text-body-1 font-weight-bold mb-1" v-text="task.title"/>
                                          <v-btn icon class="mt-n2">
                                              <v-icon small color="indigo lighten-4" v-text="'mdi-close'" @click="deleteTask(i)"/>
                                          </v-btn>
                                      </div>
                                        <span class="d-block text-body-2" v-text="task.description"/>
                                    </v-card>
                                </v-hover>
                            </draggable>

                        </v-card>
                    </v-col>

                    <v-col cols="12" md="3" class="mb-5">
                        <v-card flat class="transparent" rounded="lg">
                            <v-card-title v-text="$t('inTest')" class="white py-2"/>

                            <draggable :list="inTestTasks" group="people" style="min-height: 50px">
                                <v-hover v-slot="{ hover }" v-for="(task, i) in inTestTasks"
                                         :key="`${task.title}-${i}`">
                                    <v-card flat class="pa-3 mt-2" :elevation="hover ? 6 : 1">
                                        <div class="d-flex flex-row justify-space-between">
                                            <span class="d-block text-body-1 font-weight-bold mb-1" v-text="task.title"/>
                                            <v-btn icon class="mt-n2">
                                                <v-icon small color="indigo lighten-4" v-text="'mdi-close'" @click="deleteTask(i)"/>
                                            </v-btn>
                                        </div>
                                        <span class="d-block text-body-2" v-text="task.description"/>
                                    </v-card>
                                </v-hover>
                            </draggable>

                        </v-card>
                    </v-col>

                    <v-col cols="12" md="3" class="mb-5">
                        <v-card flat class="transparent" rounded="lg">
                            <v-card-title v-text="$t('done')" class="white py-2"/>

                            <draggable :list="doneTasks" group="people" style="min-height: 50px">
                                <v-hover v-slot="{ hover }" v-for="(task, i) in doneTasks" :key="`${task.title}-${i}`">
                                    <v-card flat class="pa-3 mt-2" :elevation="hover ? 6 : 1">
                                        <div class="d-flex flex-row justify-space-between">
                                            <span class="d-block text-body-1 font-weight-bold mb-1" v-text="task.title"/>
                                            <v-btn icon class="mt-n2">
                                                <v-icon small color="indigo lighten-4" v-text="'mdi-close'" @click="deleteTask(i)"/>
                                            </v-btn>
                                        </div>
                                        <span class="d-block text-body-2" v-text="task.description"/>
                                    </v-card>
                                </v-hover>
                            </draggable>

                        </v-card>
                    </v-col>
                </v-row>

            </div>
        </v-card>

        <add-task-dialog :open="addDialog" @add-task="addTask($event)"/>

    </v-container>
</template>

<script>
import draggable from 'vuedraggable'
import AddTaskDialog from "./AddTaskDialog";

export default {
    components: {
        draggable,
        AddTaskDialog
    },
    data() {
        return {
            pageTitle: this.$t('scrumBoard'),
            openTasks: [
                {
                    id: 1,
                    title: 'My first Task Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
                {
                    id: 2,
                    title: 'My Second Task Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
                {
                    id: 3,
                    title: 'My Third Task Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },
            ],
            inProgressTasks: [],
            inTestTasks: [],
            doneTasks: [],
            search: null,
            addDialog: false,
        };
    },
    computed: {},
    methods: {
        addTask(task) {
            this.openTasks.push(task)
        },
        deleteTask(i) {
            if (confirm('Silinsin mi?')) {
                this.$delete(this.openTasks, i)
            }
        },
    },
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
    }
}
</script>
