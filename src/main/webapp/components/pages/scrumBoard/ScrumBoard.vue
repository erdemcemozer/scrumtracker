<template>
    <v-container fluid>

        <v-card flat tile color="transparent">
            <v-row no-gutters>
                <v-col cols="8" class="pa-2">
                    <v-text-field color="transparent"
                                  class="neumerophism py-1 mt-0 fill-width mr-3"
                                  v-model="search"
                                  append-icon="mdi-magnify"
                                  :label="$t('search')"
                                  single-line flat rounded
                                  hide-details/>
                </v-col>

                <v-col cols="2" class="pa-2">
                    <v-select
                        v-model="select"
                        :items="items"
                        item-text="sprintName"
                        item-value="sprintId"
                        return-object
                        single-line
                        @change="changeSelect(select)"
                    />
                </v-col>

                <v-col cols="2" class="pa-2">
                    <add-sprint-dialog/>
                </v-col>
            </v-row>

            <v-divider/>

            <div class="pa-3">
                <v-row>
                    <v-col cols="12" md="3" class="mb-5">
                        <v-card flat class="transparent" rounded="lg">


                                <v-card-title v-text="$t('openReopen')" class="py-2 white"/>

                            <draggable :list="openTasks" group="people" style="min-height: 50px">
                                <v-hover v-slot="{ hover }" v-for="(task, i) in openTasks" :key="`${task.issueTitle}-${i}`">
                                    <v-card flat class="pa-3 mt-2" :elevation="hover ? 6 : 1">
                                      <div class="d-flex flex-row justify-space-between">
                                          <span class="d-block text-body-1 font-weight-bold mb-1" v-text="task.issueTitle"/>
                                          <v-btn icon class="mt-n2">
                                            <v-icon small color="indigo lighten-4" v-text="'mdi-close'" @click="deleteResult(openTasks,task)"/>
                                          </v-btn>
                                      </div>

                                        <span class="d-block text-body-2" v-text="task.issueDesc"/>

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
                                         :key="`${task.issueTitle}-${i}`">
                                    <v-card flat class="pa-3 mt-2" :elevation="hover ? 6 : 1">
                                      <div class="d-flex flex-row justify-space-between">
                                          <span class="d-block text-body-1 font-weight-bold mb-1" v-text="task.issueTitle"/>
                                          <v-btn icon class="mt-n2">
                                              <v-icon small color="indigo lighten-4" v-text="'mdi-close'" @click="deleteResult(inProgressTasks,task)"/>
                                          </v-btn>
                                      </div>
                                        <span class="d-block text-body-2" v-text="task.issueDesc"/>
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
                                         :key="`${task.issueTitle}-${i}`">
                                    <v-card flat class="pa-3 mt-2" :elevation="hover ? 6 : 1">
                                        <div class="d-flex flex-row justify-space-between">
                                            <span class="d-block text-body-1 font-weight-bold mb-1" v-text="task.issueTitle"/>
                                            <v-btn icon class="mt-n2">
                                                <v-icon small color="indigo lighten-4" v-text="'mdi-close'" @click="deleteResult(inTestTasks, task)"/>
                                            </v-btn>
                                        </div>
                                        <span class="d-block text-body-2" v-text="task.issueDesc"/>
                                    </v-card>
                                </v-hover>
                            </draggable>

                        </v-card>
                    </v-col>

                    <v-col cols="12" md="3" class="mb-5">
                        <v-card flat class="transparent" rounded="lg">
                            <v-card-title v-text="$t('done')" class="white py-2"/>

                            <draggable :list="doneTasks" group="people" style="min-height: 50px">
                                <v-hover v-slot="{ hover }" v-for="(task, i) in doneTasks" :key="`${task.issueTitle}-${i}`">
                                    <v-card flat class="pa-3 mt-2" :elevation="hover ? 6 : 1">
                                        <div class="d-flex flex-row justify-space-between">
                                            <span class="d-block text-body-1 font-weight-bold mb-1" v-text="task.issueTitle"/>
                                            <v-btn icon class="mt-n2">
                                                <v-icon small color="indigo lighten-4" v-text="'mdi-close'" @click="deleteResult(doneTasks, task)"/>
                                            </v-btn>
                                        </div>
                                        <span class="d-block text-body-2" v-text="task.issueDesc"/>
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
import AddSprintDialog from "./AddSprintDialog";

export default {
    components: {
        draggable,
        AddTaskDialog,
        AddSprintDialog
    },
    data() {
        return {
            select: {},
            items: [],
            pageTitle: this.$t('scrumBoard'),
            openTasks: [
                /*{
                    id: 1,
                    title: 'My first Task Title',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis neque quia quod.'
                },*/
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
        async deleteResult(arr,task) {
            await this.$store.dispatch('POST_DELETE_ISSUE', task)
            this.$delete(arr, task)
        },
        changeSelect(select) {
            this.$store.dispatch('GET_SELECTED_ISSUE', select.sprintName).then(()=>{
                this.openTasks = this.$store.state.selectedIssue.filter((obj)=>{
                    return obj.issueStatus === 'Reopen' || obj.issueStatus === 'Open'
                })
                this.inProgressTasks = this.$store.state.selectedIssue.filter((obj)=>{
                    return obj.issueStatus === 'In Progress'
                })
                this.inTestTasks = this.$store.state.selectedIssue.filter((obj)=>{
                    return obj.issueStatus === 'In Test'
                })
                this.doneTasks = this.$store.state.selectedIssue.filter((obj)=>{
                    return obj.issueStatus === 'Done' || obj.issueStatus === 'Resolved'
                })
                console.log('done',this.doneTasks)
            })
            //this.$storage.setCookie('sprintName', select.sprintName)
        },
        dragObj(e) {
            console.log('drag',e)
        }
    },
    /*
         id: "f0a9e748-315b-4829-bd4c-9cf2e77b51ae"
        issueDesc: "aaaaa"
        issueEstimation: "aaaaaa"
        issueOwner: "muhammed1 kurfeyiz1"
        issuePriority: "kritik"
        issueSprintName: "spr demo 2"
        issueStatus: "story"
         "Yeni iş"
        issueType: "bbbbb"
     */
    created() {
        this.$store.commit('SET_PAGE_TITLE', this.pageTitle)
        this.$store.dispatch('GET_ALL_SPRINTS').then(()=>{
            this.items = this.$store.state.allSprints
            this.select = this.$store.state.allSprints[this.$store.state.allSprints.length-1]
            this.$storage.setCookie('sprintName', this.select.sprintName)
            this.$store.dispatch('GET_SELECTED_ISSUE', this.select.sprintName).then(()=>{
                this.openTasks = this.$store.state.selectedIssue.filter((obj)=>{
                    return obj.issueStatus === 'Reopen' || obj.issueStatus === 'Open'
                })
                this.inProgressTasks = this.$store.state.selectedIssue.filter((obj)=>{
                    return obj.issueStatus === 'In Progress'
                })
                this.inTestTasks = this.$store.state.selectedIssue.filter((obj)=>{
                    return obj.issueStatus === 'In Test'
                })
                this.doneTasks = this.$store.state.selectedIssue.filter((obj)=>{
                    return obj.issueStatus === 'Done' || obj.issueStatus === 'Resolved'
                })
                //console.log('done',this.doneTasks)
            })
        })
    },
    watch: {
        '$store.state.allSprints'(val) {
            this.items = [...val]
            this.$nuxt.refresh()
        },
        select: {
            handler(val){
                this.$storage.removeCookie('sprintName')
                this.$storage.setCookie('sprintName', val.sprintName)
                console.log('aaaa',val)
            },
            deep: true
        },

    },
}
</script>

<style lang="scss" scoped>
.v-text-field {
    padding-top: initial;
}
</style>
